package codeminators.finclusion;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by naman on 08/11/16.
 */

public class GaddiView extends ImageView {

    private int level = 1;

    public GaddiView(Context context) {
        super(context);

    }

    public GaddiView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setCoinLevel(int level) {
        this.level = level;
        redraw();
    }

    private void redraw() {

        switch (level) {
            case 1:
                setImageResource(R.drawable.coin_1);
                break;
            case 2:
                setImageResource(R.drawable.coin_2);
                break;
            case 3:
                setImageResource(R.drawable.coin_3);
                break;
            case 4:
                setImageResource(R.drawable.coin_4);
                break;
        }

    }
}
