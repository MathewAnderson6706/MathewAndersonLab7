//Mathew Anderson, n01436706
package mathew.anderson.n01436706;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;


public class SettingsFragment extends Fragment {

    private TextView clockTextView;
    private TextView provinceTextView;
    private TextView indexTextView;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        clockTextView = view.findViewById(R.id.clockTextView);
        provinceTextView = view.findViewById(R.id.provinceTextView);
        indexTextView = view.findViewById(R.id.indexTextView);

        getParentFragmentManager().setFragmentResultListener("dataFrom1", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {

                String data = result.getString("df1");
                provinceTextView.setText(data);
            }
        });

        getParentFragmentManager().setFragmentResultListener("dataFrom2", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                int data = result.getInt("df2");
                indexTextView.setText(String.valueOf(data));
            }
        });

        // Start clock update
        startClockUpdate();

        return view;
    }

    private void startClockUpdate() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                // Get current time
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String currentTime = sdf.format(new Date());
                // Update clock TextView
                clockTextView.setText(currentTime);
                // Schedule next update after 1 second
                handler.postDelayed(this, 1000);
            }
        });
    }
}