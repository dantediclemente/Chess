import java.awt.Graphics;

import javax.swing.ImageIcon;

public abstract class Piece
{
	boolean color; //true = white
	ImageIcon image;
	
	public Piece(Boolean color)  //constructor 
	{
		this.color = color;
		image=new ImageIcon();
	}
	public void drawPiece(Graphics g, int x, int y) //draws piece on board
	{
		image = Chess.position[x][y].image;
	  	g.drawImage(image.getImage(),x*44,y*44,null);
	}
	
	abstract boolean canMove(int startx, int starty, int endx, int endy); //makes sure all pieces have valid moves
}
