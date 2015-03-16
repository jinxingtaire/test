package a;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Home_Image extends JDialog implements  KeyListener{
	 JLabel jlabel;
	 public Home_Image() {
		 setTitle("欢迎回家");
		 Container c =getContentPane();
			JLabel jlabel = new JLabel("",JLabel.CENTER);
			jlabel.setSize(200, 200);
			URL url=Fight_Image.class.getResource("/hero.png");
			ImageIcon icon =new ImageIcon(url);
			jlabel.setIcon(icon);
			setLayout(new FlowLayout(2,10,10));
			c.add(BorderLayout.WEST,jlabel);
			c.add(new JButton("休息一下"));
			c.add(new JButton("存一下档"));
			c.add(new JButton("关于游戏"));
			c.add(new JButton("离开这里"));
		 setSize(300,200);
		 setVisible(true);
		 setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// TODO Auto-generated constructor stub
//			setModal(true);
			setVisible(true);
	 }
	 
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
