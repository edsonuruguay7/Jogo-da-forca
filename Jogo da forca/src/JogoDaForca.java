import java.util.Scanner;

public class JogoDaForca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] palavras = {"java", "computador", "teclado", "programacao", "desenvolvedor"};
        String palavra = palavras[(int) (Math.random() * palavras.length)];
        StringBuilder progresso = new StringBuilder("_".repeat(palavra.length()));
        int tentativasRestantes = 6;
        String letrasErradas = "";

        System.out.println("🎯 JOGO DA FORCA 🎯");

        while (tentativasRestantes > 0 && progresso.toString().contains("_")) {
            System.out.println("\nPalavra: " + progresso);
            System.out.println("Tentativas restantes: " + tentativasRestantes);
            System.out.println("Letras erradas: " + letrasErradas);
            System.out.print("Digite uma letra: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Digite apenas uma letra válida.");
                continue;
            }

            char letra = input.charAt(0);
            boolean acertou = false;

            for (int i = 0; i < palavra.length(); i++) {
                if (palavra.charAt(i) == letra) {
                    progresso.setCharAt(i, letra);
                    acertou = true;
                }
            }

            if (!acertou) {
                if (!letrasErradas.contains(String.valueOf(letra))) {
                    tentativasRestantes--;
                    letrasErradas += letra + " ";
                } else {
                    System.out.println("Você já tentou essa letra.");
                }
            }
        }

        if (tentativasRestantes == 0) {
            System.out.println("\n💀 Você perdeu! A palavra era: " + palavra);
        } else {
            System.out.println("\n🎉 Parabéns! Você acertou a palavra: " + palavra);
        }

        scanner.close();
    }
}
