package pt.isep.dei.simov.android.sellit.activities;

import pt.isep.simov.android.app.R;
import pt.isep.simov.android.app.R.layout;
import pt.isep.simov.android.app.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
