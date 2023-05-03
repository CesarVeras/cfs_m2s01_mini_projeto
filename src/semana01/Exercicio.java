package semana01;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio {
    public static Scanner s = new Scanner(System.in);
    public static ArrayList<String> nomesArray = new ArrayList<>();
    public static ArrayList<float[]> notasArray = new ArrayList<>();
    public static ArrayList<Float> mediasArray = new ArrayList<>();
    public static String digitado = "";
    public static void main(String[] args) {
        coletarDados();
        exibirDados();
        exibirAprovados();
    }

    public static void coletarDados() {
        while(!digitado.equals("fim")) {
            System.out.print("Digite o nome do aluno (digite 'fim' para parar): ");
            digitado = s.next();
            if (!digitado.equals("fim")) {
                nomesArray.add(digitado);
                float[] notas = new float[3];
                for (int i = 0; i < notas.length; i++) {
                    System.out.printf("Digite a nota #%s: ", (i + 1));
                    notas[i] = s.nextFloat();
                }
                notasArray.add(notas);
                float media = (notas[0] + notas[1] + notas[2])/3;
                mediasArray.add(media);
            }

        }
    }

    public static void exibirDados() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < notasArray.size(); i++) {
            out.append("Alun@: ").append(nomesArray.get(i)).append("\n");
            out.append("Notas: ");
            for (int j = 0; j < 3; j++) {
                out.append(notasArray.get(i)[j]).append(", ");
            }
            out.append("\nMédia: ").append(mediasArray.get(i));
            out.append("\n--------------------\n");
        }
        System.out.print(out);
    }

    private static void exibirAprovados() {
        StringBuilder aprovados = new StringBuilder();
        aprovados.append("Aprovados: \n");
        StringBuilder reprovados = new StringBuilder();
        reprovados.append("Reprovados: \n");
        for (int i = 0; i < nomesArray.size(); i++) {
            if (mediasArray.get(i) >= 7.0) {
                aprovados.append(nomesArray.get(i)).append(": ").append(mediasArray.get(i)).append("\n");
            } else {
                reprovados.append(nomesArray.get(i)).append(": ").append(mediasArray.get(i)).append("\n");
            }
        }
        System.out.printf("%s%n---------------%n",aprovados);
        System.out.printf("%s%n---------------%n",reprovados);
    }
}
