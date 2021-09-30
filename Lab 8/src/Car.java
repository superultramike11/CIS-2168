public class Car {
	private String make, model;
	private int year;
	private double MPG, milesDriven, fuelCapacity, fuelRemaining;
	
	//				   Ford			   Pinto         1972          17.5 MPG        132480 miles             12 gallons              8 gallons
	public Car(String getMake, String getModel, int getYear, double getMPG, double getMilesDriven, double getFuelCapacity, double getFuelRemaining) {
		make = getMake; // Ford
		model = getModel; // Pinto
		year = getYear; // 1982
		MPG = getMPG; // 17.5
		milesDriven = getMilesDriven; // 132480
		fuelCapacity = getFuelCapacity; // 12
		fuelRemaining = getFuelRemaining; // 8
	}
	
	/* 
		which simulates driving m miles in the car, adding to the total number of miles driven, 
		and reducing the amount of gas in the car according to this car's average MPG. 
	*/
	public double drive(double m) {
		milesDriven += m;
		fuelRemaining = fuelRemaining - ((1/MPG)*m); // computes fuelRemaining of 7.714285...
		return milesDriven;
	}
	
	// add up to g gallons of gas to the fuel tank, but not more than the car's fuel capacity
	public double fillTank(double g) {
		fuelRemaining += g;
		if(fuelRemaining > fuelCapacity) {
			System.out.println("You are adding too much gas");
		}
		return 0.0;
	}
	
	// returns a string representation of the car
	public String toString() { // CHANGE ARGUMENTS
		StringBuilder outputStr = new StringBuilder();
		
		outputStr.append("\nMake: ").append(make)
				 .append("\nModel: ").append(model)
				 .append("\nYear: ").append(year)
				 .append("\nMPG: ").append(MPG)
				 .append("\nMiles Driven: ").append(milesDriven)
				 .append("\nFuel Capacity: ").append(fuelCapacity)
				 .append("\nFuel Remaining: ").append(fuelRemaining);
		return outputStr.toString();
	}
	
	// returns the amount of fuel left in the tank.
	public double getFuelRemaining() {
		return fuelRemaining;
	}
	
	public static void main(String[] args) {
		Car oldJunker = new Car("Ford", "Pinto", 1972, 17.5, 132480, 12, 8); // creates a new Car object
	    oldJunker.drive(5); // drives the Car 5 miles
	    oldJunker.fillTank(1); // put in a gallon of gas
	    System.out.print("Fuel Remaining: " + oldJunker.getFuelRemaining()); // prints the amount of fuel left
	    System.out.println(oldJunker); // prints the attributes of the car to the screen
	}

}
