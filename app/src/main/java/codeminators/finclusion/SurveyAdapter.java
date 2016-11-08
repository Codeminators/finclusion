package codeminators.finclusion;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by pujamathur on 08/11/16.
 */

public class SurveyAdapter extends RecyclerView.Adapter<SurveyAdapter.ViewHolder> {
    private ArrayList<String> mDataset;

    public SurveyAdapter(ArrayList<String> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.optionText.setText(mDataset.get(position));
        switch (position){
            case 0 : holder.optionImage.setImageResource(R.drawable.girl);
                break;
            case 1 : holder.optionImage.setImageResource(R.drawable.woman);
                break;
            case 2 : holder.optionImage.setImageResource(R.drawable.gas);
                break;
            case 3 : holder.optionImage.setImageResource(R.drawable.suit);
                break;
            case 4 : holder.optionImage.setImageResource(R.drawable.notes);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView optionImage;
        public TextView optionText;
        public CheckBox optionSelect;

        public ViewHolder(View v) {
            super(v);
            optionImage = (ImageView) v.findViewById(R.id.optionImage);
            optionText = (TextView) v.findViewById(R.id.optionText);
            optionSelect = (CheckBox) v.findViewById(R.id.optionSelect);
        }
    }
}
