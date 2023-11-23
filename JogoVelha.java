import java.util.Random;

public class JogoVelha {

    public static void main(String[] args) {

        char[][] board = { { ' ', ' ', ' ' },
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' } };

        impressao.printboard(board);
        VezJogador.PlayerTurn(board);

        Random rand = new Random(); 
        int ComputerPlay;
        while (true) {
             ComputerPlay = rand.nextInt(9) + 1;
            if(EspacoVazio(board, ComputerPlay)){
                break;
            }
        }

        VezJogador.placeMove(board, Integer.toString(ComputerPlay), 'O');

        impressao.printboard(board);
    }

    private static boolean EspacoVazio(char[][] board, int posicao) {

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

}
