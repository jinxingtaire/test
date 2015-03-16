package a;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Fight_Image extends JDialog implements  KeyListener,MouseListener {
	 JLabel jlabel;
	    ImageIcon icon;
	    public Fight_Image(String string){
			Container container=getContentPane();
			JLabel jlabel = new JLabel("激烈的打斗场面",JLabel.CENTER);
			URL url=Fight_Image.class.getResource("/战斗画面.gif");
			ImageIcon icon =new ImageIcon(url);
			jlabel.setIcon(icon);
			container.add(jlabel);
	        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	        this.addMouseListener(this);
	        this.addKeyListener(this);
			setSize(802,453);
			setModal(true);
			setVisible(true);
	    }
	    public void mouseClicked(MouseEvent e) {
	    }

	    public void mousePressed(MouseEvent e) {
	       if(e.getButton()==1)this.dispose();
	    }

	    public void mouseReleased(MouseEvent e) {
	    }

	    public void mouseEntered(MouseEvent e) {
	    }

	    public void mouseExited(MouseEvent e) {
	    }

	    public void keyTyped(KeyEvent e) {
	    }

	    public void keyPressed(KeyEvent e) {
	        if(e.getKeyCode() == ' '||e.getKeyCode() == '\n')
	            this.dispose();
	    }

	    public void keyReleased(KeyEvent e) {
	    }	    
}
