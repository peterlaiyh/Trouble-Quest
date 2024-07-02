package final_work;

public class Goblin extends Minion{
	private String [] typeArray = {"剣持ちの","弓持ちの","騎馬の"};
	
	//コンストラクタ
	public Goblin(int pr) {
		int num = new java.util.Random().nextInt(3);
		this.setType(typeArray[num]+"ゴブリン");
		this.setMaxHp(20);
		this.setHp(this.getMaxHp());
		this.setPower(pr);
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
    		System.out.println(this.getType()+"はウォーと襲いかかってきた。しかし、"+f.getName()+"は無敵な状態だ。");
    	}else {
    		int damage = new java.util.Random().nextInt(this.getPower()+1);
        	System.out.println(this.getType()+"はウォーと襲いかかってきた。"+f.getName()+"に"+damage+"のダメージを与えた。");
        	f.setHp(f.getHp()-damage);
    	}
	}    
 
    public void run() {
    	System.out.println(this.getType()+"はそそくさと逃げ出した。");
    	this.setFled(true);
	}
}
