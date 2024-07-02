package final_work;

public class Slime extends Minion{
	private String [] typeArray = {"赤い","青い","黄色の"};
	
	//コンストラクタ
	public Slime(int pr) {
		int num = new java.util.Random().nextInt(3);
		this.setType(typeArray[num]+"スライム");
		this.setMaxHp(10);
		this.setHp(this.getMaxHp());
		this.setPower((int)(pr*0.5));
	}
	
	//getter・setterメソッド
	public void setTypeArray(String [] typeArray) {
		this.typeArray = typeArray;
	}

	public String [] getTypeArray() {
		return this.typeArray;
	}
	
	//メソード
    public void fight(Fighter f) {
    	if(f.getInvincibility()) {
    		System.out.println(this.getType()+"はハネて攻撃してきた。しかし、"+f.getName()+"は無敵な状態だ。");
    	}else {
    		int damage = new java.util.Random().nextInt(this.getPower()+1);
        	System.out.println(this.getType()+"はハネて攻撃してきた。"+f.getName()+"に"+damage+"のダメージを与えた。");
        	f.setHp(f.getHp()-damage);
    	}
	}
 
    public void run() {
    	System.out.println(this.getType()+"はゆっくりと逃げ出した。");
    	this.setFled(true);
	}
}