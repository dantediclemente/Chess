import javax.swing.ImageIcon;

public class King extends Piece
{
	public King(Boolean color)
	{
		super(color);
		
		if(color)
		{
			image=new ImageIcon("wking.gif");
		} 
		else
		{
			image=new ImageIcon("bking.gif");
		}
	}
	public boolean canMove(int startx, int starty, int endx, int endy) 
	{
		if(Chess.position[endx][endy] != null && Chess.position[endx][endy].color == color) //checks for move on own piece
		{
			return false;
		} 
		else if(endx-startx <= 1 && endy-starty <=1 && endx-startx >= -1 && endy-starty >=-1) //checks that the king is only moving one space in any direction
		{ 
			return true;
		} 
		else 
		{
			return false;
		}
	}
}
