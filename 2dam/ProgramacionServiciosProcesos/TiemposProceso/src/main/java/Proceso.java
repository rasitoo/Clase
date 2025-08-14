/**
 * @author Rodrigo
 * @date 17 enero, 2025
 */
public class Proceso{
    public long getInicio() {
        return inicio;
    }

    public void setInicio(long inicio) {
        this.inicio = inicio;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    private long inicio;
    private String lenguaje;
    private Process process;

    public Proceso(long inicio, String lenguaje, Process process) {
        this.inicio = inicio;
        this.lenguaje = lenguaje;
        this.process = process;
    }
}
