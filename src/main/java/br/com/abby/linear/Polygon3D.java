package br.com.abby.linear;

import java.util.Vector;

import com.badlogic.gdx.math.Vector3;

/**
 * 
 * @author yuripourre
 * @license LGPLv3
 *
 */

public class Polygon3D extends AimPoint {
	
	protected Vector<Vector3> vertices;
	
	public Polygon3D() {
		this(0, 0, 0);
	}
	public Polygon3D(float x, float y, float z) {
		super(x,y,z);
		
		vertices = new Vector<Vector3>();
			
		/*
		 * Teste
		 */
		//novoVertice( 0, 1, 0);					
		addVertex( 1, 1,-1);					// Top Right Of The Quad (Top)
		addVertex(-1, 1,-1);					// Top Left Of The Quad (Top)
		addVertex(-1, 1, 1);					// Bottom Left Of The Quad (Top)
		addVertex( 1, 1, 1);					// Bottom Right Of The Quad (Top)
		addVertex( 1,-1, 1);					// Top Right Of The Quad (Bottom)
		addVertex(-1,-1, 1);					// Top Left Of The Quad (Bottom)
		addVertex(-1,-1,-1);					// Bottom Left Of The Quad (Bottom)
		addVertex( 1,-1,-1);					// Bottom Right Of The Quad (Bottom)
		addVertex( 1, 1, 1);					// Top Right Of The Quad (Front)
		addVertex(-1, 1, 1);					// Top Left Of The Quad (Front)
		addVertex(-1,-1, 1);					// Bottom Left Of The Quad (Front)
		addVertex( 1,-1, 1);					// Bottom Right Of The Quad (Front)
		addVertex( 1,-1,-1);					// Top Right Of The Quad (Back)
		addVertex(-1,-1,-1);					// Top Left Of The Quad (Back)
		addVertex(-1, 1,-1);					// Bottom Left Of The Quad (Back)
		addVertex( 1, 1,-1);					// Bottom Right Of The Quad (Back)
		addVertex(-1, 1, 1);					// Top Right Of The Quad (Left)
		addVertex(-1, 1,-1);					// Top Left Of The Quad (Left)
		addVertex(-1,-1,-1);					// Bottom Left Of The Quad (Left)
		addVertex(-1,-1, 1);					// Bottom Right Of The Quad (Left)
		addVertex( 1, 1,-1);					// Top Right Of The Quad (Right)
		addVertex( 1, 1, 1);					// Top Left Of The Quad (Right)
		addVertex( 1,-1, 1);					// Bottom Left Of The Quad (Right)
		addVertex( 1,-1,-1);					// Bottom Right Of The Quad (Right)
		
	}
		
	public void addVertex(float x, float y, float z){
		vertices.add(new Vector3(x,y,z));
	}
	
	public Vector<Vector3> getVertices(){
		return vertices;
	}
}
