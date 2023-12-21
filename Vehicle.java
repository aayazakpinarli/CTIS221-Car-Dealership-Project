
public class Vehicle {
		
	private int id;
	private String registrationNumber;
	private String brand;
	private String model;
	private int modelYear;
	private double price;
	private String dateOfSale;
	private String salesStatus;
	
	// first command

	public Vehicle() {
		
	}

	public Vehicle(int id, String registrationNumber, double price) {
		this.id = id;
		this.registrationNumber = registrationNumber;
		this.price = price;
	}

	public Vehicle(int id, String registrationNumber, String brand, 
			String model, int modelYear, double price) {
		
		this.id = id;
		this.registrationNumber = registrationNumber;
		this.brand = brand;
		this.model = model;
		this.modelYear = modelYear;
		this.price = price;
	}

	public Vehicle(int id, String registrationNumber, String brand, 
		String model, int modelYear, double price, String dateOfSale, String salesStatus) {

		this.id = id;
		this.registrationNumber = registrationNumber;
		this.brand = brand;
		this.model = model;
		this.modelYear = modelYear;
		this.price = price;
		this.dateOfSale = dateOfSale;
		this.salesStatus = salesStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getModelYear() {
		return modelYear;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDateOfSale() {
		return dateOfSale;
	}

	public void setDateOfSale(String dateOfSale) {
		this.dateOfSale = dateOfSale;
	}

	public String getSalesStatus() {
		return salesStatus;
	}

	public void setSalesStatus(String salesStatus) {
		this.salesStatus = salesStatus;
	}

	@Override
	public String toString() {
		if(dateOfSale.equals(""))
			return  "Vehicle Id = " + id +
					"\nRegistration Number = " + registrationNumber + 
					"\nBrand = " + brand + 
					"\nModel = " + model + 
					"\nModelYear = " + modelYear + 
					"\nPrice = " + price + 
					"\nSales Status = " + salesStatus + "\n";
		else
			return  "Vehicle Id = " + id +
					"\nRegistration Number = " + registrationNumber + 
					"\nBrand = " + brand + 
					"\nModel = " + model + 
					"\nModelYear = " + modelYear + 
					"\nPrice = " + price + 
					"\nDate Of Sale = "	+ dateOfSale + 
					"\nSales Status = " + salesStatus + "\n";
	}

	
}
