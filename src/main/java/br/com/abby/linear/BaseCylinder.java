package br.com.abby.linear;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.math.Vector3;

public class BaseCylinder extends BaseCone {

	protected List<Vector3> upperPoints;

	public BaseCylinder(int sides) {
		super(sides);
	}
		
	public BaseCylinder(int sides, float height) {
		super(sides, height);
	}
	
	public BaseCylinder(int sides, float height, float radius) {
		super(sides, height, radius);
	}
	
	@Override
	protected void buildPoints() {
		upperPoints = new ArrayList<Vector3>();
		for (int i = 0; i <= sides; i++) {
			upperPoints.add(BaseCone.point(radius, +height/2, sides, i));
			lowerPoints.add(BaseCone.point(radius, -height/2, sides, i));
		}
	}

}
