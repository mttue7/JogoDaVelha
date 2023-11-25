import java.util.Scanner;

public class JogoVelha {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String escolha;

    char[][] board = { { ' ', ' ', ' ' },
        { ' ', ' ', ' ' },
        { ' ', ' ', ' ' } };

    impressao.printboard(board);

    System.out.print("\n");
    System.out.println("Você deseja que quem comece?\nJogador ou Oponente: ");
      escolha = scanner.nextLine();
      System.out.print("\n");

      while (true) {
      
      switch (escolha.toLowerCase()) {
        case "jogador":
          Movimento.PlayerTurn(board, scanner);
          if (Movimento.jogoTerminado(board)) {
            System.exit(0);
          }
          System.out.print("\nSUA JOGADA\n\n");
          impressao.printboard(board);
          System.out.println(" ------------------- \n");

          Movimento.computerTurn(board);
          impressao.printboard(board);
          System.out.print("\n");
          break;

        case "oponente":
          Movimento.computerTurn(board);
          
          if (Movimento.jogoTerminado(board)) {
            System.exit(0);
          }

          impressao.printboard(board);
          
          Movimento.PlayerTurn(board, scanner);
          System.out.print("\nSUA JOGADA\n\n");
          impressao.printboard(board);
          System.out.println(" ------------------- \n");

          break;

        default:
        System.out.println("Escolha de acordo com o informado!\n");
        main(args);
        break;
      }

    }
    // scanner.close();
  }
}
