package br.com.abby.linear;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

public class BaseCone extends Shape {

	protected int sides = 3;
	protected float height = 1f;
	protected float radius = 1f;

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
		
		buildPoints();
	}

	public BaseCone(int sides, float height, float radius) {
		super();
		this.sides = sides;
		this.height = height;
		this.radius = radius;
		
		buildPoints();
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
	
	public BoundingBox bbox() {
		BoundingBox box = new BoundingBox(new Vector3(radius, height/2, radius), new Vector3(-radius, -height/2, -radius));
		box.mul(transform);
		return box;
	}
	
}
