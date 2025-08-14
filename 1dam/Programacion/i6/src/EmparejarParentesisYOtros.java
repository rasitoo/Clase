import java.util.Scanner;
/**
 * Created by desir 🥑on 27  abril, 2024
 */
public class EmparejarParentesisYOtros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una expresion ");

        String expresion = sc.nextLine();
        if (verificarDelimitadores(expresion)) {
            System.out.println("Todos los delimitadores están bien emparejados.");
        }else{
            System.out.println("Los delimitadores no están bien emparejados");
        }
    }

    private static boolean verificarDelimitadores(String expresion) {
        // Declaramos la clase pila para aprovechar sus metodos, se pondrá caracter
        // porque solo se le pasa uno de ellos.
        Pila<Character> pila = new Pila<>();
        for (int i = 0; i < expresion.length(); i++) {
            char ch = expresion.charAt(i); // para verificar si es un caracter
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    pila.anadir(ch);
                    break;
                case ')':
                case ']':
                case '}':
                    if (pila.isEmpty()) {
                        System.out.println("Sobra un " + ch);
                        return false;
                    }
                    char topchar = pila.sacar();
                    if ((ch == ')' && topchar != '(') ||
                            (ch == ']' && topchar != '[') ||
                            (ch == '}' && topchar != '{')) {
                        System.out.println("No estan bien emparejados " + topchar + " y " + ch);
                        return false;
                    }
                    break;
            }
        }
        if (!pila.isEmpty()) {
            System.out.println("Falta cerrar un " + pila.sacar());
            return false;
        }
        return true ;
    }
}
