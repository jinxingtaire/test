package a;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;


public class Fight extends JDialog{
	private String player_name;// ��ɫ����
	private int Power;// ����
	private int Power_initial=10;//��ʼ������
	private int blood;// Ѫ��
	private int blood_initial=100;//��ʼѪ��
	private int speed;// �ٶ�
	private int speed_initial=3;//��ʼ�ٶ�
//	private int defence;//����
//	private int defence_initial;
	private int lv;//�ȼ�
	public Fight(String player_name,int lv) {
		this.player_name = player_name;// ��ɫ����
		this.Power = Power_initial+lv*5;// ÿ�ι�����ǿ��
		this.blood = blood_initial+lv*10;// Ѫ��
		this.speed = speed_initial+lv*2;// �ٶȣ�����˫������˳��
	}

	public void attack(Fight r) {
		new Fightdialog("ս����ʼ");
		new Fight_Image(" ");
		while (this.blood > 0 && r.blood > 0)// ˫��Ѫ�����ս������
		{
			if (this.speed > r.speed)// �Ƚ��ٶȣ��ٶȿ����ȳ���
			{

				r.blood = r.blood - this.Power;
				System.out.println(this.player_name + "��" + r.player_name
						+ "�����" + this.Power + "�˺�");


				if (r.blood > 0) {
					System.out.println(r.player_name + "ʣ��Ѫ����" + r.blood);

					this.blood = this.blood - r.Power;

					System.out.println(r.player_name + "��" + this.player_name
							+ "�����" + r.Power + "�˺�");
					System.out.println(this.player_name + "ʣ��Ѫ����" + this.blood);
				}

			} else if (r.speed == this.speed) {// ˫���ٶ���ͬ
				int a = (int) (Math.random() * 10);
				if (a > 5) {

					r.blood = r.blood - this.Power;
					System.out.println(this.player_name + "��" + r.player_name
							+ "�����" + this.Power + "�˺�");
					new Fightdialog(this.player_name + "��" + r.player_name
							+ "�����" + this.Power + "�˺�");

					if (r.blood > 0) {
						System.out.println(r.player_name + "ʣ��Ѫ����" + r.blood);

						this.blood = this.blood - r.Power;

						System.out.println(r.player_name + "��"
								+ this.player_name + "�����" + r.Power + "�˺�");
						System.out.println(this.player_name + "ʣ��Ѫ����"
								+ this.blood);
					}
				}

				else //
				{

					this.blood = this.blood - r.Power;
					System.out.println(r.player_name + "��" + this.player_name
							+ "�����" + r.Power + "�˺�");


					if (this.blood > 0) {

						r.blood = r.blood - this.Power;

						System.out.println(this.player_name + "ʣ��Ѫ����"
								+ this.blood);
						System.out.println(this.player_name + "��"
								+ r.player_name + "�����" + this.Power + "�˺�");
						System.out.println(r.player_name + "ʣ��Ѫ����" + r.blood);
					}

				}
				
			}
		
			else //
			{

				this.blood = this.blood - r.Power;

				System.out.println(r.player_name + "��" + this.player_name
						+ "�����" + r.Power + "�˺�");

				if (this.blood > 0) {

					System.out.println(this.player_name + "ʣ��Ѫ����"
							+ this.blood);

					r.blood = r.blood - this.Power;

					System.out.println(this.player_name + "��"
							+ r.player_name + "�����" + this.Power + "�˺�");
					System.out.println(r.player_name + "ʣ��Ѫ����" + r.blood);
				}

			}
			
			if (r.blood < 0)
				new Fightdialog(this.player_name + "ʤ��");
				System.out.print(this.player_name + "ʤ��");
			if (this.blood < 0)
				new Fightdialog(r.player_name + "ʤ��");
				System.out.print(r.player_name + "ʤ��");
		}

	}}
