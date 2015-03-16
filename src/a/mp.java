package a;


import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class mp extends JFrame {

        public mp() {



             // 默认的窗体名称

             setTitle("Example1[Java游戏中地图的描绘]");



             // 获得我们自定义面板[地图面板]的实例

             MyPanel panel = new MyPanel();

             Container contentPane = getContentPane();

             contentPane.add(panel);



             // 执行并构建窗体设定

             pack();

        }



        public static void main(String[] args) {

        	mp e1 = new mp();

             // 设定允许窗体关闭操作

             e1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

             // 显示窗体

             e1.setVisible(true);

        }

}