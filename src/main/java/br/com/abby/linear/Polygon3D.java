package br.com.abby.linear;

import java.util.Vector;

import com.sun.prism.paint.Color;

/**
 * 
 * @author yuripourre
 * @license LGPLv3
 *
 */

public class Polygon3D extends AimPoint {
	
	protected Color color = Color.BLACK;
	protected Vector<ColoredPoint3D> vertices;
	
	public Polygon3D() {
		this(0, 0, 0);
	}
	public Polygon3D(float x, float y, float z) {
		super(x,y,z);
		
		vertices = new Vector<ColoredPoint3D>();
			
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
		
	public void addVertex(double x, double y, double z){
		vertices.add(new ColoredPoint3D(x,y,z));
	}
	
	public Vector<ColoredPoint3D> getVertices(){
		return vertices;
	}
	public Color getColor() {
		return color;
	}

}
