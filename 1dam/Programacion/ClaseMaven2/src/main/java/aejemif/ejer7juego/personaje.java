package aejemif.ejer7juego;

public class personaje {
    String nombre;
    Punto2 posicion;
    int vida;
    int fuerza;
    arma arma;

    personaje(String nombre, Punto2 posicion, int vida, int fuerza, arma arma){
        this.nombre   = nombre;
        this.arma     = arma;
        this.vida     = vida;
        this.fuerza   = fuerza;
        this.posicion = posicion;

    }
    void moverx(int x){
        posicion.setX(posicion.getX() + x);
    }
    void movery(int y){
        posicion.setY(posicion.getY() + y);
    }
    void cambiararma(arma arma){
        this.arma = arma;
    }
    void lucha(personaje contrincante){
        double ataque1 = Math.random() * (fuerza+ fuerza * arma.porcentaje);
        double ataquecontrincante = Math.random() * (contrincante.fuerza + contrincante.fuerza * contrincante.arma.porcentaje);
        if (this.posicion.calcularDistancia(contrincante.posicion) <= 5){
            if (ataque1>ataquecontrincante){
                contrincante.vida -= ((int)(Math.random() * 6) + 5);
                System.out.println("¡Ha ganado " + this.nombre + "!");
            } else if (ataque1<ataquecontrincante) {
                this.vida -= ((int)(Math.random() * 6) + 5);
                System.out.println("¡Ha ganado " + contrincante.nombre + "!");
            }else System.out.println("¡Ha sido un empate!");

        }else System.out.println("null");
    }
    void mostrar(String txt){
        if (this.vida > 25)
            System.out.println("La salud de " + txt + " es:" + this.vida);
        else if (this.vida == 0) {
            System.out.println("La salud de " + txt + " es:" + this.vida + "MUERTO");
        }
        else System.out.println("La salud de " + txt + " es:" + this.vida + "HERIDO");
        System.out.println("La posición de " + txt + " es:" + this.posicion.getX() + "/" + this.posicion.getY());
        System.out.println("El arma de " + txt + " es:" + this.arma.nombre);
        System.out.println("La fuerza de " + txt + " es:" + this.fuerza);
        System.out.println();
    }

    public static void main(String[] args) {
        arma martillo = new arma("Martillo",0.2);
        arma espada = new arma("Espada",0.3);
        arma mandoble = new arma("Mandoble",0.4);

        personaje Pepe = new personaje("Pepe",new Punto2(0,0),100,30,espada);
        personaje Antonio = new personaje("Antonio",new Punto2(10,10), 100, 50, martillo);

        Pepe.mostrar(Pepe.nombre);
        Antonio.mostrar(Antonio.nombre);

        Antonio.lucha(Pepe);

        Antonio.moverx(-7);
        Antonio.movery(-7);

        Pepe.moverx(3);
        Pepe.movery(3);

        Antonio.lucha(Pepe);

        Pepe.cambiararma(mandoble);

        Pepe.lucha(Antonio);

        System.out.println(Pepe.vida);
        System.out.println(Antonio.vida);
    }
}
