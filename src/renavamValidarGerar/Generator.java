package renavamValidarGerar;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        String renavamSemDv = getRandom();
        String renavamSemDvReverso = String.valueOf(sb.append(renavamSemDv).reverse());

        int num = 2;
        int sum = 0;
        for (int i = 0; i < renavamSemDvReverso.length(); i++) {
            if (num > 9) {
                num = 2;
            }
            sum += digitoPorDigito(i, renavamSemDvReverso, num);
            num++;
        }
        int mod11 = 11-sum%11;

        if(mod11 == 10) {
            mod11 = 0;
        }
        if(mod11 == 11) {
            mod11 = 1;
        }

        sb.reverse().append(mod11);
        System.out.println(sb);

    }


    public static int digitoPorDigito(int i, String j, int k) {
        return Integer.parseInt(String.valueOf(j.charAt(i))) * k;
    }

    public static String getRandom() {
        Random random = new Random();
        return String.valueOf(ThreadLocalRandom.current().nextLong(1000000000L, 9999999999L + 1));
    }
}


