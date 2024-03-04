//Mathew Anderson, n01436706
package mathew.anderson.n01436706;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MathewFragment extends Fragment {

    RadioButton radioButton1, radioButton2, radioButton3;
    RadioGroup radioGroup;

    public MathewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mathew, container, false);

        radioButton1 = view.findViewById(R.id.mathewRadioButton1);
        radioButton2 = view.findViewById(R.id.mathewRadioButton2);
        radioButton3 = view.findViewById(R.id.mathewRadioButton3);
        radioGroup = view.findViewById(R.id.mathewRadioGroup);

        // Set the first radio button as selected by default
        radioButton1.setChecked(true);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedRadioButton = group.findViewById(checkedId);
                String selectedLabel = selectedRadioButton.getText().toString();
                showAlertDialog(selectedLabel);
            }
        });

        return view;
    }

    private void showAlertDialog(String selectedLabel) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());

        builder.setIcon(R.mipmap.ic_new_image);

        builder.setTitle(R.string.mathew_anderson);

        builder.setMessage(selectedLabel);

        // Set OK button
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Dismiss the dialog
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
    }
}