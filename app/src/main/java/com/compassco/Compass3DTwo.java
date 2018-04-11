package com.compassco;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import edu.umich.eecs.rtcl.carlab.CLDataProvider;
import edu.umich.eecs.rtcl.carlab.DataMarshal;
import edu.umich.eecs.rtcl.carlab.apps.App;
import edu.umich.eecs.rtcl.carlab.sources.apps.VehicleAlignment;


/**
 * This app experiments with vehicle-smartphone axis alignment.
 * It takes the phone's IMU sensors and always points to the
 * vehicle forward direction.
 */
public class Compass3DTwo extends App {
    final String TAG = "Compass3DTwo";

    // UI
    LinearLayout linearLayout;
    TextView appTextView;
    GLSurfaceView cubeView;

    private float [] lastComputedOrientation = new float[3];

    public float [] getLastOrientation() {
        return lastComputedOrientation;
    }

    public Compass3DTwo(CLDataProvider cl, Context context) {
        super(cl, context);
        name = "3D Compass";
        type = Type.DAA;
        dependencies.add("edu.umich.eecs.rtcl.carlab.apps.VehicleAlignment");
        sensors.add(new Pair<>(VehicleAlignment.APP, VehicleAlignment.ORIENT));
    }

    @Override
    public void newData(DataMarshal.DataObject dObject) {
        if (dObject.dataType != DataMarshal.MessageType.DATA) return;
        if (dObject.value == null) return;
        lastComputedOrientation[0] = dObject.value[0];
        lastComputedOrientation[1] = dObject.value[1];
        lastComputedOrientation[2] = dObject.value[2];
    }


    @Override
    public View initializeVisualization(Activity parentActivity) {
        super.initializeVisualization(parentActivity);
        cubeView = new GLSurfaceView(context);
        cubeView.setRenderer(new OpenGLRenderer(this));
        linearLayout = new LinearLayout(context);
        linearLayout.addView(cubeView);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams params;
        params = (LinearLayout.LayoutParams)cubeView.getLayoutParams();
        params.weight = 1.0f;
        params.height = 0;
        cubeView.setLayoutParams(params);

        return linearLayout;
    }


    @Override
    public void destroyVisualization() {
        // Should be garbage collected after this.
        appTextView = null;
    }
}
