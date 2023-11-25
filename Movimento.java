import java.util.Random;
import java.util.Scanner;

public class Movimento {
    public static void PlayerTurn(char[][] board, Scanner scanner) {
        String userInput;
        boolean inputValido = false;
        while (!inputValido) {

            System.out.print("Onde quer jogar?\nResposta: ");
            userInput = scanner.nextLine();

            if (isValidInput(userInput)) {
                int posicao = Integer.parseInt(userInput);

                if (EspacoVazio(board, posicao)) {
                    placeMove(board, userInput, 'X');
                    inputValido = true;
                    break;

                } else {
                    System.out.println("Este espaço já está ocupado!");

                }
            } else {
                System.out.println("\nPosição inválida. Digite um número de 1 a 9.");
            }
        }
    }

    private static boolean hasContestantWon(char[][] board, char symbol) {
		if ((board[0][0] == symbol && board [0][1] == symbol && board [0][2] == symbol) ||
			(board[1][0] == symbol && board [1][1] == symbol && board [1][2] == symbol) ||
			(board[2][0] == symbol && board [2][1] == symbol && board [2][2] == symbol) ||
			
			(board[0][0] == symbol && board [1][0] == symbol && board [2][0] == symbol) ||
			(board[0][1] == symbol && board [1][1] == symbol && board [2][1] == symbol) ||
			(board[0][2] == symbol && board [1][2] == symbol && board [2][2] == symbol) ||
			
			(board[0][0] == symbol && board [1][1] == symbol && board [2][2] == symbol) ||
			(board[0][2] == symbol && board [1][1] == symbol && board [2][0] == symbol) ) {
			return true;
		}
		return false;
	}

    public static boolean jogoTerminado(char[][] board) {

        if (hasContestantWon(board, 'X')) {	
			impressao.printboard(board);
			System.out.println("\nVitória do jogador!");
			return true;
		}
		
		if (hasContestantWon(board, 'O')) {	
			impressao.printboard(board);
			System.out.println("\nVitória do oponente!");
			return true;
		}

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        impressao.printboard(board);
        System.out.println("\nO jogo foi finalizado em empate!");
        return true;
        
    }

    private static boolean isValidInput(String input) {
        try {
            int posicao = Integer.parseInt(input);
            return posicao >= 1 && posicao <= 9;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void computerTurn(char[][] board) {

        System.out.println("JOGADA DO OPONENTE \n");
        Random rand = new Random();
        int ComputerPlay;
        while (true) {
            ComputerPlay = rand.nextInt(9) + 1;
            if (EspacoVazio(board, ComputerPlay)) {
                break;
            }
        }

        placeMove(board, Integer.toString(ComputerPlay), 'O');

    }

    static boolean EspacoVazio(char[][] board, int posicao) {

        switch (posicao) {
            case 1:
                return (board[0][0] == ' ');

            case 2:
                return (board[0][1] == ' ');

            case 3:
                return (board[0][2] == ' ');

            case 4:
                return (board[1][0] == ' ');

            case 5:
                return (board[1][1] == ' ');

            case 6:
                return (board[1][2] == ' ');

            case 7:
                return (board[2][0] == ' ');

            case 8:
                return (board[2][1] == ' ');

            case 9:
                return (board[2][2] == ' ');

            default:
                return true;
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
