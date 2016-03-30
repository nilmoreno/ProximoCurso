package com.example.alumne.proximocurso;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment{
    List<Map<String,Object>> data;
    String[] titles = {"dam","daw","informatica","multimedia"};
    String[] images = {"ic_dam","ic_daw","ic_informatica","ic_multimedia"};

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        SimpleAdapter adapter = new SimpleAdapter (this.getActivity(),
                data,
                android.R.layout.activity_list_item,
                new String[] {"image","title"},
                new int[] {android.R.id.icon,android.R.id.title});

        //hacemos this.getActivity en vez de this, porque estamos en la MainFragment y this en este momento es la MainFragment
        //y tiene que ser la Mainactivity.
        ListView listView = (ListView) this.getActivity().findViewById(R.id.listView);

        //añadimos el adapter a nuestra view.
        listView.setAdapter(adapter);


    }

}
