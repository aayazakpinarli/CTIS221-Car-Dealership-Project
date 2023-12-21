//package MainandSystem;

public class DealershipMain {

	public static void main(String[] args) {
		
        DealerSys.readFromFile();
        System.out.println(DealerSys.displayCustomersByExpense());
        System.out.println(DealerSys.displayDealer());
        System.out.println(DealerSys.displayVehicle());

    }
}