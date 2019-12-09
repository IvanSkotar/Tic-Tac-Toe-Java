import java.util.Scanner;

public class TicTacToe{
   static int row = 0;
   static int col = 0;
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int index = 1;
    char player = 'X';
    char[][] grid = { { ' ', ' ', ' '},
                      { ' ', ' ', ' '},
                      { ' ', ' ', ' '}
                    };
    printGrid(grid);
    while (!isWinner(grid, player)){
      if(index % 2 == 0){
        player = 'O';
      }
      else{
        player = 'X';
      }
      playTurn(input, player);
      while(isPositionTaken(grid, row, col) == true){
        playTurn(input, player);
      }
      setGridValue(grid, player, row, col);
			printGrid(grid);
			if (isWinner(grid, player)){
			  System.out.printf("Player " + player + " wins!!!");
			  System.exit(0);
			}
			if (isDraw(grid)){
			  System.out.printf("It is a draw!!!");
			  System.exit(0);
			}
			index++;
  	} 
  }
  // print a tic tac toe grid  
  public static void printGrid(char[][] grid) {
    System.out.println("+---+---+---+");
    for (int i = 0; i < grid.length; i++){
      System.out.print("|");
        for (int j = 0; j < grid.length; j++){
          System.out.print(" " + grid[i][j] + " |");
        }
    System.out.println();
    System.out.println("+---+---+---+");
    }
  }
  // set a grid value, row and column are 0, 1, or 2
  public static void setGridValue(char[][] grid, char value, int row, int col) {
    if(value == 'X' || value == 'O'){
      grid[row - 1][col - 1] = value;
    }
    else{
      System.out.println("Wrong value");
    }
  }
  public static boolean isWinner(char[][] grid, char value) {
  // Check if someone won
    if(grid[0][0] == value && grid[0][1] == value && grid[0][2] == value)
      return true;
    if(grid[1][0] == value && grid[1][1] == value && grid[1][2] == value)
      return true;
    if(grid[2][0] == value && grid[2][1] == value && grid[2][2] == value)
      return true;
    if(grid[0][0] == value && grid[1][0] == value && grid[2][0] == value)
      return true;
    if(grid[0][1]  == value && grid[1][1] == value && grid[2][1] == value)
      return true;
    if(grid[0][2]  == value && grid[1][2] == value && grid[2][2] == value)
      return true;
    if(grid[0][0]  == value && grid[1][1] == value && grid[2][2] == value)
      return true;
    if(grid[0][2]  == value && grid[1][1] == value && grid[2][0] == value)
      return true;
    return false;
  }
  public static boolean isPositionTaken(char[][] grid, int row, int col) {
  // Check if pisition taken
    if(grid[row - 1][col - 1] == 'X' || grid[row - 1][col - 1] == 'O'){
      System.out.println("Position taken. Try again.");
      return true;
    }
    return false;
  }
  // Check if all nine spots are taken
  public static boolean isDraw(char[][] grid) {
    int emptyCels = 0;
    for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid[i].length; j++){
        if(grid[i][j] == ' '){
          emptyCels++;
        }
      }
    }
    if(emptyCels == 0){
      return true;
    }
    return false;
  }
  public static void playTurn(Scanner input, char player){
    System.out.print("Player " + player + ", enter row and column: ");
    if (input.hasNextInt()){
      row = input.nextInt();
			col = input.nextInt();
		}
		else {
		  System.out.print("Not a number. Exiting.");
			System.exit(0);
		}
		if ((row < 1 || row > 3) || (col < 1 || col > 3)){
		  System.out.println("Value not 1,2 or 3. Exiting.");
      System.exit(0);
		}
  }
}
