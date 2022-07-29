import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalcPanel {
	private JPanel cPanel;
	private JFrame cFrame;
	private JTextField cText;
	private Evaluator eval;
	private boolean result;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bplus, bac,
				bminus, bdiv, bmult, bequal, bcos, bsin, btan,
				bdec, bdel, be, bpi, brightp, bleftp;
	
	public CalcPanel() {
		cFrame = new JFrame("Scientific Calculator");
		cPanel = new JPanel(new BorderLayout());
		cText = new JTextField();
		eval = new Evaluator();
		result = false;
		cText.setFont(new Font ("TimesRoman",0,25));
		cText.setEditable(false);
		cText.setHorizontalAlignment(JTextField.RIGHT);
		cPanel.setLayout(new GridLayout(0,5, 5, 5));
		
		createButtons();
		cPanel.setBackground(Color.darkGray);
		cPanel.setPreferredSize(new Dimension(310, 200));
		cFrame.add(cText, BorderLayout.PAGE_START);
		cFrame.add(cPanel, BorderLayout.CENTER);
		cFrame.setSize(400, 300);
		cFrame.setResizable(false);
		cFrame.setVisible(true);
	}
	
	private void createButtons() {
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		b0 = new JButton("0");
		bplus = new JButton("+");
		bminus = new JButton("-");
		bdiv = new JButton("÷");
		bmult = new JButton("×");
		bequal = new JButton("=");
		bcos = new JButton("cos");
		bsin = new JButton("sin");
		btan = new JButton("tan");
		bdel = new JButton("del");
		bac = new JButton("AC");
		bdec = new JButton(".");
		bleftp = new JButton("(");
		brightp = new JButton(")");
		bpi = new JButton("π");
		be = new JButton ("e");
		
		cPanel.add(bsin); cPanel.add(bcos); cPanel.add(btan); cPanel.add(bpi); cPanel.add(be); 
		cPanel.add(b1); cPanel.add(b2); cPanel.add(b3); cPanel.add(bdel);  cPanel.add(bac);
		cPanel.add(b4); cPanel.add(b5); cPanel.add(b6); cPanel.add(bmult);  cPanel.add(bdiv);
		cPanel.add(b7); cPanel.add(b8); cPanel.add(b9); cPanel.add(bplus); cPanel.add(bminus);
		cPanel.add(b0); cPanel.add(bdec); cPanel.add(bequal); cPanel.add(bleftp); cPanel.add(brightp);
	
	
		b1.addActionListener(e -> {
			afterEqual();
			cText.setText(cText.getText() + "1");
		});
		b2.addActionListener(e -> {
			afterEqual();
			cText.setText(cText.getText() + "2");
		});
		b3.addActionListener(e -> {
			afterEqual();
			cText.setText(cText.getText() + "3");
		});
		b4.addActionListener(e -> {
			afterEqual();
			cText.setText(cText.getText() + "4");
		});
		b5.addActionListener(e -> {
			afterEqual();
			cText.setText(cText.getText() + "5");
		});
		b6.addActionListener(e -> {
			afterEqual();
			cText.setText(cText.getText() + "6");
		});
		b7.addActionListener(e -> {
			afterEqual();
			cText.setText(cText.getText() + "7");
		});
		b8.addActionListener(e -> {
			afterEqual();
			cText.setText(cText.getText() + "8");
		});
		b9.addActionListener(e -> {
			afterEqual();
			cText.setText(cText.getText() + "9");
		});
		b0.addActionListener(e -> {
			afterEqual();
			cText.setText(cText.getText() + "0");
		});
		bplus.addActionListener(e -> {
			afterEqual();
			cText.setText(cText.getText() + "+");
		});
		bminus.addActionListener(e -> {
			afterEqual();
			cText.setText(cText.getText() + "-");
		});
		bmult.addActionListener(e -> {
			afterEqual();
			cText.setText(cText.getText() + "×");
		});
		bdiv.addActionListener(e -> {
			afterEqual();
			cText.setText(cText.getText() + "÷");
		});
		bdec.addActionListener(e -> {
			afterEqual();
			cText.setText(cText.getText() + ".");
		});
		bleftp.addActionListener(e -> {
			afterEqual();
			cText.setText(cText.getText() + "(");
		});
		brightp.addActionListener(e -> {
			afterEqual();
			cText.setText(cText.getText() + ")");
		});
		bsin.addActionListener(e -> {
			afterEqual();
			cText.setText(cText.getText() + "sin");
		});
		bcos.addActionListener(e -> {
			afterEqual();
			cText.setText(cText.getText() + "cos");
		});
		btan.addActionListener(e -> {
			afterEqual();
			cText.setText(cText.getText() + "tan");
		});
		bdel.addActionListener(e -> {
			if(!cText.getText().equals(""))
				cText.setText(cText.getText().substring(0, cText.getText().length() - 1));
		});
		bac.addActionListener(e -> {
			afterEqual();
			cText.setText("");
		});
		bpi.addActionListener(e -> {
			afterEqual();
			cText.setText(cText.getText() + "π");
		});
		be.addActionListener(e -> {
			afterEqual();
			cText.setText(cText.getText() + "e");
		});
		bequal.addActionListener(e -> {
			String expression = cText.getText();
			String replacedExp = expression.replace("×","*").replace("÷", "/");
			Double x = eval.evaluate(replacedExp);
			cText.setText(x.toString());
			result = true;
		});

	
	}
	
	public void afterEqual() {
		if(result) {
			cText.setText("");
			result = false;
		}
	}
	
}
