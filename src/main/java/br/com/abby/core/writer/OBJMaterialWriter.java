package br.com.abby.core.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import br.com.abby.core.loader.OBJMaterialLoader;
import br.com.abby.core.material.OBJMaterial;
import br.com.etyllica.util.StringUtils;
import br.com.etyllica.util.io.IOHelper;

public class OBJMaterialWriter implements MaterialWriter<OBJMaterial> {

	@Override
	public void writeMaterial(OBJMaterial material, String filename) throws IOException {

		Writer writer = null;

		try {
			File file = IOHelper.getFile(filename);

			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file), IOHelper.ENCODING_UTF_8));

			writeHeader(material, writer);
			
			writer.write(OBJMaterialLoader.NEW_MATERIAL+" "+material.getName()+StringUtils.NEW_LINE);
			writer.write(OBJMaterialLoader.DIFFUSE_TEX_MAP+" "+material.getMapKd()+StringUtils.NEW_LINE);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			writer.close();			
		}
	}

	private void writeHeader(OBJMaterial material, Writer writer) throws IOException {
		writer.write("# Created by Abby "+StringUtils.NEW_LINE);
	}
	
}
