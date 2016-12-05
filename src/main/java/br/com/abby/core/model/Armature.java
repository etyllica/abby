package br.com.abby.core.model;

import java.util.ArrayList;
import java.util.List;

public class Armature {

	Joint root;
	List<Bone> bones = new ArrayList<Bone>();
	
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
	
}
