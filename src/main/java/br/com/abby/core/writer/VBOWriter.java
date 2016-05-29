package br.com.abby.core.writer;

import java.io.IOException;

import br.com.abby.core.model.Model;

public interface VBOWriter {

	public void writeVBO(Model vbo, String filename) throws IOException;
	
}
