//package InheritanceClasses;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer extends User implements Comparable<Customer> {

	private double expense;
	private int carId;
	private String saleDate;
	
	public Customer() {
		
	}

	public Customer(int carId, double expense) {
		
		this.carId = carId;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		this.saleDate = dateFormat.format(date);
		this.expense = expense;
	}

	public Customer(int id, String nameSurname, String phoneNum, String address,
					 String userType) {

		super(id, nameSurname, phoneNum, address, userType);
	}
	
	public Customer(int id, String nameSurname, String phoneNum, String address, 
					String userType, int carId, double expense) {

		super(id, nameSurname, phoneNum, address, userType);
		this.carId = carId;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		this.saleDate = dateFormat.format(date);
		this.expense = expense;
	}

	public Customer(int id, String nameSurname, String phoneNum, String address, 
					String userType, int carId, double expense, String date) {
						
		super(id, nameSurname, phoneNum, address, userType);
		this.carId = carId;
		this.saleDate = date;
		this.expense = expense;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getsaleDate() {
		return saleDate;
	}

	public void setsaleDate(String saleDate) {
		this.saleDate = saleDate;
	}

	public double getExpense() {
		return expense;
	}

	public void addToExpense(double expense) {
		this.expense += expense;
	}

	
	@Override
	public String toString() {
		return super.toString() + "Customer's Car Id = " + carId + 
				"\nSale Date = " + saleDate + 
				"\nExpense = " + expense + "\n";
	}

	@Override
	public int compareTo(Customer o) {
		return (int) (o.getExpense() - expense);
	}

	
	
}
