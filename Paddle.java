import java.awt.Color;
import java.awt.Graphics;


public class Paddle {
	private int x;
	private int y;
	
	private int height;
	private int width;
	
	private int velocity;
	
	private int score;
	
	private Color c;
	
	public Paddle(int x_param, int y_param, int w, int h, Color hue){
		x = x_param;
		y = y_param;
		height = h;
		width = w;
		c = hue;
	}
	
	public void paint(Graphics g){
		g.setColor(c);
		g.fillRect(x, y, width, height);
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
	
	public int getVelocity(){
		return velocity;
	}
	
	public void setVelocity(int i){
		velocity = i;
	}
	
	public int getWidth(){
		return width;
	}
	
	public void setWidth(int i){
		width = i;
	}
	
	public int getHeight(){
		return height;
	}
	
	public void setHeight(int i){
		height = i;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int i) {
		score = i;
	}
	
	public void smoothUpMovement(){
		this.y -= this.velocity;
	}
	
	public void smoothDownMovement(){
		this.y += this.velocity;
	}
}
