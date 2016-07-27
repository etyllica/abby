package br.com.abby.linear;

import java.awt.Color;

import com.badlogic.gdx.math.Vector3;

/**
 * 
 * @author yuripourre
 * @license LGPLv3
 *
 */

public class Camera extends Shape {
	
	private Vector3 target;
	private Vector3 normal;
	
	private Color color = Color.BLACK;
	
	public Camera(float x, float y, float z) {
		super(x, y, z);
		target = new Vector3(0, 0, 0);
		normal = new Vector3(0, 1, 0);
	}
	
	public Camera(Vector3 origin) {
		this(origin.x, origin.y, origin.z);
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
		return angle(position.x, target.x, position.y, target.y);
	}
	
	public double angleXZ() {
		return angle(position.x, target.x, position.z, target.z);
	}
	
	public double angleYZ() {
		return angle(position.y, target.x, position.z, target.z);
	}
	
	protected double angle(double x, double px, double y, double py) {

		double deltaX = px - x;
		double deltaY = py - y;

		double angleInDegrees = Math.atan2(deltaY, deltaX) * 180 / Math.PI;

		return angleInDegrees;		
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
