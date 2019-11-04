import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
//LEAVE SUGGESTIONS AT BOTTOM!!!!!!!!!!!!!!!!!

public class Driver extends JPanel implements ActionListener, KeyListener {
	int table_width = 900; //width of the screen "table"
	int table_height = 600;//height of the screen "table"

	//ball
	Ball ball = new Ball();
	

	//Paddles
	Paddle left = new Paddle(20, 20, 20, 140, Color.white, 0);
	Paddle right = new Paddle(860, 20, 20, 140, Color.white, 0);



	public int getTW(){
		return table_width;
	}

	public int getTH(){
		return table_height;
	}

	public void paint(Graphics g) {

		super.paintComponent(g);

		//draw table
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, table_width, table_height);

		//ball: drawing
		ball.paint(g);
		
		//paddles: drawing
		left.paint(g);
		right.paint(g);

		//score counter
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Courier", 0, 50));
		g.drawString(right.getScore() + "", 600, 200);
		g.drawString(left.getScore() + "", 300, 200);
	}

	//update data/variables
	public void update(){
		//Ball moving
		ball.setX(ball.getX() + ball.getV_x());
		ball.setY(ball.getY() + ball.getV_y());
		
		//Paddles moving
	    left.move();
	    right.move();
		
		//bottom wall collision for ball
		if(ball.getY() > 530){
			ball.setV_y(-ball.getV_y());
		}
		
		//bottom wall collision for paddles
		if(right.getY() + right.getHeight() >= table_height - right.getHeight()){
			right.setVelocity(0);
		}
		
		if(left.getY() + left.getHeight() >= table_height - left.getHeight()){
			left.setVelocity(0);
		}
		
		//top wall collision for ball
		if(ball.getY() < 0){
			ball.setV_y(-ball.getV_y());
		}

		//top wall collision for paddles
		
		if(right.getY() <= 10){
			right.setVelocity(0);
		}
		
		if(left.getY() <= 10){
			left.setVelocity(0);
		}
		
		//right wall collision + add score to left player + reset ball
		if(ball.getX() > 850){
			ball.setX(table_width / 2);
			ball.setY(table_height / 2);			
			ball.setV_x(-ball.getV_x());
			ball.setV_y(-ball.getV_y());
			left.setScore(left.getScore() + 1);
		}


		//left wall collision + add score to right player + reset ball
		if(ball.getX() < 0){
			ball.setX(table_width / 2);
			ball.setY(table_height / 2);			
			ball.setV_x(-ball.getV_x());
			ball.setV_y(-ball.getV_y());
			right.setScore(right.getScore() + 1);
		}
		
		//left paddle collision
		if(ball.collided(left)){
			ball.setV_x(-ball.getV_x());
		}
		
		//right paddle collision
		if(ball.collided(right)){
			ball.setV_x(-ball.getV_x());
		}

	}//end of update function


	@Override
	public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub

		update();
		repaint();

	}
	
	public static void main(String[] arg) {
		Driver d = new Driver();
	}
	
	public Driver(){
		//Make window
		JFrame f = new JFrame();
		f.setTitle("Pong");
		f.setSize(table_width,table_height);
		f.setBackground(Color.BLACK);
		f.setResizable(false);

		//add code to listen to inputs
		f.addKeyListener(this);

		f.add(this);	
		t = new Timer(17,this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	Timer t;


	@Override
	public void keyPressed(KeyEvent arg0) {

		//check if right paddle is in range and if up arrow is pressed
		if(right.getY() >= 10){
			if(arg0.getKeyCode() == 38){
				right.setVelocity(-5);
			}
		}	

		//check if right paddle is in range and if bottom arrow is pressed
		if(right.getY() + right.getHeight() <= table_height - 30){
			if(arg0.getKeyCode() == 40){
				right.setVelocity(5);
			}
		}

		//check if left paddle is in range and if 'w' is pressed
		if(left.getY() >= 10){
			if(arg0.getKeyCode() == 87){	
				left.setVelocity(-5);
			}
		}

		//check if left paddle is in range and if 's' is pressed
		if(left.getY() + left.getHeight() <= table_height - 30){
			if(arg0.getKeyCode() == 83){
				left.setVelocity(5);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//released
		if(e.getKeyCode() == 38 || e.getKeyCode() == 40){
			right.setVelocity(0);
		}
		
		if(e.getKeyCode() == 87 || e.getKeyCode() == 83){
			left.setVelocity(0);
		}
}

@Override
	public void keyTyped(KeyEvent e) {
	//pressed AND released

}
}
/*SUGGESTIONS PLEASE!!!
* Try to make it so that it bounces back to the center of paddle if it hits the side
* Ball does not collide with paddle if it hits the corner. Otherwise it good
* Try and make it so that after the ball reaches out of bounds, the velocity is reversed
* Funny hitbox
* cool game hit box wack
* very good
* cool game
* top of paddle hitbox is missing, otherwise game works well
* A little slow
* */
