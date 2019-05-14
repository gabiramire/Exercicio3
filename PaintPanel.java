
import java.awt.Color;

import java.awt.Graphics;

import java.awt.Point;

import java.awt.event.MouseEvent;

import java.awt.event.MouseMotionAdapter;

import javax.swing.*;

public class PaintPanel extends JPanel {
	
	private Color color;
	
	private int tamanho;
	
	private int pointCount=0;
	
	private Point[] points = new Point[100000];
	
	
	public PaintPanel() {
		
		
		addMouseMotionListener(

				new MouseMotionAdapter() { // classe interna anônima

					public void mouseDragged(MouseEvent event) { 
						
						if (pointCount <points.length) {

							points[pointCount] = event.getPoint(); // localiza o ponto

							pointCount++;
							
							repaint(); 

						}

					}

				}

		);
		
	}
	
	public void setColor(Color color) {
		this.color=color;
	}
	
	public void setTamanho(int tamanho) {
		this.tamanho=tamanho;
	}
	public void apagar() {
		for(int j=0; j<100000;j++){
			points[j]= new Point();
		}	
		repaint();
		
	}
	public void paintComponent(Graphics g) {

		super.paintComponent(g); 

		for (int i = 0; i < pointCount; i++) {

			g.setColor(color);

			g.fillOval(points[i].x, points[i].y, tamanho, tamanho);
			
		}
		
	}
	
}