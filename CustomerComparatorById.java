//package Comparators;

//import InheritanceClasses.Customer;
import java.util.Comparator;


public class CustomerComparatorById implements Comparator<Customer> {

	@Override
	public int compare(Customer o1, Customer o2) { 
		// customers according to their id's in ascending order 
		return o1.getId() - o2.getId();
	}
	

}
