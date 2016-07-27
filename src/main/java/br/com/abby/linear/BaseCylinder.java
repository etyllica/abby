package br.com.abby.linear;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.math.Vector3;

public class BaseCylinder extends BaseCone {

	protected  List<Vector3> upperPoints = new ArrayList<Vector3>();

	public BaseCylinder(int sides) {
		super(sides);
	}
	
	@Override
	protected void buildPoints() {
		for (int i = 0; i < sides; i++) {
			upperPoints.add(BaseCone.point(position, radius, +height/2, sides, i));
			lowerPoints.add(BaseCone.point(position, radius, -height/2, sides, i));
		}
	}

}
