//package InheritanceClasses;

public class Dealer extends User implements Comparable<Dealer>{

	private double income = 0;
	

	public Dealer(int id, String nameSurname, String phoneNum, String address, String userType, String password, String mail) {
		super(id, nameSurname, phoneNum, address, userType, password, mail);
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

	@Override
	public int compareTo(Dealer o) {
		// TODO Auto-generated method stub
		return (int) (income - o.getIncome());
	}
	
}
