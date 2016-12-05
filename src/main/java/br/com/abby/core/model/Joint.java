package br.com.abby.core.model;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;

public class Joint {
	
	String name;
	Vector3 position;
	
	List<Bone> children = new ArrayList<Bone>();
	
	public Joint(String name, Vector3 position) {
		super();
		this.name = name;
		this.position = position;
	}
	
	public String getName() {
		return name;
	}
	
	public Vector3 getPosition() {
		return position;
	}
	
	public void addBone(Bone bone) {
		children.add(bone);
	}
	
	public List<Bone> getChildren() {
		return children;
	}

	public void rotate(Bone bone, Matrix4 t) {
		position.set(bone.getDestination().getPosition());
		position.sub(bone.getOrigin().getPosition());
		position.mul(t);
		position.add(bone.getOrigin().getPosition());
		
		for(Bone child:children) {
			child.getDestination().rotate(bone, t);
		}
	}
}
