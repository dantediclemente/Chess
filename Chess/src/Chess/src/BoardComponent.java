import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
@SuppressWarnings("serial")

public class BoardComponent extends JComponent
{
	Color firstColor = new Color(233,174,95);
	Color secondColor = new Color(177,113,24);
	
	public void paintComponent(Graphics g) 
	{
		for(int x = 0; x < 8; x++) //paints a board of 64 spots
		{
			for(int y = 0; y < 8; y++)
			{
				if(x % 2 == 0 && y % 2 == 0) //paints every other square opposite color
				{
					g.setColor(firstColor); 
				} else if (x % 2 != 0 && y % 2 != 0) {
					g.setColor(firstColor);
				} else {
					g.setColor(secondColor);
				}
				int a;
				int b;
				a = x * 44; //
				b = y * 44;
				g.fillRect(a, b, 44, 44);
			}
		}
		for(int x = 0; x < 8; x++) //loops through to check for pieces
		{
			for(int y = 0; y < 8; y++)
			{	
				if(Chess.position[x][y] != null)
				{
					Chess.position[x][y].drawPiece(g, x, y); //draws piece if it is not null
					repaint(); //refreshes after move
					
					if(Chess.KingExit())
						System.exit(0);
				}
			}
		}
	}
	
}