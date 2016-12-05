package br.com.abby.core.loader.motion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;

import br.com.abby.TestUtils;
import br.com.abby.core.loader.AnimationLoader;
import br.com.abby.core.model.Bone;
import br.com.abby.core.model.motion.Motion;
import br.com.abby.core.model.motion.Transform;
import br.com.etyllica.util.PathHelper;

public class BVHLoaderTest {

	
	private static final float EPSILON = 0.0001f; 
	private BVHLoader loader;
	
	@Before
	public void setUp() throws MalformedURLException {
		String path = PathHelper.currentFileDirectory();
				
		URL url = new URL(path+"../");
		
		AnimationLoader.getInstance().setUrl(url.toString());
		
		loader = (BVHLoader) AnimationLoader.getInstance().getLoader("bvh");
	}
	
	@Test
	public void testLoadModel() {
		
		//Load a .bvh file
		String fileName = "01_01.bvh";
		int boneIndex = 2; //LegUp
		
		URL dir = null;
		try {
			dir = AnimationLoader.getInstance().getFullURL(fileName);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			
			if(TestUtils.isTestEnvironment(dir)) {
				dir = new URL(AnimationLoader.getInstance().getUrl(), "etyllica/assets/models/"+fileName);
			}
			
			Motion motion = loader.loadMotion(dir, fileName);
			Assert.assertNotNull(motion);
			Assert.assertEquals(37, motion.getArmature().getBones().size());
			
			Assert.assertEquals(3, motion.getArmature().getRoot().getChildren().size());
			Assert.assertEquals(1, motion.getArmature().getBones().get(1).getDestination().getChildren().size());
			
			Assert.assertEquals(0, motion.getArmature().getBones().get(0).getOrigin().getPosition().x, EPSILON);
			Assert.assertEquals(0, motion.getArmature().getBones().get(0).getOrigin().getPosition().y, EPSILON);
			Assert.assertEquals(0, motion.getArmature().getBones().get(0).getOrigin().getPosition().z, EPSILON);
			Assert.assertEquals(0, motion.getArmature().getBones().get(1).getOrigin().getPosition().x, EPSILON);
			Assert.assertEquals(0, motion.getArmature().getBones().get(1).getOrigin().getPosition().y, EPSILON);
			Assert.assertEquals(0, motion.getArmature().getBones().get(1).getOrigin().getPosition().z, EPSILON);
			Assert.assertEquals(1.36306f, motion.getArmature().getBones().get(2).getOrigin().getPosition().x, EPSILON);
			Assert.assertEquals(-1.79463f, motion.getArmature().getBones().get(2).getOrigin().getPosition().y, EPSILON);
			Assert.assertEquals(0.83929f, motion.getArmature().getBones().get(2).getOrigin().getPosition().z, EPSILON);
			
			Assert.assertEquals(2752, motion.getFrames());
			Assert.assertEquals(0.0083333f, motion.getFrameTime(), EPSILON);
			Assert.assertEquals(2752, motion.getKeyFrames().size());
			
			//Test Transform
			Transform transform = motion.getKeyFrames().get(1).getTransform(boneIndex);
			Quaternion qL = transform.q;
			 
			Matrix4 fromFile = new Matrix4().setFromEulerAngles(2.5002f, 3.3502f, -13.8102f);
			Quaternion q1 = fromFile.getRotation(new Quaternion());
			
			Assert.assertEquals(q1.x, qL.x, EPSILON);
			Assert.assertEquals(q1.y, qL.y, EPSILON);
			Assert.assertEquals(q1.z, qL.z, EPSILON);
			
			Bone LeftUpLeg = motion.getArmature().getBones().get(1);
			  
			Assert.assertEquals(1.36306, LeftUpLeg.getDestination().getPosition().x, EPSILON);
			Assert.assertEquals(-1.79463, LeftUpLeg.getDestination().getPosition().y, EPSILON);
			Assert.assertEquals(0.83929, LeftUpLeg.getDestination().getPosition().z, EPSILON);
			
			Bone LeftLeg = motion.getArmature().getBones().get(2);
			
			Assert.assertEquals(2.44811, LeftLeg.getDestination().getPosition().x-LeftUpLeg.getDestination().getPosition().x, EPSILON);
			Assert.assertEquals(-6.72613 , LeftLeg.getDestination().getPosition().y-LeftUpLeg.getDestination().getPosition().y, EPSILON);
			Assert.assertEquals(0.00000, LeftLeg.getDestination().getPosition().z-LeftUpLeg.getDestination().getPosition().z, EPSILON);
			
			Assert.assertEquals(31, motion.getKeyFrames().get(0).getTransforms().size());
			Assert.assertEquals(31, motion.getKeyFrames().get(1).getTransforms().size());
			Assert.assertEquals(31, motion.getKeyFrames().get(2).getTransforms().size());
			
		} catch (FileNotFoundException e) {
			Assert.fail();
			e.printStackTrace();
		} catch (IOException e) {
			Assert.fail();
			e.printStackTrace();
		}
		
	}	
}
