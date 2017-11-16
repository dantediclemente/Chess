import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardMouseListener implements MouseListener
{	
	public int startx; //variables for positions on board
	public int starty;
	public int endx;
	public int endy;
	
	public void mousePressed(MouseEvent e)  //gets coordinates and divides them to make an integer 0 through 7
	{
		startx = e.getX()/44;
		starty = e.getY()/44;
	}
	
	public void mouseReleased(MouseEvent e) 
	{
		endx = e.getX()/44;
		endy = e.getY()/44;
		if(startx < 8 && //if statement checks if you are making moves with your own pieces only etc...
			startx >= 0 &&
			starty < 8 && 
			starty >= 0 &&
			endx < 8 && 
			endx >= 0 && 
			endy < 8 && 
			endy >= 0 &&
			(startx != endx || starty != endy) &&
			Chess.position[startx][starty] != null &&
			Chess.position[startx][starty].color == true &&
			Chess.position[startx][starty].canMove(startx, starty, endx, endy) == true) //checks if moves are valid
		{
			Chess.position[endx][endy] = Chess.position[startx][starty]; //changes position of piece if valid
			Chess.position[startx][starty] = null;
			while(true) //randomly generates moves by a computer player
			{
				int compStartx = (int)(Math.random()*8);
				int compEndx = (int)(Math.random()*8);
				int compStarty = (int)(Math.random()*8);
				int compEndy = (int)(Math.random()*8);

				if(Chess.position[compStartx][compStarty]==null || //checks that it starts on a piece
					Chess.position[compStartx][compStarty].color == true || //checks that it is not a white piece
					Chess.position[compStartx][compStarty] == Chess.position[compEndx][compEndy] || //checks that the piece does not start and end in same place
					Chess.position[compStartx][compStarty].canMove(compStartx, compStarty, compEndx, compEndy) == false) //checks if computer players move is valid
				{	
					continue;
				} else {
					Chess.position[compEndx][compEndy] = Chess.position[compStartx][compStarty]; //changes position of computer piece if valid
					Chess.position[compStartx][compStarty] = null;
					break;
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
