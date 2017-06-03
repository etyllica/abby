package br.com.abby.core.graphics;

import com.badlogic.gdx.math.Vector3;

import br.com.abby.linear.AimPoint;
import br.com.etyllica.core.linear.Point3D;

public interface Graphics3D {

	int[] getViewPort();
	
	//Drawing Methods
	void drawLine(Point3D a, Point3D b);
	
	void drawLine(Point3D a, Vector3 b);
	
	void drawLine(Vector3 a, Vector3 b);
	
	void drawSphere(Vector3 point, double radius);
	
	void drawSphere(AimPoint point, double radius);
	
}
