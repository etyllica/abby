package br.com.abby.core.model.motion;

import java.util.HashMap;
import java.util.Map;

public class KeyFrame {

	Map<Integer, Transform> boneTransforms = new HashMap<Integer, Transform>();
	
	public KeyFrame() {
		super();
	}
	
	public void addTransform(int boneIndex, Transform transform) {
		boneTransforms.put(boneIndex, transform);
	}

	public Transform getTransform(int boneIndex) {
		return boneTransforms.get(boneIndex);
	}

	public Map<Integer, Transform> getTransforms() {
		return boneTransforms;
	}
}
