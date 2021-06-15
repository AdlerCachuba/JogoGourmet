package model;


public class Dish {
	
	private String name;
	private Dish accept;
	private Dish notAccept;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Dish getAccept() {
		return accept;
	}
	public void setAccept(Dish accept) {
		this.accept = accept;
	}
	public Dish getNotAccept() {
		return notAccept;
	}
	public void setNotAccept(Dish notAccept) {
		this.notAccept = notAccept;
	}
	
}
