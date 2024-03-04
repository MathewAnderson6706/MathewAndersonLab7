//Mathew Anderson, n01436706
package mathew.anderson.n01436706;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PersonFragment extends Fragment {

    private ListView listView;

    String[] locations;


    public PersonFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_person, container, false);

        locations = getResources().getStringArray(R.array.provinces_and_territories);
        listView = view.findViewById(R.id.mathewListView1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, locations);
        //bind the list view with array adapter
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3)
            {
                listView.setSelector(android.R.color.holo_blue_dark);
                // Pass selected concept and definition to the second fragment
                String selectedLocation = locations[position];
                int index = position + 1;
                Bundle result = new Bundle();
                Bundle result2 = new Bundle();
                result.putString("df1", selectedLocation);
                result2.putInt("df2", index);
                getParentFragmentManager().setFragmentResult("dataFrom1", result);
                getParentFragmentManager().setFragmentResult("dataFrom2", result2);
            }
        });

        return view;
    }
}