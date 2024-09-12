package ir.freeland.springboot.model;

public class Publisher {

	
	private String name;
	private String date;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return name + ": " + date;
	}
}
