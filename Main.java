package final_work;

public class Main {

	public static void main(String[] args) {
		int pr = 10;
		Hero h = new Hero(pr);
		King k = new King();
		Princess p = new Princess();
		Magic m = new Magic(pr);
		//勇者は、誕⽣したらプレーヤーから名前を与えられる。
		Scenario.gameStart(h);
		
		//勇者は、最初に、王様に会いに⾏き、使命を与えられる。
		//使命は、「魔王を倒して、お姫様を助け出すこと」
		Scenario.seeKing(h,k);

		//勇者は冒険の旅に出る。
		//旅の途中で、魔法使いか敵に出会う。
		while(true) {
			System.out.println();
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println(h.getName()+"は冒険の旅に出た。");
			if(h.getEvo()[0]&&m.getFled()) {
				System.out.println("そして、先のバトルを逃げた"+m.getName()+"が戻ってくれた。");
				m.setFled(false);
			}
			//スライム、ゴブリン、狼男を全て倒し、魔法使いと仲間になると、勇者は、スーパー勇者になる。
			boolean evolution = true;
			for (boolean condition:h.getEvo()) {
				evolution &= condition;
			}
			if(evolution) {//勇者は進化の条件を達成する場合、進化する
				m.talk(3);
				System.out.println(m.getName()+"は呪文を読みながら、スライムの粘液、ゴブリンの目玉、そして狼の牙を全部混ぜて勇者にこぼした。");
				System.out.println("そして、"+h.getName()+"はスーパー勇者に進化した！");
				break;
			}
			int meet;
			if(!h.getEvo()[0]) {//魔法使いがまだ仲間にならない場合
				meet = new java.util.Random().nextInt(4);
			}else {
				meet = new java.util.Random().nextInt(3)+1;
			}
			switch(meet) {
				case 0://魔法使い
					System.out.println(h.getName()+"は"+m.getName()+"に出会った。");
					Scenario.invitation(h,m);
					break;
			//スライム、ゴブリン、狼男の内のいずれかの敵に出会う。
			//どの敵に出会うかは、乱数で決まる。
			//各キャラクターが攻撃を⾏った場合、敵にどの程度のダメージを与えることが出来るかは、乱数できまる。
				case 1://スライム
					Slime s = new Slime(pr);
					Scenario.minionSpawn(s);
					h.setFled(false);
					m.setFled(false);
					while(true) {
						Scenario.info(h,m,s);
						Scenario.playerRound(h,s);
						if(h.getFled()) {
							break;	
						}
						if(s.getHp()<=0) {
							System.out.println(s.getType()+"は倒れた。");
							System.out.print(h.getName()+"はスライムの粘液をゲットした。");
							h.setEvo(1,true);
							break;
						}
						if(h.getEvo()[0]&&!(m.getFled())) {
							Scenario.magicRound(m,h,s);
						}
						if(s.getHp()<=0) {
							System.out.println(s.getType()+"は倒れた。");
							System.out.print(h.getName()+"はスライムの粘液をゲットした。");
							h.setEvo(1,true);
							break;
						}
						if(h.getEvo()[0]&&!(m.getFled())) {
							Scenario.minionRound(s,h,m);
						}else {
							Scenario.minionRound(s,h);
						}
						if(h.getHp()<=0) {
							Scenario.badEnding(h);
						}
						if(s.getFled()) {
							break;
						}
					}
					break;
				case 2://ゴブリン
					Goblin g = new Goblin(pr);
					Scenario.minionSpawn(g);
					h.setFled(false);
					m.setFled(false);
					while(true) {
						Scenario.info(h,m,g);
						Scenario.playerRound(h,g);
						if(h.getFled()) {
							break;	
						}
						if(g.getHp()<=0) {
							System.out.println(g.getType()+"は倒れた。");
							System.out.println(h.getName()+"はゴブリンの目玉をゲットした。");
							h.setEvo(2,true);
							break;
						}
						if(h.getEvo()[0]&&!(m.getFled())) {
							Scenario.magicRound(m,h,g);
						}
						if(g.getHp()<=0) {
							System.out.println(g.getType()+"は倒れた。");
							System.out.println(h.getName()+"はゴブリンの目玉をゲットした。");
							h.setEvo(2,true);
							break;
						}
						if(h.getEvo()[0]&&!(m.getFled())) {
							Scenario.minionRound(g,h,m);
						}else {
							Scenario.minionRound(g,h);
						}
						if(h.getHp()<=0) {
							Scenario.badEnding(h);
						}
						if(g.getFled()) {
							break;
						}
					}
					break;
				case 3://狼男
					Werewolf w = new Werewolf(pr);
					Scenario.minionSpawn(w);
					h.setFled(false);
					m.setFled(false);
					while(true) {
						Scenario.info(h,m,w);
						Scenario.playerRound(h,w);
						if(h.getFled()) {
							break;	
						}
						if(w.getHp()<=0) {
							System.out.println(w.getType()+"は倒れた。");
							System.out.println(h.getName()+"は狼の牙をゲットした。");
							h.setEvo(3,true);
							break;
						}
						if(h.getEvo()[0]&&!(m.getFled())) {
							Scenario.magicRound(m,h,w);
						}
						if(w.getHp()<=0) {
							System.out.println(w.getType()+"は倒れた。");
							System.out.println(h.getName()+"は狼の牙をゲットした。");
							h.setEvo(3,true);
							break;
						}
						if(h.getEvo()[0]&&!(m.getFled())) {
							Scenario.minionRound(w,h,m);
						}else {
							Scenario.minionRound(w,h);
						}
						if(h.getHp()<=0) {
							Scenario.badEnding(h);
						}
						if(w.getFled()) {
							break;
						}
					}
					break;
			}
		}
		
		SuperHero sh = new SuperHero(h);
		sh.talk(7);//スーパー勇者になると、⾶ぶ能⼒を⾝につけることができる。 
		
		//スーパー勇者になったあと、再び旅に出る。
		while(true) {
			System.out.println();
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println(sh.getName()+"は再び冒険の旅に出た。");
			if(m.getFled()) {
				System.out.println("そして、先のバトルを逃げた"+m.getName()+"が戻ってくれた。");
				m.setFled(false);
			}
			
			int meet = new java.util.Random().nextInt(4);
			switch(meet) {//スーパー勇者は、スライム、ゴブリン、狼男、魔王の内のいずれか敵に出会う。どの敵に出会うかは、乱数で決まる。
				case 0://魔王
					Boss b = new Boss(pr);
					System.out.println(b.getName()+"が現れた。");
					sh.setFled(false);
					sh.setFlying(false);
					sh.setCheered(false);
					m.setFled(false);
					b.talk(0);
					sh.talk(8);
					while(true) {
						Scenario.info(sh,m,b);
						Scenario.playerRound(sh,b,p);
						if(sh.getFled()) {
							break;
						}
						if(b.getHp()<=0) {
							sh.talk(9);
							b.talk(1);
							System.out.println(b.getName()+"は倒れた。");
							Scenario.goodEnding(sh,p);
						}
						if(!(m.getFled())) {
							Scenario.magicRound(m,sh,b);
							
						}
						if(b.getHp()<=0) {
							sh.talk(9);
							b.talk(1);
							System.out.println(b.getName()+"は倒れた。");
							Scenario.goodEnding(sh,p);
						}
						if(!m.getFled()) {
							Scenario.bossRound(b,sh,m);
						}else {
							Scenario.bossRound(b,sh);
						}
						if(sh.getHp()<=0) {
							Scenario.badEnding(sh);
						}
						if(b.getFled()) {
							break;
						}
					}
					break;
				case 1://スライム
					Slime s = new Slime(pr);
					Scenario.minionSpawn(s);
					sh.setFled(false);
					sh.setFlying(false);
					sh.setCheered(false);
					m.setFled(false);
					while(true) {
						Scenario.info(sh,m,s);
						Scenario.playerRound(sh,s);
						if(sh.getFled()) {
							break;	
						}
						if(s.getHp()<=0) {
							System.out.println(s.getType()+"は倒れた。");
							break;
						}
						if(!(m.getFled())) {
							Scenario.magicRound(m,sh,s);
						}
						if(s.getHp()<=0) {
							System.out.println(s.getType()+"は倒れた。");
							break;
						}
						if(!(m.getFled())) {
							Scenario.minionRound(s,sh,m);
						}else {
							Scenario.minionRound(s,sh);
						}
						if(sh.getHp()<=0) {
							Scenario.badEnding(sh);
						}
						if(s.getFled()) {
							break;
						}
					}
					break;
				case 2://ゴブリン
					Goblin g = new Goblin(pr);
					Scenario.minionSpawn(g);
					sh.setFled(false);
					sh.setFlying(false);
					sh.setCheered(false);
					m.setFled(false);
					while(true) {
						Scenario.info(sh,m,g);
						Scenario.playerRound(sh,g);
						if(sh.getFled()) {
							break;	
						}
						if(g.getHp()<=0) {
							System.out.println(g.getType()+"は倒れた。");
							break;
						}
						if(!(m.getFled())) {
							Scenario.magicRound(m,sh,g);
						}
						if(g.getHp()<=0) {
							System.out.println(g.getType()+"は倒れた。");
							break;
						}
						if(!(m.getFled())) {
							Scenario.minionRound(g,sh,m);
						}else {
							Scenario.minionRound(g,sh);
						}
						if(sh.getHp()<=0) {
							Scenario.badEnding(sh);
						}
						if(g.getFled()) {
							break;
						}
					}
					break;
				case 3://狼男
					Werewolf w = new Werewolf(pr);
					Scenario.minionSpawn(w);
					sh.setFled(false);
					sh.setFlying(false);
					sh.setCheered(false);
					m.setFled(false);
					while(true) {
						Scenario.info(sh,m,w);
						Scenario.playerRound(sh,w);
						if(sh.getFled()) {
							break;	
						}
						if(w.getHp()<=0) {
							System.out.println(w.getType()+"は倒れた。");
							break;
						}
						if(!(m.getFled())) {
							Scenario.magicRound(m,sh,w);
						}
						if(w.getHp()<=0) {
							System.out.println(w.getType()+"は倒れた。");
							break;
						}
						if(!(m.getFled())) {
							Scenario.minionRound(w,sh,m);
						}else {
							Scenario.minionRound(w,sh);
						}
						if(sh.getHp()<=0) {
							Scenario.badEnding(sh);
						}
						if(w.getFled()) {
							break;
						}
					}
					break;
			}
		}
	}
}