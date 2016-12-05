package br.com.abby.core.model;


public class Bone {

	String name;
	
	Joint origin;
	Joint destination;
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Joint getOrigin() {
		return origin;
	}

	public Joint getDestination() {
		return destination;
	}
	
	public void setOrigin(Joint origin) {
		this.origin = origin;
	}
	
	public void setDestination(Joint destination) {
		this.destination = destination;
	}

}