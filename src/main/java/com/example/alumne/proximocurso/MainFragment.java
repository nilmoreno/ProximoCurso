package com.example.alumne.proximocurso;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener{
    //List<Map<String,Object>> data;

    ArrayList<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
    HashMap<String, Object> data2 = new HashMap<String, Object>();

    String[] titles = new String[] {"dam","daw","informatica","multimedia"};
    String[] images = new String[] {"ic_dam","ic_daw","ic_informatica","ic_multimedia"};

    private OnMasterFragmentListener mCallback;

    public MainFragment() {
        // Required empty public constructor
    }

    public interface OnMasterFragmentListener {
        public void onSendButtonClicked(String message);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        //for testing
        for(int i=0;i<4;i++)
        {
            data2.put(images[i],titles[i]);
            data.add(data2);
        }

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

    @Override
    public void onClick(View v) {

       // String message = editText.getText().toString();
        String message = "";
        if (!message.isEmpty()){
            //Comunicate with the activity
            this.mCallback.onSendButtonClicked(message);
        }else {
            //Show error message: The message is empty!
            Toast toast = Toast.makeText(getActivity(), "El mensaje está vacío", Toast.LENGTH_LONG);
            toast.show();
        }

    }
}
