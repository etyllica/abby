package br.com.abby.core.writer;

import java.io.IOException;

public interface MaterialWriter<T> {

	public void writeMaterial(T material, String filename) throws IOException;
	
}
