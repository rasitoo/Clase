package eecadenas.e5dni;

/**
 * @author Rodrigo
 * @date 03 marzo, 2024
 */
public class ksmm {
    public static void main(String[] args) {
        int r=0;
        for (int i=1, j=0; i<=9; i=i+4,j=j+2) {
            try {
                r+= i/j;
            }catch (ArithmeticException e) {
                r=20;
            }catch (Exception e) {
                r=10;
            }
        }
        System.out.println(r);

    }
}
