package br.com.abby.core.graphics;

/**
 * Methods from https://jogamp.org/deployment/v2.1.0/javadoc/jogl/javadoc/javax/media/opengl/GL.html
 */
public interface GLGraphics {

    /**
     * Entry point to C language function: void glBegin(GLenum mode);
     * Part of GL_VERSION_1_0
     * @param mode
     */
    void glBegin(int mode);

    /**
     * Entry point to C language function: void glEnd(void);
     * Part of GL_VERSION_1_0
     */
    void glEnd();

    /**
     * Entry point to C language function: void glColor3d(GLdouble red, GLdouble green, GLdouble blue);
     * Part of GL_VERSION_1_0
     * @param red
     * @param green
     * @param blue
     */
    void glColor3d(double red, double green, double blue);

    void glLoadIdentity();

    int[] getViewPort();

    void glMatrixMode(int mode);

    /**
     * Entry point to C language function: void glClear(GLbitfield mask);
     * Part of GL_VERSION_ES_CL_CM, GL_VERSION_1_0, GL_ES_VERSION_2_0
     *  @param mask
     */
    void glClear(int mask);

    /**
     * Entry point to C language function: void glClearColor(GLclampf red, GLclampf green, GLclampf blue, GLclampf alpha);
     * Part of GL_VERSION_1_0, GL_ES_VERSION_2_0, GL_VERSION_ES_CM
     * @param red
     * @param green
     * @param blue
     * @param alpha
     */
    void glClearColor(float red, float green, float blue, float alpha);

    /**
     * Entry point to C language function: void glClearDepthf(GLfloat depth);
     * Part of GL_ARB_ES2_compatibility, GL_ES_VERSION_2_0, GL_VERSION_ES_CM; GL_OES_single_precision
     * @param depth
     */
    void glClearDepth(float depth);

    /**
     * Entry point to C language function: void glEnable(GLenum cap);
     * Part of GL_VERSION_ES_CL_CM, GL_VERSION_1_0, GL_ES_VERSION_2_0
     * @param cap
     */
    void glEnable(int cap);

    /**
     * Entry point to C language function: void glDepthFunc(GLenum func);
     * Part of GL_VERSION_ES_CL_CM, GL_VERSION_1_0, GL_ES_VERSION_2_0
     * @param func
     */
    void glDepthFunc(int func);

    /**
     * Entry point to C language function: void glHint(GLenum target, GLenum mode);
     * Part of GL_VERSION_ES_CL_CM, GL_VERSION_1_0, GL_ES_VERSION_2_0
     * @param target
     * @param mode
     */
    void glHint(int target, int mode);

    /**
     * Entry point to C language function: void glViewport(GLint x, GLint y, GLsizei width, GLsizei height);
     * Part of GL_VERSION_ES_CL_CM, GL_VERSION_1_0, GL_ES_VERSION_2_0
     * @param x
     * @param y
     * @param width
     * @param height
     */
    void glViewport(int x, int y, int width, int height);

    /**
     * Entry point to C language function: void glFlush(void);
     * Part of GL_VERSION_ES_CL_CM, GL_VERSION_1_0, GL_ES_VERSION_2_0
     */
    void glFlush();
}
