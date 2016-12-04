package br.com.abby.core.model.motion;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.math.Matrix4;

public class KeyFrame {

	Map<Integer, Matrix4> boneTransforms = new HashMap<Integer, Matrix4>();
	
	public KeyFrame() {
		super();
	}
	
	public void addTransform(int boneIndex, Matrix4 transform) {
		boneTransforms.put(boneIndex, transform);
	}

	public Matrix4 getTransform(int boneIndex) {
		return boneTransforms.get(boneIndex);
	}

	public Map<Integer, Matrix4> getTransforms() {
		return boneTransforms;
	}
}
