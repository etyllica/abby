package br.com.abby.linear;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.math.Vector3;

public class BaseCone extends Shape {

	protected int sides = 3;
	protected float height = 1f;
	protected float radius = 10f;

	private static final double TWICE_PI = 2.0f * Math.PI;

	protected  List<Vector3> lowerPoints = new ArrayList<Vector3>();

	public BaseCone() {
		super();
	}

	public BaseCone(int sides) {
		super();
		this.sides = sides;

		buildPoints();
	}

	public BaseCone(int sides, float height) {
		super();
		this.sides = sides;
		this.height = height;
	}

	protected void buildPoints() {
		for(int i = 0; i <= sides; i++) {
			lowerPoints.add(point(position, radius, -height/2, sides, i));
		}
	}

	protected static Vector3 point(Vector3 center, float radius, float height, int sides, int i) {
		float px = (float) (center.x + (radius * Math.cos(i *  TWICE_PI / sides)));
		float py = center.y + height;
		float pz = (float) (center.z + (radius * Math.sin(i * TWICE_PI / sides)));

		return new Vector3(px, py, pz);
	}

}
