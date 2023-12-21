
public class Dealer extends User {

	private double income = 0;

	public Dealer() {
		
	}

	public Dealer(int id, String nameSurname, String phoneNum, String address, String userType) {
		super(id, nameSurname, phoneNum, address, userType);
	}
	
	public double getIncome() {
		return income;
	}

	public void addToIncome(double income) {
		this.income += income;
	}

	@Override
	public String toString() {
		return super.toString() + "Dealer Income = " + income + "\n";
	}
	
	
	
	
	
}
