public class DealershipMain {

	public static void main(String[] args) {
		
        //System.out.println("hello");
        DealerSys.readFromFile();
        System.out.println(DealerSys.displayCustomers());
        System.out.println(DealerSys.displayDealer());
        System.out.println(DealerSys.displayVehicle());

    }
}