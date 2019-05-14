import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Component;

public class ColorSelect1 extends JFrame implements ActionListener {
	
	//seletor
	private GridBagConstraints constraints;
	private GridBagLayout layout;
	private JPanel p1 ;
	private Color color = Color.BLACK;
	private JButton[] buttons;
	private static final String[] names = { "Ok", "Cancel", "Cor"};
	
	//draw area
	private PaintPanel pp;
	
	//tamanho e apaga
	private int i=4;
	private JPanel p2;
	private static final String[] names2 = {"Aumentar", "Diminuir", "Apagar"};


	public ColorSelect1() {
		
		
		//seletor
		setBackground(color);
			p1=new JPanel();
		  	layout = new GridBagLayout();
			Box box = Box.createVerticalBox();
			setLayout(layout);
			constraints = new GridBagConstraints();
			
		
			buttons = new JButton[names.length]; // configura tamanho do array

			// cria JButtons e registra ouvintes para eles
			for (int count = 0; count < names.length; count++) {
				buttons[count] = new JButton(names[count]);
				buttons[count].addActionListener(this);
				buttons[count].setMaximumSize(new Dimension(90,20));
				box.add(Box.createRigidArea(new Dimension(2,2)));
				box.add(buttons[count]);
			}
			p1.add(box);
			p1.setBackground(Color.BLACK);
			constraints.weightx = 0;  // can grow wider
			constraints.weighty = 1;     // can grow taller
			constraints.fill = GridBagConstraints.BOTH;
			addComponent( p1, 1, 0, 1, 1 );

			
			buttons[2].addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						color= JColorChooser.showDialog(ColorSelect1.this, "Escolha uma cor", color);
						if (color== null) {
							color = Color.BLACK;
						}
					}
				}
			);
			buttons[0].addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						p1.setBackground(color);
						pp.setColor(color);
					}
				}
			);
		
			buttons[1].addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						color = Color.BLACK;
						p1.setBackground(color);
						pp.setColor(color);
					}
				}
			);
			
			
			//draw area

			
			pp= new PaintPanel();
			pp.setBackground(Color.WHITE);
			pp.setSize(400,200);	
			pp.setColor(color);
			pp.setTamanho(4);
			 constraints.weightx = 0;
		      constraints.weighty = 0;    
		      addComponent( pp, 1, 2, 0, 1 );
		      
		      
			//tamanho e apaga
			
			p2= new JPanel(new BorderLayout(5,5));
			p2.setSize(200,100);
			
			
			for (int i = 0; i < names2.length; i++) {
				buttons[i] = new JButton(names2[i]);
				buttons[i].addActionListener(this);
			}
			
			p2.add(buttons[0], BorderLayout.WEST);
			p2.add(buttons[1], BorderLayout.CENTER);
			p2.add(buttons[2], BorderLayout.EAST);
			 constraints.fill = GridBagConstraints.HORIZONTAL;
		      addComponent( p2, 0, 1, 2, 1 );
		
		
			
			buttons[0].addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						pp.setTamanho(i++);
						}
					}
			);
			buttons[1].addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
					pp.setTamanho(i--);
					}
				}
			);
			buttons[2].addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
						pp.apagar();
						}
					}
			);
			

			
	}
	  private void addComponent( Component component, int row, int column, int width, int height ){
		  constraints.gridx = column; 
		  constraints.gridy = row; 
		  constraints.gridwidth = width; 
		  constraints.gridheight = height;
		  layout.setConstraints( component, constraints ); 
		  add( component );
	  } 
		@Override 
		public void actionPerformed(ActionEvent event) {
			for (JButton button : buttons) {
					button.setVisible(true);
			}
		}
		}
		
