public class Main {
    public static void main(String[] args) {
        MiPila <Persona> pilaPers= new MiPila<Persona>();
        pilaPers.anadir(new Persona (30, "Juan"));
        pilaPers.imprimir();
        pilaPers.sacar();
        pilaPers.imprimir();
        pilaPers.estaVacia();

        MiPila<Coche> pilaC= new MiPila<>();
        pilaC.anadir(new Coche("AAA111", 100, 1000));
        pilaC.imprimir();
        pilaC.sacar();
        pilaC.imprimir();
        pilaC.estaVacia();

        MiPilaTamMax<Persona> miPilaTamMax = new MiPilaTamMax<>(3);
        System.out.println("Anadido:"+miPilaTamMax.anadir(new Persona(30, "Juan")));
        System.out.println("Anadido:"+miPilaTamMax.anadir(new Persona(31, "Ana")));
        System.out.println("Anadido:"+miPilaTamMax.anadir(new Persona(32, "Pepe")));
        System.out.println("Anadido:"+miPilaTamMax.anadir(new Persona(33, "Rosa")));




   }
}