import javax.swing.ImageIcon;

public class Bishop extends Piece
{
	public Bishop(Boolean color)
	{
		super(color);
		
		if(color)
		{
			image=new ImageIcon("wbishop.gif");
		} else {
			image=new ImageIcon("bbishop.gif");
		}
	}
		
		public boolean canMove(int startx, int starty, int endx, int endy) 
		{
			int i;
			if(Chess.position[endx][endy] != null && Chess.position[endx][endy].color == color) //checks for move on own piece
			{
				return false;
			} 
		else if (startx > endx && starty > endy) //up and left
		{
			if((startx-endx) == (starty-endy)) //checking that piece moved the same amount of spaces in each direction
			{
				int diagonal = 1;
				for(i = startx - 1; i > endx; i--)
				{
					if(Chess.position[startx - diagonal][starty - diagonal] != null) //checks each position diagonally for other pieces until the end//
						return false;												//coordinates and returns false if it finds a piece in a spot that is not the end destination//
						diagonal += 1;
				}
			} else {
				return false;
			}
		} 
		else if (startx < endx && starty > endy) //up and right
		{
			if((startx-endx) == (-(starty-endy))) //checking that piece moved the same amount of spaces in each direction
			{
				int diagonal = 1;
				for(i = startx + 1; i < endx; i++)
				{
					if(Chess.position[startx + diagonal][starty - diagonal] != null) 
						return false;
						diagonal += 1;
				}
			} else {
				return false;
			}
		}
		else if (startx < endx && starty < endy) //down and right
		{
			if((startx-endx) == (starty-endy)) //checking that piece moved the same amount of spaces in each direction
			{
				int diagonal = 1;
				for(i = startx + 1; i < endx; i++)
				{
					if(Chess.position[startx + diagonal][starty + diagonal] != null) 
						return false;
						diagonal += 1;
				}
			} else {
				return false;
			}
		}
		else if (startx > endx && starty < endy) //down and left
		{
			if((-(startx-endx)) == (starty-endy)) //checking that piece moved the same amount of spaces in each direction
			{
				int diagonal = 1;
				for(i = startx - 1; i > endx; i--)
				{
					if(Chess.position[startx - diagonal][starty + diagonal] != null) 
						return false;
						diagonal += 1;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}
}
