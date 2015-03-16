package a;

import java.awt.Container;
import java.awt.FlowLayout;
import java.net.URL;

import javax.swing.*;


public class MyImageIcon extends JFrame {  
	public MyImageIcon(){	
	Container container=getContentPane();
	setLayout(new FlowLayout(2,10,10));
	JLabel jl=new JLabel("这是一个窗体");
	URL url=MyImageIcon.class.getResource("/1.PNG");
	Icon icon=new ImageIcon(url);
	jl.setIcon(icon);
	jl.setHorizontalAlignment(SwingConstants.CENTER);
	jl.setOpaque(true);
	container.add(jl);
	setSize(WIDTH,HEIGHT);
	setVisible(true);
	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	
	}
//public static void main (String args[])
//{
//	new MyImageIcon();
//	}
}
