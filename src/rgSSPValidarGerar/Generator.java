package rgSSPValidarGerar;

import java.util.Random;

public class Generator {
    public static void main(String[] args) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        String rgSemDV = String.valueOf(random.nextInt(99999999));
        while (rgSemDV.length() < 8) {
            rgSemDV = String.valueOf(random.nextInt(99999999));
        }

        int noveDecrescente = 9;
        int sum = 0;

        for (int i = 0; i < rgSemDV.length(); i++) {
            sum += Integer.parseInt(String.valueOf(rgSemDV.charAt(i))) * noveDecrescente;
            noveDecrescente--;
        }

        String dv = null;
        if(sum % 11 == 10) {
            dv = "x";
        }
        else {
            dv = String.valueOf(sum % 11);
        }

        sb.append(rgSemDV).append(dv);

        System.out.println(sb);

    }
}
