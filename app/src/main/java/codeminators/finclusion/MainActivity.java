package codeminators.finclusion;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TickerView tickerView;
    Handler handler;

    double initialAmount = 2000;
    DecimalFormat df = new DecimalFormat("0.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
