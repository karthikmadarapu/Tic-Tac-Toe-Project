import java.util.Objects;
import java.util.Scanner;

public class Main
{

    // Imported ANSI escape codes to change the text color of the console
    static Scanner scanner = new Scanner(System.in);
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";

    public static void main(String[] args)
    {

        // Name of members and ids:
        // Ricardo Alvear | 101536306
        // Sayuni Wimaladharma | 101563313
        // Kartik Madarapu | 101564894
        // Noela Bilonda Kabundi |

        System.out.println(BLUE + "Hello! Welcome To The TicTacToe Game" + RESET);
        System.out.print(GREEN + "Enter 1 for single player or 2 for two players: " + RESET);
        String choice = scanner.nextLine();

        // While the user input does not equal to "1" or "2",
        // Continue asking them for the valid input
        while(!Objects.equals(choice, "1") && !Objects.equals(choice, "2"))
        {
            System.out.println(RED + "\nSorry, invalid input." + RESET);
            System.out.println("Please enter 1 for single player or 2 for two players: ");
            choice = scanner.nextLine();
        }

        // Selects the correct method depending on the user input
        switch (choice)
        {
            case "1":
                System.out.println(YELLOW + "\nNow loading single player game..." + RESET);
                OnePlayer();
                break;
            case "2":
                System.out.println(YELLOW + "\nNow loading two player game..." + RESET);
                TwoPlayer();
        }

    }

    public static void OnePlayer()
    {
          System.out.println(GREEN + "Starting the game!" + RESET);
//        Sayuni will do this:
//        2) If the user selects 1 player (versus Minimax AI)
//        a. The Human player should be asked their name
//        b. The player must be prompted to choose their symbol (‘X’ or O’)
//        c. The player with symbol ‘X’ should go first (computer or human player).
//        d. The present board state will be displayed and:
//        1. If the computer is to play, it will now show the board updated with the
//        computer’s symbol.
//        2. If it is the player’s turn, the player will be prompted for a row and column
//        location to play.
//        e. The board will then be checked for a winning state or draw and if it is not in a winning
//        state or draw(tie), go to step d otherwise display the winner or declare a draw (tie).

    }

    public static void TwoPlayer()
    {

        System.out.println(GREEN + "Starting the game!\n" + RESET);
        String winner = "";
        String p1Symbol;
        String p2Symbol = "";
        boolean draw = false;

        System.out.print("Player 1 | Please enter your name: ");
        String p1 = scanner.nextLine();

        nameCheckTwoPlayerGame(p1);

        System.out.print("Please enter your symbol: ");
        p1Symbol = scanner.nextLine().toLowerCase();

        symbolCheckTwoPlayerGame(p1Symbol, p2Symbol);

        System.out.print("Player 2 | Please enter your name: ");
        String p2 = scanner.nextLine();

        nameCheckTwoPlayerGame(p2);

        System.out.print("Please enter your symbol: ");
        p2Symbol = scanner.nextLine().toLowerCase();

        symbolCheckTwoPlayerGame(p1Symbol, p2Symbol);

        // While the winner is not either player one or player two or a draw has not been reached,
        // Continue the game
        while (!Objects.equals(winner, p1) || !Objects.equals(winner, p2) || !Objects.equals(draw, true))
        {

            // Make an array of integers that has three columns and rows
            int[][] array = new int[3][3];

            System.out.println("Player 1 | Enter the column and row (comma separated):");

            columnsRowsCheckTwoPlayerGame(winner, draw, p1Symbol, array);

            System.out.println("Player 2 | Enter the column and row (comma separated):");

            columnsRowsCheckTwoPlayerGame(winner, draw, p2Symbol, array);


            // Check if the result of the method matches one of the conditions,
            // If true, break out of the while loop
            if (columnsRowsCheckTwoPlayerGame(winner, draw, p1Symbol, array).equals("Player 1"))
            {
                winner = p1;
            }else if(columnsRowsCheckTwoPlayerGame(winner, draw, p2Symbol, array).equals("Player 2"))
            {
                winner = p2;
            }else if (columnsRowsCheckTwoPlayerGame(winner, draw, p1Symbol, array).equals("draw") && columnsRowsCheckTwoPlayerGame(winner, draw, p2Symbol, array).equals("draw"))
            {
                draw = true;
            }

        }

        if (!Objects.equals(winner, ""))
        {
            System.out.println(GREEN + "CONGRATULATIONS! " + winner + " has won the game!" + RESET);
        }
        else if (draw)
        {
            System.out.println(GREEN + "DRAW! " + p1 + " and " + p2 + " have tied" + RESET);
        }


    }

    public static String columnsRowsCheckTwoPlayerGame(String winner, boolean draw, String curPlayer, int[][] array)
    {
        while (true)
        {

            String[] data;
            try
            {

                data = scanner.nextLine().split(",");

                // Try to parse the columns and rows
                int p2Column = Integer.parseInt(data[0].trim());
                int p2Row = Integer.parseInt(data[1].trim());

                // If the player has the symbol 'x', pass that symbol which uniquely identifies that player
                // Otherwise, pass the symbol that uniquely identifies the second player
                // Regardless, the array with the indicated column and row will be passed
                if (Objects.equals(curPlayer, "x")){
                    return tablePrintAndCheckResult("x", array[p2Column][p2Row]);
                }else{
                    return tablePrintAndCheckResult("o", array[p2Column][p2Row]);
                }
            } catch (Exception e)
            {
                System.out.println(RED + "\nSorry, invalid input" + RESET);
                System.out.println("\nPlease, enter a valid input");
                columnsRowsCheckTwoPlayerGame(winner, draw, curPlayer, array);
            }

        }
    }

    public static String tablePrintAndCheckResult(String symbol, int array)
    {

        String result = "";

        // Print the table with the current placements of all the symbols
        System.out.println(
                BLUE + "   Table\n" + RESET +
                "   |   " +    "|\n" +
                "---" + "|---" + "|" + "---\n" +
                "---" + "|---" + "|" + "---\n" +
                "   |   " + "|"
        );

        // Check if the result is one of the players or a draw
        if (Objects.equals(result, "Player 1"))
        {
            return result;
        }else if (Objects.equals(result, "Player 2"))
        {
            return result;
        }else if (result.equals("draw"))
        {
            return result;
        }

        return "Continuing";
    }

    public static void nameCheckTwoPlayerGame(String name)
    {

        // While the input does not contain only letters,
        // Continue asking for the valid input
        while (!name.matches("^[a-zA-Z]+$"))
        {
            System.out.println(RED + "\nSorry, invalid input." + RESET);
            System.out.print("Please enter your name: ");
            name = scanner.nextLine();
        }

    }

    public static void symbolCheckTwoPlayerGame(String p1Symbol, String p2Symbol)
    {

        // While the symbols are the same,
        // continue asking for the valid input
        while (Objects.equals(p1Symbol, p2Symbol))
        {
            System.out.println(RED + "\nSorry, invalid input." + RESET);
            System.out.print("Cannot be the same. enter your symbol: ");
            p2Symbol = scanner.nextLine().toLowerCase();
        }

        // While symbols do not contain either 'x' or 'o',
        // continue asking for the valid input
        while (!Objects.equals(p1Symbol, "o")  && !Objects.equals(p1Symbol, "x") && !Objects.equals(p2Symbol, "o")  && !Objects.equals(p2Symbol, "x"))
        {
            System.out.println(RED + "\nSorry, invalid input." + RESET);
            System.out.print("Please enter your symbol: ");
            p2Symbol = scanner.nextLine().toLowerCase();
        }

    }
}