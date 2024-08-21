package rgSSPValidarGerar;


import java.util.Scanner;

public class Validator {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String rgComDV = sc.next();

        int noveDecrescente = 9;
        int sum = 0;

        for (int i = 0; i < rgComDV.length()-1; i++) {
            sum += Integer.parseInt(String.valueOf(rgComDV.charAt(i))) * noveDecrescente;
            noveDecrescente--;
            sb.append(Integer.parseInt(String.valueOf(rgComDV.charAt(i))));
        }

        String dv = null;
        if(sum % 11 == 10) {
            dv = "x";
        }
        else {
            dv = String.valueOf(sum % 11);
        }

        sb.append(dv);


        if (rgComDV.contentEquals(sb)) {
            System.out.printf("O RG: %s é válido!", sb);
        }
        else {
            System.out.printf("O RG: %s é inválido!", sb);
        }


    }
}
