package br.com.abby.core.loader.motion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;

import br.com.abby.core.model.Armature;
import br.com.abby.core.model.Bone;
import br.com.abby.core.model.Joint;
import br.com.abby.core.model.motion.KeyFrame;
import br.com.abby.core.model.motion.Motion;

public class BVHLoader implements MotionLoader {

	private static final String TAG_HIERARCHY = "HIERARCHY";
	private static final String TAG_ROOT = "ROOT";
	private static final String TAG_OFFSET = "OFFSET";
	private static final String TAG_JOINT = "JOINT";
	private static final String TAG_CHANNELS = "CHANNELS";
	private static final String TAG_END_SITE = "End Site";
	
	private static final String TAG_MOTION = "MOTION";
	private static final String TAG_FRAMES = "Frames:";
	private static final String TAG_FRAME_TIME = "Frame Time:";
	private static final String TAG_KEYFRAME = "KEYFRAME";

	private static final String CHANNEL_X_POSITION = "Xposition";
	private static final String CHANNEL_Y_POSITION = "Yposition";
	private static final String CHANNEL_Z_POSITION = "Zposition";
	private static final String CHANNEL_X_ROTATION = "Xrotation";
	private static final String CHANNEL_Y_ROTATION = "Yrotation";
	private static final String CHANNEL_Z_ROTATION = "Zrotation";
	private static final String SUFFIX_END = "End";
	
	class BVHJoint {
		
		BVHJoint parent;
		String name;
		Vector3 offset;
		
		float xPosition = 0;
		float yPosition = 0;
		float zPosition = 0;
		float xRotation = 0;
		float yRotation = 0;
		float zRotation = 0;

		//Channel Indexes
		Map<Integer, String> channels;

		public BVHJoint(String name) {
			super();
			this.name = name;
		}

		public BVHJoint(String name, BVHJoint parent) {
			super();
			this.name = name;
			this.parent = parent;
		}

		public void setParent(BVHJoint parent) {
			this.parent = parent;
		}

		public boolean equals(BVHJoint otherJoint) {
			return xPosition == otherJoint.xPosition &&
				   yPosition == otherJoint.yPosition &&
				   zPosition == otherJoint.zPosition &&
				   xRotation == otherJoint.xRotation &&
				   yRotation == otherJoint.yRotation &&
				   zRotation == otherJoint.zRotation;
		}
		
	}

	public Motion loadMotion(URL url, String path) throws FileNotFoundException, IOException {

		Motion motion = new Motion();

		List<BVHJoint> joints = new ArrayList<BVHJoint>();
		Map<Integer, KeyFrame> keyFrames = motion.getKeyFrames();

		BVHJoint currentJoint = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

		String line;
		
		String mode = TAG_HIERARCHY;

		while ((line = reader.readLine()) != null) {

			line = fixLine(line);

			if (line.startsWith(TAG_HIERARCHY)) {
				mode = TAG_HIERARCHY;
			} else if (line.startsWith(TAG_MOTION)) {
				mode = TAG_MOTION;
			}
			
			if (TAG_HIERARCHY.equals(mode)) {
				currentJoint = parseHierarchy(joints, currentJoint, line);
			} else if(TAG_MOTION.equals(mode)) {
				mode = parseMotion(motion, line, mode);
			} else if(TAG_KEYFRAME.equals(mode)) {
				parseKeyFrame(joints, keyFrames, line);
			}
		}

		reader.close();

		Armature armature = buildArmature(joints);

		motion.setArmature(armature);
		motion.setKeyFrames(keyFrames);
		return motion;
	}

	private void parseKeyFrame(List<BVHJoint> joints, Map<Integer, KeyFrame> keyFrames, String line) {
		String[] parts = line.split(" ");
		
		int index = 0;

		int keyFrameIndex = keyFrames.size();
		
		KeyFrame keyFrame = new KeyFrame();
		
		for (BVHJoint joint : joints) {
			
			for (int i = 0; i < joint.channels.size(); i++) {
				String part = parts[index + i];
				String p = joint.channels.get(i);
				
				float value = Float.parseFloat(part);
				
				if (CHANNEL_X_POSITION.equals(p)) {
					joint.xPosition = value;
				} else if (CHANNEL_Y_POSITION.equals(p)) {
					joint.yPosition = value;
				} else if (CHANNEL_Z_POSITION.equals(p)) {
					joint.zPosition = value;
				} else if (CHANNEL_X_ROTATION.equals(p)) {
					joint.xRotation = value;
				} else if (CHANNEL_Y_ROTATION.equals(p)) {
					joint.yRotation = value;
				} else if (CHANNEL_Z_ROTATION.equals(p)) {
					joint.zRotation = value;
				}
			}
			index += joint.channels.size();
			Matrix4 transform = new Matrix4();
			transform.setFromEulerAngles(joint.zRotation, joint.xRotation, joint.yRotation);
			keyFrame.addTransform(joint.name, transform);
		}
		//Add a keyFrame after iterate over all joints  
		keyFrames.put(keyFrameIndex, keyFrame);
	}

	private String parseMotion(Motion motion, String line, String mode) {
		if (line.startsWith(TAG_FRAMES)) {
			String framesText = line.substring((TAG_FRAMES+" ").length());		
			int frames = Integer.parseInt(framesText);
			motion.setFrames(frames);
		} else if (line.startsWith(TAG_FRAME_TIME)) {
			String frameTimeText = line.substring((TAG_FRAME_TIME+" ").length());		
			float frameTime = Float.parseFloat(frameTimeText);
			motion.setFrameTime(frameTime);
			return TAG_KEYFRAME;
		}
		return mode;
	}

	private BVHJoint parseHierarchy(List<BVHJoint> joints, BVHJoint currentJoint, String line) {
		if (line.startsWith(TAG_ROOT+" ")) {
			String jointName = line.substring((TAG_ROOT+" ").length());
			BVHJoint joint = new BVHJoint(jointName);
			joint.setParent(joint);

			currentJoint = joint;
			joints.add(joint);

		} else if (line.startsWith(TAG_JOINT+" ")) {
			String jointName = line.substring((TAG_JOINT+" ").length());
			BVHJoint joint = new BVHJoint(jointName, currentJoint);
			joint.setParent(currentJoint);
			
			currentJoint = joint;
			joints.add(joint);

		} else if (line.startsWith(TAG_END_SITE+" ")) {
			String jointName = line.substring((TAG_END_SITE+" ").length());
			BVHJoint joint = new BVHJoint(jointName+SUFFIX_END, currentJoint);
			joint.setParent(currentJoint);
			
			currentJoint = joint;
			joints.add(joint);

		} else if (line.startsWith(TAG_OFFSET+" ")) {
			String[] parts = line.split(" ");

			float offsetX = Float.parseFloat(parts[1]);
			float offsetY = Float.parseFloat(parts[2]);
			float offsetZ = Float.parseFloat(parts[3]);;

			Vector3 offset = new Vector3(offsetX, offsetY, offsetZ);
			currentJoint.offset = offset;

		} else if (line.startsWith(TAG_CHANNELS+" ")) {
			String[] parts = line.split(" ");

			int index = Integer.parseInt(parts[1]);

			Map<Integer, String> channels = new HashMap<Integer, String>();
			for (int i = 0; i < index; i++) {
				channels.put(i, parts[2 + i]);
			}
			
			currentJoint.channels = channels;
		}
		return currentJoint;
	}

	private Armature buildArmature(List<BVHJoint> joints) {
		
		Armature armature = new Armature();
		
		//Map<String, Bone> bones = new HashMap<String, Bone>();
		Map<String, Joint> js = new HashMap<String, Joint>();		
		
		for (BVHJoint joint : joints) {
			
			if (joint.parent == joint) {
				Joint j = createJoint(joint);
				js.put(joint.name, j);
				
				armature.setRootName(joint.name);
				armature.setRoot(j);
				
				
			} else {
				
				Joint parentJoint = js.get(joint.parent.name);
				Joint j = createJoint(joint);
				js.put(joint.name, j);
				
				Bone bone = new Bone();

				bone.setOrigin(parentJoint);
				bone.setDestination(j);

				armature.addBone(bone);
				
				Bone parentBone = findParentBone(parentJoint, armature);
				if (parentBone != null) {
					parentBone.addBone(bone);
				}
			}
		}

		return armature;
	}

	private Bone findParentBone(Joint parentJoint, Armature armature) {
		for(Bone b : armature.getBones()) {
			if (b.getDestination().equals(parentJoint)) {
				return b;
			}
		}
		return null;
	}

	private Joint createJoint(BVHJoint joint) {
		Vector3 position = new Vector3(joint.offset);
		return new Joint(joint.name, position);
	}

	private String fixLine(String line) {
		return line.trim();
	}
}