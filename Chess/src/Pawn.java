import javax.swing.ImageIcon;

public class Pawn extends Piece
{
	public Pawn(Boolean color)
	{
		super(color);
		
		if(color)
		{
			image=new ImageIcon("wpawn.gif");
		} else {
			image=new ImageIcon("bpawn.gif");
		}
	}
	public boolean canMove(int startx, int starty, int endx, int endy) 
	{
		if(Chess.position[endx][endy] != null && Chess.position[endx][endy].color == color) //checks for move on own piece
		{
			return false;
		} 
		else if (Chess.position[startx][starty].color == true) //move one or 2 spaces off the start for white piece
		{
			if(starty == 1 && (endy == 2 || endy == 3) && (startx - endx == 0) && (Chess.position[endx][endy] == null))
			{
				return true;
			}
			else if(starty == 6 && endy == 7 && (startx - endx == 0)) //transform white pawn to queen
			{
				Chess.position[startx][starty] = null;
				Chess.position[startx][starty] = new Queen(true);
				return true;
			}
			else if((starty - endy == -1) && (startx - endx == 0) && (Chess.position[endx][endy] == null)) //moving down for white piece
			{
				return true;
			}
			else if((starty - endy == -1) && ((startx - endx == -1) || (startx - endx == 1)) && (Chess.position[endx][endy] != null)) //attacking for white piece
			{
				return true;
			}
		}
		else if (Chess.position[startx][starty].color == false) //move one or 2 spaces off the start for black piece
		{
			if(starty == 7 && (endy == 5 || endy == 4) && (startx - endx == 0) && (Chess.position[endx][endy] == null))
			{
				return true;
			}
			else if(starty == 1 && endy == 0 && (startx - endx == 0)) //transform black pawn to queen
			{
				Chess.position[startx][starty] = null;
				Chess.position[startx][starty] = new Queen(true);
				return true;
			}
			else if((starty - endy == 1) && (startx - endx == 0) && (Chess.position[endx][endy] == null)) //moving up for black piece
			{
				return true;
			}
			else if((starty - endy == 1) && ((startx - endx == -1) || (startx - endx == 1)) && (Chess.position[endx][endy] != null)) //attacking for black piece
			{
				return true;
			}
		}
		else 
		{
			return false;
		}
		return false;
	}
}
		
