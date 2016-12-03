package br.com.abby;

import java.net.URL;

import br.com.etyllica.util.io.IOHelper;

public class TestUtils {

	public static boolean isTestEnvironment(URL dir) {
		String prefix = IOHelper.FILE_PREFIX+"/home/ubuntu";
		return dir.toString().startsWith(prefix);
	}	
}
