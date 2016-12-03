package br.com.abby.core.model;

import com.badlogic.gdx.math.Vector3;

public class Bone {

	String name;
	
	Vector3 origin;
	Vector3 destination;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vector3 getOrigin() {
		return origin;
	}

	public Vector3 getDestination() {
		return destination;
	}

	public void setOrigin(Vector3 origin) {
		this.origin = origin;
	}
	
	public void setDestination(Vector3 destination) {
		this.destination = destination;
	}

}
