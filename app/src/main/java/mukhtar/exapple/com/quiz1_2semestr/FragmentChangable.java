package mukhtar.exapple.com.quiz1_2semestr;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class FragmentChangable extends Fragment {
    ListView lv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_changable, container, false);
        lv = (ListView) v.findViewById(R.id.listviewData);
        Bundle b = getArguments();
        int type = b.getInt("type");
        int color = b.getInt("color");
        v.setBackgroundColor(color);
        fillListView(type);

        return v;
    }
    void fillListView(int type){
        switch(type){
            case 1:
                lv.setAdapter(new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1, MainActivity.frA));
                break;
            case 2:
                lv.setAdapter(new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1, MainActivity.frB));
                break;
            case 3:
                lv.setAdapter(new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1, MainActivity.frC));
                break;

        }
    }


}
