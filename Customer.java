//package InheritanceClasses;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import OtherClasses.Wallet;

public class Customer extends User implements Comparable<Customer> {

	private ArrayList<Integer> carId = new ArrayList<>();
	private String saleDate;
	private Wallet wallet;
	
	public Customer() {
		
	}

	public Customer(int carId, double expense) {
		
		this.carId.add(carId);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		this.saleDate = dateFormat.format(date);
		wallet.purchase(expense);
	}

	public Customer(int id, String nameSurname, String phoneNum, String address,
					 String userType, String password) {

		super(id, nameSurname, phoneNum, address, userType, password);
	}
	
	public Customer(int id, String nameSurname, String phoneNum, String address,
			 String userType, String password, double walletMoney) {
	
		super(id, nameSurname, phoneNum, address, userType, password);
		Wallet w = new Wallet(walletMoney, 0);
		this.wallet = w;
	}
	
	public Customer(int id, String nameSurname, String phoneNum, String address, 
					String userType, int carId,Wallet wallet, String password) {

		super(id, nameSurname, phoneNum, address, userType, password);
		this.carId.add(carId);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		this.saleDate = dateFormat.format(date);
		this.wallet = wallet;
	}

	public Customer(int id, String nameSurname, String phoneNum, String address, 
					String userType, int carId, Wallet wallet, String date, String password) {
						
		super(id, nameSurname, phoneNum, address, userType, password);
		this.carId.add(carId);
		this.saleDate = date;
		this.wallet = wallet;
	}

	public ArrayList<Integer> getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId.add(carId);
	}

	public String getsaleDate() {
		return saleDate;
	}

	public void setsaleDate(String saleDate) {
		this.saleDate = saleDate;
	}
	
	
	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
	public void addWallet(double m) {
		this.wallet.addMoney(m);
	}

	@Override
	public String toString() {
		String res = "";
		for(Integer i : carId) {
			res += i.toString() + "\n\t\t";
		}
		return super.toString() + "Customer's Car Id Numbers = " + res + 
				"Sale Date = " + saleDate + "\n" +
				wallet.toString();
	}

	@Override
	public int compareTo(Customer o) {
		return (int) (o.wallet.getExpense() - wallet.getExpense());
	}

	
	
}
