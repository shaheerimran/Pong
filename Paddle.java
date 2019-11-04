import java.awt.Color;
import java.awt.Graphics;


public class Paddle {
	//Coordinates
	private int x;
	private int y;

	//Dimensions
	private int height;
	private int width;
	
	//Vertical velocity
	private int velocity;
	
	//Score
	private int score;
	
	//Color
	private Color c;
	
	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}
	
	public Paddle(){
		x = 10;
		y = 10;
		height = 140;
		width = 20;
		c = Color.white;
		velocity = 0;
	}
	
	public Paddle(int x_param, int y_param, int w, int h, Color hue, int v){
		x = x_param;
		y = y_param;
		height = h;
		width = w;
		c = hue;
		velocity = v;
	}
	
	public void paint(Graphics g){
		g.setColor(c);
		g.fillRect(x, y, width, height);
	}
	
	public void move(){
		y += velocity;
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
}
