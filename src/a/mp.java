package a;


import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class mp extends JFrame {

        public mp() {



             // Ĭ�ϵĴ�������

             setTitle("Example1[Java��Ϸ�е�ͼ�����]");



             // ��������Զ������[��ͼ���]��ʵ��

             MyPanel panel = new MyPanel();

             Container contentPane = getContentPane();

             contentPane.add(panel);



             // ִ�в����������趨

             pack();

        }



        public static void main(String[] args) {

        	mp e1 = new mp();

             // �趨������رղ���

             e1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

             // ��ʾ����

             e1.setVisible(true);

        }

}