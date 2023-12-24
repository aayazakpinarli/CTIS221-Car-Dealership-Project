//package OtherClasses;

public class Wallet {
	
	private double money;
	private double expense;
	
	
	public Wallet(double money, double expense) {
		this.money = money;
		this.expense = expense;
	}

	public double getMoney() {
		return money;
	}
	
	public void setMoney(double money) {
		this.money = money;
	}
	
	public double getExpense() {
		return expense;
	}
	
	public void setExpense(double expense) {
		this.expense = expense;
	}
	
	public void purchase(double m) {
		money = money - m;
		expense = expense + m;
	}
	
	public void addMoney(double m) {
		money += m;
	}
	
	@Override
	public String toString() {
		return "Wallet Money=" + money + "\nExpense=" + expense + "\n";
	}

	
	
}
