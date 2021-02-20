package com.example.multithreading;

import android.app.Activity;
import android.widget.Toast;

import java.lang.ref.WeakReference;

/**
 * This class is used to count to 100 by even numbers on a background thread.
 * It properly uses weak references.
 */
public class EvenCounter implements Runnable {
    // This variable holds a WeakReference to an activity, so that it will allow
    // it to be garbage collected if necessary. Because of this, whenever we use
    // it, we need to make sure to check if it's null.
    private WeakReference<Activity> activityRef;

    public EvenCounter(Activity activity) {
        this.activityRef = new WeakReference<Activity>(activity);
    }

    @Override
    public void run() {

        // Start at 2 so we count the even numbers
        for (int i = 2; i < 100; i+=2) {
            System.out.println(i);

            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // we are now finished counting, display the toast:

        // first, we'll get the activity from the WeakReference
        final Activity activity = activityRef.get();

        // now, make sure the activity was not destroyed since we last saw it
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    // This is the code that will run on the UI thread.
                    Toast toast = Toast.makeText(activity, "Even Counting Finished", Toast.LENGTH_SHORT);
                    toast.show();
                }
            });
        }
    }
}
