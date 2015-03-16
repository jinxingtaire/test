package a;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;


public class Fight extends JDialog{
	private String player_name;// 角色名字
	private int Power;// 攻击
	private int Power_initial=10;//初始攻击力
	private int blood;// 血量
	private int blood_initial=100;//初始血量
	private int speed;// 速度
	private int speed_initial=3;//初始速度
//	private int defence;//防御
//	private int defence_initial;
	private int lv;//等级
	public Fight(String player_name,int lv) {
		this.player_name = player_name;// 角色名称
		this.Power = Power_initial+lv*5;// 每次攻击的强度
		this.blood = blood_initial+lv*10;// 血量
		this.speed = speed_initial+lv*2;// 速度，决定双方攻击顺序
	}

	public void attack(Fight r) {
		new Fightdialog("战斗开始");
		new Fight_Image(" ");
		while (this.blood > 0 && r.blood > 0)// 双方血量存活战斗继续
		{
			if (this.speed > r.speed)// 比较速度，速度快者先出手
			{

				r.blood = r.blood - this.Power;
				System.out.println(this.player_name + "对" + r.player_name
						+ "造成了" + this.Power + "伤害");


				if (r.blood > 0) {
					System.out.println(r.player_name + "剩余血量：" + r.blood);

					this.blood = this.blood - r.Power;

					System.out.println(r.player_name + "对" + this.player_name
							+ "造成了" + r.Power + "伤害");
					System.out.println(this.player_name + "剩余血量：" + this.blood);
				}

			} else if (r.speed == this.speed) {// 双方速度相同
				int a = (int) (Math.random() * 10);
				if (a > 5) {

					r.blood = r.blood - this.Power;
					System.out.println(this.player_name + "对" + r.player_name
							+ "造成了" + this.Power + "伤害");
					new Fightdialog(this.player_name + "对" + r.player_name
							+ "造成了" + this.Power + "伤害");

					if (r.blood > 0) {
						System.out.println(r.player_name + "剩余血量：" + r.blood);

						this.blood = this.blood - r.Power;

						System.out.println(r.player_name + "对"
								+ this.player_name + "造成了" + r.Power + "伤害");
						System.out.println(this.player_name + "剩余血量："
								+ this.blood);
					}
				}

				else //
				{

					this.blood = this.blood - r.Power;
					System.out.println(r.player_name + "对" + this.player_name
							+ "造成了" + r.Power + "伤害");


					if (this.blood > 0) {

						r.blood = r.blood - this.Power;

						System.out.println(this.player_name + "剩余血量："
								+ this.blood);
						System.out.println(this.player_name + "对"
								+ r.player_name + "造成了" + this.Power + "伤害");
						System.out.println(r.player_name + "剩余血量：" + r.blood);
					}

				}
				
			}
		
			else //
			{

				this.blood = this.blood - r.Power;

				System.out.println(r.player_name + "对" + this.player_name
						+ "造成了" + r.Power + "伤害");

				if (this.blood > 0) {

					System.out.println(this.player_name + "剩余血量："
							+ this.blood);

					r.blood = r.blood - this.Power;

					System.out.println(this.player_name + "对"
							+ r.player_name + "造成了" + this.Power + "伤害");
					System.out.println(r.player_name + "剩余血量：" + r.blood);
				}

			}
			
			if (r.blood < 0)
				new Fightdialog(this.player_name + "胜利");
				System.out.print(this.player_name + "胜利");
			if (this.blood < 0)
				new Fightdialog(r.player_name + "胜利");
				System.out.print(r.player_name + "胜利");
		}

	}}
