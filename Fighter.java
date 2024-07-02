package final_work;

public abstract class Fighter extends Human{
	//フィールド
	private int maxHp;
	private int hp;
	private int power;
	private boolean fled = false;
	private boolean invincibility = false;
 
	//getter・setterメソッド
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	
	public int getMaxHp() {
		return this.maxHp;
	}
	
	public void setHp(int hp) {
		if (hp > this.maxHp) {
			hp = this.maxHp;
		}else if(hp<0) {
			hp = 0;
		}
			this.hp = hp;
	}
		
	public int getHp() {
		return this.hp;
	}
	
	public void setPower(int power) {
		this.power = power;
	}
	
	public int getPower() {
		return this.power;
	}
	
	public void setFled(boolean fled) {
		this.fled = fled;
	}
	
	public boolean getFled() {
		return this.fled;
	}
	
	public void setInvincibility(boolean invincibility) {
		this.invincibility = invincibility;
	}
	
	public boolean getInvincibility() {
		return this.invincibility;
	}
	
	//メソッド
 	public abstract void fight(Minion m);
 	public abstract void fight(Fighter f);
 	public abstract void run();
}