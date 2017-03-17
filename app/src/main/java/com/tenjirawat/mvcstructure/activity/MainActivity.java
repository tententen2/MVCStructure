package com.tenjirawat.mvcstructure.activity;

import android.os.Build;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.tenjirawat.mvcstructure.R;
import com.tenjirawat.mvcstructure.fragment.MainFragment;
import com.tenjirawat.mvcstructure.fragment.SecondFragment;
import com.tenjirawat.mvcstructure.util.ScreenUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int screenw = ScreenUtils.getInstance().getScreenWidth();
        int screenh = ScreenUtils.getInstance().getScreenHeight();

        Toast.makeText(MainActivity.this,screenh+"",Toast.LENGTH_LONG).show();
        if(Build.VERSION.SDK_INT >= 21){

        }else{

        }
        if(savedInstanceState == null){
            //First Created
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, MainFragment.newInstance(123),"MainFragment")
                    .commit();
            //set parameter to Fragment
        }

    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if(savedInstanceState == null) {
            MainFragment mainFragment = (MainFragment) getSupportFragmentManager().findFragmentByTag("MainFragment");
            mainFragment.setHelloText("Woo Hooooo");
            //some change
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_manu,menu);
        return true; // we handler already ?
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.item_hello){
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.contentContainer);

            if(fragment instanceof SecondFragment == false) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentContainer, SecondFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
            Toast.makeText(MainActivity.this,"Second",Toast.LENGTH_LONG).show();
            return true; // we handler already ?
        }
        return super.onOptionsItemSelected(item); // didn't enter someone
    }
}
