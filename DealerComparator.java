//package Comparators;

import java.util.Comparator;

//import InheritanceClasses.Dealer;

public class DealerComparator implements Comparator<Dealer>{

	@Override
	public int compare(Dealer o1, Dealer o2) {
		// TODO Auto-generated method stub
		return (int) (o1.getIncome() - o2.getIncome());
	}

	
}
