package com.aryaman.covid.ui;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;

import com.aryaman.covid.R;
import com.aryaman.covid.ui.characters.view.CharactersFragment;
import com.aryaman.covid.ui.planets.view.PlanetsFragment;
import com.aryaman.covid.ui.grocery.view.groceryFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BottomNavigationActivity extends AppCompatActivity {

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;

    PlanetsFragment planetsFragment;
    CharactersFragment charactersFragment;
    groceryFragment groceryFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        ButterKnife.bind(this);

        planetsFragment = new PlanetsFragment();
        charactersFragment = new CharactersFragment();
        groceryFragment = new groceryFragment();

        showFragment(planetsFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_planets:
                                showFragment(planetsFragment);
                                break;
                            case R.id.action_schedules:
                                showFragment(charactersFragment);
                                break;
                            case R.id.action_music:
                                showFragment(groceryFragment);
                                break;
                        }
                        return false;
                    }
                });
    }

    public void showFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.navigation_placeholder, fragment);
        fragmentTransaction.commit();
    }
}
