public class Gameplay {

    /**
     * The gameplay table
     */
    private final String[][] table = {
            {"+", "---", "-", "---", "-", "---", "+",},
            {"|", "   ", "|", "   ", "|", "   ", "|",},
            {"|", "---", "+", "---", "+", "---", "|",},
            {"|", "   ", "|", "   ", "|", "   ", "|",},
            {"|", "---", "+", "---", "+", "---", "|",},
            {"|", "   ", "|", "   ", "|", "   ", "|",},
            {"+", "---", "-", "---", "-", "---", "+",},
    };

    /**
     * The player 1 (X)
     */
    private final Player player1;
    /**
     * The player 2 (O)
     */
    private final Player player2;
    /**
     * {@link Player} object to handle the players turn
     */
    private Player playerTurn;

    /**
     * The one and only constructor to generate the gameplay
     * @param player1 the player1 object
     * @param player2 the player2 object
     */
    public Gameplay(Player player1, Player player2){
        this.player1 = player1;
        this.player2 =  player2;
        playerTurn = player1;
    }



    /**
     * Call this method to print the TicTacToe table
     */
    public void printTable(){
        for (String[] strings : table) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    /**
     * Function to get the player's name and symbol at a readable way! (For menu usage)
     * @return player info (readable way!)
     */
    public String getPlayerTurnToString(){
        return playerTurn.toString();
    }

    /**
     * Change the {@code player} symbol at given {@code position}.
     * @param position the table position
     * @return true if there is a winner, false otherwise
     */
    public boolean setPlayerOption(int position){

        // first, we have to check if the given position is valid
        if(!verifyPosition(position)){
            System.out.println("Cannot add here!");
            return false;
        }

        String symbolToAdd = playerTurn.symbol();
        // X is at first position of the int[]
        // Y is at the second position
        int[] positionXY = new int[]{
                UserInput.replaceUserPosToXY(position)[0],
                UserInput.replaceUserPosToXY(position)[1]
        };

        // set the new symbol to the table
        table[positionXY[0]][positionXY[1]] = " " + symbolToAdd + " ";

        // pre-pre-final step:
        // check if current player is winner
        if(isCurrentPlayerWinner()){
            printTable();
            System.out.println("We have a winner...Congratulations " + playerTurn.name());
            return true;
        }

        // pre-final step:
        // check if there is a tie!
        if(isTie()){
            printTable();
            System.out.println("No one win! TIE");
            return true;
        }

        // final step:
        // if current player is not winner, change the player's turn
        if(playerTurn == player1) playerTurn = player2;
        else playerTurn = player1;

        printTable();
        return false;
    }

    /**
     * Function to get if this position is available for the user to add a symbol.
     * @param position the user input position as a number
     * @return true if this position is available
     */
    private boolean verifyPosition(int position){
        int x = UserInput.replaceUserPosToXY(position)[0];
        int y = UserInput.replaceUserPosToXY(position)[1];

        // if user gives a number different from >9 and <0 then the replaceUserPosToXY return [-1, -1]
        if(x==-1 && y==-1) return false;

        // only if table[x][y] has a space as string, the function will return true
        return table[x][y].equalsIgnoreCase("   ");
    }

    /**
     * Check if the current player is winner. This method will call other 4 sub-methods to perform the job!
     * @return true if current player is winner, false otherwise
     */
    private boolean isCurrentPlayerWinner(){
        if(checkRow(1)) return true;
        if(checkRow(3)) return true;
        if(checkRow(5)) return true;

        if(checkColumn(1)) return true;
        if(checkColumn(3)) return true;
        if(checkColumn(5)) return true;

        if(checkDiagonal()) return true;
        return checkReverseDiagonal();
    }

    /**
     * Function to check table if not any player is winner.
     * @return true if not any player wins
     */
    private boolean isTie(){
        // check every table position for empty string.
        // if any empty string found, means that the game still on! No tie.
        if(table[1][1].trim().equalsIgnoreCase("")) return false;
        if(table[1][3].trim().equalsIgnoreCase("")) return false;
        if(table[1][5].trim().equalsIgnoreCase("")) return false;
        if(table[3][1].trim().equalsIgnoreCase("")) return false;
        if(table[3][3].trim().equalsIgnoreCase("")) return false;
        if(table[3][5].trim().equalsIgnoreCase("")) return false;
        if(table[5][1].trim().equalsIgnoreCase("")) return false;
        if(table[5][3].trim().equalsIgnoreCase("")) return false;
        // last option can be as return but with "not" operator
        return !table[5][5].trim().equalsIgnoreCase("");
    }

    /**
     * Function to check given {@code row} for winner
     * @param row given row to scan
     * @return true if current player's symbol is at every available position of the given row
     */
    private boolean checkRow(int row){
        int winnerCount = 0;
        if(table[row][1].trim().equalsIgnoreCase(playerTurn.symbol())) winnerCount++;
        if(table[row][3].trim().equalsIgnoreCase(playerTurn.symbol())) winnerCount++;
        if(table[row][5].trim().equalsIgnoreCase(playerTurn.symbol())) winnerCount++;
        return winnerCount == 3;
    }

    /**
     * Function to check given {@code column} for winner
     * @param column given column to scan
     * @return true if current player's symbol is at every available position of the given column
     */
    private boolean checkColumn(int column){
        int winnerCount = 0;
        if(table[1][column].trim().equalsIgnoreCase(playerTurn.symbol())) winnerCount++;
        if(table[3][column].trim().equalsIgnoreCase(playerTurn.symbol())) winnerCount++;
        if(table[5][column].trim().equalsIgnoreCase(playerTurn.symbol())) winnerCount++;
        return winnerCount == 3;
    }

    /**
     * Function to check the diagonal line of the table for a winner
     * @return true if current player's symbol is at every position of the diagonal table line
     */
    private boolean checkDiagonal(){
        int winnerCount = 0;
        if(table[1][1].trim().equalsIgnoreCase(playerTurn.symbol())) winnerCount++;
        if(table[3][3].trim().equalsIgnoreCase(playerTurn.symbol())) winnerCount++;
        if(table[5][5].trim().equalsIgnoreCase(playerTurn.symbol())) winnerCount++;
        return winnerCount == 3;
    }

    /**
     * Function to check the reverse diagonal line of the table for a winner
     * @return true if current player's symbol is at every position of the reverse diagonal table line
     */
    private boolean checkReverseDiagonal(){
        int winnerCount = 0;
        if(table[5][1].trim().equalsIgnoreCase(playerTurn.symbol())) winnerCount++;
        if(table[3][3].trim().equalsIgnoreCase(playerTurn.symbol())) winnerCount++;
        if(table[1][5].trim().equalsIgnoreCase(playerTurn.symbol())) winnerCount++;
        return winnerCount == 3;
    }



}
