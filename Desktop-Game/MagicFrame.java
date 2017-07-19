import javax.swing.JFrame;
import java.awt.Container;
class MagicFrame extends JFrame
{
	private Container c;
	private MagicPanel p;
	private MagicFrame mfmain;
	MagicFrame()
	{
		c=getContentPane();
		p=new MagicPanel();
		c.add(p);
	}
}