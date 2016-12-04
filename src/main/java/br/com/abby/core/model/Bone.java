package br.com.abby.core.model;

import java.util.ArrayList;
import java.util.List;

public class Bone {

	String name;
	
	Joint origin;
	Joint destination;
	
	List<Bone> children = new ArrayList<Bone>();
	
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

	public void addBone(Bone bone) {
		children.add(bone);
	}
	
	public List<Bone> getChildren() {
		return children;
	}

}
