//package MainandSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

//import Comparators.CustomerComparatorById;
//import InheritanceClasses.Customer;
//import InheritanceClasses.Dealer;
//import OtherClasses.Vehicle;
//import OtherClasses.Wallet;

public class DealerSys {

	protected static LinkedHashMap<Dealer,ArrayList<Vehicle>> dealers = new LinkedHashMap<Dealer, ArrayList<Vehicle>>();
	protected static ArrayList<Customer> customers = new ArrayList<>();
	protected static ArrayList<Vehicle> vehicles = new ArrayList<>();
	private static final String SPLIT = "%";
	
	

	public static void readFromFile() {

		try {
		File myObj = new File("Customer.txt");
		Scanner myReader = new Scanner(myObj);
		while (myReader.hasNextLine()) {
			String[] data = myReader.nextLine().split(SPLIT);
			Wallet w = new Wallet(Double.parseDouble(data[5]), Double.parseDouble(data[6]));
			Customer c = new Customer(Integer.parseInt(data[0]), 
			data[1], data[2], data[3],
			 "customer", 
			 Integer.parseInt(data[4]), w , data[7], data[8], data[9]);
			customers.add(c);
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
				dateOfSale = findDateOfSale(Integer.parseInt(data[0]));
				Vehicle v = null;

				if(!dateOfSale.equals("")){
					v = new Vehicle(Integer.parseInt(data[0]), data[1],data[2], data[3], Integer.parseInt(data[4]),
										 Double.parseDouble(data[5]),  "on sale", "sold");
				} else{
					v = new Vehicle(Integer.parseInt(data[0]), data[1],data[2], data[3], Integer.parseInt(data[4]),
									Double.parseDouble(data[5]), "", "on sale");
				}
				vehicles.add(v);

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
			Dealer d = new Dealer(Integer.parseInt(data[0]), data[1], data[2], data[3], "dealer", data[4], data[5]);
			ArrayList<Vehicle> alAnkara = new ArrayList<>();
			ArrayList<Vehicle> alIstanbul = new ArrayList<>();
			ArrayList<Vehicle> alIzmir = new ArrayList<>();
			for(Vehicle v : vehicles) {
				if(v.getId() <= 699 && v.getId() > 600)
					alAnkara.add(v);
				if(v.getId() <= 3499 && v.getId() > 3400)
					alIstanbul.add(v);
				if(v.getId() <= 3599 && v.getId() > 3500)
					alIzmir.add(v);
			}
			if(d.getId() == 6)
				dealers.put(d,alAnkara);
			else if(d.getId() == 34)
				dealers.put(d, alIstanbul);
			else if(d.getId() == 35)
				dealers.put(d, alIzmir);
		}
		myReader.close();
		} catch (FileNotFoundException e) {
		System.out.println("An error occurred.");
		e.printStackTrace();
		}

	

	}
	
	public static String findDateOfSale(int id){
		String res = "";
		ArrayList<Integer> al = null;
		for(Customer c : customers) {
			al = c.getCarId();
			for(Integer ids : al) {
				if(ids == id)
					res += c.getsaleDate();
			}
		}
		return res;
	}

	public static String searchId(int id) {
		Customer c;
		for(int i = 0 ; i < customers.size() ; i++) {
			c = customers.get(i);
			if(id == c.getId())
				return "customer";
		}
		
		
		Set<Dealer> keyId = dealers.keySet();
		Dealer d;
		Iterator<Dealer> it = keyId.iterator();
		while(it.hasNext()) {
			d = it.next();
			if(id == d.getId())
				return "dealer";
		}
		
		return null;
	}
	
	
	public static void addMoneyToWallet(int customerId, String money) {
		double m = Double.parseDouble(money);
		Customer c = searchCustomer(customerId);
		c.getWallet().addMoney(m);
	}

	public static boolean checkCustomerId(int id) {
		Customer c;
		for(int i = 0 ; i < customers.size() ; i++) {
			c = customers.get(i);
			if(id == c.getId())
				return true;
		}
		return false;
	}
	
	public static String displayCustomersCar(int id) {
		String res = "";
		ArrayList<Integer> al = null;
		Customer c = searchCustomer(id);

		al = c.getCarId();
		for(Integer ids : al) 
			res += DealerSys.searchVehicle(ids).toString() + "\n\n"; 
		
		return res;
	}
	
	public static int addCustomer( String name, String phone, String address, String password, String walletMoney, String mail) {

		boolean flag = true;
		int id = (int)Math.floor(Math.random() * 35 + 100);
		Customer c = null;
		
		while(flag) {
			flag = false;
			for(int i = 0 ; i < customers.size() ; i++) {
				c = customers.get(i);
				if(c.getId() == id) {
					flag = true;
					id = (int)Math.floor(Math.random() * 35 + 100);
				}
			}
		}

		Customer newCustomer = new Customer(id,name,phone,address, "customer", password, Double.parseDouble(walletMoney), mail);
		customers.add(newCustomer);
		return id;
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
	
	
	public static String displayCustomersById() {
		TreeSet<Customer> ts = new TreeSet<Customer>(new CustomerComparatorById());
		
		ts.addAll(customers);
		String res = "";
		
		for(Customer c : ts) {
			res += c.toString() + "\n";
		}
		
		return res;
	}
	
	public static String displayCustomersByExpense() {
		TreeSet<Customer> ts = new TreeSet<Customer>();
		ts.addAll(customers);
		String res = "";
		for(Customer c : ts) {
			res += c.toString() + "\n";
		}
		return res;
	}
	
	public static String dipslayDealersCar(Dealer d) {
		String res = "";
		
		ArrayList<Vehicle> v = dealers.get(d);
		for(Vehicle c : v) {
			res += c.toString() + "\n";
		}

		return res;
	}
	
	public static String getCustomersMoney(int id) {
		Double money = 0.0;
		Customer c = searchCustomer(id);
		if(c != null) {
			money += c.getWallet().getMoney();
		}
		
		return money.toString();
	}
	

	public static void buyVehicleToCustomer(int customerId, int vehicleid) {
		
		// find vehicle and change status
		Vehicle v = searchVehicle(vehicleid);
		v.setSalesStatus("sold");
		
		
		// find the customer and add the car 
		Customer c = searchCustomer(customerId);
		c.getWallet().purchase(v.getPrice());
		c.setCarId(v.getId());
		
		
		// find the dealer who sale the cars
		// add its income
		ArrayList<Vehicle> vh = null;
		Set<Dealer>  keys= dealers.keySet();
		for(Dealer d : keys) {
				vh = dealers.get(d);
				for(Vehicle newvh : vh) {
					if(newvh.getId() == vehicleid) {
						v.setSalesStatus("sold");
						LocalDate date = LocalDate.now();
						v.setDateOfSale(date.toString());
						d.addToIncome(v.getPrice());
					}
				}
		}
	}	
	
	
	
		
	
	
	public static void changeAddress(Object c, String res) {
		if(c instanceof Customer)
			((Customer) c).setAddress(res);
		else
			((Dealer) c).setAddress(res);
	}
	
	public static boolean changePassword(Object c, String oldPass, String newPass) {
		
		if(c instanceof Customer) {
			if(oldPass.equals(((Customer) c).getPassword())) {
				((Customer) c).setPassword(newPass);
				return true;
			}
		} else if(c instanceof Dealer) {
			if(oldPass.equals(((Dealer) c).getPassword())) {
				((Dealer) c).setPassword(newPass);
				return true;
			}
		}
		
		return false;
	}
	
	public static void changePhoneNumber(Object c, String phone) {
		if(c instanceof Customer) {
			((Customer) c).setPhoneNum(phone);	
		} else if(c instanceof Dealer){
			((Dealer) c).setPhoneNum(phone);
		}
	}
	
	
	public static boolean checkDealerId(int id) {
		Set<Dealer> keyId = dealers.keySet();
		Iterator<Dealer> it = keyId.iterator();
		Dealer d;
		
		while(it.hasNext()) {
			d = it.next();
			if(id == d.getId())
				return true;
		}
		return false;
	}
	
	
	public static int addDealer(String name, String phone, String address, String password, String mail) {
		
		ArrayList<Vehicle> v = new ArrayList<>();
		int id = (int)Math.floor(Math.random() * 35 + 1);
		Set<Dealer> d = dealers.keySet();
		boolean flag = true;
		while(flag) {
			flag = false;
			for(Dealer c : d) {
				if(c.getId() == id) {
					flag = true;
					id = (int)Math.floor(Math.random() * (35 - 1 + 1) + 1);
				}
			}
			d = dealers.keySet();
		}
		
		Dealer newDealer = new Dealer(id,name,phone,address, "dealer", password, mail);
		dealers.put(newDealer, v);
		
		return id;
		
	}
	
	public static Dealer searchDealer(String s) {
		Set<Dealer> keyId = dealers.keySet();
		Iterator<Dealer> it = keyId.iterator();
		Dealer d;
		while(it.hasNext()) {
			d = it.next();
			if(Integer.parseInt(s) == d.getId())
			{
				return d;
			}
		}
		return null;
	}
	
	
	public static String displayDealer() {
		
		String out = "";
		Dealer d;
		Set<Dealer> keyId = dealers.keySet();
		Iterator<Dealer> it = keyId.iterator(); 
		while(it.hasNext()) {
			d = it.next();
			out += d.toString() + "\n\n";
		}

		return out;
	}
	
	public static String displayDealersRevenue(Dealer d) {
		Double revenue = d.getIncome();
		String out =  d.getNameSurname() + "\n" + "Your revenue = " + revenue.toString();
		return out;
	}
	
	public static String displayDealersCars(Dealer k) {
		String res = "";
		ArrayList<Vehicle> vh = null;
		Set<Dealer>  keys= dealers.keySet();
		for(Dealer d : keys) {
			if(d.getId() == k.getId()) {
				vh = dealers.get(d);
				for(Vehicle newvh : vh) {
					res += newvh.toString() + "\n";
				}
			}
		}
		return res;
	}
	
	public static boolean addDealersCar(Dealer d, String regNum, String brand, String model, int modelYear, double price) {
		
		// find new car id
		boolean flag = true;
		int id = (int)Math.floor(Math.random() * 3500 + 601);
		Vehicle c = null;
		
		while(flag) {
			flag = false;
			for(int i = 0 ; i < vehicles.size() ; i++) {
				c = vehicles.get(i);
				if(c.getId() == id) {
					flag = true;
					id = (int)Math.floor(Math.random()  * 3500 + 601);
				}
			}
		}
			
		Vehicle v = new Vehicle(id, regNum,brand,model,modelYear,price);
		
		Set<Dealer> keys= dealers.keySet();
		for(Dealer k : keys) {
			if(d.getId() == k.getId()) {
				ArrayList<Vehicle> vh = dealers.get(k);
				vh.add(v);
				
				//add to vehicle list
				vehicles.add(v);
				
				return true;
			}
		}

		return false;
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
	
	
	public static Vehicle searchVehicle(int id) {
		Vehicle c;
		for(int i = 0 ; i < vehicles.size() ; i++) {
			c = vehicles.get(i);
			if(id == c.getId())
				return c;
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
	
	
	public static String displayVehicleonSale() {
		Vehicle c;
		String out = "";
		for(int i = 0 ; i < vehicles.size() ; i++) {
			c = vehicles.get(i);
			if(c.getSalesStatus().equalsIgnoreCase("on sale"))
				out += c.toString() + "\n\n";
		}
		return out;
	}
	
	
	public static String[] getVehicleIdonSale() {
		Vehicle c;

		String[] out = new String[vehicles.size()];
		int k = 0;
		for(int i = 0 ; i < vehicles.size() ; i++) {
			c = vehicles.get(i);
			if(c.getSalesStatus().equalsIgnoreCase("on sale")) {
				out[k] = c.getId() + "";
				k++;
			}
		}
		return out;
	}
	
}
