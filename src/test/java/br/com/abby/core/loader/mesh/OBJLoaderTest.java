package br.com.abby.core.loader.mesh;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.abby.TestUtils;
import br.com.abby.core.loader.MeshLoader;
import br.com.abby.core.model.Model;
import br.com.etyllica.util.PathHelper;

public class OBJLoaderTest {

	private OBJLoader loader;
	
	@Before
	public void setUp() throws MalformedURLException {
		String path = PathHelper.currentFileDirectory();
				
		URL url = new URL(path+"../");
		
		MeshLoader.getInstance().setUrl(url.toString());
		
		loader = (OBJLoader) MeshLoader.getInstance().getLoader("obj");
	}
	
	@Test
	public void testLoadModel() {
		
		//Load a cube made with triangles
		String filename = "cube.obj";
		
		URL dir = null;
		try {
			dir = MeshLoader.getInstance().getFullURL(filename);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			
			if(TestUtils.isTestEnvironment(dir)) {
				dir = new URL(MeshLoader.getInstance().getUrl(), "etyllica/assets/models/"+filename);
			}
			
			Model vbo = loader.loadModel(dir, filename);
			Assert.assertNotNull(vbo);
			Assert.assertEquals(12, vbo.getFaces().size());
			Assert.assertEquals(8, vbo.getVertices().size());
			
		} catch (FileNotFoundException e) {
			Assert.fail();
			e.printStackTrace();
		} catch (IOException e) {
			Assert.fail();
			e.printStackTrace();
		}
		
	}
}
