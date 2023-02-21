package bao201102.gmail.com.testinput;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

public class PersonActivity extends AppCompatActivity {
    TextView tv_Name, tv_Phone, tv_Gender, tv_Age, tv_Sport, tv_Music, tv_Level;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        tv_Name = findViewById(R.id.tv_Name);
        tv_Phone = findViewById(R.id.tv_Phone);
        tv_Gender = findViewById(R.id.tv_Gender);
        tv_Age = findViewById(R.id.tv_Age);
        tv_Sport = findViewById(R.id.tv_Sport);
        tv_Music = findViewById(R.id.tv_Music);
        tv_Level = findViewById(R.id.tv_Level);

        Person person =(Person) getIntent().getSerializableExtra("person");

        tv_Name.setText(person.name);
        tv_Phone.setText(person.phone);
        if (person.gender)
            tv_Gender.setText("Nữ");
        else
            tv_Gender.setText("Nam");
        tv_Level.setText(person.level);
        tv_Age.setText(person.age);
        if (person.sport)
            tv_Sport.setText("Có");
        else
            tv_Sport.setText("Không");
        tv_Music.setText(person.music);

    }
}