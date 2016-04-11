package com.home.ubbs.pocketlingo.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.home.ubbs.pocketlingo.R;
import com.home.ubbs.pocketlingo.config.LingoConfigurationManager;
import com.home.ubbs.pocketlingo.fragment.ComingSoonFragment;
import com.home.ubbs.pocketlingo.fragment.LingoBaseFragment;

public class MainActivity extends AppCompatActivity {
    private Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment = new LingoBaseFragment();
        // Add the fragment to the 'fragment_container' FrameLayout
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame_container, fragment).commit();
        if (savedInstanceState != null) {
            //Restore the fragment's instance
            fragment = getSupportFragmentManager().getFragment(savedInstanceState, "mContent");
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_container, fragment).commit();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.lingo_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection

        switch (item.getItemId()) {
            case R.id.french:


                LingoConfigurationManager.setCurrentLingo("french");
                fragment = new LingoBaseFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_container, fragment).commit();
                return true;
            case R.id.dutch:

                LingoConfigurationManager.setCurrentLingo("dutch");
                fragment = new ComingSoonFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_container, fragment).commit();
                return true;
            case R.id.english:

                LingoConfigurationManager.setCurrentLingo("english");
                fragment = new ComingSoonFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_container, fragment).commit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //Save the fragment's instance
        getSupportFragmentManager().putFragment(outState, "mContent", fragment);
    }





}
