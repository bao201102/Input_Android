package bao201102.gmail.com.testinput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tv_Age;
    EditText editText_Name, editText_Phone;
    Switch switch_Gender;
    Spinner spinner_Level;
    SeekBar seekBar_Age;
    CheckBox checkBox_Sport;
    RadioGroup radioBtnGr;
    RadioButton radioBtn_Pop, radioBtn_Rap, radioBtn_Rock, radioBtn;
    Button btn_Register, btn_Cancel;
    ArrayList<String> arrayList = new ArrayList<>();
    String music;
    Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_Name = findViewById(R.id.editText_Name);
        editText_Phone = findViewById(R.id.editText_Phone);
        checkBox_Sport = findViewById(R.id.checkBox_Sport);
        radioBtnGr = findViewById(R.id.radioBtnGr);
        radioBtn_Rap = findViewById(R.id.radioBtn_Rap);
        radioBtn_Pop = findViewById(R.id.radioBtn_Pop);
        radioBtn_Rock = findViewById(R.id.radioBtn_Rock);
        spinner_Level = findViewById(R.id.spinner_Level);
        seekBar_Age = findViewById(R.id.seekBar_Age);
        switch_Gender = findViewById(R.id.switch_Gender);
        btn_Register = findViewById(R.id.btn_Register);
        btn_Cancel = findViewById(R.id.btn_Cancel);
        tv_Age = findViewById(R.id.tv_Age);

        btn_Cancel.setOnClickListener(clickListener);
        btn_Register.setOnClickListener(clickListener);

        //spinner
        arrayList.add("Cao đẳng");
        arrayList.add("Đại học");
        arrayList.add("Cao học");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_Level.setAdapter(arrayAdapter);
        spinner_Level.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String _level = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected: " + _level,Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });

        //SeekBar
        seekBar_Age.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_Age.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });

        //RadioButton
        radioBtnGr = findViewById(R.id.radioBtnGr);

        radioBtnGr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radioBtn_Pop:
                        music = radioBtn_Pop.getText().toString();
                        break;
                    case R.id.radioBtn_Rap:
                        music = radioBtn_Rap.getText().toString();
                        break;
                    case R.id.radioBtn_Rock:
                        music = radioBtn_Rock.getText().toString();
                        break;
                }
            }
        });
    }

    public View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn_Register){
                String name = editText_Name.getText().toString();
                String phone = editText_Phone.getText().toString();
                Boolean gender = switch_Gender.isChecked();
                String level = spinner_Level.getSelectedItem().toString();
                String age = tv_Age.getText().toString();
                Boolean sport = checkBox_Sport.isChecked();

                person = new Person(name,phone,gender,level,age,sport,music);

                Intent i = new Intent(v.getContext(),PersonActivity.class);
                i.putExtra("person", person);
                startActivity(i);
            } else if (v.getId() == R.id.btn_Cancel){
                editText_Name.setText("");
                editText_Phone.setText("");
                switch_Gender.setChecked(false);
                spinner_Level.setSelection(0);
                seekBar_Age.setProgress(1);
                checkBox_Sport.setChecked(false);
                radioBtn_Rock.setChecked(true);
            }
        }
    };
}