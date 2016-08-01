package br.com.abby.animation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import examples.etyllica.interpolation.Interpolation;

public class Timeline<T> {

	private int count = 0;
	
	Map<Integer, T> ids = new HashMap<Integer, T>();
	Map<Integer, Map<Integer, KeyFrame>> actorFrames = new HashMap<Integer, Map<Integer, KeyFrame>>();
	Map<KeyFrame, Interpolation> interpolations = new HashMap<KeyFrame, Interpolation>();
		
	public int addActor(T actor) {
		int id = count++;
		ids.put(id, actor);
		actorFrames.put(id, new HashMap<Integer, KeyFrame>());
		return id;
	}
	
	public Map<Integer, KeyFrame> addKeyFrame(Integer id, int time, KeyFrame keyFrame) {
		Map<Integer, KeyFrame> frames = getKeyFrames(id);
		frames.put(time, keyFrame);
		
		return frames;
	}
	
	public Map<Integer, KeyFrame> addKeyFrame(int id, int time, KeyFrame keyFrame, Interpolation interpolation) {
		Map<Integer, KeyFrame> frames = addKeyFrame(id, time, keyFrame);
		setInterpolation(keyFrame, interpolation);
		
		return frames;
	}
	
	public void setInterpolation(KeyFrame keyFrame, Interpolation interpolation) {
		interpolations.put(keyFrame, interpolation);
	}
	
	public Map<Integer, KeyFrame> getKeyFrames(T actor) {
		for(Map.Entry<Integer, T> entry: ids.entrySet()) {
			if(entry.getValue().equals(actor)) {
				return getKeyFrames(entry.getKey());		
			}
		}
		return null;
	}
	
	public Map<Integer, KeyFrame> getKeyFrames(int id) {
		return actorFrames.get(id);
	}

	public Collection<T> getActors() {
		return ids.values();
	}

	public Set<Integer> getIds() {
		return ids.keySet();
	}
	
}
