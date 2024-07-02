package final_work;

public abstract class Minion implements Monster{
	//フィールド
	private String type;
	private int maxHp;
	private int hp;
	private int power;
	private boolean fled = false;
    
	//getter・setterメソッド
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType(){
		return this.type;
	}
	
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	
	public int getMaxHp() {
		return maxHp;
	}
	
	public void setHp(int hp) {
		if(hp > this.maxHp) {
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
}