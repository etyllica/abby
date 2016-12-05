package br.com.abby.core.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Armature {

	Joint root;
	List<Bone> bones = new ArrayList<Bone>();
	List<Joint> joints = new ArrayList<Joint>();
	
	Map<String, Integer> jointIndex = new HashMap<String, Integer>();
	
	public Armature() {
		super();
	}

	public Joint getRoot() {
		return root;
	}

	public void setRoot(Joint root) {
		this.root = root;
	}

	public void addBone(Bone bone) {
		bones.add(bone);
	}
	
	public List<Bone> getBones() {
		return bones;
	}

	public void addJoint(Joint joint) {
		jointIndex.put(joint.name, joints.size());
		joints.add(joint);
	}
	
	public List<Joint> getJoints() {
		return joints;
	}

	public int getIndex(Joint child) {
		return jointIndex.get(child.name);
	}
	
}
