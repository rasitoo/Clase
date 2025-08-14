package org.example;

public class EscribeCadaSeg {
    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Tiempo:"+i);
        }
    }
}