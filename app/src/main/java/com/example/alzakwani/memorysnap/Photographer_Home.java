package com.example.alzakwani.memorysnap;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.alzakwani.memorysnap.photographer_home.PhotographerHomeFragment;
import com.example.alzakwani.memorysnap.photographer_profile.PhotographerPrpfileFragment;

public class Photographer_Home extends AppCompatActivity implements PhotographerHomeFragment.OnFragmentInteractionListener,
        PhotographerPrpfileFragment.OnFragmentInteractionListener{
    FrameLayout frame;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photographer__home);

        PhotographerHomeFragment homeFragment=new PhotographerHomeFragment();
         frame=(FrameLayout)findViewById(R.id.main_container);
       FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
       PhotographerHomeFragment fragment=new PhotographerHomeFragment();
       transaction.replace(R.id.main_container, fragment);
       transaction.commit();


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item))
        {

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
