package br.com.abby.core.model;

import com.badlogic.gdx.math.Vector3;

public class Joint {
	
	String name;
	Vector3 offset;
	
	public Joint(String name, Vector3 offset) {
		super();
		this.name = name;
		this.offset = offset;
	}
	
	public String getName() {
		return name;
	}
	
	public Vector3 getOffset() {
		return offset;
	}
	
}
