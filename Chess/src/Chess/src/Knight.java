import javax.swing.ImageIcon;

public class Knight extends Piece 
{
	public Knight(Boolean color)
	{
		super(color);
		
		if(color)
		{
			image=new ImageIcon("wknight.gif");
		} else {
			image=new ImageIcon("bknight.gif");
		}
	}
	
	public boolean canMove(int startx, int starty, int endx, int endy) 
	{
		if(Chess.position[endx][endy] != null && Chess.position[endx][endy].color == color) //checks for move on own piece
		{
			return false;
		} 
		else if((startx-endx) == -1 && (starty - endy) == 2 || (startx-endx) == -2 && (starty - endy) == 1) //up and right
		{
			return true;
		}
		else if((startx-endx) == 1 && (starty - endy) == 2 || (startx-endx) == 2 && (starty - endy) == 1) //up and left
		{
			return true;
		} 
		else if((startx-endx) == -1 && (starty - endy) == -2 || (startx-endx) == -2 && (starty - endy) == -1) //down and right
		{
			return true;
		}
		else if((startx-endx) == 1 && (starty - endy) == -2 || (startx-endx) == 2 && (starty - endy) == -1) //down and left
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}
}
