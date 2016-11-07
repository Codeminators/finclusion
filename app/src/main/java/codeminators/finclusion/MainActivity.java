package codeminators.finclusion;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TickerView tickerView;
    Handler handler;

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    double initialAmount = 2000;
    DecimalFormat df = new DecimalFormat("0.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //Closing drawer on item click
                drawerLayout.closeDrawers();
                switch(item.getItemId()){
                    case R.id.nav_home:
                        return true;
                    case R.id.nav_bank:
                        Intent intent = new Intent();
                        intent.setClassName("com.bankbazaar.app", "com.bankbazaar.app.mybb.primer.activity.AllCategoriesActivity");
                        startActivity(intent);
                        return true;
                    case R.id.nav_learn:
                        return true;
                }
                return false;
            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout, toolbar, R.string.app_name, R.string.app_name){

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();

        Button kysButton = (Button) findViewById(R.id.btn_kys);
        Button investmentsButton = (Button) findViewById(R.id.btn_invest_more);

        kysButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SchemesActivity.class));
            }
        });

        investmentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // show bottom sheet dialog
            }
        });

        tickerView = (TickerView) findViewById(R.id.tickerView);
        tickerView.setCharacterList(TickerUtils.getDefaultListForUSCurrency());
        handler = new Handler();
        handler.post(liveAmount);
    }

    private Runnable liveAmount = new Runnable() {
        @Override
        public void run() {
            tickerView.setText(df.format(calculateLiveAmount()));
            handler.postDelayed(this, 1000);
        }
    };

    private double calculateLiveAmount() {
        double rate = 4;

        double newAmount = initialAmount += 0.3;
        return newAmount;
    }
}
