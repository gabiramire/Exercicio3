import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class Printer extends JFrame 
{ 
   private RadioButtonHandler radioButtonHandler;
   private GridBagLayout layout; // layout of this frame
   private GridBagConstraints constraints; // constraints of this layout
   private JCheckBox[] checkBox;
   private JCheckBox checkBox2;
   private JRadioButton[] radioButton;
   private JButton[] buttons;
   private JComboBox comboBox;
   private ButtonGroup grupo;
   private JPanel panel, panel2, panel3;
   private static final String[] names1 = { "OK", "Cancel", "Setup...", "Help"};
   private static final String[] names2 = { "Image", "Text", "Code"};
   private static final String[] names3 = { "Selection", "All", "Applet"};
   private static final String[] names4 = { "High", "Medium", "Low"};
   private class RadioButtonHandler implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(radioButton[0].isSelected()){
				
			}else
				if(radioButton[1].isSelected()){
					
				}else {
					
				}

		}
   }
   
   public Printer()
   {
      super( "GridBagLayout" );
      layout = new GridBagLayout();
      setLayout( layout ); 
      constraints = new GridBagConstraints();

      //Text1
      JLabel text1 = new JLabel( "Printer: MyPrinter");
      
      
      //CheckBox1
      checkBox = new JCheckBox[names2.length];
      Box box1 = Box.createVerticalBox();
      for(int i=0; i<names2.length; i++) {
			checkBox[i] = new JCheckBox(names2[i]);
			checkBox[i].setMaximumSize(new Dimension(95,25));
			box1.add(checkBox[i]);
      }
      
      
      //Text2
      JLabel text2 = new JLabel( "Print Quality: ");
      
      
      //RadioButton
      grupo= new ButtonGroup();
      radioButtonHandler= new RadioButtonHandler();
      radioButton = new JRadioButton[names3.length];
      Box box2 = Box.createVerticalBox();
      for(int i=0; i<names2.length; i++) {
    	  radioButton[i] = new JRadioButton(names3[i]);
    	  radioButton[i].setMaximumSize(new Dimension(95,25));
    	  grupo.add(radioButton[i]);
    	  radioButton[i].addItemListener(radioButtonHandler);
    	  box2.add(radioButton[i]);
      }
      
    
    	 
      
      //ComboBox
      comboBox= new JComboBox(names4);
      comboBox.setMaximumRowCount(3);
      
      
      //CheckBox2
      checkBox2 = new JCheckBox("Print to File");
      
      
      //Buttons
      Box box = Box.createVerticalBox();
		buttons= new JButton[names1.length];
		for(int i=0; i<names1.length; i++) {
			buttons[i] = new JButton(names1[i]);
			buttons[i].setMaximumSize(new Dimension(95,25));
			
			box.add(buttons[i]);
			box.add(Box.createRigidArea(new Dimension(5,10)));
		}
     
		panel= new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setSize(new Dimension(5,10));
		
		panel2= new JPanel();
		panel2.setBackground(Color.WHITE);
		panel2.setSize(new Dimension(5,10));
		
		panel3= new JPanel();
		panel3.setBackground(Color.WHITE);
		panel3.setSize(new Dimension(5,10));
		
		
      constraints.fill = GridBagConstraints.BOTH;
      addComponent( text1, 0, 0, 2, 1 );    
       
      constraints.fill= GridBagConstraints.VERTICAL;
      addComponent( box1, 1, 1, 1, 1);
      
      constraints.fill= GridBagConstraints.BOTH;
      addComponent( panel, 1, 0, 1, 1 );
      
      constraints.fill= GridBagConstraints.BOTH;
      addComponent( panel2, 1, 2, 1, 1 );
      
      constraints.fill= GridBagConstraints.BOTH;
      addComponent( panel3, 1, 4, 1, 1 );
      
      constraints.fill= GridBagConstraints.BOTH;
      addComponent( text2, 4, 0, 2, 1 );
      
      constraints.fill= GridBagConstraints.VERTICAL;
      addComponent( box2, 1, 3, 1, 1 );
      
      constraints.fill= GridBagConstraints.BOTH;
      addComponent( comboBox, 4, 2, 1, 1 );
      
      constraints.fill= GridBagConstraints.BOTH;
      addComponent( checkBox2, 4, 3, 2, 1 );
      
      constraints.fill= GridBagConstraints.VERTICAL;
      addComponent( box, 0, 5, 1, 6 );

		}

      
   private void addComponent( Component component,
      int row, int column, int width, int height )
   {
      constraints.gridx = column; 
      constraints.gridy = row;
      constraints.gridwidth = width; 
      constraints.gridheight = height;
      layout.setConstraints( component, constraints ); 
      add( component ); 
   } 
} 


