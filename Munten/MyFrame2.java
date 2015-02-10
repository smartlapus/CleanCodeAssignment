import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class MyFrame2 extends JFrame implements ActionListener {
	private JLabel l1, l2;
	private JTextField tf1, tf2;
	private JPanel p;
	private JButton b;

	public MyFrame2(){
		setLayout(new FlowLayout());

		l1 = new JLabel("Te betalen:");
		add(l1);

		tf1 = new JTextField("", 6);
		add(tf1);

		l2 = new JLabel("Klant betaalt met:");
		add(l2);

		tf2 = new JTextField("", 6);
		add(tf2);

		p = new JPanel();
		add(p);
		p.setPreferredSize(new Dimension(300, 225));

		b = new JButton("Bereken het wisselgeld");
		add(b);
		b.addActionListener(this);

		getContentPane().setBackground(Color.BLUE);
		setSize(400, 330);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == b){
			double tebetalen = Double.parseDouble(tf1.getText());
			double betalenmet = Double.parseDouble(tf2.getText());
			if (tebetalen > betalenmet) {
				// Foutmelding
				JOptionPane.showMessageDialog(null, "Houd de dief");
			}
			else {
				String s = "";
				double temp_geld = betalenmet - tebetalen;

				// Vijftig biljetten
				double vijftig;
				if ((vijftig = temp_geld/50) >= 1) { s += Math.floor(vijftig)+" biljet van 50 euro\n"; }
				else { s+= "0 biljet van 50 euro\n"; }
				temp_geld %= 50;

				// Twintig biljetten
				double twintig;
				if ((twintig = temp_geld/20) >= 1) { s += Math.floor(twintig)+" biljet van 20 euro\n"; }
				else { s+= "0 biljet van 20 euro\n"; }
				temp_geld %= 20;

				// Tien biljetten
				double tien;
				if ((tien = temp_geld/10) >= 1) { s += Math.floor(tien)+" biljet van 10 euro\n"; }
				else { s+= "0 biljet van 10 euro\n"; }
				temp_geld %= 10;

				// Vijf biljetten
				double vijf;
				if ((vijf = temp_geld/5) >= 1) { s += Math.floor(vijf)+" biljet van 5 euro\n"; }
				else { s+= "0 biljet van 5 euro\n"; }
				temp_geld %= 5;

				// Twee munten
				double twee;
				if ((twee = temp_geld/2) >= 1) { s += Math.floor(twee)+" munt van 2 euro\n"; }
				else { s+= "0 munten van 2 euro\n"; }
				temp_geld %= 2;

				// Een munten
				double een;
				if ((een = temp_geld/1) >= 1) { s += Math.floor(een)+" munt van 1 euro\n"; }
				else { s+= "0 munten van 1 euro\n"; }
				temp_geld %= 1;

				// Vijftig centen
				double vijftigcent;
				if ((vijftigcent = temp_geld/0.5) >= 1) { s += Math.floor(vijftigcent)+" munt van 0.5 euro\n"; }
				else { s+= "0 munten van 0.5 euro\n"; }
				temp_geld %= 0.5;

				// Twintig centen
				double twintigcent;
				if ((twintigcent = temp_geld/0.2) >= 1) { s += Math.floor(twintigcent)+" munt van 0.2 euro\n"; }
				else { s+= "0 munten van 0.2 euro\n"; }
				temp_geld %= 0.2;

				// Tien centen
				double tiencent;
				if ((tiencent = temp_geld/0.1) >= 1) { s += Math.floor(tiencent)+" munt van 0.1 euro\n"; }
				else { s+= "0 munten van 0.1 euro\n"; }
				temp_geld %= 0.1;

				// Indien 1 of 2 eurocent zou overblijven 10 cent van maken zodat er 2 vijfcent wordt berekent
				if (temp_geld >= 0.08 || temp_geld <= 0.09) { temp_geld = 0.1; }
				if (temp_geld >= 0.03 || temp_geld <= 0.04) { temp_geld = 0.05; }

				// Vijf centen
				double vijfcent;
				if ((vijfcent = temp_geld/0.05) >= 1) { s += Math.floor(vijfcent)+" munt van 0.05 euro\n"; }
				else { s+= "0 munten van 0.05 euro\n"; }
				temp_geld %= 0.05;

				Scanner sc = new Scanner(s);
				sc.useDelimiter("\n");
				Graphics g = p.getGraphics();
				g.setColor(Color.YELLOW);
				g.fillRect(0, 0, 1000, 1000);
				g.setColor(Color.CYAN);
				for (int i=15;sc.hasNext();i+=20) {
					g.drawString(sc.next(), 10, i);
				}
			}
			System.out.println(tebetalen);
		}
	}
		public static void main(String[] args)
		{
			new MyFrame2();
		}

}
