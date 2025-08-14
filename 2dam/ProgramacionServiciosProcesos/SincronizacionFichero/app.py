import os
import time
import portalocker as pl
class ProcessState:
    def __init__(self, filename):
        self.filename = filename

    def lock_file(self, mode):
        self.file = open(self.filename, mode)
        pl.lock(self.file, pl.LOCK_EX)

    def unlock_file(self):
        pl.lock(self.file, pl.LOCK_UN)
        self.file.close()

    def write_state(self, state):
        self.lock_file('w')
        self.file.write(state)
        self.unlock_file()

    def read_state(self):
        self.lock_file('r')
        state = self.file.read().strip()
        self.unlock_file()
        return state

import multiprocessing

def process_function(process_id, process_state):
    #simula diferentes estados del proceso
    states = ["INICIO", "PROCESANDO", "FINALIZADO"]

    for state in states:
        time.sleep(1)  #simular tiempo de procesamiento
        print(f"Proceso {process_id} cambiando estado a: {state}")
        process_state.write_state(state) #Escribe el estado en el que se encuentra el proceso

if __name__ == "__main__":
    filename = "process_state.txt"
    
    #asegurarse de que el archivo exista
    if not os.path.exists(filename):
        open(filename, 'w').close()

    process_state = ProcessState(filename) #Se crea un objeto process_state

    processes = []
    for i in range(2): 
        p = multiprocessing.Process(target=process_function, args=(i, process_state)) #Se crea un hilo de la clase Process que ejecuta la función process_function con los argumentos necesarios
        processes.append(p)
        p.start()

    for p in processes:
        p.join() #Esperamos a que terminen los procesos

    # Mostrar el estado final del fichero
    print(f"Estado final del fichero: {process_state.read_state()}")