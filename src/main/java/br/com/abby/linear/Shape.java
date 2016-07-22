package br.com.abby.linear;

import java.awt.Color;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;


public class Shape {
	
	//TODO Move to material
	protected Color color = Color.BLACK;
	
	public Vector3 position = new Vector3();
	public Matrix4 transform = new Matrix4();
		
	public Shape() {
		super();
	}
	
	public Shape(float x, float y, float z) {
		super();
		position.set(x, y, z);
	}

	public Vector3 getScale() {
		return transform.getScale(new Vector3());
	}

	public void setScale(float scale) {
		transform.scl(scale);
	}
	
	public void setScale(Vector3 scale) {
		transform.scl(scale);
	}
	
	public void rotateX(float angle) {
		transform.rotate(Vector3.X.mul(transform), angle);
	}
	
	public void rotateY(float angle) {
		transform.rotate(Vector3.Y.mul(transform), angle);
	}
	
	public void rotateZ(float angle) {
		transform.rotate(Vector3.Z.mul(transform), angle);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setPosition(float x, float y, float z) {
		this.position.set(x, y, z);
		transform.setToTranslation(position);
	}
	
	public void setX(float x) {
		this.position.x = x;
		transform.setToTranslation(position);
	}
	
	public float getX() {
		return position.x;
	}
	
	public void setY(float y) {
		this.position.y = y;
		transform.setToTranslation(position);
	}
	
	public float getY() {
		return position.y;
	}
	
	public void setZ(float z) {
		this.position.z = z;
		transform.setToTranslation(position);
	}
	
	public float getZ() {
		return position.z;
	}
	
	public void offsetX(float offsetX) {
		position.x += offsetX;
		transform.translate(offsetX, 0, 0);
	}
	
	public void offsetY(float offsetY) {
		position.y += offsetY;
		transform.translate(0, offsetY, 0);
	}
	
	public void offsetZ(float offsetZ) {
		position.z += offsetZ;
		transform.translate(0, 0, offsetZ);
	}
}
