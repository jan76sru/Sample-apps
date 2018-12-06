package srujan.com.droidcafef;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class oderActivity extends AppCompatActivity implements  AdapterView.OnItemSelectedListener {
 private  String spinnerLabel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oder);
        Intent intent = getIntent();
        String message = "Order: " + intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);


        Spinner spinner = findViewById(R.id.label_spinner);

        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        //create arrayadapter using string array and default spinner layout

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.labels_array, android.R.layout.simple_spinner_item);
        // specifying the layout for dropdown
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // apply the adpater to the spinner
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }


    }


    public void onRadioButtonClicked(View view) {

        // is button checked
        boolean checked = ((RadioButton) view).isChecked();

        // check which radio button is clicked
        switch (view.getId()) {

            case R.id.sameday:
                if (checked)
                    displayToast(getString(R.string.same_day_messenger_service));
                break;

            case R.id.nextday:
                if (checked)
                    displayToast(getString(R.string.next_day_ground_delivery));
                break;

            case R.id.pickup:
                if (checked)
                    displayToast(getString(R.string.pick_up));
                break;

            default:
                // do nothing
                break;


        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        spinnerLabel = adapterView.getItemAtPosition(i).toString();
        displayToast(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
