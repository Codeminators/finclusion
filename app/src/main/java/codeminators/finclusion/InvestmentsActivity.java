package codeminators.finclusion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.appyvet.rangebar.RangeBar;

public class InvestmentsActivity extends AppCompatActivity {


    RangeBar timebar, moneybar;
    GaddiView gaddiView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investments);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Invest");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        timebar = (RangeBar) findViewById(R.id.rangebarTime);
        moneybar = (RangeBar) findViewById(R.id.rangebarMoney);
        gaddiView = (GaddiView) findViewById(R.id.gaddiView);

        timebar.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex,
                                              int rightPinIndex,
                                              String leftPinValue, String rightPinValue) {

            }
        });
        timebar.setSeekPinByValue(0);

        moneybar.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex,
                                              int rightPinIndex,
                                              String leftPinValue, String rightPinValue) {
                if (Integer.parseInt(rightPinValue) <= 750) {
                    gaddiView.setCoinLevel(1);
                } else if (Integer.parseInt(rightPinValue) > 750 && Integer.parseInt(rightPinValue) <= 1000) {
                    gaddiView.setCoinLevel(2);
                } else if (Integer.parseInt(rightPinValue) > 1000 && Integer.parseInt(rightPinValue) <= 1500) {
                    gaddiView.setCoinLevel(3);
                } else if (Integer.parseInt(rightPinValue) > 1500) {
                    gaddiView.setCoinLevel(4);
                }
            }
        });
        moneybar.setSeekPinByValue(500);

        gaddiView.setCoinLevel(1);
    }
}
