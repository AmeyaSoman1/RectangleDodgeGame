package rectgame1;
import javax.swing.JFrame;

public class RectangleGameRun {
  
  public static void main (String [] args) {
    
    JFrame frame = new JFrame ();
    RectangleGame s = new RectangleGame ();
    frame.add(s);
    frame.setVisible(true);
    frame.setSize (850, 470);
    frame.setTitle ("Dodge The 4 Rectangles");
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
  }
}