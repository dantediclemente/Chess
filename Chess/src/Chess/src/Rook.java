import javax.swing.ImageIcon;

public class Rook extends Piece
{
	public Rook(Boolean color)
	{
		super(color);
		
		if(color)
		{
			image=new ImageIcon("wrook.gif");
		} else {
			image=new ImageIcon("brook.gif");
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
		else 
		{
			return false;
		}
		return true;
	}
}
