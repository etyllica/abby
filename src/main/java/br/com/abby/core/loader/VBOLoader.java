package br.com.abby.core.loader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import br.com.abby.core.model.Model;

public interface VBOLoader {

	static final String DEFAULT_GROUP_NAME = "default";
	
	public Model loadModel(URL url, String path) throws FileNotFoundException, IOException;
	
}
