import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.text.*;

public class MyFrame3 extends JFrame implements ActionListener
{
	private JButton b1;
	private JPanel p1, p2, p3;
	private JTextField tf1, tf2;
	private JLabel lb1, lb2;
	private DecimalFormat df = new DecimalFormat("#.00");

	public MyFrame3()
	{
		setLayout(new BorderLayout() );

		p1 = new JPanel(); add(p1, BorderLayout.NORTH);
		p1.setPreferredSize(new Dimension(300, 100) );

		lb1 = new JLabel("Te betalen:"); p1.add(lb1);
		tf1 = new JTextField(8); p1.add(tf1);

		lb2 = new JLabel("Klant betaalt met:"); p1.add(lb2);
		tf2 = new JTextField(8); p1.add(tf2);

		p2 = new JPanel(); add(p2, BorderLayout.CENTER);
		p2.setPreferredSize(new Dimension(300, 400) );
		p2.setBackground(Color.WHITE);

		p3 = new JPanel(); add(p3, BorderLayout.SOUTH);
		p3.setPreferredSize(new Dimension(300, 40) );

		b1 = new JButton("Bereken het wisselgeld");
		b1.addActionListener(this); p3.add(b1);

		setSize(300, 450);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent event)
	{
		// bedragV = bedrag voorlopig, want moet worden afgerond.
		double bedragV =  Double.parseDouble(tf1.getText() );
		double in = Double.parseDouble(tf2.getText() );
		double bedrag = java.lang.Math.round((bedragV / 0.05)) * 0.05;
		double wissel = in - bedrag;

		int aantal50 = 0;
		int aantal20 = 0;
		int aantal10 = 0;
		int aantal5 = 0;
		int aantal2 = 0;
		int aantal1 = 0;
		int aantal50cent = 0;
		int aantal20cent = 0;
		int aantal10cent = 0;
		int aantal5cent = 0;

		// foutmelding voor als er te weinig betaald wordt
		if (bedrag > in)
		{
			double tekort = bedrag - in;
			JOptionPane.showMessageDialog(null,"Betaal opnieuw, u komt " + tekort + " euro tekort");
		}
		else if (bedrag <= in)
		{
			while ( wissel >= 50 )
			{ aantal50++; wissel-=50; }
			while ( wissel >= 20 && wissel < 50 )
			{ aantal20++; wissel-=20; }
			while ( wissel >= 10 && wissel < 20 )
			{ aantal10++; wissel-=10; }
			while ( wissel  >= 5 && wissel < 10 )
			{ aantal5++; wissel-=5; }
			while ( wissel  >= 2 && wissel < 5 )
			{ aantal2++; wissel-=2; }
			while ( wissel  >= 1 && wissel < 2 )
			{ aantal1++; wissel-=1;}
			while ( wissel  >= 0.50 && wissel < 1 )
			{ aantal50cent++; wissel-=0.50;}
			while ( wissel  >= 0.20 && wissel < 0.50 )
			{ aantal20cent++; wissel-=0.20;}
			while ( wissel  >= 0.10 && wissel < 0.20 )
			{ aantal10cent++; wissel-=0.10; }
			while ( wissel < 0.10 && wissel >= 0.04)
			{ aantal5cent++; wissel-=0.05; }

			Graphics g = p2.getGraphics();
			g.setColor(Color.WHITE);
			g.fillRect(0,0,300,400);
			g.setColor(Color.BLACK);

			if (aantal50 == 1 ) { g.drawString("één biljet van 50 Euro", 10, 10); } else { g.drawString(aantal50 + " biljetten van 50 Euro", 10, 10); }
			if (aantal20 == 1 ) { g.drawString("één biljet van 20 Euro", 10, 40);  } else { g.drawString(aantal20 + " biljetten van 20 Euro", 10, 40); }
			if (aantal10 == 1 ) { g.drawString("één biljet van 10 Euro", 10, 70);  } else { g.drawString(aantal10 + " biljetten van 10 Euro", 10, 70); }
			if (aantal5 == 1 ) { g.drawString("één biljet van 5 Euro", 10, 100); } else { g.drawString(aantal5 + " biljetten van 5 Euro", 10, 100); }
			if (aantal2 == 1 ) { g.drawString("één munt van 2 Euro", 10, 130); } else { g.drawString(aantal2 + " munten van 2 Euro", 10, 130); }
			if (aantal1 == 1 ) { g.drawString("één munt van 1 Euro", 10, 160); } else { g.drawString(aantal1 + " munten van 1 Euro", 10, 160); }
			if (aantal50cent == 1 ) { g.drawString("één munt van 50 Eurocent", 10, 190); } else { g.drawString(aantal50cent + " munten van 50 Eurocent", 10, 190); }
			if (aantal20cent == 1 ) { g.drawString("één munt van 20 Eurocent", 10, 220); } else { g.drawString(aantal20cent + " munten van 20 Eurocent", 10, 220); }
			if (aantal10cent == 1 ) { g.drawString("één munt van 10 Eurocent", 10, 250); } else { g.drawString(aantal10cent + " munten van 10 Eurocent", 10, 250); }
			if (aantal5cent == 1 ) { g.drawString("één munt van 5 Eurocent", 10, 280); } else { g.drawString(aantal5cent + " munten van 5 Eurocent", 10, 280); }
		}
	}
		public static void main(String[] args)
		{
			new MyFrame3();
		}

}


