package br.com.abby.core.model.motion;

import java.util.HashMap;
import java.util.Map;

import br.com.abby.core.model.Armature;

public class Motion {

	int frames;
	float frameTime;
	
	Armature armature;
	
	Map<Integer, KeyFrame> keyFrames = new HashMap<Integer, KeyFrame>();
	
	public Motion() {
		super();
	}
	
	public int getFrames() {
		return frames;
	}
	
	public void setFrames(int frames) {
		this.frames = frames;
	}
	
	public float getFrameTime() {
		return frameTime;
	}
	
	public void setFrameTime(float frameTime) {
		this.frameTime = frameTime;
	}

	public Armature getArmature() {
		return armature;
	}
	
	public void setArmature(Armature armature) {
		this.armature = armature;
	}

	public Map<Integer, KeyFrame> getKeyFrames() {
		return keyFrames;
	}

	public void setKeyFrames(Map<Integer, KeyFrame> keyFrames) {
		this.keyFrames = keyFrames;
	}

}
