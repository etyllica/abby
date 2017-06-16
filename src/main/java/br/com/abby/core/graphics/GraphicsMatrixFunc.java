package br.com.abby.core.graphics;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/**
 * Forked from https://jogamp.org/deployment/v2.1.0/javadoc/jogl/javadoc/javax/media/opengl/fixedfunc/GLMatrixFunc.html
 */
public interface GraphicsMatrixFunc {
    public static final int GL_MATRIX_MODE = 2976;
    public static final int GL_MODELVIEW = 5888;
    public static final int GL_MODELVIEW_MATRIX = 2982;
    public static final int GL_PROJECTION = 5889;
    public static final int GL_PROJECTION_MATRIX = 2983;
    public static final int GL_TEXTURE_MATRIX = 2984;

    /*
     * Multiply the current matrix with the frustum matrix.
     */
    void glFrustumf(float left, float right, float bottom, float top, float zNear, float zFar);

    /*
     * Copy the named matrix to the given storage at offset.
     */
    void glGetFloatv(int pname, float[] params, int params_offset);

    /*
     * Copy the named matrix into the given storage.
     */
    void glGetFloatv(int pname, FloatBuffer params);

    void glGetIntegerv(int pname, int[] params, int params_offset);

    void glGetIntegerv(int pname, IntBuffer params);

    /*
     * Load the current matrix with the identity matrix
     */
    void glLoadIdentity();

    /*
     * Load the current matrix w/ the provided one.
     */
    void glLoadMatrixf(float[] m, int m_offset);

    /*
     * Load the current matrix w/ the provided one.
     */
    void glLoadMatrixf(FloatBuffer m);

    /*
     * Sets the current matrix mode.
     */
    void glMatrixMode(int mode);

    /*
     * Multiply the current matrix
     */
    void glMultMatrixf(float[] m, int m_offset);

    /*
     * Multiply the current matrix
     */
    void glMultMatrixf(FloatBuffer m);

    /*
     * Multiply the current matrix with the orthogonal matrix.
     */
    void glOrthof(float left, float right, float bottom, float top, float zNear, float zFar);

    /*
     * Pop the current matrix from it's stack.
     */
    void glPopMatrix();

    /*
     * Push the current matrix to it's stack, while preserving it's values.
     */
    void glPushMatrix();

    /*
     * Rotate the current matrix.
     */
    void glRotatef(float angle, float x, float y, float z);

    /*
     * Scale the current matrix.
     */
    void glScalef(float x, float y, float z);

    /*
     * Translate the current matrix.
     */
    void glTranslatef(float x, float y, float z);

}
