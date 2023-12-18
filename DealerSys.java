import java.util.ArrayList;
import java.util.Scanner;

public class DealerSys {

	protected static ArrayList<Dealer> dealers = new ArrayList<>();
	protected static ArrayList<Customer> customers = new ArrayList<>();
	protected static ArrayList<Vehicle> vehicles = new ArrayList<>();
	
	private static int numOfVehicles = 0;
	private static int numOfCustomer = 0;
	private static int numOfDealers = 0;
	
	
	
	
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

	
	private static Customer searchCustomer(int id) {
		Customer c;
		for(int i = 0 ; i < customers.size() ; i++) {
			c = customers.get(i);
			if(id == c.getId())
				return c;
		}
		return null;
	}
	
	
	private static Customer deleteCustomer(int id) {
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
	
	
	private static String displayCustomers() {
		Customer c;
		String out = "";
		for(int i = 0 ; i < customers.size() ; i++) {
			c = customers.get(i);
			out += c + "\n\n";
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
	
	
	private static Dealer searchDealer(int id) {
		Dealer c;
		for(int i = 0 ; i < dealers.size() ; i++) {
			c = dealers.get(i);
			if(id == c.getId())
				return c;
		}
		return null;
	}
	
	
	private static Dealer deleteDealer(int id) {
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
	
	
	private static String displayDealer() {
		Dealer c;
		String out = "";
		for(int i = 0 ; i < dealers.size() ; i++) {
			c = dealers.get(i);
			out += c + "\n\n";
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

	
	private static Vehicle searchVehicle(int id) {
		Vehicle c;
		for(int i = 0 ; i < vehicles.size() ; i++) {
			c = vehicles.get(i);
			if(id == c.getId())
				return c;
		}
		return null;
	}
	
	
	private static Vehicle deletVehicle(int id) {
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
	
	
	private static String displayVehicle() {
		Vehicle c;
		String out = "";
		for(int i = 0 ; i < vehicles.size() ; i++) {
			c = vehicles.get(i);
			out += c + "\n\n";
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
