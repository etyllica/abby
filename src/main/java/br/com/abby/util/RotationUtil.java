package br.com.abby.util;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;

public class RotationUtil {

	/**
	 * Convert angles to quaternion
	 * @param yaw in radians
	 * @param pitch in radians
	 * @param roll in radians
	 * @return quaternion
	 */
	public static final Quaternion convertToQuaternion(double yaw, double pitch, double roll) {

		// Assuming the angles are in radians.
		double c1 = Math.cos(yaw);
		double s1 = Math.sin(yaw);
		double c2 = Math.cos(pitch);
		double s2 = Math.sin(pitch);
		double c3 = Math.cos(roll);
		double s3 = Math.sin(roll);

		double w = Math.sqrt(1.0 + c1 * c2 + c1*c3 - s1 * s2 * s3 + c2*c3) / 2.0;
		double w4 = (4.0 * w);
		double x = (c2 * s3 + c1 * s3 + s1 * s2 * c3) / w4 ;
		double y = (s1 * c2 + s1 * c3 + c1 * s2 * s3) / w4 ;
		double z = (-s1 * s3 + c1 * s2 * c3 +s2) / w4 ;

		Quaternion quaternion = new Quaternion((float)x, (float) y, (float) z, (float) w);
		return quaternion;
	}

	public static Vector3 transformVector(Vector3 vector, Matrix4 transform) {
		Vector3 out = new Vector3();
		float[] mat = transform.val;
		out.x = mat[Matrix4.M00]*vector.x + mat[Matrix4.M10]*vector.y + mat[Matrix4.M20]*vector.z + mat[Matrix4.M30];
		out.y = mat[Matrix4.M01]*vector.x + mat[Matrix4.M11]*vector.y + mat[Matrix4.M21]*vector.z + mat[Matrix4.M31];
		out.z = mat[Matrix4.M02]*vector.x + mat[Matrix4.M12]*vector.y + mat[Matrix4.M22]*vector.z + mat[Matrix4.M32];
		return out;
	}

}
