package a;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import a.Textdialog;

public class MyPanel extends JPanel implements KeyListener {

	// 窗体的宽与高

	private static final int WIDTH = 630;

	private static final int HEIGHT = 600;

	// 像素行数

	private static final int ROW = 30;

	// 像素列数

	private static final int COL = 31;

	// 单个图像大小，我默认采用32x32图形,可根据需要调整比例。

	// 当时，始终应和窗体大小比例协调；比如32x32的图片，如何

	// 一行设置15个，那么就是480,也就是本例子默认的窗体大小，

	// 当然，我们也可以根据ROW*CS,COl*CS在初始化时自动调整

	// 窗体大小，以后的例子中会用到类似情况。总之一句话，编程

	// 是[为目的而存在的]，所有的方法，大家都可任意尝试和使用。

	private static final int CS = 20;

	// 设定地图，通常在rpg类型游戏开发中，以[二维数组]对象为

	// 基础进行地图处理，用以描绘出X坐标和Y坐标。实际上,即令

	// 再华丽的RPG类游戏，都是从这些简单的X,Y坐标开始的。

	// PS:所谓[数组]，大家可以简单的理解为即数据的集合，一维数组

	// 仅包含X轴，而二维是由X,Y两个轴组成的，X与Y的交织点，即为

	// 一条数据。

	// 以数字区别方向键

	private static final int LEFT = 30;

	private static final int RIGHT = 1;

	private static final int UP = 2;

	private static final int DOWN = 3;

	private int[][] map = {

			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
					1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
					1, 1, 1, 1, 1, 1, 1, 1, 1 }, };
	// 设定显示图像对象
	private Image floorImage;

	private Image wallImage;

	private Image roleImage;

	private Image home_image;
	// 角色坐标

	private int x, y;

	public MyPanel() {
		// 设定初始构造时面板大小
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		loadImage();
		x = 3;
		y = 3;
		// 设定焦点在本窗体并付与监听对象
		setFocusable(true);
		addKeyListener(this);
	}

	// 描绘窗体，此处在默认JPanel基础上构建底层地图．

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		// 画出地图

		drawMap(g);
		drawHome(g);
		drawRole(g);

	}

	/**
	 * 
	 * 载入图像
	 * 
	 * 
	 */

	private void loadImage() {

		ImageIcon icon = new ImageIcon(getClass().getResource("/草地.png"));

		// 地板图像

		floorImage = icon.getImage();

		// 获得当前类对应的相对位置image文件夹下的墙体图像

		icon = new ImageIcon(getClass().getResource("/树.png"));

		// 围墙图像

		wallImage = icon.getImage();

		// 导入个[英雄]来当主角吧~
		icon = new ImageIcon(getClass().getResource("/hero1.png"));

		roleImage = icon.getImage();

		// home_image,老家图像
		icon = new ImageIcon(getClass().getResource("/家.png"));

		home_image = icon.getImage();

	}

	private void drawRole(Graphics g) {

		g.drawImage(roleImage, x * CS, y * CS, this);
		

	}

	private void drawHome(Graphics g) {

		g.drawImage(home_image, 1 * CS, 1 * CS, this);
		

	}


	private void drawMap(Graphics g) {

		// 在Java或任何游戏开发中，算法都是最重要的一步，本例尽使用

		// 简单的双层for循环进行地图描绘，

		for (int x = 0; x < ROW; x++) {

			for (int j = 0; j < COL; j++) {

				// switch作为java中的转换器，用于执行和()中数值相等

				// 的case操作。请注意，在case操作中如果不以break退出

				// 执行；switch函数将持续运算到最后一个case为止。

				switch (map[x][j]) {

				case 0: // map的标记为0时画出地板

					// 在指定位置[描绘]出我们所加载的图形，以下同

					g.drawImage(floorImage, j * CS, x * CS, this);

					break;

				case 1: // map的标记为1时画出城墙

					g.drawImage(wallImage, j * CS, x * CS, this);

					break;
				case 2: // map的标记为2时画出家

					g.drawImage(home_image, j * CS, x * CS, this);

					break;

				default: // 当所有case值皆不匹配时，将执行此操作。

					break;

				}

			}

		}

	}

	public void keyPressed(KeyEvent e) {

		// 获得按键编号

		int keyCode = e.getKeyCode();

		// 通过转换器匹配事件

		switch (keyCode) {

		// 当触发Left时

		case KeyEvent.VK_LEFT:

			// 进行left操作，仅符合move()中[规范]时执行，以下相同

			move(LEFT);

			break;

		// 当触发Right时

		case KeyEvent.VK_RIGHT:

			move(RIGHT);

			break;

		// 当触发Up时

		case KeyEvent.VK_UP:

			move(UP);

			break;

		// 当触发Down时

		case KeyEvent.VK_DOWN:

			move(DOWN);

			break;

		}

		// 重新绘制窗体图像

		// PS:在此例程中，仅进行了角色的简单移动处理

		// ，关于避免闪烁及限制活动区域问题，请见后续

		// 案例。

		repaint();

	}

	private boolean isAllow(int x, int y) {

		// 以(x,y)交点进行数据判定，我们都知道，

		// 在本例中我仅以0作为地板的参数，1作为

		// 墙的参数，由于我们的主角是[人类]，而

		// 不是[幽灵]，所以当他要[撞墙]时，我们

		// 当然不会允许，至少，是我讲到剧情的触发

		// 以前……

		if (map[y][x] == 1) {

			// 不允许移动时，返回[假]

			return false;

		}

		// 允许移动时时，返回[真]

		return true;

	}

	/**
	 * 
	 * 判断移动事件，关联isAllow()函数
	 * 
	 * @param event
	 */

	private void move(int event) {
		Fight r1 = new Fight("hero", 4);
		Fight r2 = new Fight("ghost", 8);
		// 以转换器判断相关事件，仅执行符合[规范]的操作。
		int a = (int) (Math.random() * 10 + 4) / 4;
		switch (event) {

		case LEFT:
			// new Home_Image();
			// 依次判定事件

//			if (a > 5) {
//				if (map[x][y] == 1)
					r1.attack(r2);
//			}
			if (isAllow(x - 1, y))
				x--;

			break;

		case RIGHT:

			if (a > 3) {
				if (map[x][y] == 1)
					r1.attack(r2);
			}
			if (isAllow(x + 1, y))
				x++;

			break;

		case UP:

			if (a > 4) {
				if (map[x][y] == 1)
					r1.attack(r2);
			}
			if (isAllow(x, y - 1))
				y--;

			break;

		case DOWN:

			if (a > 2) {
				if (map[x][y] == 1)
					r1.attack(r2);
			}
			if (isAllow(x, y + 1))
				y++;

			break;

		default:

			break;

		}

	}

	/**
	 * 
	 * 暂无释放键盘事件
	 */

	public void keyReleased(KeyEvent e) {

	}

	/**
	 * 
	 * 暂无字符输入事件
	 */

	public void keyTyped(KeyEvent e) {

	}
}