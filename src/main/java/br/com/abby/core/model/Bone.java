package br.com.abby.core.model;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;

public class Bone {

	String name;
	
	Joint origin;
	Joint destination;
	Vector3 offset = new Vector3();
	
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
	
	public Vector3 getOffset() {
		return offset;
	}

	public void setOrigin(Joint origin) {
		this.origin = origin;
	}
	
	public void setDestination(Joint destination) {
		this.destination = destination;
		offset.set(destination.offset);
	}

	public void addBone(Bone bone) {
		children.add(bone);
	}
	
	public List<Bone> getChildren() {
		return children;
	}

	public void rotate(Bone bone, Matrix4 t) {
		offset.set(destination.getOffset());
		offset.sub(bone.getOrigin().getOffset());
		offset.mul(t);
		offset.add(bone.getOrigin().getOffset());
		
		for(Bone child:children) {
			child.rotate(bone, t);
		}
	}

}