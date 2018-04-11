package com.compassco;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by arunganesan on 2/10/18.
 * http://www.intransitione.com/blog/create-a-spinning-cube-with-opengl-es-and-android/
 */

public class OpenGLRenderer implements GLSurfaceView.Renderer {
    private Cube mCube = new Cube();
    final String TAG = "GLRenderer";
    Compass3DTwo parentApp;

    public OpenGLRenderer(Compass3DTwo parentApp) {
        this.parentApp = parentApp;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);

        gl.glClearDepthf(1.0f);
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glDepthFunc(GL10.GL_LEQUAL);

        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT,
                GL10.GL_NICEST);

    }

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();

        gl.glTranslatef(0.0f, 0.0f, -10.0f);

        float[] lastOrientation = parentApp.getLastOrientation();
        if (lastOrientation == null)
            gl.glRotatef(0, 1.0f, 1.0f, 1.0f);
        else {
            float xRotation = lastOrientation[1] * 180f / 3.14f;
            float yRotation = -lastOrientation[2] * 180f / 3.14f;
            float zRotation = lastOrientation[0] * 180f / 3.14f;

            // https://stackoverflow.com/questions/10192057/android-getorientation-method-returns-bad-results#
            // The order apparently matters, for some mysterious reason
            gl.glRotatef(yRotation, 0, 1.0f, 0);
            gl.glRotatef(xRotation, 1.0f, 0, 0);
            gl.glRotatef(zRotation, 0, 0, 1.0f);
        }

        mCube.draw(gl);

        gl.glLoadIdentity();

        //mCubeRotation -= 0.9f;//0.15f;
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        GLU.gluPerspective(gl, 45.0f, (float)width / (float)height, 0.1f, 100.0f);
        gl.glViewport(0, 0, width, height);

        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
    }
}
