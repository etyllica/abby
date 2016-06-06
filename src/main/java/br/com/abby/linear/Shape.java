package br.com.abby.linear;

import java.awt.Color;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;


public class Shape {

	//TODO Move to material
	protected Color color = Color.BLACK;
	
	public Matrix4 transform = new Matrix4();
	
	public Vector3 position() {
		return transform.getTranslation(new Vector3());
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

	public void setX(float x) {
		Vector3 position = transform.getTranslation(new Vector3());
		transform.setToTranslation(x, position.y, position.z);
	}
	
	public float getX() {
		Vector3 position = transform.getTranslation(new Vector3());
		return position.x;
	}
	
	public void setY(float y) {
		Vector3 position = transform.getTranslation(new Vector3());
		transform.setToTranslation(position.x, y, position.z);
	}
	
	public float getY() {
		Vector3 position = transform.getTranslation(new Vector3());
		return position.y;
	}
	
	public void setZ(float z) {
		Vector3 position = transform.getTranslation(new Vector3());
		transform.setToTranslation(position.x, position.y, z);
	}
	
	public float getZ() {
		Vector3 position = transform.getTranslation(new Vector3());
		return position.z;
	}
	
	public void offsetX(float offsetX) {
		transform.translate(offsetX, 0, 0);
	}
	
	public void offsetY(float offsetY) {
		transform.translate(0, offsetY, 0);
	}
	
	public void offsetZ(float offsetZ) {
		transform.translate(0, 0, offsetZ);
	}
}
