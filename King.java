package final_work;

public class King extends Human {
	//コンストラクタ
	public King() {
	this.setName("王様アキ");
	}

	//メソッド
	public void talk(int num) {
		switch(num){
			case 0:
				System.out.println(this.getName()+"：「うむ、思ったより弱い勇者よ。実は、姫が魔王にさらわれた。そこで、そなたには魔王を討伐しに行ってほしい。」");
				break;
			case 1:
				System.out.println(this.getName()+"：「ありがとう、そなたは恐ろしい魔王の手下と戦うことになるだろう。魔法使いを仲間にするのだ。きっと魔王まで導いてくれるだろう。」");
				break;
			case 2:	
				System.out.println(this.getName()+"：「頼める人は、ただ一人のお前だ。お願い！（もじもじ）」");
				break;
		}
	}
}
