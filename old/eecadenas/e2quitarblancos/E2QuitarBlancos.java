package eecadenas.e2quitarblancos;

/**
 * @author Rodrigo🦖
 * @date 18 enero, 2024
 */
public class E2QuitarBlancos {
    String quitarBlancos(String s){
        String res = "";
        String[] sep = s.split(" ");

        for (int i = 0; i < sep.length; i++){
            if (!sep[i].equals(""))
                res += sep[i] + " ";
        }

        return res.trim();
    }

    public static void main(String[] args) {
        String s = "   holaa,   que       haces  poniendo     tantos  espacios locoooo     ";
        E2QuitarBlancos ej = new E2QuitarBlancos();

        String res = ej.quitarBlancos(s);
        if (res == null)
            System.out.println("ERROR");
        else System.out.println(res);
    }
}
