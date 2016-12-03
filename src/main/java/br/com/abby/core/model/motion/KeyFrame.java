package br.com.abby.core.model.motion;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.math.Matrix4;

public class KeyFrame {

	Map<String, Matrix4> boneTransforms = new HashMap<String, Matrix4>();
	
	public KeyFrame() {
		super();
	}
	
	public void addTransform(String boneName, Matrix4 transform) {
		boneTransforms.put(boneName, transform);
	}

	public Matrix4 getTransform(String boneName) {
		return boneTransforms.get(boneName);
	}
}
