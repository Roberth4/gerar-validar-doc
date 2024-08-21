package renavamValidarGerar;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Validator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String renavamSemDV = sc.next();
        StringBuilder sb = new StringBuilder();

        int sum, onzeDecrescente;
        sum = 0;
        onzeDecrescente = 11;

        for (int i = 0; i < renavamSemDV.length(); i++) {
            sum+= digitoPorDigito(i, renavamSemDV) * onzeDecrescente;
            onzeDecrescente--;
        }

        System.out.println(sum);

        int moduloSum = 11 - (sum % 11);
        if (moduloSum == 9) {
            moduloSum = 0;
        }

        System.out.println(moduloSum);

        sb.append(renavamSemDV).append(moduloSum);

        System.out.println(sb);
    }

    public static int digitoPorDigito(int i, String j) {
        return Integer.parseInt(String.valueOf(j.charAt(i)));
    }

    public static String getRandom() {
        Random random = new Random();
        return String.valueOf(ThreadLocalRandom.current().nextLong(1000000000L, 9999999999L + 1));
    }
}


