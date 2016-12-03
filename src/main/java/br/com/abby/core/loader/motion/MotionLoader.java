package br.com.abby.core.loader.motion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import br.com.abby.core.model.motion.Motion;

public interface MotionLoader {

	public Motion loadMotion(URL dir, String path) throws IOException, FileNotFoundException;

}
