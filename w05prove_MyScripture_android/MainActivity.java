package com.example.myscripture;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_KEY_1 = "EXTRA_KEY_1";
    public static final String EXTRA_KEY_2 = "EXTRA_KEY_2";
    public static final String EXTRA_KEY_3 = "EXTRA_KEY_3";
    private SharedPreferences sharedpreferences;

    String editTextBook;
    String editTextChapter;
    String editTextVerse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    /** reset all variables onResume **/
    protected void onResume(){
        super.onResume();
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Submit button */
    public void saveScripture(View view) {
        /* Adda debug log message */
        Log.d("Vics Message", "About to create intent with John 3:16");

        Intent i = new Intent(this, DisplayMessageActivity.class);

        EditText editTextBook = (EditText) findViewById(R.id.editTextBook);
        String message1 = editTextBook.getText().toString();
        i.putExtra(EXTRA_KEY_1, message1);

        EditText editTextChapter = (EditText) findViewById(R.id.editTextChapter);
        String message2 = editTextChapter.getText().toString();
        i.putExtra(EXTRA_KEY_2, message2);

        EditText editTextVerse = (EditText) findViewById(R.id.editTextVerse);
        String message3 = editTextVerse.getText().toString();
        i.putExtra(EXTRA_KEY_3, message3);

        startActivity(i);
    }
    /** Called when the user taps the Load Scripture button **/
    public void LoadScripture(View view) {
        //display toast message in top right side
        Toast toast = Toast.makeText(MainActivity.this, "Your scripture is loading.", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();

        SharedPreferences prefs = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        String string1 = prefs.getString("m1", "defaultValue");
        String string2 = prefs.getString("m2", "defaultValue");
        String string3 = prefs.getString("m3", "defaultValue");

        editTextBook = string1;
        editTextChapter = string2;
        editTextVerse = string3;
    }
}

