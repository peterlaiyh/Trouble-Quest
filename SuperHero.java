package final_work;

public class SuperHero extends Hero {
	//フィールド(属性)
	private boolean flying = false;
	private boolean cheered = false;
	
	//コンストラクタ
	public SuperHero(Hero h) {
		this.setName("スーパー"+h.getName());
		this.setMaxHp(200);
		this.setHp(this.getMaxHp());
		this.setPower(h.getPower()*2);
		this.setFled(false);
		this.setEvo(0,true);
	}
	
	//getter・setterメソッド
	public void setFlying(boolean flying) {
		this.flying = flying;
	}
	
	public boolean getFlying() {
		return this.flying;
	}
	
	public void setCheered(boolean cheered) {
		this.cheered = cheered;
	}
	
	public boolean getCheered() {
		return this.cheered;
	}
	//メソッド
	public void fight(Minion mn) {
		double a = 1;
		int c = 1;
		if(this.flying) {
			a = 0.5;
		}
		if(this.cheered) {
			c = 2;
		}
		int damage = ((int)(new java.util.Random().nextInt(this.getPower()+1)*a*c));
		System.out.println(this.getName()+"はスーパー勇者の宝剣で戦った。"+mn.getType()+"に"+damage+"のダメージを与えた。");
		}
	
	public void fight(Fighter f) {
		double a = 1;
		int c = 1;
		if(this.flying) {
			a = 0.5;
		}
		if(this.cheered) {
			c = 2;
		}
		int damage = ((int)(new java.util.Random().nextInt(this.getPower()+1)*a*c));
		System.out.println(this.getName()+"はスーパー勇者の宝剣で戦った。"+f.getName()+"に"+damage+"のダメージを与えた。");
		f.setHp(f.getHp()-damage);
		}
	
	public void fly() {
		System.out.println(this.getName()+"は飛んだ");
		this.flying = true;
		this.setInvincibility(true);
	}
	
	public void land() {
		if(flying) {
			System.out.println(this.getName()+"は着地した");
			this.flying = false;
			this.setInvincibility(false);
		}else {
			System.out.println(this.getName()+"は飛んでいないので、着地できない。");
		}
	}
}
