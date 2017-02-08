package mukhtar.exapple.com.quiz1_2semestr;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class FragmentStable extends Fragment{

    EditText editText;
    FragmentTransaction fragmentTransaction;
    int idOfFrameLayout;
    int type = 1;
    int color = Color.RED;
    FragmentChangable current;
    TextView tv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_stable, container, false);

        editText = (EditText) v.findViewById(R.id.editText);
        idOfFrameLayout =R.id.idOfFrameLayout;
        tv = (TextView) v.findViewById(R.id.showDate);
        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(idOfFrameLayout,getFragmentChangable());
        fragmentTransaction.commit();





        View.OnClickListener fragmentListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                switch(view.getId()){
                    case R.id.fragmentA:
                        type = 1;
                        color = Color.RED;
                        fragmentTransaction.replace(idOfFrameLayout,getFragmentChangable());
                        break;
                    case R.id.fragmentB:
                        type = 2;
                        color = Color.GREEN;
                        fragmentTransaction.replace(idOfFrameLayout,getFragmentChangable());
                        break;
                    case R.id.fragmentC:
                        type = 3;
                        color = Color.YELLOW;
                        fragmentTransaction.replace(idOfFrameLayout,getFragmentChangable());
                        break;
                }
                fragmentTransaction.commit();
            }
        };

        View.OnClickListener dataListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.buttonPickDate:
                        DatePickerFragment fragment = new DatePickerFragment();
                        fragment.show(getFragmentManager(),"date");
                        break;
                    case R.id.buttonAdd:

                        switch(type){
                            case 1:
                                MainActivity.frA.add(editText.getText().toString()+tv.getText().toString());
                                current.lv.setAdapter(new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1, MainActivity.frA));
                                break;
                            case 2:
                                MainActivity.frB.add(editText.getText().toString()+tv.getText().toString());
                                current.lv.setAdapter(new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1, MainActivity.frB));
                                break;
                            case 3:
                                MainActivity.frC.add(editText.getText().toString()+tv.getText().toString());
                                current.lv.setAdapter(new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1, MainActivity.frC));
                                break;

                        }
                        break;
                }

            }
        };

        (v.findViewById(R.id.fragmentA)).setOnClickListener(fragmentListener);
        (v.findViewById(R.id.fragmentB)).setOnClickListener(fragmentListener);
        (v.findViewById(R.id.fragmentC)).setOnClickListener(fragmentListener);
        (v.findViewById(R.id.buttonPickDate)).setOnClickListener(dataListener);
        (v.findViewById(R.id.buttonAdd)).setOnClickListener(dataListener);

        return v;
    }
    public FragmentChangable getFragmentChangable(){
        current = new FragmentChangable();
        Bundle bundle = new Bundle();
        bundle.putInt("type",type);
        bundle.putInt("color",color);
        current.setArguments(bundle);
        return current;
    }



    public static class DatePickerFragment extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(),
                    (DatePickerDialog.OnDateSetListener)getActivity(),
                    year,
                    month,
                    day);
        }
    }

}
