package br.com.abby.core.model;

import java.util.ArrayList;
import java.util.List;

import br.com.abby.core.model.motion.Transform;

import com.badlogic.gdx.math.Vector3;

public class Joint {
	
	String name;
	Vector3 position;
	Vector3 originalOffset;
	
	Joint parent;
	
	List<Joint> children = new ArrayList<Joint>();
	
	public Joint(String name, Vector3 position, Vector3 offset) {
		super();
		this.name = name;
		this.position = position;
		this.originalOffset = offset;
	}
	
	public String getName() {
		return name;
	}
	
	public Vector3 getPosition() {
		return position;
	}
	
	public void addJoint(Joint joint) {
		children.add(joint);
		joint.parent = this;
	}
	
	public List<Joint> getChildren() {
		return children;
	}

	public void rotate(Joint anchor, Transform t) {
		position.sub(anchor.position);
		t.apply(position);
		position.add(anchor.position);
		
		for (Joint child : children) {
			child.rotate(anchor, t);
		}
	}

	public void reset(Vector3 origin) {
		position.set(originalOffset);
		position.add(origin);
		for (Joint child :children) {
			child.reset(position);	
		}
	}
}
