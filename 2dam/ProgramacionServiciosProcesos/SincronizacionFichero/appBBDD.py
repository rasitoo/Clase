import sqlite3
import time
import multiprocessing

class ProcessStateDB:
    def __init__(self, db_name):
        self.db_name = db_name
        self.conn = sqlite3.connect(self.db_name)
        self.create_table()

    def create_table(self):
        with self.conn:
            self.conn.execute('''CREATE TABLE IF NOT EXISTS process_state (
                                    process_id INTEGER PRIMARY KEY,
                                    state TEXT
                                 );''')

    def write_state(self, process_id, state):
        with self.conn:
            self.conn.execute('REPLACE INTO process_state (process_id, state) VALUES (?, ?);', (process_id, state))

    def read_state(self, process_id):
        cursor = self.conn.cursor()
        cursor.execute('SELECT state FROM process_state WHERE process_id = ?;', (process_id,))
        result = cursor.fetchone()
        return result[0] if result else None

    def close(self):
        self.conn.close()

def process_function(process_id, db_name):
    process_state_db = ProcessStateDB(db_name)
    states = ["INICIO", "PROCESANDO", "FINALIZADO"]

    for state in states:
        time.sleep(1)
        print(f"Proceso {process_id} cambiando estado a: {state}")
        process_state_db.write_state(process_id, state)

    process_state_db.close()

if __name__ == "__main__":
    db_name = "process_state.db"
    process_state_db = ProcessStateDB(db_name)

    processes = []
    for i in range(2):
        p = multiprocessing.Process(target=process_function, args=(i, db_name))
        processes.append(p)
        p.start()

    for p in processes:
        p.join()

    for i in range(2):
        print(f"Estado final del proceso {i}: {process_state_db.read_state(i)}")

    process_state_db.close()
