import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class GridBagFrame extends JFrame{
	private GridBagLayout layout;
	private GridBagConstraints constraints;
	private String input = "";
	private String secInput = "";
	private double rfs;//resultFirstInput
	private double rsi;//resultSecondInput
	private boolean isZero = false;
	private double result;
	private String analise;
	private double remain;
	private String op = "";
	JButton[] buttons = new JButton[28];
	JTextField textField = new JTextField("");
	String[] numbers = new String[] {"7","4","1","0","8","5","2",".","9","6","3","+/-"};
	String[] operations = new String[] {"sqrt","!","e^","cbrt","%","²","³","^","+","-","/","*","π","(",")","="};
	public GridBagFrame() {
//		super("Calculator");
		layout = new GridBagLayout();
		setLayout(layout);
		constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		//screen
				
		int cont = 0;
		for(int i = 0; i < numbers.length;i++) {
			buttons[i] = new JButton(numbers[i]);
			int aux = i%4+1;
			if(i%4 == 0) {
				cont++;
			}
			addComponent(buttons[i],aux,cont,1,1);
		}
		
		cont++;
		
		for(int i = 0; i < operations.length;i++) {
			buttons[i + numbers.length] = new JButton(operations[i]);
			int aux = i%4+1;
			if(i%4 == 0) {
				cont++;
			}
			addComponent(buttons[i + numbers.length],aux,cont,1,1);
		}
		
		addComponent(textField,0,1,6,1);
		JButton button22 = new JButton("C");
		addComponent(button22,0,7,2,1);
		button22.addActionListener(this::onPressButton);
		for(int i = 0; i < buttons.length; i++) {
			buttons[i].addActionListener(this::onPressButton);
		}
		
	}
	//
	public void onPressButton(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		System.out.println("Clicou em " + btn.getText());
		if(btn.getText().equals("(") || btn.getText().equals(")") || btn.getText().equals("1") || btn.getText().equals("2") || btn.getText().equals(".") || btn.getText().equals("3") || btn.getText().equals("4") || btn.getText().equals("5") || btn.getText().equals("6") || btn.getText().equals("7") || btn.getText().equals("8") || btn.getText().equals("9") || btn.getText().equals("0")) {
			if(op.equals("")) {
				input += btn.getText();
				textField.setText(input);
			}
			else if(!op.equals("")) {
				secInput += btn.getText();
				textField.setText(secInput);
				if(secInput.equals("0")) {
					isZero = true;
				}else {
					isZero = false;
				}
			}
		}
		else if(btn.getText().equals("π")) {
			if(op.equals("")) {
				input = Double.toString(Operations.pi());
				textField.setText(input);
			}else if(!op.equals("")) {
				secInput = Double.toString(Operations.pi());
				textField.setText(secInput);
			}
		}
		//what do i do
//		while(input.contains("(") || input.contains(")")) {
//			analise = parse(input);
//			resultado = input;
//			input = analise;
//		}
		System.out.println(input);
		System.out.println(secInput);
		rfs = Double.parseDouble(input);
		
		textField.setText(input);
		if (btn.getText().equals("C")) {
			rfs = 0;
			rsi = 0;
			input = "";
			secInput = "";
			op = "";
			textField.setText("");
		}		
		if (btn.getText().equals("sqrt")) {
			remain = Operations.sqrt(rfs);
			input = Double.toString(remain);
			textField.setText(input);
		}
		//o meu fatorial so funciona ate 33 sem precisao
		if (btn.getText().equals("!")) {
			remain = Operations.fatorial(rfs);
			input = Double.toString(remain);
			textField.setText(input);
		}
		if (btn.getText().equals("e^")) {
			remain =  Operations.exp_E(rfs);
			input = Double.toString(remain);
			textField.setText(input);
		}
		if(btn.getText().equals("+/-")) {
			remain = -1*rfs;
			input = Double.toString(remain);
			textField.setText(input);
		}
		if (btn.getText().equals("cbrt")) {
			remain = Operations.sqrt_3(rfs);
			input = Double.toString(remain);
			textField.setText(input);
		}
		if (btn.getText().equals("%")) {
			remain = Operations.porcento(rfs);
			input = Double.toString(remain);
			textField.setText(input);
		}
		if (btn.getText().equals("²")) {
			remain = Operations.ao_quadrado(rfs);
			input = Double.toString(remain);
			textField.setText(input);
		}
		if (btn.getText().equals("³")) {
			remain = Operations.ao_cubo(rfs);
			input = Double.toString(remain);
			textField.setText(input);
		}
		if (btn.getText().equals("^")) {
			op = btn.getText();	
			textField.setText(input + "^");
		}
		if (btn.getText().equals("+")) {
			op = btn.getText();
			textField.setText(input + "+");
		}
		if (btn.getText().equals("-")) {
			op = btn.getText();
			textField.setText(input + "-");
		}
		if (btn.getText().equals("/")) {
			op = btn.getText();
			textField.setText(input + "/");
		}
		if (btn.getText().equals("*")) {
			op = btn.getText();	
			textField.setText(input + "*");
		}
		if (btn.getText().equals("=")) {
			 rsi = Double.parseDouble(secInput);
			if(op.equals("+")) {
				result = rfs + rsi;
				input = Double.toString(result);
				secInput = "";
				rsi = 0;
			}else if(op.equals("-")) {
				result = rfs - rsi;
				input = Double.toString(result);
				rsi = 0;
				secInput = "";
			}else if(op.equals("*")) {
				result = rfs * rsi;
				input = Double.toString(result);
				secInput = "";
				rsi = 0;
			}else if(op.equals("/") && rsi!=0) {
				result = rfs/rsi;
				input = Double.toString( result);
				secInput = "";
				rsi = 0;
			}else if(op.equals("^")) {
				result = Operations.na_n(rfs, rsi);
				input = Double.toString( result);
				secInput = "";
				rsi = 0;
			}
			textField.setText(Double.toString(result));
			if(op.equals("/") && isZero) {
				textField.setText("ERRO!: Divisao por zero invalida!");
			}
		}
	}
	public String parse(String str) {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		try {
			engine.eval(str);
		} catch(ScriptException e) {
			e.printStackTrace();
		}
		return str;
	}
	/**
	 * 	oq falta fazer:
	 * arrumar os parenteses
	 * 
	 */
	
	private void addComponent(Component component, int row, int column, int width, int height) {
		constraints.gridx = column;
		constraints.gridwidth = width;
		constraints.gridy = row;
		constraints.gridheight = height;
		layout.setConstraints(component, constraints);
		add(component);
		
	}
}
