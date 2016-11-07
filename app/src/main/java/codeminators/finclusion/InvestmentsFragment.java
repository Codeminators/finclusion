package codeminators.finclusion;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.View;
import android.widget.TextView;

/**
 * Created by naman on 08/11/16.
 */

public class InvestmentsFragment extends BottomSheetDialogFragment {

    private BottomSheetBehavior mBehavior;
    private TextView mlf, ppf, fd;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);

        View view = View.inflate(getContext(), R.layout.fragment_investment_bottom, null);

        mlf = (TextView) view.findViewById(R.id.txt_mlf);
        ppf = (TextView) view.findViewById(R.id.txt_ppf);
        fd = (TextView) view.findViewById(R.id.txt_fd);

        dialog.setContentView(view);
        mBehavior = BottomSheetBehavior.from((View) view.getParent());

        mlf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), InvestmentsActivity.class));
                dismiss();
            }
        });
        ppf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), InvestmentsActivity.class));
                dismiss();
            }
        });
        fd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), InvestmentsActivity.class));
                dismiss();
            }
        });

        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();
        mBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }
}
