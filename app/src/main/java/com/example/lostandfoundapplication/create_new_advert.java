package com.example.lostandfoundapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class create_new_advert extends AppCompatActivity {
    RadioGroup post_type;
    RadioButton radioButton1;
    Button saveButton;
    EditText name_, phone_, description_, location_, date_;
    String Name,  Description, Location, Date;
    Integer Phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_advert);

        post_type = findViewById(R.id.Post_type);
        saveButton = findViewById(R.id.saveButton);
        name_ = findViewById(R.id.enter_name);
        phone_ = findViewById(R.id.enter_phone);
        description_ = findViewById(R.id.enter_description);
        location_ = findViewById(R.id.enter_Location);
        date_ = findViewById(R.id.enter_date);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Goodtype;
                int radioId = post_type.getCheckedRadioButtonId();
                radioButton1 = findViewById(radioId);
                Goodtype = radioButton1.getText().toString().trim();

                DataBaseForItems db = new DataBaseForItems(create_new_advert.this);

                Name = name_.getText().toString().trim();
                Phone = Integer.valueOf(phone_.getText().toString().trim());
                Description = description_.getText().toString().trim();
                Location = location_.getText().toString().trim();
                Date = date_.getText().toString().trim();

                db.add_Data1(
                        Name,
                        Goodtype,
                        Phone,
                        Description,
                        Date,
                        Location

                );


            }
        });


    }

    public void checkButton(View v){
        int radioId = post_type.getCheckedRadioButtonId();
        radioButton1 = findViewById(radioId);
        Toast.makeText(create_new_advert.this, "Selected radio Button: " + radioButton1.getText(), Toast.LENGTH_SHORT).show();
    }
}