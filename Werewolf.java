package final_work;

public class Werewolf extends Minion{
	private String [] typeArray = {"普通の","怒ってる","狂暴な"};
	
	//コンストラクタ
	public Werewolf(int pr) {
		int num = new java.util.Random().nextInt(3);
		this.setType(typeArray[num]+"狼男");
		this.setMaxHp(20);
		this.setHp(this.getMaxHp());
		this.setPower(pr*2);
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
    		System.out.println(this.getType()+"は爪で攻撃してきた。しかし、"+f.getName()+"は無敵な状態だ。");
    	}else {
    		int damage = new java.util.Random().nextInt(this.getPower()+1);
        	System.out.println(this.getType()+"は爪で攻撃してきた。"+f.getName()+"に"+damage+"のダメージを与えた。");
        	f.setHp(f.getHp()-damage);
    	}
	}    
 
    public void run() {
    	System.out.println(this.getType()+"は尻尾を巻いて逃げ出した。");
    	this.setFled(true);
	}
}