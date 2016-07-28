package br.com.abby.animation;

import java.util.HashMap;
import java.util.Map;

import examples.etyllica.interpolation.Interpolation;

public class Timeline<T> {

	Map<T, Map<Integer, KeyFrame>> actorFrames = new HashMap<T, Map<Integer, KeyFrame>>();
	Map<KeyFrame, Interpolation> interpolations = new HashMap<KeyFrame, Interpolation>();
		
	public void addActor(T actor) {
		actorFrames.put(actor, new HashMap<Integer, KeyFrame>());
	}
	
	public Map<Integer, KeyFrame> addKeyFrame(T actor, int time, KeyFrame keyFrame) {
		Map<Integer, KeyFrame> frames = getKeyFrames(actor);
		frames.put(time, keyFrame);
		
		return frames;
	}
	
	public Map<Integer, KeyFrame> addKeyFrame(T actor, int time, KeyFrame keyFrame, Interpolation interpolation) {
		Map<Integer, KeyFrame> frames = addKeyFrame(actor, time, keyFrame);
		setInterpolation(keyFrame, interpolation);
		
		return frames;
	}
	
	public void setInterpolation(KeyFrame keyFrame, Interpolation interpolation) {
		interpolations.put(keyFrame, interpolation);
	}
	
	public Map<Integer, KeyFrame> getKeyFrames(T actor) {
		return actorFrames.get(actor);
	}
	
}
