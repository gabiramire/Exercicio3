import javax.swing.JFrame;

public class Main {
	public static void main( String[] args )
	   { 
	      GridBagFrame gridBagFrame = new GridBagFrame(); 
	      gridBagFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	      gridBagFrame.setSize( 400, 250 ); // set frame size
	      gridBagFrame.setVisible( true ); // display frame
	   } 
}
