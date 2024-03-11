package ejer5EquiposFutbol;

public class Partido {
    Equipo equipo1;
    Equipo equipo2;
    Partido(Equipo Local, Equipo visitante){
        this.equipo1 = Local;
        this.equipo2 = visitante;
    }
    void jugarPartido(){
        int numeroGoles = (int) (Math.random() * 10);
        equipo1.setGolesfavor((int)(Math.random() * numeroGoles));
        equipo1.setGolescontra(numeroGoles - equipo1.getGolesfavor());
        equipo2.setGolescontra(equipo1.getGolesfavor());
        equipo2.setGolesfavor(equipo1.getGolescontra());
    }
    void jugarPartidoPonderada(){
        int numeroGoles = (int) (Math.random() * 10);
        double probabilidadLocal = (((double) 1 / 3) * 2);
        double probabilidadVisitante = (((double) 1 / 3));
        if (equipo1.getPuntuacion() > equipo2.getPuntuacion()){
            probabilidadLocal += probabilidadVisitante/2;
        } else if (equipo2.getPuntuacion() > equipo1.getPuntuacion()) {
            probabilidadLocal -= probabilidadVisitante/2;
        }
        equipo1.setGolesfavor((int)(probabilidadLocal * numeroGoles));
        equipo1.setGolescontra(numeroGoles - equipo1.getGolesfavor());
        equipo2.setGolescontra(equipo1.getGolesfavor());
        equipo2.setGolesfavor(equipo1.getGolescontra());
        System.out.println("La probabilidad del equipo local es: " + probabilidadLocal);
        System.out.println("La probabilidad del equipo visitante es: " + probabilidadVisitante);
        System.out.println("La probabilidad del local sobre el visitante es de " + probabilidadLocal / probabilidadVisitante);

    }

    public static void main(String[] args) {
        Equipo x = new Equipo("equipoLocal");
        Equipo y = new Equipo("equipoVisitante");
        Partido z = new Partido(x,y);
        z.jugarPartido();
        x.mostrarGolesFavor();
        x.mostrarGolesContra();
        y.mostrarGolesFavor();
        y.mostrarGolesContra();

        x.setPuntuacion(70);
        y.setPuntuacion(70);
        z.jugarPartidoPonderada();
        x.mostrarGolesFavor();
        x.mostrarGolesContra();
        y.mostrarGolesFavor();
        y.mostrarGolesContra();

    }
}
