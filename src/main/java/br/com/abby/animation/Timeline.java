package br.com.abby.animation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import br.com.etyllica.core.interpolation.Interpolator;

public class Timeline<T> {

	public static final int UNKNOWN = -1;
	private long keyFrameCount = 0;
	private int count = 0;
	
	Map<Integer, T> ids = new HashMap<Integer, T>();
	Map<Integer, Map<Integer, KeyFrame>> actorFrames = new HashMap<Integer, Map<Integer, KeyFrame>>();
	Map<Long, Interpolator> interpolators = new HashMap<Long, Interpolator>();
	
	public int addActor(int index, T actor) {
		if(ids.containsKey(index)) {
			return UNKNOWN;
		}
		ids.put(index, actor);
		actorFrames.put(index, new HashMap<Integer, KeyFrame>());
		return index;
	}
		
	public Map<Integer, KeyFrame> addKeyFrame(Integer id, int time, KeyFrame keyFrame) {
		Map<Integer, KeyFrame> frames = getKeyFrames(id);
		frames.put(time, keyFrame);
		
		return frames;
	}
	
	public Map<Integer, KeyFrame> addKeyFrame(int id, int time, KeyFrame keyFrame, Interpolator interpolator) {
		Map<Integer, KeyFrame> frames = addKeyFrame(id, time, keyFrame);
		addInterpolation(keyFrame.getId(), interpolator);
		
		return frames;
	}
	
	public void addInterpolation(long id, Interpolator interpolation) {
		interpolators.put(id, interpolation);
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

	public void removeActor(int index) {
		Map<Integer, KeyFrame> frames = getKeyFrames(index);
		
		for(KeyFrame frame:frames.values()) {
			long id = frame.getId();
			if (interpolators.containsKey(id)) {
				interpolators.remove(id);
			}
		}
		
		actorFrames.remove(index);
		ids.remove(index);
	}

	public int addActor(T actor) {
		int id = count++;
		return addActor(id, actor);
	}

	public long generateKeyFrameId() {
		return keyFrameCount++;
	}
	
}
