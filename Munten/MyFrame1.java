import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyFrame1 extends JFrame implements ActionListener {
private JButton b1;
private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
private JTextField tf1, tf2;
private JPanel p;

 	public MyFrame1() {

		setLayout(new FlowLayout());
		getContentPane().setBackground(Color.WHITE);

		//aanmaken van alle elementen binnen de frame
		l11 = new JLabel("Tebetalen Bedrag"); add(l11);
		tf1 = new JTextField(5); add(tf1);

		l12 = new JLabel("Betaalde  Bedrag"); add(l12);
		tf2 = new JTextField(5); add(tf2);

		l1  = new JLabel(" 0 Biljetten van 50 euro");	  add(l1);
		l2  = new JLabel(" 0 Biljetten van 20 euro");	  add(l2);
		l3  = new JLabel(" 0 Biljetten van 10 euro");	  add(l3);
		l4  = new JLabel(" 0 Biljetten van 5  euro");	  add(l4);
		l5  = new JLabel(" 0 Munten    van 2  euro");	  add(l5);
		l6  = new JLabel(" 0 Munten	   van 1  euro");	  add(l6);
		l7  = new JLabel(" 0 Munten	   van 50 eurocent"); add(l7);
		l8  = new JLabel(" 0 Munten	   van 20 eurocent"); add(l8);
		l9  = new JLabel(" 0 Munten	   van 10 eurocent"); add(l9);
		l10 = new JLabel(" 0 Munten    van 5  eurocent"); add(l10);

		b1 = new JButton("Bereken het wisselgeld"); add(b1); b1.addActionListener(this);

		setSize(250, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e){

		l1.setText(" 0 Biljetten van 50 euro");
		l2.setText(" 0 Biljetten van 20 euro");
		l3.setText(" 0 Biljetten van 10 euro");
		l4.setText(" 0 Biljetten van  5 euro");
		l5.setText(" 0 Munten	 van  2 euro");
		l6.setText(" 0 Munten    van  1 euro");
		l7.setText(" 0 Munten 	 van 50 eurocent");
		l8.setText(" 0 munten 	 van 20 eurocent");
		l9.setText(" 0 munten 	 van 10 eurocent");
		l10.setText(" 0 munten    van 5 eurocent");

		//er moet iets in de tekstfields zijn ingevuld
		if(!tf1.getText().equals("") && !tf1.getText().equals("")){

				//bedragen worden uit tekstfields gehaald en wisselgeld berekent
				double tebetalen = Double.parseDouble(tf1.getText());
				double betalen   = Double.parseDouble(tf2.getText());
				double wisselgeld = betalen - tebetalen;
				int teller = 0;

			//het wisselgeld moet boven de 0 zijn, zoniet dan heeft de klant te weinig betaald
			if(wisselgeld > 0){
				while(wisselgeld >= 50){
					wisselgeld = wisselgeld - 50;
					teller++;
					l1.setText(teller + " Biljetten van 50 euro");
				}
				teller = 0;
				while(wisselgeld >= 20){
					wisselgeld = wisselgeld - 20;
					teller++;
					l2.setText(teller + " Biljetten van 20 euro");
				}
				teller = 0;
				while(wisselgeld >= 10){
				wisselgeld = wisselgeld - 10;
				teller++;
				l3.setText(teller + " Biljetten van 10 euro");
				}
				teller = 0;
				while(wisselgeld >= 5){
					wisselgeld = wisselgeld - 5;
					teller++;
					l4.setText(teller + " Biljetten van 5 euro");
				}
				teller = 0;
				while(wisselgeld >= 2){
					wisselgeld = wisselgeld - 2;
					teller++;
					l5.setText(teller + " Munten van 2 euro");
				}
				teller = 0;
				while(wisselgeld >= 1){
					wisselgeld = wisselgeld - 1;
					teller++;
					l6.setText(teller + " Munten van 1 euro");
				}
				teller = 0;
				while(wisselgeld >= 0.50){
					wisselgeld = wisselgeld - 0.50;
					teller++;
					l7.setText(teller + " Munten van 50 eurocent");
				}
				teller = 0;
				while(wisselgeld >= 0.20){
					wisselgeld = wisselgeld - 0.20;
					teller++;
					l8.setText(teller + " Munten van 20 eurocent");
				}
				teller = 0;
				while(wisselgeld >= 0.10){
					wisselgeld = wisselgeld - 0.10;
					teller++;
					l9.setText(teller + " Munten van 10 eurocent");
				}
				teller = 0;
				while(wisselgeld >= 0.05){
					wisselgeld = wisselgeld - 0.05;
					teller++;
					l10.setText(teller + " Munten van 5 eurocent");
				}
				if( (wisselgeld < 0.05) && (wisselgeld > 0.02) ){
					teller++;
					l10.setText(teller + " Munten van 5 eurocent");
					wisselgeld = 0;
				}
			}
			else{JOptionPane.showMessageDialog(null, "De klant betaald teweinig"); }
		}
		else{JOptionPane.showMessageDialog(null, "Vul geldige bedragen in"); }

	}
		public static void main(String[] args)
		{
			new MyFrame1();
		}

}