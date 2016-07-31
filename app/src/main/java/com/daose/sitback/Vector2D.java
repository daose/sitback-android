package com.daose.sitback;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by STUDENT on 2016-07-30.
 */
@IgnoreExtraProperties
public class Vector2D {
    public float x, y;

    public Vector2D() {
    }

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
