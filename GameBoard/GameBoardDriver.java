public class GameBoardDriver
{

	public static void main(String[] args)
	{
		GameBoard gameBoard = new GameBoard();
		gameBoard.printBoard();
		if(gameBoard.validBoard() == false)
			System.out.println("Invalid Board...");
		else
			System.out.println("Valid Board!");		


		int[][] board = {	{0,2,0},
							{0,2,3},
							{0,1,2},
							{2,1,1}};
					
		GameBoard gameBoard2 = new GameBoard(board, 4, 3);
		
		gameBoard2.printBoard();
		if(gameBoard2.validBoard() == false)
			System.out.println("Invalid Board2...");
		else
			System.out.println("Valid Board!");
	}

}