package a;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import a.Textdialog;

public class MyPanel extends JPanel implements KeyListener {

	// ����Ŀ����

	private static final int WIDTH = 630;

	private static final int HEIGHT = 600;

	// ��������

	private static final int ROW = 30;

	// ��������

	private static final int COL = 31;

	// ����ͼ���С����Ĭ�ϲ���32x32ͼ��,�ɸ�����Ҫ����������

	// ��ʱ��ʼ��Ӧ�ʹ����С����Э��������32x32��ͼƬ�����

	// һ������15������ô����480,Ҳ���Ǳ�����Ĭ�ϵĴ����С��

	// ��Ȼ������Ҳ���Ը���ROW*CS,COl*CS�ڳ�ʼ��ʱ�Զ�����

	// �����С���Ժ�������л��õ������������֮һ�仰�����

	// ��[ΪĿ�Ķ����ڵ�]�����еķ�������Ҷ������Ⳣ�Ժ�ʹ�á�

	private static final int CS = 20;

	// �趨��ͼ��ͨ����rpg������Ϸ�����У���[��ά����]����Ϊ

	// �������е�ͼ������������X�����Y���ꡣʵ����,����

	// �ٻ�����RPG����Ϸ�����Ǵ���Щ�򵥵�X,Y���꿪ʼ�ġ�

	// PS:��ν[����]����ҿ��Լ򵥵����Ϊ�����ݵļ��ϣ�һά����

	// ������X�ᣬ����ά����X,Y��������ɵģ�X��Y�Ľ�֯�㣬��Ϊ

	// һ�����ݡ�

	// �������������

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
	// �趨��ʾͼ�����
	private Image floorImage;

	private Image wallImage;

	private Image roleImage;

	private Image home_image;
	// ��ɫ����

	private int x, y;

	public MyPanel() {
		// �趨��ʼ����ʱ����С
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		loadImage();
		x = 3;
		y = 3;
		// �趨�����ڱ����岢�����������
		setFocusable(true);
		addKeyListener(this);
	}

	// ��洰�壬�˴���Ĭ��JPanel�����Ϲ����ײ��ͼ��

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		// ������ͼ

		drawMap(g);
		drawHome(g);
		drawRole(g);

	}

	/**
	 * 
	 * ����ͼ��
	 * 
	 * 
	 */

	private void loadImage() {

		ImageIcon icon = new ImageIcon(getClass().getResource("/�ݵ�.png"));

		// �ذ�ͼ��

		floorImage = icon.getImage();

		// ��õ�ǰ���Ӧ�����λ��image�ļ����µ�ǽ��ͼ��

		icon = new ImageIcon(getClass().getResource("/��.png"));

		// Χǽͼ��

		wallImage = icon.getImage();

		// �����[Ӣ��]�������ǰ�~
		icon = new ImageIcon(getClass().getResource("/hero1.png"));

		roleImage = icon.getImage();

		// home_image,�ϼ�ͼ��
		icon = new ImageIcon(getClass().getResource("/��.png"));

		home_image = icon.getImage();

	}

	private void drawRole(Graphics g) {

		g.drawImage(roleImage, x * CS, y * CS, this);
		

	}

	private void drawHome(Graphics g) {

		g.drawImage(home_image, 1 * CS, 1 * CS, this);
		

	}


	private void drawMap(Graphics g) {

		// ��Java���κ���Ϸ�����У��㷨��������Ҫ��һ����������ʹ��

		// �򵥵�˫��forѭ�����е�ͼ��棬

		for (int x = 0; x < ROW; x++) {

			for (int j = 0; j < COL; j++) {

				// switch��Ϊjava�е�ת����������ִ�к�()����ֵ���

				// ��case��������ע�⣬��case�������������break�˳�

				// ִ�У�switch�������������㵽���һ��caseΪֹ��

				switch (map[x][j]) {

				case 0: // map�ı��Ϊ0ʱ�����ذ�

					// ��ָ��λ��[���]�����������ص�ͼ�Σ�����ͬ

					g.drawImage(floorImage, j * CS, x * CS, this);

					break;

				case 1: // map�ı��Ϊ1ʱ������ǽ

					g.drawImage(wallImage, j * CS, x * CS, this);

					break;
				case 2: // map�ı��Ϊ2ʱ������

					g.drawImage(home_image, j * CS, x * CS, this);

					break;

				default: // ������caseֵ�Բ�ƥ��ʱ����ִ�д˲�����

					break;

				}

			}

		}

	}

	public void keyPressed(KeyEvent e) {

		// ��ð������

		int keyCode = e.getKeyCode();

		// ͨ��ת����ƥ���¼�

		switch (keyCode) {

		// ������Leftʱ

		case KeyEvent.VK_LEFT:

			// ����left������������move()��[�淶]ʱִ�У�������ͬ

			move(LEFT);

			break;

		// ������Rightʱ

		case KeyEvent.VK_RIGHT:

			move(RIGHT);

			break;

		// ������Upʱ

		case KeyEvent.VK_UP:

			move(UP);

			break;

		// ������Downʱ

		case KeyEvent.VK_DOWN:

			move(DOWN);

			break;

		}

		// ���»��ƴ���ͼ��

		// PS:�ڴ������У��������˽�ɫ�ļ��ƶ�����

		// �����ڱ�����˸�����ƻ�������⣬�������

		// ������

		repaint();

	}

	private boolean isAllow(int x, int y) {

		// ��(x,y)������������ж������Ƕ�֪����

		// �ڱ������ҽ���0��Ϊ�ذ�Ĳ�����1��Ϊ

		// ǽ�Ĳ������������ǵ�������[����]����

		// ����[����]�����Ե���Ҫ[ײǽ]ʱ������

		// ��Ȼ�����������٣����ҽ�������Ĵ���

		// ��ǰ����

		if (map[y][x] == 1) {

			// �������ƶ�ʱ������[��]

			return false;

		}

		// �����ƶ�ʱʱ������[��]

		return true;

	}

	/**
	 * 
	 * �ж��ƶ��¼�������isAllow()����
	 * 
	 * @param event
	 */

	private void move(int event) {
		Fight r1 = new Fight("hero", 4);
		Fight r2 = new Fight("ghost", 8);
		// ��ת�����ж�����¼�����ִ�з���[�淶]�Ĳ�����
		int a = (int) (Math.random() * 10 + 4) / 4;
		switch (event) {

		case LEFT:
			// new Home_Image();
			// �����ж��¼�

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
	 * �����ͷż����¼�
	 */

	public void keyReleased(KeyEvent e) {

	}

	/**
	 * 
	 * �����ַ������¼�
	 */

	public void keyTyped(KeyEvent e) {

	}
}