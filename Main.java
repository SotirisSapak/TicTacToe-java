import java.util.Scanner;

public class Main {

    /**
     * Main method
     * @param args arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Give name for {X} player: ");
        String nameX = scanner.next();

        System.out.print("Give name for {O} player: ");
        String nameO = scanner.next();

        Player playerX = new Player(nameX, "X");
        Player playerO = new Player(nameO, "O");

        Gameplay gameplay = new Gameplay(playerX, playerO);
        printMenu();

        int option;
        do {
            System.out.print(gameplay.getPlayerTurnToString() + " - Give the position: ");
            option = scanner.nextInt();
            if(option == 0) break;
        } while (!gameplay.setPlayerOption(option));
    }

    private static void printMenu(){
        System.out.println("+=============================+");
        System.out.println("|                             |");
        System.out.println("|       TIC TAC TOE Game      |");
        System.out.println("|                             |");
        System.out.println("+=============================+");
        System.out.println("| Available positions:        |");
        System.out.println("| **numPad keys layout        |");
        System.out.println("+=============================+");
        System.out.println("|        TABLE LAYOUT         |");
        System.out.println("+-----------------------------+");
        System.out.println("|    7    |    8    |    9    |");
        System.out.println("+-----------------------------+");
        System.out.println("|    4    |    5    |    6    |");
        System.out.println("+-----------------------------+");
        System.out.println("|    1    |    2    |    3    |");
        System.out.println("+-----------------------------+");
        System.out.println("+-----------------------------+");
        System.out.println("| 0: EXIT                     |");
        System.out.println("+=============================+");
        System.out.println();
    }



}
