package codeminators.finclusion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.appyvet.rangebar.RangeBar;

public class InvestmentsActivity extends AppCompatActivity {


    RangeBar timebar, moneybar;
    GaddiView gaddiView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investments);

        timebar = (RangeBar) findViewById(R.id.rangebarTime);
        moneybar = (RangeBar) findViewById(R.id.rangebarMoney);
        gaddiView = (GaddiView) findViewById(R.id.gaddiView);

        timebar.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex,
                                              int rightPinIndex,
                                              String leftPinValue, String rightPinValue) {
                if (rightPinIndex <= 25) {
                    gaddiView.setCoinLevel(1);
                } else if (rightPinIndex > 25) {
                    gaddiView.setCoinLevel(2);
                } else if (rightPinIndex > 50) {
                    gaddiView.setCoinLevel(3);
                } else if (rightPinIndex > 75) {
                    gaddiView.setCoinLevel(4);
                }
            }
        });

        moneybar.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex,
                                              int rightPinIndex,
                                              String leftPinValue, String rightPinValue) {
            }
        });
    }
}
