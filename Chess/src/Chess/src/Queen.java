import javax.swing.ImageIcon;

public class Queen extends Piece
{
	public Queen(Boolean color)
	{
		super(color);

		if(color)
		{
			image=new ImageIcon("wqueen.gif");
		} 
		else 
		{
			image=new ImageIcon("bqueen.gif");
		}
	}
	public boolean canMove(int startx, int starty, int endx, int endy) 
	{
		int i;
		if(Chess.position[endx][endy] != null && Chess.position[endx][endy].color == color) //checks for move on own piece
		{
			return false;
		} 
		else if(startx == endx)
		{
			if(starty < endy) 
			{
				for(i = starty + 1; i < endy; i++) //down
				{
					if(Chess.position[endx][i] != null)
						return false;
				}
			}
			else
			{
				for(i = starty - 1; i > endy; i--) //up
				{
					if(Chess.position[endx][i] != null)
						return false;
				}
			}
		} 
		else if(starty == endy)
		{
			if(startx < endx) 
			{
				for(i = startx + 1; i < endx; i++) //right
				{
					if(Chess.position[i][endy] != null)
						return false;
				}
			}
			else
			{
				for(i = startx - 1; i > endx; i--) //left
				{
					if(Chess.position[i][endy] != null)
						return false;
				}
			}
		} 
		else if (startx > endx && starty > endy) //up and left
		{
			if((startx-endx) == (starty-endy)) //checking that piece moved the same amount of spaces in each direction
			{
				int diagonal = 1;
				for(i = startx - 1; i > endx; i--)
				{
					if(Chess.position[startx - diagonal][starty - diagonal] != null) //checks each postion diagonally for other pieces until the end coordinates 
						return false;
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
		}
		return true;
	}
}

