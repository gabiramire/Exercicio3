import javax.swing.JFrame;

public class Main
{ 
   public static void main( String[] args )
   { 
      Printer printer = new Printer(); 
      printer.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      printer.setSize( 380, 190 ); // set frame size
      printer.setVisible( true ); // display frame
   } // end main
} // end class GridBagDemo