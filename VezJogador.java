import java.util.Scanner;

public class VezJogador {
    public static void PlayerTurn(char[][] board) {
        Scanner scanner = new Scanner(System.in);

        boolean inputValido = false;
        while (!inputValido) {
            System.out.println("Onde quer jogar?");
            String userInput = scanner.nextLine();

            if (isValidInput(userInput)) {
                placeMove(board, userInput, 'X');
                inputValido = true;
            } else {
                System.out.println("Posição inválida. Digite um número de 1 a 9.");
            }
        }
        scanner.close();
    }

    private static boolean isValidInput(String input) {
        try {
            int posicao = Integer.parseInt(input);
            return posicao >= 1 && posicao <= 9;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void placeMove(char[][] board, String posicao, char symbol) {
        switch (posicao) {
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
            default:
                System.out.println("Você digitou um número inválido. Tente novamente.");
                break;
        }
    }
}
