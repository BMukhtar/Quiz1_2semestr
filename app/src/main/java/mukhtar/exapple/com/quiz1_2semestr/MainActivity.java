package mukhtar.exapple.com.quiz1_2semestr;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    static ArrayList frA = new ArrayList();
    static ArrayList frB = new ArrayList();
    static ArrayList frC = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    private  void setDate(final Calendar calendar){
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        ((TextView) findViewById(R.id.showDate)).setText(dateFormat.format(calendar.getTime()));
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        Calendar cal = new GregorianCalendar(year,month,day);
        setDate(cal);
    }

}
