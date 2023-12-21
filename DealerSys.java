import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class DealerSys {

	protected static ArrayList<Dealer> dealers = new ArrayList<>();
	protected static ArrayList<Customer> customers = new ArrayList<>();
	protected static ArrayList<Vehicle> vehicles = new ArrayList<>();
	private static final String SPLIT = "%";
	
	

	public static void readFromFile() {

		try {
		File myObj = new File("Customer.txt");
		Scanner myReader = new Scanner(myObj);
		while (myReader.hasNextLine()) {
			String[] data = myReader.nextLine().split(SPLIT);
			Customer c = new Customer(Integer.parseInt(data[0]), 
			data[1], data[2], data[3],
			 "customer", 
			 Integer.parseInt(data[4]), 
			 Double.parseDouble(data[5]), data[6]);
			customers.add(c);
		}
		myReader.close();
		} catch (FileNotFoundException e) {
		System.out.println("An error occurred.");
		e.printStackTrace();
		}

		try {
		File myObj = new File("Dealer.txt");
		Scanner myReader = new Scanner(myObj);
		while (myReader.hasNextLine()) {
			String[] data = myReader.nextLine().split(SPLIT);
			Dealer d = new Dealer(Integer.parseInt(data[0]), data[1], data[2], data[3], "dealer");
			dealers.add(d);
		}
		myReader.close();
		} catch (FileNotFoundException e) {
		System.out.println("An error occurred.");
		e.printStackTrace();
		}

		try {
		File myObj = new File("Vehicle.txt");
		Scanner myReader = new Scanner(myObj);
		while (myReader.hasNextLine()) {
			String[] data = myReader.nextLine().split(SPLIT);
			String dateOfSale = "";
			//dateOfSale = findDateOfSale(Integer.parseInt(data[0]));


			Vehicle v = new Vehicle(Integer.parseInt(data[0]), data[1],data[2], data[3], Integer.parseInt(data[4]),
									 Double.parseDouble(data[5]),  dateOfSale, "sold");
			vehicles.add(v);

		}
		myReader.close();
		} catch (FileNotFoundException e) {
		System.out.println("An error occurred.");
		e.printStackTrace();
		}

	}
	/*
	public static String findDateOfSale(int id){
		TreeSet<Customer> ts = new TreeSet<Customer>();

		for(Customer c : ts) {
			if(c.getCarId() == id)
				return c.getsaleDate();
		}
		return null;
	}
	*/
	public static boolean checkCustomerId(int id) {
		Customer c;
		for(int i = 0 ; i < customers.size() ; i++) {
			c = customers.get(i);
			if(id == c.getId())
				return true;
		}
		return false;
	}
	
	
	public static boolean addCustomer() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter customer id : ");
		int id = s.nextInt();
		while(checkCustomerId(id)) {
			System.out.println("The id has been given already.");
			System.out.println("Please enter new id : ");
			id = s.nextInt();
		}
		System.out.println("Enter customer name and surname (name,surname) : ");
		String name = s.nextLine();
		System.out.println("Enter customer phone number : ");
		String phone = s.nextLine();
		System.out.println("Enter customer address : ");
		String address = s.nextLine();
		Customer c = new Customer(id,name,phone,address, "customer");
		customers.add(c);
		return true;
	}

	
	public static Customer searchCustomer(int id) {
		Customer c;
		for(int i = 0 ; i < customers.size() ; i++) {
			c = customers.get(i);
			if(id == c.getId())
				return c;
		}
		return null;
	}
	
	
	public static Customer deleteCustomer(int id) {
		Customer c;
		for(int i = 0 ; i < customers.size() ; i++) {
			c = customers.get(i);
			if(id == c.getId())
			{
				customers.remove(i);
				return c;
			}
		}
		return null;	
	}
	
	
	public static String displayCustomers() {
		Customer c;
		String out = "";
		for(int i = 0 ; i < customers.size() ; i++) {
			c = customers.get(i);
			out += c.toString() + "\n\n";
		}
		return out;
	}
	
	/*
		private static boolean buyVehicle() {
		Scanner s = new Scanner(System.in);
		
		
		return true;
	}*/
	
	
	
	public static boolean checkDealerId(int id) {
		Dealer c;
		for(int i = 0 ; i < dealers.size() ; i++) {
			c = dealers.get(i);
			if(id == c.getId())
				return true;
		}
		return false;
	}
	
	
	public static boolean addDealer() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter dealer id : ");
		int id = s.nextInt();
		while(checkDealerId(id)) {
			System.out.println("The id has been given already.");
				System.out.println("Do you want to continue? (y/n) : ");
				String ch = s.next();
				if(ch.equalsIgnoreCase("n"))
					return false;
			System.out.println("Please enter new id : ");
			id = s.nextInt();
		}
		System.out.println("Enter dealer name and surname (name,surname) : ");
		String name = s.nextLine();
		System.out.println("Enter dealer phone number : ");
		String phone = s.nextLine();
		System.out.println("Enter dealer address : ");
		String address = s.nextLine();
		Dealer c = new Dealer(id,name,phone,address, "dealer");
		dealers.add(c);
		return true;
	}
	
	
	public static Dealer searchDealer(int id) {
		Dealer c;
		for(int i = 0 ; i < dealers.size() ; i++) {
			c = dealers.get(i);
			if(id == c.getId())
				return c;
		}
		return null;
	}
	
	
	public static Dealer deleteDealer(int id) {
		Dealer c;
		for(int i = 0 ; i < dealers.size() ; i++) {
			c = dealers.get(i);
			if(id == c.getId())
			{
				dealers.remove(i);
				return c;
			}
		}
		return null;	
	}
	
	
	public static String displayDealer() {
		Dealer c;
		String out = "";
		for(int i = 0 ; i < dealers.size() ; i++) {
			c = dealers.get(i);
			out += c.toString() + "\n\n";
		}
		return out;
	}
	
	
	public static boolean checkVehicleId(int id) {
		Vehicle c;
		for(int i = 0 ; i < vehicles.size() ; i++) {
			c = vehicles.get(i);
			if(id == c.getId())
				return true;
		}
		return false;
	}
	
	
	public static boolean addVehicle() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter vehicle id : ");
		int id = s.nextInt();
		while(checkCustomerId(id)) {
			System.out.println("The id has been given already.");

			System.out.println("Do you want to continue? (y/n) : ");
			String ch = s.next();
			if(ch.equalsIgnoreCase("n"))
				return false;
			
			System.out.println("Please enter new id : ");
			id = s.nextInt();
		}
		System.out.println("Enter registration number : ");
		String regNum = s.nextLine();
		System.out.println("Enter brand : ");
		String brand = s.nextLine();
		System.out.println("Enter model : ");
		String model = s.nextLine();
		System.out.println("Enter model year : ");
		int year = s.nextInt();
		System.out.println("Enter price : ");
		double price = s.nextDouble();		
		
		Vehicle c = new Vehicle(id, regNum, brand,model,year,price);
		vehicles.add(c);
		return true;
	}

	
	public static Vehicle searchVehicle(int id) {
		Vehicle c;
		for(int i = 0 ; i < vehicles.size() ; i++) {
			c = vehicles.get(i);
			if(id == c.getId())
				return c;
		}
		return null;
	}
	
	
	public static Vehicle deletVehicle(int id) {
		Vehicle c;
		for(int i = 0 ; i < vehicles.size() ; i++) {
			c = vehicles.get(i);
			if(id == c.getId())
			{
				vehicles.remove(i);
				return c;
			}
		}
		return null;	
	}
	
	
	public static String displayVehicle() {
		Vehicle c;
		String out = "";
		for(int i = 0 ; i < vehicles.size() ; i++) {
			c = vehicles.get(i);
			out += c.toString() + "\n\n";
		}
		return out;
	}
	
	
	
	public static boolean addUser() {
		Scanner s = new Scanner(System.in);
		boolean res = false;
		System.out.println("Enter user type : ");
		String type = s.next();
		
		if(type.equalsIgnoreCase("customer"))
			res = addCustomer();
		else if(type.equalsIgnoreCase("dealer"))
			res = addDealer();
		
		return res;
		
	}
	
}
