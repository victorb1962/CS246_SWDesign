package com.example.myscripture;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayMessageActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    TextView TextView2;
    String message1;
    String message2;
    String message3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        /* Adda debug log message */
        Log.d("Vics Message", "Received intent with John 3:16");

        // Get the Intent that started this activity and extract the string
        Intent i = getIntent();
        String message1 = i.getStringExtra(MainActivity.EXTRA_KEY_1);
        String message2 = i.getStringExtra(MainActivity.EXTRA_KEY_2);
        String message3 = i.getStringExtra(MainActivity.EXTRA_KEY_3);

        // Capture the layout's TextView and set the string as its text
        TextView textView2 = findViewById(R.id.textView2);
        String string1 = message1 + " " + message2 + ":" + message3;
        textView2.setText(string1);
    }

    /** Called when the user taps the Save Scripture button **/
    public void Save(View view) {
        //display toast message
        Toast toast = Toast.makeText(DisplayMessageActivity.this, "Your scripture was saved.", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("m1", message1);
        editor.putString("m2", message2);
        editor.putString("m3", message3);
        editor.commit();
    }
}