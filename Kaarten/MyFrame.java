import java.awt.*;
import java.lang.Enum;
import java.awt.event.*;

import javax.swing.*;


public class MyFrame extends JFrame implements ActionListener
{
	public JLabel lab1, uitput;
	public JButton b;

	protected MyFrameData kaart = new MyFrameData(new String[] { "Schoppen", "Harten", "Klaveren", "Ruiten" },
			new String[] {"Aas", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Boer", "Vrouw", "Heer"}, "", "", "", "");

	public MyFrame()
	{
		setLayout(new FlowLayout());

		lab1 = new JLabel("Druk op knop Kaart"); 
		add(lab1);

		b = new JButton("Kaar");
		b.addActionListener(this);
		add(b);

		uitput = new JLabel("Het spel begint");
		add(uitput);

		setSize(350, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		kaart.s1 = kaart.soort[(int)(4 * Math.random())];
		kaart.w1 = " " + kaart.waarde[(int)(13 * Math.random())];
	}

	public void actionPerformed(ActionEvent arg0)
	{
		//zodra je op de knop drukt wordt er willekeurig twee delen bij elkaar gehaald
		kaart.s2 = kaart.soort[(int)(4 * Math.random())];
		kaart.w2 = " " + kaart.waarde[(int)(13 * Math.random())];

		//vergelijken met een standaard kaart
		//Standaard kaart
		int soortZelf1 = -1;
		int vindSoort1 = -1;
		for(soortZelf1 = 0; soortZelf1 < 4; soortZelf1++)
		{
			if(kaart.soort[soortZelf1] == kaart.s1)
			{
				vindSoort1 = soortZelf1;
			}
		}
		int waardeZelf1 = -1;
		int vindWaarde1 = -1;
		for(waardeZelf1 = 0; waardeZelf1 < 13; waardeZelf1++)
		{
			if(kaart.waarde[waardeZelf1] == kaart.w1)
			{
				vindWaarde1 = waardeZelf1;
			}
		}

		//Nieuwe kaart
		int soortZelf2 = -1;
		int vindSoort2 = -1;
		for(soortZelf2 = 0; soortZelf2 < 4; soortZelf2++)
		{
			if(kaart.soort[soortZelf2] == kaart.s2)
			{
				vindSoort2 = soortZelf2;
			}
		}
		int waardeZelf2 = -1;
		int vindWaarde2 = -1;
		for(waardeZelf2 = 0; waardeZelf2 < 13; waardeZelf2++)
		{
			if(kaart.waarde[waardeZelf2] == kaart.w2)
			{
				vindWaarde2 = waardeZelf2;
			}
		}

		//kaarten vergelijken
		if(vindWaarde1 >= vindWaarde2)
		{
			if(vindWaarde1 == vindWaarde2)
			{
				if(vindSoort1 >= vindSoort2)
				{
					if(vindSoort1 == vindSoort2)
					{
						uitput.setText("De kaarten zijn gelijk");
					}
					else
					{
						uitput.setText("De kaarten is kleiner");
					}
				}
				else
				{
					uitput.setText("De kaarten is groter");
				}
			}
			else
			{
				if(vindSoort1 >= vindSoort2)
				{
					if(vindSoort1 == vindSoort2)
					{
						uitput.setText("De kaarten is kleiner");
					}
					else
					{
						uitput.setText("De kaarten is kleiner");
					}
				}
				else
				{
					uitput.setText("De kaarten is kleiner");
				}
			}
		}
		else
		{
			if(vindSoort1 >= vindSoort2)
				{
					if(vindSoort1 >= vindSoort2)
					{
						uitput.setText("De kaarten is groter");
					}
					else
					{
						uitput.setText("De kaarten is groter");
					}
				}
				else
				{
					uitput.setText("De kaarten is groter");
				}
		}

	}

	public static void main(String[] args)
	{
		new MyFrame();
	}

}
