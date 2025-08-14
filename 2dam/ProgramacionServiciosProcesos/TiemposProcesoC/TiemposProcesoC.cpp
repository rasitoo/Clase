// TiemposProcesoC.cpp : Este archivo contiene la función "main". La ejecución del programa comienza y termina ahí.
//Programa hecho con ChatGPT, pero lo entiendo

#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include<windows.h>


int main() {
    //Inicializa el generador de números aleatorios
    srand(time(NULL));

    //Generar un tiempo aleatorio entre 2 y 8 segundos, se genera un numero del 0 al 6 y se suma 2 2-8
    int tiempo_espera = rand() % 7 + 2;

    //Esperar el tiempo aleatorio en milisegundos
    Sleep(tiempo_espera * 1000);

    //Generar un número aleatorio entre 3 y 12, se genera un numero del 0 al 9 y se le suma 3 3-12
    int numero_aleatorio = rand() % 10 + 3;
    std::cout << numero_aleatorio << std::endl;
    return 0;
}


// Ejecutar programa: Ctrl + F5 o menú Depurar > Iniciar sin depurar
// Depurar programa: F5 o menú Depurar > Iniciar depuración

// Sugerencias para primeros pasos: 1. Use la ventana del Explorador de soluciones para agregar y administrar archivos
//   2. Use la ventana de Team Explorer para conectar con el control de código fuente
//   3. Use la ventana de salida para ver la salida de compilación y otros mensajes
//   4. Use la ventana Lista de errores para ver los errores
//   5. Vaya a Proyecto > Agregar nuevo elemento para crear nuevos archivos de código, o a Proyecto > Agregar elemento existente para agregar archivos de código existentes al proyecto
//   6. En el futuro, para volver a abrir este proyecto, vaya a Archivo > Abrir > Proyecto y seleccione el archivo .sln
