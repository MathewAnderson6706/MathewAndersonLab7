//Mathew Anderson, n01436706
package mathew.anderson.n01436706;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

public class HomeFragment extends Fragment {

    private ProgressBar progressBar;
    private ImageButton imageButton;
    private int counter = 0;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // Initialize views
        progressBar = view.findViewById(R.id.progressBar);
        imageButton = view.findViewById(R.id.imageButton);

        // Set click listener for ImageButton
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Increment counter
                counter++;

                // Show toast with name + counter
                if (counter <= 8) {
                    String message = getString(R.string.first_name) + " " + counter;
                    Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                }

                // Hide progress bar when counter reaches 5
                if (counter == 5) {
                    progressBar.setVisibility(View.GONE);
                }

                // Exit application when counter reaches 8
                if (counter == 8) {
                    getActivity().finishAffinity();
                }
            }
        });

        return view;
    }
}