package codeminators.finclusion;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by naman on 08/11/16.
 */

public class GaddiView extends LinearLayout {

    private int level = 1;

    public GaddiView(Context context) {
        super(context);
        setOrientation(HORIZONTAL);

    }

    public GaddiView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(HORIZONTAL);

    }

    public void setCoinLevel(int level) {
        this.level = level;
        redraw();
    }

    private void redraw() {

        LayoutParams params = (LinearLayout.LayoutParams) getLayoutParams();
        params.weight = 0.25f;
        setLayoutParams(params);

        ImageView img1 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.item_image, null);
        img1.setImageResource(R.drawable.coin_1);
        ImageView img2 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.item_image, null);
        img2.setImageResource(R.drawable.coin_2);
        ImageView img3 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.item_image, null);
        img3.setImageResource(R.drawable.coin_3);
        ImageView img4 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.item_image, null);
        img4.setImageResource(R.drawable.coin_4);

        removeAllViews();

        switch (level) {
            case 1:
                addView(img1);
                break;
            case 2:
                addView(img1);
                addView(img2);
                break;
            case 3:
                addView(img1);
                addView(img2);
                addView(img3);
                break;
            case 4:
                addView(img1);
                addView(img2);
                addView(img3);
                addView(img4);
                break;
        }

    }
}
