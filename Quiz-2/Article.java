package ir.freeland.springboot.model;



public class Article {
	private String name;
	private String description;
	private Publisher publisher;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	@Override
	public String toString() {

		return name + ", " + description + ", " + publisher.toString();
	}

}
