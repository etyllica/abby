package br.com.abby.core.model.motion;

import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;

public class Transform {

	private static final Vector3 ORIGIN = new Vector3();
	
	public Quaternion q;
	public Vector3 translation = ORIGIN;
	
	public void apply(Vector3 position) {
		position.mul(q);
		if (translation != ORIGIN) {
			position.add(translation);
		}
	}
		
}
