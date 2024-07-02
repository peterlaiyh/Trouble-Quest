package final_work;

public class Scenario {
	public static void gameStart(Hero h) {
		System.out.println("GAME START");
		System.out.println("勇者の名前を決めてください。");
		h.setName("勇者"+new java.util.Scanner(System.in).nextLine());
	}
	
	public static void seeKing(Hero h, King k) {
		System.out.println(h.getName()+"は、王様に会いに⾏った。");
		h.talk(0);
		k.talk(0);
		boolean refuse = true;
		while(refuse) {
			System.out.println(h.getName()+"はどう返事するのか。1.依頼を受ける 2.拒否する");
			int answer = new java.util.Scanner(System.in).nextInt();
			if(answer == 1) {
				h.talk(1);
				k.talk(1);
				refuse = false;
			}else {
				h.talk(2);
				k.talk(2);
			}
		}	
	}
	
	public static void invitation(Hero h, Magic m) {
		boolean invitationContinue = true;
		while(invitationContinue) {
			System.out.println(h.getName()+"はどう誘うのか。1.丁寧に願う 2.不躾に強要する 3.やめる");//魔法使いが登場したら、冒険の仲間になるように誘う。
			int invite = new java.util.Scanner(System.in).nextInt();
			int join = 0;
			switch(invite) {//仲間になるかどうかは、乱数で決まる。
				case 1:
					h.talk(3);
					join = 30+new java.util.Random().nextInt(71);//丁寧に願うと、可能性が30から100までになる
					break;
				case 2:
					h.talk(4);
					join = new java.util.Random().nextInt(101);//不躾に強要すると、可能性が0から100までになる
					break;
				case 3:
					h.talk(5);
					join = 60+ new java.util.Random().nextInt(41);//やめると、可能性が60から100までになる
					break;
				default:
					System.out.println(h.getName()+"はただ"+m.getName()+"を睨んだ。");
					join = 0;
					break;
			}
			if(join>=80) {//可能性が80以上の場合、仲間になる
				m.talk(0);
				h.setEvo(0,true);
				invitationContinue = false;
				System.out.println("そして、"+m.getName()+"は仲間になった。");
			}else if(invite == 3) {
				m.talk(1);
				invitationContinue = false;
				System.out.println("そして、"+h.getName()+"は一旦誘うことをやめた。");
			}else{
				m.talk(1);
			}
		}
	}
	
	public static void minionSpawn(Minion mn) {
		System.out.println("敵の"+mn.getType()+"が現れた。");
	}
	
	public static void playerRound(Hero h, Minion mn){
		System.out.println(h.getName()+"の動作を決めてください。1.戦う 2.眠る 3.逃げる");
		int input = new java.util.Scanner(System.in).nextInt();
		switch(input){
			case 1:
				h.fight(mn);
				break;
			case 2:
				h.sleep();
				break;
			case 3:
				h.run();
				break;
			default:
				System.out.println(h.getName()+"はスルーした");
		}
	}
	
	public static void playerRound(SuperHero sh, Minion mn){
		System.out.println(sh.getName()+"の動作を決めてください。1.戦う 2.眠る 3.逃げる 4.空を飛ぶ 5.着陸する");
		int input = new java.util.Scanner(System.in).nextInt();
		switch(input){
			case 1:
				sh.fight(mn);
				break;
			case 2:
				sh.sleep();
				break;
			case 3:
				sh.run();
				break;
			case 4:
				sh.fly();
				break;
			case 5:
				sh.land();
				break;
			default:
				System.out.println(sh.getName()+"はスルーした");
		}
	}
	
	public static void playerRound(SuperHero sh, Boss b,Princess p){
		System.out.println(sh.getName()+"の動作を決めてください。1.戦う 2.眠る 3.逃げる 4.空を飛ぶ 5.着陸する");
		int input = new java.util.Scanner(System.in).nextInt();
		switch(input){
		case 1:
			sh.setCheered(p.cheer());
			sh.fight(b);
			sh.setCheered(false);
			break;
		case 2:
			sh.sleep();
			break;
		case 3:
			sh.run();
			break;
		case 4:
			sh.fly();
			break;
		case 5:
			sh.land();
			break;
		default:
			System.out.println(sh.getName()+"はスルーした");
		}
	}
	
	public static void magicRound(Magic m, Hero h,Minion mn) {
		int input;
		if (m.getHp()<=0) {
			System.out.println(m.getName()+"は戦闘不能。");
			input = new java.util.Random().nextInt(3)+2;
		}else {
			input = new java.util.Random().nextInt(5);
		}
		switch(input){
			case 0:
				m.pray();
				break;
			case 1:
				m.fight(mn);
				break;
			case 2:
				m.run();
				h.talk(6);
				break;
			case 3:
				m.recover();
				break;
			default:
				System.out.println(m.getName()+"はスルーした");
		}
	}
	
	public static void magicRound(Magic m, Hero h,Boss b) {
		int input;
		if (m.getHp()<=0) {
			System.out.println(m.getName()+"は戦闘不能。");
			input = new java.util.Random().nextInt(3)+2;
		}else {
			input = new java.util.Random().nextInt(5);
		}
		switch(input){
			case 0:
				m.pray();
				break;
			case 1:
				m.fight(b);
				break;
			case 2:
				m.run();
				h.talk(6);
				break;
			case 3:
				m.recover();
				break;
			default:
				System.out.println(m.getName()+"はスルーした");
		}
	}
	
	public static void minionRound(Minion mn, Hero h) {
		int input = new java.util.Random().nextInt(3);
		switch(input){
			case 0:
				mn.fight(h);
				break;
			case 1:
				mn.run();
				break;
			default:
				System.out.println(mn.getType()+"はスルーした");
		}
	}
	
	public static void minionRound(Minion mn, Hero h, Magic m) {
		int input = new java.util.Random().nextInt(3);
		switch(input){
			case 0:
				int target = new java.util.Random().nextInt(2);
				switch(target) {
					case 0:
						mn.fight(h);
						break;
					case 1:
						mn.fight(m);
						break;
				}
				break;
			case 1:
				mn.run();
				break;
			default:
				System.out.println(mn.getType()+"はスルーした");
		}
	}
	
	public static void bossRound(Boss b, SuperHero sh) {
		int input = new java.util.Random().nextInt(4);
		switch(input){
			case 0:
				b.fight(sh);
				break;
			case 1:
				b.fight(sh);
				break;
			case 2:
				b.run();
				break;
			default:
				System.out.println(b.getName()+"はスルーした");
		}
	}
	
	public static void bossRound(Boss b, SuperHero sh, Magic m) {
		int input = new java.util.Random().nextInt(4);
		switch(input){
			case 0:
				b.fight(sh);
				break;
			case 1:
				b.fight(m);
				break;
			case 2:
				b.run();
				break;
			default:
				System.out.println(b.getName()+"はスルーした");
		}
	}
	
	public static void info(Hero h, Magic m, Minion mn) {
		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println(h.getName()+"（HP:"+h.getHp()+"）      VS      "+mn.getType()+"（HP:"+mn.getHp()+"）");
		if(h.getEvo()[0]&&!(m.getFled())) {
			System.out.println(m.getName()+"（HP:"+m.getHp()+"  MP:"+m.getMp()+"）");
		}
		System.out.println("------------------------------------------------------------");
	}
	
	public static void info(SuperHero sh, Magic m, Boss b) {
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println(sh.getName()+"（HP:"+sh.getHp()+"）      VS      "+b.getName()+"（HP:"+b.getHp()+"）");
		if(!m.getFled()) {
			System.out.println(m.getName()+"（HP:"+m.getHp()+"  MP:"+m.getMp()+"）");
		}
		System.out.println("-------------------------------------------------------------");
	}
	
	public static void badEnding(Hero h) {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(h.getName()+"は死亡した。");
		System.out.println("BAD ENDING");
		System.exit(0);
	}
	
	public static void goodEnding(SuperHero sh, Princess p) {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		p.talk(1);//お姫様から、感謝の⾔葉をもらい、使命は完了して、ゲームは終了する。
		sh.talk(99);
		System.out.println("GOOD ENDING");
		System.exit(0);
	}

}
