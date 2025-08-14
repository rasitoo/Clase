package aejemgeometria;

public class RGB {
    private int R;
    private int G;
    private int B;
    RGB(int R, int G, int B){
        this.R = R;
        this.G = G;
        this.B = B;
    }
    public int getR() {
        return R;
    }
    public int getG() {
        return G;
    }
    public int getB() {
        return B;
    }
    public void setR(int r) {
        R = r;
    }
    public void setG(int g) {
        G = g;
    }
    public void setB(int b) {
        B = b;
    }

    void mostrar(String txt){
        System.out.println(txt + " es: R:" + R + " G:" + G + " B:" + B);
    }
    public static void main(String[] args) {
        RGB prueba = new RGB(255,255,255);
        prueba.mostrar("prueba");
    }
}
