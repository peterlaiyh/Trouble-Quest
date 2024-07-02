package final_work;

public class Princess extends Human {
	//コンストラクタ
	public Princess() {
	this.setName("お姫様マユ");
	}
	
	//メソッド
	public boolean cheer(){ //スーパーヒーローに対して発動するメソッド
		if(new java.util.Random().nextBoolean()) {
			this.talk(0);
			System.out.println(this.getName()+"はいっぱい応援した。"+"スーパー勇者の攻撃力が2倍になった");
			return true;
		}else {
			return false;
		}	
	}
	
	public void talk(int num) {
		switch(num){
			case 0:
				System.out.println(this.getName()+"：「スーパー勇者様❤︎、頑張ってください！」");
				break;
			case 1:
				 System.out.println(this.getName()+"：「ありがとうございます。このことは王に報告します。」");
				 break;
		}
	}
}