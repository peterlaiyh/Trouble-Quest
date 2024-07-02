package final_work;

public class Boss extends Fighter implements Monster{
	//コンストラクタ
	public Boss(int pr) {
		this.setName("魔王コヤブ");
		this.setMaxHp(200);
		this.setHp(this.getMaxHp());
		this.setPower(pr*5);
	}
	
	//メソッド
	public void talk(int num) {
		switch(num){
		case 0:
			System.out.println(this.getName()+"：「俺は」"+this.getName()+"だ。貴様らの勇気に敬意を表する。が、本当の恐ろしさを見せてやろう。泣くがいい！叫ぶがいい！");
			break;
		case 1:
			System.out.println(this.getName()+"：「なに！！！？？？」");
			break;
		}
	}
	
    public void fight(Minion mn) {
    	//不可能
    }
	
	public void fight(Fighter f) {
    	int damage = new java.util.Random().nextInt(this.getPower()+1);
    	System.out.println(this.getName()+"は大声を出して攻撃してきた。"+f.getName()+"に"+damage+"のダメージを与えた。");
    	f.setHp(f.getHp()-damage);
	}
 
    public void run() {
      System.out.println(this.getName()+"は飛んで逃げ出した。");
      this.setFled(true);
	}
}