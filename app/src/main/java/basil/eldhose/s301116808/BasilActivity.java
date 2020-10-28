/*
* Basil Eldhose
* 301116808
* Sec 002
* */


package basil.eldhose.s301116808;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BasilActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basil);

        FragmentManager fragmentManager = getSupportFragmentManager();

        bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

}

    BasilFragment fragmentA=new BasilFragment();
    EldhoseFragment fragmentB=new EldhoseFragment();
    S301116808Fragment fragmentC=new S301116808Fragment();
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.Basilpage_1:
                 getSupportFragmentManager().beginTransaction().replace(R.id.BasilmainFrame,fragmentA).commit();
                 return true;
            case R.id.Basilpage_2:
                getSupportFragmentManager().beginTransaction().replace(R.id.BasilmainFrame,fragmentB).commit();
                return true;
            case R.id.Basilpage_3:
                getSupportFragmentManager().beginTransaction().replace(R.id.BasilmainFrame,fragmentC).commit();
                return true;

        }
        return true;
    }




    public void loadFragmentOne() {

        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment fragmentA = fragmentManager.findFragmentByTag("frag1");

        if (fragmentA == null) {
            fragmentA = new BasilFragment();
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.BasilmainFrame, fragmentA, "frag1");
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN); //setting animation for fragment transaction
        transaction.addToBackStack(null);

        transaction.commit();
    }

    public void loadFragmentTwo() {

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back

        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment fragmentB = fragmentManager.findFragmentByTag("frag2");

        if (fragmentB == null) {
            fragmentB = new EldhoseFragment();
        }

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.BasilmainFrame, fragmentB, "frag2");
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN); //setting animation for fragment transaction
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void loadFragmentThree() {

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back

        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment fragmentC = fragmentManager.findFragmentByTag("frag3");

        if (fragmentC == null) {
            fragmentC = new S301116808Fragment();
        }

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.BasilmainFrame, fragmentC, "frag3");
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN); //setting animation for fragment transaction
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Activity")
                .setMessage("Are you sure you want to close this activity?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

}