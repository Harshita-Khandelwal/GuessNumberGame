import javax.swing.JFrame;
import javax.swing.WindowConstants;
class MainMagic
{
	public static void main(String args[])
	{
		MagicFrame frame=new MagicFrame();
		frame.setTitle("Magic Game");
		frame.setSize(600,300);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}