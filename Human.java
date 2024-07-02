package final_work;

public abstract class Human {
	//フィールド
	private String name;
	
	//setter・getterメソッド
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	//メソッド
	public abstract void talk(int num);
}
