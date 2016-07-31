package com.daose.sitback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseReference ref;
    private FirebaseDatabase db;
    private View trackpad;
    public static int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseDatabase.getInstance();
        ref = db.getReference("room");
        trackpad = findViewById(R.id.pad);
        trackpad.setOnTouchListener(new OnSwipeTouchListener(this) {
            public void onSwipe(float x, float y) {
                ref.child("swipe").setValue(new Vector2D(x, y));
            }
        });
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) findViewById(view.getId());
        if (button == null) return;

        String key = ref.child("button").push().getKey();
        System.out.println("key: " + key);
        ref.child("button").child(key).setValue(button.getText());
    }
}
