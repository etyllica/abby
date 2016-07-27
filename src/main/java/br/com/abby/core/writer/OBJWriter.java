package br.com.abby.core.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import br.com.abby.core.loader.OBJLoader;
import br.com.abby.core.model.Face;
import br.com.abby.core.model.Group;
import br.com.abby.core.model.Model;
import br.com.etyllica.util.StringUtils;
import br.com.etyllica.util.io.IOHelper;

public class OBJWriter implements VBOWriter {

	private static final String FACE_SEPARATOR = "/";
	private static final String MTL_EXTENSION = ".mtl";

	@Override
	public void writeVBO(Model vbo, String filename) throws IOException {

		Writer writer = null;

		try {
			File file = IOHelper.getFile(filename);

			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file), IOHelper.ENCODING_UTF_8));

			writeMaterials(vbo, writer);
			writeVertexes(vbo, writer);
			
			writeTextures(vbo, writer);

			//Optional
			writer.write(StringUtils.NEW_LINE);
			writeNormals(vbo, writer);

			writeFaces(writer, vbo.getFaces());
			
			for (Group group : vbo.getGroups()) {
				writeGroupSetup(writer, group);
				writeFaces(writer, group.getFaces());
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			writer.close();			
		}
	}
	
	private void writeMaterials(Model vbo, Writer writer) throws IOException {
		for(String materialLib: vbo.getMaterialLibs()) {
			writer.write(OBJLoader.MATERIAL_LIB+" "+materialLib+MTL_EXTENSION+StringUtils.NEW_LINE);	
		}
		/*for(String materialName: vbo.getMaterials().keySet()) {
			writer.write(OBJLoader.MATERIAL_LIB+" "+materialName+StringUtils.NEW_LINE);	
		}*/
	}

	private void writeGroupSetup(Writer writer, Group group) throws IOException {
		if(group.getMaterial() != null) {
			writer.write(OBJLoader.USE_MATERIAL+" "+group.getMaterial().getName()+StringUtils.NEW_LINE);	
		}
		writer.write(OBJLoader.GROUP+" "+group.getName()+StringUtils.NEW_LINE);
	}

	private void writeFaces(Writer writer, List<Face> faces) throws IOException {
		for(Face face: faces) {

			boolean hasTexture = faceHasTexture(face);
			boolean hasNomals = faceHasNormal(face);
			
			StringBuilder sb = new StringBuilder();
			sb.append(OBJLoader.FACE+" ");

			for(int i=0;i<face.getSides();i++) {

				if(i>0) {
					sb.append(" ");
				}

				sb.append(face.vertexIndex[i]);

				if(hasTexture) {
					sb.append(FACE_SEPARATOR);
					sb.append(face.textureIndex[i]);
				}

				if (hasNomals) {
					sb.append(FACE_SEPARATOR);
					if(!hasTexture) {
						sb.append(FACE_SEPARATOR);
					}
					sb.append(face.normalIndex[i]);
				}				
			}

			sb.append(StringUtils.NEW_LINE);
			writer.write(sb.toString());
		}
	}
	
	private boolean faceHasTexture(Face face) {
		boolean validTexture = false;
		
		if (face.textureIndex != null) {
			for (int i = 0;i < face.getSides(); i++) {
				if (face.textureIndex[i] != 0) {
					validTexture = true;
				}
			}
		}
		
		return validTexture;
	}
	
	private boolean faceHasNormal(Face face) {
		boolean validTexture = false;
		
		if (face.normalIndex != null) {
			for (int i = 0;i < face.getSides(); i++) {
				if (face.normalIndex[i] != 0) {
					validTexture = true;
				}
			}
		}
		
		return validTexture;
	}

	private void writeTextures(Model vbo, Writer writer) throws IOException {
		for(Vector2 vector: vbo.getTextures()) {
			String text = OBJLoader.VERTEX_TEXCOORD+" "+vector.x+" "+vector.y+StringUtils.NEW_LINE;
			writer.write(text);
		}
	}
	
	private void writeNormals(Model vbo, Writer writer) throws IOException {
		for(Vector3 vector: vbo.getNormals()) {
			String text = OBJLoader.VERTEX_NORMAL+" "+vector.x+" "+vector.y+" "+vector.z+StringUtils.NEW_LINE;
			writer.write(text);
		}
		
		//Optional
		if(!vbo.getNormals().isEmpty()) {
			writer.write(StringUtils.NEW_LINE);	
		}
	}

	private void writeVertexes(Model vbo, Writer writer) throws IOException {
		for(Vector3 vector: vbo.getVertices()) {
			String text = OBJLoader.VERTEX+" "+vector.x+" "+vector.y+" "+vector.z+StringUtils.NEW_LINE;
			writer.write(text);
		}
	}

}
