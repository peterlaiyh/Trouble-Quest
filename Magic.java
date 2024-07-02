package final_work;

public class Magic extends Fighter {
	//フィールド
	private int mp;
	private int maxMp;
	
	//コンストラクタ
	public Magic(int pr) {
		this.setName("魔法使いミカ");
		this.setMaxHp(100);
		this.setHp(this.getMaxHp());
		this.setPower((int)(pr*1.5));
		this.setFled(false);
		this.maxMp = 20;
		this.mp = this.maxMp;
	}
	
	//getter・setterメソッド
	public void setMp(int mp) {
		if (mp > maxMp) {
			mp = maxMp;
		}
		this.mp = mp;
	}

	public int getMp() {
		return this.mp;
	}
	
	//メソッド
	public void talk(int num) {
		switch(num){
		case 0:
			System.out.println(this.getName()+"：「しょうがないわね〜」");
			break;
		case 1:
			System.out.println(this.getName()+"：「はあ？最近耳が遠くなったわね～」");
			break;
		case 2:
			System.out.println(this.getName()+"：「ええと、用事があって、お先に...」");
			break;
		case 3:
			System.out.println(this.getName()+"：「スライムの粘液、ゴブリンの目玉、そして狼の牙。ある古代の魔法が使えるかもしれないわね。」");
			break;
		}
	}

	public void fight(Minion mn) {
		int damage = 0;
		if(this.mp>=5) {
    		this.mp -= 5;
    		damage = new java.util.Random().nextInt(this.getPower()+1);
    		System.out.println(this.getName()+"は、魔法を使って戦った。"+mn.getType()+"に"+damage+"のダメージを与えた。");
    	}else {
    		damage = new java.util.Random().nextInt((int)(this.getPower()*0.5)+1);
    		System.out.println(this.getName()+"は、魔法が切れて竹ぼうきで戦った"+mn.getType()+"に"+damage+"のダメージを与えた。");//魔法が切れた場合、攻撃力は半分になる。
    	}
    	mn.setHp(mn.getHp()-damage);
	}
	
	public void fight(Fighter f) {
		int damage = 0;
		if(this.mp>=5) {
    		this.mp -= 5;
    		damage = new java.util.Random().nextInt(this.getPower()+1);
    		System.out.println(this.getName()+"は、魔法を使って戦った。"+f.getName()+"に"+damage+"のダメージを与えた。");
    	}else {
    		damage = new java.util.Random().nextInt((int)(this.getPower()*0.5)+1);
    		System.out.println(this.getName()+"は、魔法が切れて竹ぼうきで戦った。"+f.getName()+"に"+damage+"のダメージを与えた。");//魔法が切れた場合、攻撃力は半分になる。
    	}
    	f.setHp(f.getHp()-damage);
	}
	
	public void run() {
		this.talk(2);
		System.out.println(this.getName()+"は勇者を裏切って逃げた。");
		this.setFled(true);
	}	
	public void recover() {
		this.setHp(this.getHp()+ new java.util.Random().nextInt(this.getMaxHp())+1);
		System.out.println(this.getName()+"は傷薬を飲んで、HPが"+this.getHp()+"まで回復した。");
	}
	
	public void pray() {
		this.setMp(this.getMp()+ new java.util.Random().nextInt(this.maxMp)+1);
		System.out.println(this.getName()+"は空に祈って、MPが"+this.getMp()+"まで回復した。");
		this.setHp(this.getHp() - new java.util.Random().nextInt(20)+1);
		System.out.println("しかし、疲れて、HPが"+this.getHp()+"まで減った。");
	}
}
