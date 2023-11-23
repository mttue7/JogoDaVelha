import java.util.Scanner;

public class JogoVelha {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        char[][] board = { { ' ', ' ', ' ' },
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' } };

        impressao.printboard(board);

        while(true){
        Movimento.PlayerTurn(board, scanner);
        System.out.print("\nSUA JOGADA\n\n");
        impressao.printboard(board);
        System.out.println(" ------------------- \n");
        System.out.println("JOGADA DO OPONENTE \n");
        Movimento.computerTurn(board);
        impressao.printboard(board);
        }
        
    }
    // scanner.close();
}
