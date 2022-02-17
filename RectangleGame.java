package rectgame1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class RectangleGame extends JPanel implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//number of lives
	int user = 1000;

	//number of points
	int point = 0;

	//coordinates of squares
	Timer time = new Timer (5, this);
	double x = 0, y = 0, s1_x = 0, s1_y = 0;
	double q = 200, w = 200, s2_x = 3.0, s2_y = 2.0;
	double z = 0, c = 300, s3_x = 1.5, s3_y = 3.0;
	double s = 600, d = 0, s4_x = 3.0, s4_y = 1.5;
	double j = 400, u = 0, s5_x = 3.5, s5_y = 2.0;

	public RectangleGame () {

		time.start();
		addKeyListener (this);
		setFocusable (true);
		setFocusTraversalKeysEnabled (false);

	}

	public void paintComponent (Graphics g) {

		super.paintComponent (g);
		//gives us more control over the geometry, colour, etc.
		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D square = new Rectangle2D.Double (x, y, 40, 40);
		g2.setColor (Color.RED);
		g2.fill(square);
		g2.drawString ("Red square = arrows key",625,40);
		g2.drawString ("Get 10,000 points to win",625,20);
		g2.drawString ("Lifes=" + user,625,60);
		g2.drawString ("Points =" + point,625,80);

		Graphics2D g1 = (Graphics2D) g;
		Rectangle2D square1 = new Rectangle2D.Double (q,w,150,150);
		g1.setColor (Color.BLACK);
		g1.fill(square1);  

		Graphics2D g3 = (Graphics2D) g;
		Rectangle2D square2 = new Rectangle2D.Double (z,c,125,125);
		g3.setColor (Color.BLUE);
		g3.fill(square2);   

		Graphics2D g4 = (Graphics2D) g;
		Rectangle2D square3 = new Rectangle2D.Double (s,d,75,75);
		g4.setColor (Color.ORANGE);
		g4.fill(square3);   


		Graphics2D g5 = (Graphics2D) g;
		Rectangle2D square4 = new Rectangle2D.Double (j,u,100,100);
		g5.setColor (Color.GREEN);
		g5.fill(square4); 

		if (square.intersects (square4) || square.intersects (square3) || square.intersects (square2) || square.intersects (square1)) {

			user--;
			g2.drawString ("Lifes =" + user,625,60);

		}
		else {
			point++;
			g2.drawString ("Points =" + point,625,80);

		}

		//if 10000 points or 0 lives program closes
		if (point == 10000 || user < 0) {
			System.exit (ABORT);
		}
	}

	public void actionPerformed (ActionEvent event) {

		//redraws graphics on the screen
		repaint();

		//keeping the squares from going out of the boundary
		if (x < 0 || x > 740) {

			s1_x = -s1_x;
		}

		if (y < 0 || y > 325) {

			s1_y = -s1_y; 
		}

		if (q < 0 || q > 710) {

			s2_x = -s2_x;
		}

		if (w < 0 || w > 310) {

			s2_y = -s2_y;
		}

		if (z < 0 || z > 750) {

			s3_x = -s3_x;
		}

		if (c < 0 || c > 350) {

			s3_y = -s3_y;
		}

		if (s < 0 || s > 760) {

			s4_x = -s4_x;
		}

		if (d < 0 || d > 360) {

			s4_y = -s4_y;
		}

		if (j < 0 || j > 760) {

			s5_x = -s5_x;
		}

		if (u < 0 || u + 400 > 760) {

			s5_y = -s5_y;
		}

		j += s5_x;
		u += s5_y;

		s += s4_x;
		d += s4_y;

		z += s3_x;
		c += s3_y;

		q += s2_x;
		w += s2_y;

		x += s1_x;
		y += s1_y;
	} 

	public void keyPressed (KeyEvent key) {
		int code;
		code = key.getKeyCode ();

		if (code == KeyEvent.VK_UP) {
			up();
		}

		else if (code == KeyEvent.VK_W) {
			up(); 
		}

		else if (code == KeyEvent.VK_DOWN) {
			down();
		}

		else if (code == KeyEvent.VK_S) {
			down();
		}

		else if (code == KeyEvent.VK_LEFT) {
			left();
		}

		else if (code == KeyEvent.VK_A) {
			left(); 
		}

		else if (code == KeyEvent.VK_RIGHT) {
			right();
		}

		else if (code == KeyEvent.VK_D) {
			right(); 
		}
	}

	public void keyTyped (KeyEvent key) {}
	public void keyReleased (KeyEvent key) {}

	public void up () {
		s1_x = 0;
		s1_y = -3;
	}

	public void down () {
		s1_x = 0;
		s1_y = 3;
	}

	public void left () {
		s1_x = -3;
		s1_y = 0;
	}

	public void right () {
		s1_x = 3;
		s1_y = 0;
	}
}

