package br.com.abby.linear;

import com.badlogic.gdx.math.Vector3;

/**
 * 
 * @author yuripourre
 * @license LGPLv3
 *
 */

public class Camera extends ColoredPoint3D {
	
	private Vector3 target;
	private Vector3 normal;
	
	public Camera(float x, float y, float z) {
		super(x, y, z);
		target = new Vector3(0,0,0);
		normal = new Vector3(0,1,0);
	}
	
	public Vector3 getTarget() {
		return target;
	}
		
	public void setTarget(Vector3 target) {
		this.target.set(target);
	}
		
	public void setTarget(float x, float y, float z) {
		target.set(x, y, z);
	}
		
	public Vector3 getNormal() {
		return normal;
	}

	public void setNormal(Vector3 normal) {
		this.normal = normal;
	}

	public double angleXY() {
		return angle(x, target.x, y, target.y);
	}
	
	public double angleXZ() {
		return angle(x, target.x, z, target.z);
	}
	
	public double angleYZ() {
		return angle(y, target.x, z, target.z);
	}
}
