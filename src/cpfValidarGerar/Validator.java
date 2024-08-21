package cpfValidarGerar;

import java.util.Arrays;
import java.util.Scanner;

public class Validator {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        try (Scanner sc = new Scanner(System.in)){
            String cpfRecebido = sc.next();

            for (int i = 0; i < (cpfRecebido.length()-2); i++) {
                sb.append(cpfRecebido.charAt(i)).append(" ");
            }

            String[] cpfSeparado = sb.toString().split(" ");

            int sum, dezDecrescente, onzeDecrescente, digitoDez, digitoOnze;
            sum = 0;
            dezDecrescente = 10;
            onzeDecrescente = 11;

            for (String num: cpfSeparado) {
                sum += Integer.parseInt(num) * dezDecrescente;
                dezDecrescente--;
            }

            digitoDez = sum * 10 % 11;
            if (digitoDez > 9) {
                digitoDez = 0;
            }

            sb.append(digitoDez);

            cpfSeparado = sb.toString().split(" ");

            sum = 0;
            for (String num: cpfSeparado) {
                sum += Integer.parseInt(num) * onzeDecrescente;
                onzeDecrescente--;
            }

            digitoOnze = sum * 10 % 11;

            digitoOnze = sum * 10 % 11;
            if (digitoOnze > 9) {
                digitoOnze = 0;
            }

            sb.append(" ").append(digitoOnze);

            String cpfInicialTestado = sb.toString().replace(" ", "");

            char verificarCpfRepetido = cpfRecebido.charAt(0);
            char[] cpfRepetido = new char[11];
            Arrays.fill(cpfRepetido, verificarCpfRepetido);

            if(cpfInicialTestado.equals(cpfRecebido) != cpfRecebido.equals(String.valueOf(cpfRepetido))) {
                System.out.printf("CPF: %s é válido!", cpfRecebido);
            }
            else {
                System.out.printf("CPF: %s é inválido!", cpfRecebido);
            }
        }
        catch (RuntimeException e) {
            System.out.println("Erro desconhecido. Programa encerrado!");
        }
    }
}
