import javax.swing.JFrame;

public class Chess
{
	public static final int WINDOWWIDTH = 352;
	public static final int WINDOWHEIGHT = 372;
	
	public static Piece[][] position = new Piece[8][8]; //creates 2D array
	public static BoardComponent board;
	
	public static void main(String[] args) 
	{	
		position[0][0] = new Rook(true); //white pieces
		position[1][0] = new Knight(true);
		position[2][0] = new Bishop(true);
		position[3][0] = new Queen(true);
		position[4][0] = new King(true);
		position[5][0] = new Bishop(true);
		position[6][0] = new Knight(true);
		position[7][0] = new Rook(true);
		position[0][1] = new Pawn(true);
		position[1][1] = new Pawn(true);
		position[2][1] = new Pawn(true);
		position[3][1] = new Pawn(true);
		position[4][1] = new Pawn(true);
		position[5][1] = new Pawn(true);
		position[6][1] = new Pawn(true);
		position[7][1] = new Pawn(true);
		
		position[0][7] = new Rook(false); //black pieces
		position[1][7] = new Knight(false);
		position[2][7] = new Bishop(false);
		position[3][7] = new Queen(false);
		position[4][7] = new King(false);
		position[5][7] = new Bishop(false);
		position[6][7] = new Knight(false);
		position[7][7] = new Rook(false);
		position[0][6] = new Pawn(false);
		position[1][6] = new Pawn(false);
		position[2][6] = new Pawn(false);
		position[3][6] = new Pawn(false);
		position[4][6] = new Pawn(false);
		position[5][6] = new Pawn(false);
		position[6][6] = new Pawn(false);
		position[7][6] = new Pawn(false);
		
		JFrame window = new JFrame("Chess");
		window.setSize(WINDOWWIDTH, WINDOWHEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		board = new BoardComponent(); //creates board
		
		window.add(board);
		board.addMouseListener(new BoardMouseListener()); //adds listener 
		window.setVisible(true);
	}
	
	public static boolean KingExit() //method that exits window if king is captured
	{
		int king = 0;
		Piece kingRemaining = null;
		for(int x = 0; x < 8; x++)
		{
			for(int y = 0; y < 8; y++)
			{
				Piece piece = Chess.position[x][y];
				if (piece instanceof King) 
				{
					king += 1;
				} 		
			}
		}
		if(king != 2) //if there is not 2 kings on the board then the game exits
		{
			for(int x = 0; x < 8; x++)
			{
				for(int y = 0; y < 8; y++)
				{
					Piece piece = Chess.position[x][y];
					if (piece instanceof King) 
					{
						kingRemaining = Chess.position[x][y]; //determines what king was captured
					}
				}
			}
			
			if(kingRemaining.color == true) //lets you know if you won or lost
			{
				System.out.println("You won!");
			}
			else
			{
				System.out.println("You lost!");
			}
			return true;
		}
		else
		{
			return false;
		}
	}
}
