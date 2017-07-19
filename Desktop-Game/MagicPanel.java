import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
class MagicPanel extends JPanel
{
	private JLabel label;
	private JButton proceed,yes,no,playagain;
	private int c=1,n;
	private GridBagConstraints gbc;
	private Insets in;
	private JPanel jp,jp2,jp3;
	MagicPanel()
	{
		label=new JLabel("Select a number between 0 to 63");
		proceed=new JButton("Proceed");
		yes=new JButton("Yes");
		no=new JButton("No");
		
		first_display();
		
		proceed.addActionListener((e)->{changeLabel();
											//proceed.setVisible(false);
											remove(jp);
											remove(proceed);
											java.awt.Dimension d=getSize();
											setSize(d.width+1,d.height+1);
											setSize(d.width-1,d.height-1);
											//validate();
											jp3=new JPanel();
											jp3.add(new JLabel("Is Your No present in the given list ?"));
											gbc.gridx=0;
											gbc.gridy=0;
											add(jp3,gbc);
											gbc.gridx=0;
											gbc.gridy=1;
											add(jp,gbc);
										//	yes.setVisible(true);
										//	no.setVisible(true);
											jp2=new JPanel();
											jp2.add(yes);
											jp2.add(no);
											gbc.gridx=0;
											gbc.gridy=2;
											add(jp2,gbc);
										});
		yes.addActionListener((e)->{
									chosen_no();
									c=c*2;
									changeLabel();
									});
		no.addActionListener((e)->{	c=c*2;
									changeLabel();});
	}
	public void changeLabel()
	{
		int j,count=0;
		String s="";
		for(int i=0;i<64;i++)
		{
			j=i & c;
			if(count==0)
			{
				if(j==c)
				{
					s=""+i;
					count=1;
				}
			}
			else
			{
				if(j==c)
				{
					s=s+","+i;
				}
			}
		}
		if(c==64)
		{
			display_no();
			//jp3.setVisible(false);
			remove(jp3);
		//	yes.setVisible(false);
			remove(yes);
			//no.setVisible(false);
			remove(no);
			remove(jp);
			remove(jp2);
			java.awt.Dimension d=getSize();
			setSize(d.width+1,d.height+1);
			setSize(d.width-1,d.height-1);
			playagain=new JButton("Play Again");
			//playagain.setVisible(true);
			gbc.gridx=0;
			gbc.gridy=0;
			add(jp,gbc);
			gbc.gridx=0;
			gbc.gridy=1;
			add(playagain,gbc);
			playagain.addActionListener((e)->{
												c=1;
												n=0;
												label.setText("Select a number between 0 to 63");
												//playagain.setVisible(false);
												remove(jp);
												remove(playagain);
												//validate();
												java.awt.Dimension d1=getSize();
												setSize(d1.width+1,d1.height+1);
												setSize(d1.width-1,d1.height-1);
											//	proceed.setVisible(true);
												first_display();});
		}
		else
		{
			label.setText(s);
		}
	}
	public void chosen_no()
	{
		n=n+c;
	}
	public void display_no()
	{
		label.setText("Your no is:"+n);
	}
	public void first_display()
	{
		jp=new JPanel();
		jp.add(label);

		setLayout(new GridBagLayout());
		gbc=new GridBagConstraints();
		in=new Insets(10,10,10,10);
		gbc.insets=in;

		gbc.gridx=0;
		gbc.gridy=0;
		add(jp,gbc);
		gbc.gridx=0;
		gbc.gridy=1;
		add(proceed,gbc);
	}
}