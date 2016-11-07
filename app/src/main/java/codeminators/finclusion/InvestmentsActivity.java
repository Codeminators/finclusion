package codeminators.finclusion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.appyvet.rangebar.RangeBar;

public class InvestmentsActivity extends AppCompatActivity {


    RangeBar timebar, moneybar;
    GaddiView gaddiView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investments);

        Intent mIntent = getIntent();
        int investmentNum = mIntent.getIntExtra("investmentNum", 0);
        TextView investmentDescription = (TextView) findViewById(R.id.investmentDescription);
        switch (investmentNum) {
            case 0:
                investmentDescription.setText(R.string.mutual_liquid_funds);
                break;
            case 1:
                investmentDescription.setText(R.string.public_provident_fund);
                break;
            case 2:
                investmentDescription.setText(R.string.fixed_deposit);
                break;

        }
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
