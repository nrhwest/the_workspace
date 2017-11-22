/**
 * Nate West
 * CSMC 256 - Project 4
 * Priority Request Processing
 * Purpose: The class models a Request for the Clerk to handle
 * Description: The Request class has all the properties of a Request
 * 				so we can create Request objects from the input file.
 * Input: A text file with Requests
 * Output: Times requests finish processing
 */

public class Request implements Comparable<Request> {
	
	private int id, entryTime, processingTime, priority, doneTime, inputTime, outputTime;
	private String description;
	
	public Request() {
		id = 0;
		entryTime = 0;
		processingTime = 0;
		priority = 0;
		description = " ";
	}
	public Request(int idNum, int pt, int et, int prt, String desc) {
		id = idNum;
		entryTime = et;
		processingTime = pt;
		priority = prt;
		description = desc;
	}
	
	// sets ID number of the Request
	public void setID(int idNum) {
		id = idNum; 
	}
	
	// sets entryTime of the Request
	public void setET(int et) {
		if (et < 0)
			throw new IllegalArgumentException();
		entryTime = et;
	}
	
	// sets processingTime of the Request
	public void setPT(int pt) {
		if (pt < 0)
			throw new IllegalArgumentException();
		processingTime = pt;
	}

	// sets priority of the Request
	public void setPriority(int prt) {
		if (prt <= 0 || prt >= 5)
			throw new IllegalArgumentException();
		priority = prt;
	}
	
	// sets inputTime of the Request
	public void setInputTime(int inTime) {
		inputTime = inTime;
	}
	
	// sets outputTime of the Request
	public void setOutputTime(int outTime) {
		outputTime = outTime;
	}
	
	// sets doneTime of the Request
	public void setDoneTime(int done) {
		doneTime = done;
	}
	
	// sets description of the Request
	public void setDescription(String desc) {
		description = desc;
	}
	
	// returns the object's ID number
	public int getID() {
		return id;
	}
	
	// returns the object's entryTime
	public int getET() {
		return entryTime;
	}
	
	// returns the object's processingTime
	public int getPT() {
		return processingTime;
	}
	
	// returns the object's priority
	public int getPriority() {
		return priority;
	}
	
	// returns the objects description
	public String getDescription() {
		return description;
	}
	
	// returns the objects doneTime
	public int getDoneTime() {
		return doneTime;
	}
	
	// returns the objects inputTime from the Queue
	public int getInputTime() {
		return inputTime;
	}
	
	// returns the objects outputTime from the Queue
	public int getOutputTime() {
		return outputTime;
	}
	
	// equals method
	public boolean equals(Request obj) {
		if (this == obj) 
			return true;
		if (this == null)
			return false;
		if (obj instanceof Request) {
			Request alt = (Request) obj;
			if (id == alt.getID()) {
				if (entryTime == alt.getET()) {
					if (processingTime == alt.getPT()) {
						if (priority == alt.getPriority())
							return true;
					}
				}
			}
		}
		return false;
	}
	
	public String idToString() {
		return "Request #" + id;
	}
	
	@Override
	public String toString() {
		return "Request [id=" + id + ", processingTime=" + processingTime + ", entryTime=" + entryTime + ", priority="
				+ priority + ", description=" + description + "]";
	}

	@Override
	public int compareTo(Request obj) {
		if (priority > obj.getPriority()) 
			return -1;
		else if (priority < obj.getPriority())
			return 1;
		else 
			return 0;
	}
	
}