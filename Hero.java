package final_work;

public class Hero extends Fighter{
	//フィールド(属性)
	private boolean [] evo = {false,false,false,false};//魔法使いが仲間になったか・スライムを倒したか・ゴブリンを倒したか・狼男を倒したか
	
	//コンストラクタ
	public Hero(int pr) {
		this.setMaxHp(100);
		this.setHp(this.getMaxHp());
		this.setPower(pr);
	}
	
	public Hero() {//パラメーターがない場合の初期値
		this.setMaxHp(100);
		this.setHp(this.getMaxHp());
		this.setPower(10);
		this.setFled(false);
	}
	
	//getter・setterメソッド
	public void setEvo(int role, boolean condition) {
		this.evo[role] = condition;
	}

	public boolean [] getEvo() {
		return this.evo;
	}
	
	//メソッド
	public void talk(int num) {
		switch(num){
			case 0:
				System.out.println(this.getName()+"：「王様、お呼びでしょうか？」");
				break;
			case 1:
				System.out.println(this.getName()+"：「はい、王様。」");
				break;
			case 2:
				System.out.println(this.getName()+"：「いやだ！死にたくない！」");
				break;	
			case 3:
				System.out.println(this.getName()+"：「王様から魔王討伐を依頼されています。仲間になってくださいますか？」");
				break;
			case 4:
				System.out.println(this.getName()+"：「あのあほうな老人から魔王討伐を依頼されてる。味方になれ！なければ殴ろうよ！」");
				break;
			case 5:
				System.out.println(this.getName()+"：「まあいいか。俺は自分で魔王を倒す！」");
				break;
			case 6:
				System.out.println(this.getName()+"：「おい、裏切り者！」");
				break;
			case 7:
				System.out.println(this.getName()+"：「うおおおー！！！I believe I can fly〜〜〜」");
				break;
			case 8:
				System.out.println(this.getName()+"：「美人のキッスをゲットするため、あっ！違う。国の平和の為、必ずお前を倒す！」");
				break;
			case 9:
				System.out.println(this.getName()+"：「お前は、もう、死んでいる。」");
				break;
			case 99:
				System.out.println(this.getName()+"：「これで、魔王は倒されました。国にも平和がくるでしょう。さあ、一緒に国に帰りましょう。」");
				break;
			
		}
	}
		
	public void fight(Minion mn) {
    	int damage = new java.util.Random().nextInt(this.getPower()+1);
    	System.out.println(this.getName()+"は剣で戦った。"+mn.getType()+"に"+damage+"のダメージを与えた。");
    	mn.setHp(mn.getHp()-damage);
		}
	
	public void fight(Fighter f) {
    	int damage = new java.util.Random().nextInt(this.getPower()+1);
    	System.out.println(this.getName()+"は剣で戦った。"+f.getName()+"に"+damage+"のダメージを与えた。");
    	f.setHp(f.getHp()-damage);
		}
	
	public void run() {
	System.out.println(this.getName()+"は逃げた。");
	this.setFled(true);
	}
	
	public void sleep(){
	this.setHp(this.getMaxHp());
	System.out.println(this.getName()+"は眠ってhpを回復した。");
	}
}