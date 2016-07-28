package br.com.abby.animation;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;

public class KeyFrame {

	float positionX = 0;
	float positionY = 0;
	float positionZ = 0;
	
	float scaleX = 1;
	float scaleY = 1;
	float scaleZ = 1;
	
	Quaternion rotation;
	
	public KeyFrame() {
		super();
		
		rotation = new Quaternion();
	}
	
	public KeyFrame(Matrix4 transform) {
		super();
		
		Vector3 position = transform.getTranslation(new Vector3());
		positionX = position.x;
		positionY = position.y;
		positionZ = position.z;
		
		scaleX = transform.getScaleX();
		scaleY = transform.getScaleX();
		scaleZ = transform.getScaleX();
		
		rotation = transform.getRotation(new Quaternion());
	}

	public float getPositionX() {
		return positionX;
	}

	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}

	public float getPositionY() {
		return positionY;
	}

	public void setPositionY(float positionY) {
		this.positionY = positionY;
	}

	public float getPositionZ() {
		return positionZ;
	}

	public void setPositionZ(float positionZ) {
		this.positionZ = positionZ;
	}

	public float getScaleX() {
		return scaleX;
	}

	public void setScaleX(float scaleX) {
		this.scaleX = scaleX;
	}

	public float getScaleY() {
		return scaleY;
	}

	public void setScaleY(float scaleY) {
		this.scaleY = scaleY;
	}

	public float getScaleZ() {
		return scaleZ;
	}

	public void setScaleZ(float scaleZ) {
		this.scaleZ = scaleZ;
	}

	public Quaternion getRotation() {
		return rotation;
	}

	public void setRotation(Quaternion rotation) {
		this.rotation = rotation;
	}
	
}
