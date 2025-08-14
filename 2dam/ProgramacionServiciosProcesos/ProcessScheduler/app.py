import threading
import time

# Definir el quantum (tiempo de CPU asignado a cada proceso)
QUANTUM = 2  # segundos

class Process(threading.Thread):
    def __init__(self, process_id, burst_time):
        threading.Thread.__init__(self)
        self.process_id = process_id
        self.burst_time = burst_time

    def run_for_quantum(self):
        if self.burst_time > 0:
            time_to_run = min(self.burst_time, QUANTUM)
            print(f"Proceso {self.process_id} ejecutándose por {time_to_run} segundos.")
            time.sleep(time_to_run)
            self.burst_time -= time_to_run
            if self.burst_time > 0:
                print(f"Proceso {self.process_id} detenido, resta {self.burst_time} segundos.")
            else:
                print(f"Proceso {self.process_id} finalizado.")

def round_robin_scheduler(processes):
    while any(process.burst_time > 0 for process in processes):
        for process in processes:
            if process.burst_time > 0:
                process.run_for_quantum()

if __name__ == "__main__":
    # Crear procesos con diferentes tiempos de ráfaga (burst time)
    processes = [
        Process(1, 5),
        Process(2, 8),
        Process(3, 3),
        Process(4, 6)
    ]

    # Iniciar el planificador Round Robin
    round_robin_scheduler(processes)


