/**
 * Nathan West
 * CMSC 255
 * Project 6
 * Bicycle Class 
 * 
 * This class models the attributes of a Bicycle
 */

public class Bicycle {

	 private String color, brand;
	 private int wheelSize, weight, numGears;
	 private BikeType type;
	 private UserType user;
	 private FrameMaterial frame;
	 private BrakeType brakes;
	 private Condition condition;
	 
	 // type of bike it is
	 public enum BikeType { Road, Mountain, Hybrid, Cruiser }
		
	 // who the bike is made for
	public enum UserType { Men, Women, Boys, Girls }
	
	// the frame materials the bike have	
	public enum FrameMaterial {	Steel, Carbon, Aluminum }
		
	// type of brakes the bike can have
	public enum BrakeType {	Caliper, Cantilever, LinearPull, Disc }
		
	// conditions of the bike
	public enum Condition {	New, Used }
	
	// default Bicycle constructor w/ initialized ins variables
	public Bicycle() {
		type = BikeType.Road;
		user = UserType.Men;
		frame = FrameMaterial.Steel;
		brakes = BrakeType.Caliper;
		condition = condition.New;
		weight = 0;
		wheelSize = 0;
		numGears = 0;
		brand = "unknown";
		color = "unknown";
	}
	
	// parameterized Bicycle constructor setting ins variables
	 public Bicycle(BikeType type, UserType user, FrameMaterial frame, BrakeType brakes, Condition condition, 
			 int wheelSize, int weight, int numGears, String brand, String color) {		 
		setType(type);
		setUser(user);
		setFrame(frame);
		setBrakes(brakes);
		setCondition(condition);
		setWheelSize(wheelSize);
		setWeight(weight);
		setNumGears(numGears);
		setBrand(brand);
		setColor(color);	
	 }

	 // returns brakes of Bicycle
	 public BrakeType getBrakes() {
		 return brakes;
	 }
	 
	 // sets brakes of Bicycle
	public void setBrakes(BrakeType brakes) {
		this.brakes = brakes;
	}
	
	// returns bikeType of Bicycle
	public BikeType getType() {
		return type;
	}
	
	 // sets bikeType of Bicycle
	public void setType(BikeType type) {
		this.type = type;
	}

	// returns frame of Bicycle
	public FrameMaterial getFrame() {
		return frame;
	}
	
	 // sets frameMaterial of Bicycle
	public void setFrame(FrameMaterial frame) {
		this.frame = frame;
	}
	
	// returns userType of Bicycle
	public UserType getUser() {
		return user;
	}
	
	 // sets userType of Bicycle
	public void setUser(UserType user){
		this.user = user;
	}
	
	// returns condition of Bicycle
	public Condition getCondition() {
		return condition;
	}
	
	 // sets condition of Bicycle
	public void setCondition(Bicycle.Condition condition) {
		this.condition = condition;
	}
	
	 // returns color of Bicycle
	public String getColor() {
		return color;
	}
	
	 // sets color of Bicycles
	public void setColor(String color) {
		this.color = color;
	}
	
	 // returns brand of Bicycle
	public String getBrand() {
		return brand;
	}
	
	 // sets brand of Bicycle
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	 // returns numGears of Bicycle
	public int getNumGears() {
		return numGears;
	}
	
	 // sets number of gears to Bicycle
	public void setNumGears(int numGears) {
		if (numGears <= 0)
			throw new IllegalArgumentException("Please enter a valid number of gears");
		this.numGears = numGears;
	}
	
	 // returns weight of Bicycle
	public int getWeight() {
		return weight;
	}

	 // sets weight of Bicycle
	public void setWeight(int weight) {
		if (weight <= 0) 
			throw new IllegalArgumentException("Please enter a valid weight");
		this.weight = weight;
	}
	
	 // returns wheelSize of Bicycle
	public int getWheelSize() {
		return wheelSize;
	}
	
	 // sets wheelSize of Bicycle
	public void setWheelSize(int wheelSize) {
		if(wheelSize == 10 || wheelSize == 12 || wheelSize == 14 || wheelSize == 16 || wheelSize == 18
				|| wheelSize == 20 || wheelSize == 24 || wheelSize == 26 || wheelSize == 29) {
			this.wheelSize = wheelSize;
		} else throw new IllegalArgumentException("Please enter a valid wheel size");
	}	
	
	 // converts properties of Bicycle to String for output
	 public String toString() {
		 String output = "Bicycle {" + "type=" + type.toString() + ", user=" + user.toString() + ", frame=" + frame.toString() + ", \n "
				 + "brakes=" + brakes.toString() + ", condition=" + condition.toString() + ", wheelSize=" + wheelSize + ", \n"
				 + "weight=" + weight + ", numGears=" + numGears + ", brand=" + brand + ", color=" + color + "}";
		 return output;
	 }
}
