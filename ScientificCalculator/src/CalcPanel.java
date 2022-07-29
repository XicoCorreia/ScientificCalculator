import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalcPanel {

	private JFrame cFrame;
	private JTextField cText;
	private JTextField cTextResult;
	private JPanel cNumOpPanel;
	private JPanel cFuncPanel;
	private Evaluator eval;
	private boolean result;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bdec, badd, bsub,
				bdiv, bmult, bequal, bac, bdel, bans, bexp,  
				bcos, bsin, btan, be, bpi, brightp, bleftp, bsquare,
				bsqrt, blog, bln, bpow;
	
	public CalcPanel() {
		
		cFrame = new JFrame("Scientific Calculator");
		cText = new JTextField();
		cTextResult = new JTextField();
		cFuncPanel = new JPanel(new BorderLayout());
		cNumOpPanel = new JPanel(new BorderLayout());
		eval = new Evaluator();
		result = false;
		
		cFrame.getContentPane().setLayout(null);
	    cFrame.getContentPane().setBackground(Color.decode("#333537"));
	    cFrame.setResizable(false);
		cFrame.setSize(410, 750);
		
		cText.setFont(new Font ("TimesRoman",0,28));
		cText.setEditable(false);
		cText.setHorizontalAlignment(JTextField.RIGHT);
		cText.setBounds(15, 30, 360, 40);
		
		cTextResult.setFont(new Font ("TimesRoman",Font.BOLD,38));
		cTextResult.setEditable(false);
		cTextResult.setHorizontalAlignment(JTextField.RIGHT);
		cTextResult.setBounds(15, 70, 360, 50);
		
		cFuncPanel.setLayout(new GridLayout(0,6, 5, 5));
		cFuncPanel.setBackground(Color.decode("#333537"));
		cFuncPanel.setBounds(15, 300, 360, 80);
		
		cNumOpPanel.setLayout(new GridLayout(0,5, 5, 5));
		cNumOpPanel.setBackground(Color.decode("#333537"));
		cNumOpPanel.setBounds(15, 450, 360, 200);
		
		createButtons();
	    
		cFrame.add(cText);
		cFrame.add(cTextResult);
		cFrame.add(cNumOpPanel);
		cFrame.add(cFuncPanel);
		cFrame.setVisible(true);
	}
	
	private void createButtons() {
		
		b1 = new JButton("1");
		b1.setBackground(Color.gray);
		b1.setForeground(Color.white);
		b1.setFont(new Font ("Arial",Font.BOLD,22));
		
		b2 = new JButton("2");
		b2.setBackground(Color.gray);
		b2.setForeground(Color.white);
		b2.setFont(new Font ("Arial",Font.BOLD,22));
		
		b3 = new JButton("3");
		b3.setBackground(Color.gray);
		b3.setForeground(Color.white);
		b3.setFont(new Font ("Arial",Font.BOLD,22));
		
		b4 = new JButton("4");
		b4.setBackground(Color.gray);
		b4.setForeground(Color.white);
		b4.setFont(new Font ("Arial",Font.BOLD,22));
		
		b5 = new JButton("5");
		b5.setBackground(Color.gray);
		b5.setForeground(Color.white);
		b5.setFont(new Font ("Arial",Font.BOLD,22));
		
		b6 = new JButton("6");
		b6.setBackground(Color.gray);
		b6.setForeground(Color.white);
		b6.setFont(new Font ("Arial",Font.BOLD,22));
		
		b7 = new JButton("7");
		b7.setBackground(Color.gray);
		b7.setForeground(Color.white);
		b7.setFont(new Font ("Arial",Font.BOLD,22));
		
		b8 = new JButton("8");
		b8.setBackground(Color.gray);
		b8.setForeground(Color.white);
		b8.setFont(new Font ("Arial",Font.BOLD,22));
		
		b9 = new JButton("9");
		b9.setBackground(Color.gray);
		b9.setForeground(Color.white);
		b9.setFont(new Font ("Arial",Font.BOLD,22));
		
		b0 = new JButton("0");
		b0.setBackground(Color.gray);
		b0.setForeground(Color.white);
		b0.setFont(new Font ("Arial",Font.BOLD,22));
		
		bdec = new JButton(".");
		bdec.setBackground(Color.decode("#577d4a"));
		bdec.setForeground(Color.white);
		bdec.setFont(new Font ("Arial",Font.BOLD,22));
		
		bans = new JButton("Ans");
		bans.setBackground(Color.decode("#577d4a"));
		bans.setForeground(Color.white);
		bans.setFont(new Font ("Arial",Font.BOLD,17));
		
		bexp = new JButton("EXP");
		bexp.setBackground(Color.decode("#577d4a"));
		bexp.setForeground(Color.white);
		bexp.setFont(new Font ("Arial",Font.BOLD,15));
		
		badd = new JButton("+");
		badd.setBackground(Color.decode("#577d4a"));
		badd.setForeground(Color.white);
		badd.setFont(new Font ("Arial",Font.BOLD,22));
		
		bsub = new JButton("-");
		bsub.setBackground(Color.decode("#577d4a"));
		bsub.setForeground(Color.white);
		bsub.setFont(new Font ("Arial",Font.BOLD,22));
		
		bdiv = new JButton("÷");
		bdiv.setBackground(Color.decode("#577d4a"));
		bdiv.setForeground(Color.white);
		bdiv.setFont(new Font ("Arial",Font.BOLD,22));
		
		bmult = new JButton("×");
		bmult.setBackground(Color.decode("#577d4a"));
		bmult.setForeground(Color.white);
		bmult.setFont(new Font ("Arial",Font.BOLD,22));
		
		bequal = new JButton("=");
		bequal.setBackground(Color.decode("#577d4a"));
		bequal.setForeground(Color.white);
		bequal.setFont(new Font ("Arial",Font.BOLD,22));
		
		bdel = new JButton("DEL");
		bdel.setBackground(Color.decode("#b7342b"));
		bdel.setForeground(Color.white);
		bdel.setFont(new Font ("Arial",Font.BOLD,15));
		
		bac = new JButton("AC");
		bac.setBackground(Color.decode("#b7342b"));
		bac.setForeground(Color.white);
		bac.setFont(new Font ("Arial",Font.BOLD,22));
		
		bcos = new JButton("cos");
		bcos.setForeground(Color.white);
		bcos.setBackground(Color.black);
		
		bsin = new JButton("sin");
		bsin.setForeground(Color.white);
		bsin.setBackground(Color.black);
		
		btan = new JButton("tan");
		btan.setForeground(Color.white);
		btan.setBackground(Color.black);
		
		bleftp = new JButton("(");
		bleftp.setForeground(Color.white);
		bleftp.setBackground(Color.black);
		
		brightp = new JButton(")");
		brightp.setForeground(Color.white);
		brightp.setBackground(Color.black);
		
		bpi = new JButton("π");
		bpi.setForeground(Color.white);
		bpi.setBackground(Color.black);
		
		be = new JButton ("e");
		be.setForeground(Color.white);
		be.setBackground(Color.black);
		
		bsquare = new JButton("x²");
		bsquare.setForeground(Color.white);
		bsquare.setBackground(Color.black);
		
		bsqrt = new JButton("√");
		bsqrt.setForeground(Color.white);
		bsqrt.setBackground(Color.black);
		
		blog = new JButton("log");
		blog.setForeground(Color.white);
		blog.setBackground(Color.black);
		
		bln = new JButton("ln");
		bln.setForeground(Color.white);
		bln.setBackground(Color.black);
		
		bpow = new JButton("^");
		bpow.setForeground(Color.white);
		bpow.setBackground(Color.black);
		
		cFuncPanel.add(bpi); cFuncPanel.add(bsqrt); cFuncPanel.add(bsquare); cFuncPanel.add(bpow);cFuncPanel.add(blog);cFuncPanel.add(bln);
		cFuncPanel.add(be); cFuncPanel.add(bleftp); cFuncPanel.add(brightp); cFuncPanel.add(bsin);cFuncPanel.add(bcos); cFuncPanel.add(btan);  
		
		
		cNumOpPanel.add(b7); cNumOpPanel.add(b8); cNumOpPanel.add(b9); cNumOpPanel.add(bdel);  cNumOpPanel.add(bac);
		cNumOpPanel.add(b4); cNumOpPanel.add(b5); cNumOpPanel.add(b6); cNumOpPanel.add(bmult);  cNumOpPanel.add(bdiv);
		cNumOpPanel.add(b1); cNumOpPanel.add(b2); cNumOpPanel.add(b3); cNumOpPanel.add(badd); cNumOpPanel.add(bsub);
		cNumOpPanel.add(b0); cNumOpPanel.add(bdec); cNumOpPanel.add(bexp); cNumOpPanel.add(bans); cNumOpPanel.add(bequal);
	
	
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
		badd.addActionListener(e -> {
			afterEqual();
			cText.setText(cText.getText() + "+");
		});
		bsub.addActionListener(e -> {
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
		bdel.addActionListener(e -> {
			if(!cText.getText().equals(""))
				cText.setText(cText.getText().substring(0,
						cText.getText().length() - 1));
		});
		bac.addActionListener(e -> {
			afterEqual();
			cText.setText("");
		});
		bans.addActionListener(e -> {
			afterEqual();
			cText.setText(cText.getText() + cTextResult.getText());
		});
		bexp.addActionListener(e -> {
			afterEqual();
			cText.setText(cText.getText() + "E");
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
		bpi.addActionListener(e -> {
			afterEqual();
			cText.setText(cText.getText() + "π");
		});
		be.addActionListener(e -> {
			afterEqual();
			cText.setText(cText.getText() + "e");
		});
		bsqrt.addActionListener(e-> {
			afterEqual();
			cText.setText(cText.getText() + "√");
		});
		bsquare.addActionListener(e-> {
			afterEqual();
			cText.setText(cText.getText() + "²");
		});
		bpow.addActionListener(e-> {
			afterEqual();
			cText.setText(cText.getText() + "^");
		});
		blog.addActionListener(e-> {
			afterEqual();
			cText.setText(cText.getText() + "log");
		});
		bln.addActionListener(e-> {
			afterEqual();
			cText.setText(cText.getText() + "ln");
		});
		bequal.addActionListener(e -> {
			String replacedExp = cText.getText().replace("×","*")
					.replace("÷", "/");
			Double x = eval.evaluate(replacedExp);
			cTextResult.setText(x.toString());
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
