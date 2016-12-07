package br.com.abby.core.model.motion;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.math.Vector3;

import br.com.abby.core.model.Armature;
import br.com.abby.core.model.Joint;

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
	
	public void animate(int currentFrame) {
		resetAnimation();
		
		KeyFrame frame = keyFrames.get(currentFrame);
		
		int index = 0;
		
		for (int i = armature.getJoints().size()-1; i >= 0; i--) {
			Joint joint = armature.getJoints().get(i);

			if (joint.getChildren().size() == 0) {
				continue;
			}
			
			index = armature.getIndex(joint);

			Transform t = frame.getTransform(index);
			
			for (Joint child : joint.getChildren()) {
				rotateJoint(child, joint, t);
			}
			
			//Apply Transformation to Vertices
			//Matrix4 t2 = new Matrix4(t);
			//float weight = 1;
			//t2.scl(weight);
			//for (each associated vertex v)
			//Vector3 p = new Vector3(v);
			//p.sub(bone.getOrigin());
			//t2.transform(P);
			//p.add(bone.getOrigin());
		}
	}
	
	/**
	 * Set the armature to the base pose
	 */
	private void resetAnimation() {
		Joint root = armature.getRoot();
		
		Vector3 origin = new Vector3();
		root.reset(origin);
	}
	
	private void rotateJoint(Joint joint, Joint anchor, Transform t) {
		joint.getPosition().sub(anchor.getPosition());
		t.apply(joint.getPosition());
		joint.getPosition().add(anchor.getPosition());
		
		for (Joint child : joint.getChildren()) {
			rotateJoint(child, anchor, t);
		}
	}
	
	public void rotate(Joint joint, Joint anchor, Transform t) {
		joint.getPosition().sub(anchor.getPosition());
		t.apply(joint.getPosition());
		joint.getPosition().add(anchor.getPosition());
	}

}
