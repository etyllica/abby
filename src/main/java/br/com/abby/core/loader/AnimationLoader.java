package br.com.abby.core.loader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import br.com.abby.core.loader.motion.BVHLoader;
import br.com.abby.core.loader.motion.MotionLoader;
import br.com.abby.core.model.motion.Motion;
import br.com.etyllica.loader.LoaderImpl;
import br.com.etyllica.util.StringUtils;
import br.com.etyllica.util.io.IOHelper;

/**
 * 
 * @author yuripourre
 * @license LGPLv3
 *
 */

public class AnimationLoader extends LoaderImpl {

	private static AnimationLoader instance = null;

	private Map<String, MotionLoader> loaders = new HashMap<String, MotionLoader>();

	public static final String BVH = "bvh";

	public static AnimationLoader getInstance() {
		if(instance==null){
			instance = new AnimationLoader();
		}

		return instance;
	}

	private AnimationLoader() {
		super();

		folder = "assets/animations/";

		loaders.put(BVH, new BVHLoader());
	}
	
	public Motion loadModel(String path) {
		return loadModel(path, false);
	}

	public Motion loadModel(String path, boolean absolutePath) {

		URL dir = null;
		try {
			if(!absolutePath) {
				dir = getFullURL(path);
			} else {
				dir = new URL(IOHelper.FILE_PREFIX+path);
			}
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}

		String ext = StringUtils.fileExtension(path);
		MotionLoader loader = getLoader(ext);

		if(loader == null) {
			System.out.println("Abby can't load "+ext+" files.");
		} else {
			try {
				return loader.loadMotion(dir, path);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				System.err.println("Asset "+path+" not found.");
			}
		}

		return null;
	}

	public MotionLoader getLoader(String extension) {
		return loaders.get(extension);
	}
	
	public void addLoader(String extension, MotionLoader loader) {
		loaders.put(extension, loader);
	}

	public Set<String> supportedExtensions() {
		return loaders.keySet();
	}

}