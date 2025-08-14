package org.example;

import java.io.*;
import com.thoughtworks.xstream.XStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {
    public static void main(String[] args) throws IOException,
            ClassNotFoundException {
        File fichero = new File("c:\\ejercicios\\Departamentos.dat");
        FileInputStream filein = new FileInputStream(fichero);//flujo de entrada
        ObjectInputStream dataIS = new ObjectInputStream(filein);
        System.out.println("Comienza el proceso de creación del fichero a XML ...");

        //Creamos un objeto Lista de Departamentos
        ListaDepartamento listadep = new ListaDepartamento();

        try {
            while (true) { //lectura del fichero
                Departamento departamento= (Departamento) dataIS.readObject();
                listadep.add(departamento); //añadir Departamento a la lista
            }
        }catch (EOFException eo) {}
        dataIS.close();  //cerrar stream de entrada

        try {
            XStream xstream = new XStream();
            //cambiar de nombre a las etiquetas XML
            xstream.alias("ListaDepartamentos", ListaDepartamento.class);
            xstream.alias("DatosDepartamento", Departamento.class);
            //quitar etiqueta lista (atributo de la clase ListaDepartamentos)
            xstream.addImplicitCollection(ListaDepartamento.class, "lista");
            //Insertar los objetos en el XML
            xstream.toXML(listadep, new FileOutputStream("c:\\ejercicios\\Departamentos.xml"));
            System.out.println("Creado fichero XML....");

        }catch (Exception e)
        {e.printStackTrace();}
    } // fin main
} //fin