import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Ball {
	//coordinates
	private int x;
	private int y;
	
	//velocity
	private int v_x;
	private int v_y;
	
	//size
	private int width; 
	
	//color
	private Color color;
	
	//Default constructor
	public Ball(){
		x = 450;
		y = 300;
		v_x = 4;
		v_y = 3;
		width = 50;
		color = Color.WHITE;
	}
	
	//Draw ball
	public void paint(Graphics g){
		g.setColor(color);
		g.fillOval(x, y, width, width);
	}
	
	// check if ball collided with paddle
	public boolean collided(Paddle p){
		
		Rectangle b = new Rectangle(x, y, width, width);
		Rectangle pad = new Rectangle(p.getX(), p.getY(), p.getWidth(), p.getHeight());
		
		return b.intersects(pad);
		
	}
	
	public int getX(){
		return x;
	}
	
	public void setX(int i){
		x = i;
	}
	
	public int getY(){
		return y;
	}
	
	public void setY(int i){
		y = i;
	}
	
	public int getWidth(){
		return width;
	}
	
	public void setWidth(int i){
		width = i;
	}
	
	public int getV_x() {
		return v_x;
	}

	public void setV_x(int i) {
		v_x = i;
	}

	public int getV_y() {
		return v_y;
	}

	public void setV_y(int i) {
		v_y = i;
	}
	
	public Color getColor(){
		return color;
	}
	
	public void setColor(Color c){
		color = c;
	}
}
