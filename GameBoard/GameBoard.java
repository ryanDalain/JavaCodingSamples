import java.math.*;

public class GameBoard
{

	private int[][] board;
	private int numRows, numCols;
	
	public GameBoard(int[][] board, int rows, int columns)
	{
		this.board = board;
		this.numRows = rows;
		this.numCols = columns;
	}
	
	public GameBoard()
	{
		this.board = new int[5][5];
		this.numRows = 5;
		this.numCols = 5;
		initializeDefaultBoard();
	}
	
	private void initializeDefaultBoard()
	{
		for(int i = 0; i < numRows; i++)
			for(int j = 0; j < numCols; j++)
				board[i][j] = (int)(1 + Math.random()*9);
	}
	
	public void printBoard()
	{
		for(int i = 0; i < numRows; i++)
		{
			for(int j = 0; j < numCols; j++)
				System.out.format("%d", board[i][j]);
			System.out.println();
		}
	}
	
	public int getRows()
	{
		return this.numRows;
	}
	
	public int getColumns()
	{
		return this.numCols;
	}
	
	// if there are 3 in a row vertically or horizontally, then the board is not in a valid state
	// returns true				returns false
	// [x][x][y][z][z]			[x][x][y][z][z]
	// [y][z][z][y][z]			[y][z](z)[y][z]
	// [y][x][y][x][x]			[y][x](z)[x][x]
	// [x][y][z][x][y]			[x][y](z)[x][y]
	// [y][z][x][y][z]			[y][z][x][y][z]
	public boolean validBoard()
	{
		
		for(int r = 0; r < numRows; r++)
		{
			for(int c = 0; c < numCols; c++)
			{
				// if there is board spaces above and below us, check them
				if((r-1) >= 0 && (r+1) <= numRows-1)
					if(board[r][c] == board[r+1][c] && board[r][c] == board[r-1][c])
						return false;
				// if there is board spaces to the left and right of us, check them
				if((c-1) >= 0 && (c+1) <= numCols-1)
					if(board[r][c] == board[r][c+1] && board[r][c] == board[r][c-1])
						return false;
			}
		}
		
		return true;
	}

}
