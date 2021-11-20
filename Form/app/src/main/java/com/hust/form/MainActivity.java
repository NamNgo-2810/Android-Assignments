package com.hust.form;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextStudentID, editTextDOB, editTextAddress, editTextPhone, editTextEmail;
    RadioButton radioButtonMale, radioButtonFemale, radioButtonOther;
    CheckBox checkBoxSport, checkBoxTravel, checkBoxMusic, checkBoxAgree;
    Button buttonContinue;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextStudentID = findViewById(R.id.editTextStudentID);
        editTextDOB = findViewById(R.id.editTextDOB);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextEmail = findViewById(R.id.editTextEmailAddress);

        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        radioButtonOther = findViewById(R.id.radioButtonOther);

        checkBoxSport = findViewById(R.id.checkBoxSport);
        checkBoxTravel = findViewById(R.id.checkBoxTravel);
        checkBoxMusic = findViewById(R.id.checkBoxMusic);

        checkBoxAgree = findViewById(R.id.checkBoxAgree);
        buttonContinue = findViewById(R.id.buttonContinue);

        checkBoxAgree.setOnCheckedChangeListener((compoundButton, b) -> {
            if (checkBoxAgree.isChecked()) {
                buttonContinue.setClickable(true);
                buttonContinue.setBackgroundColor(R.color.teal_200);
            }
            else {
                buttonContinue.setClickable(false);
                buttonContinue.setBackgroundColor(R.color.darker_gray);
            }
        });

        buttonContinue.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            String studentID = editTextStudentID.getText().toString();
            String DOB = editTextDOB.getText().toString();
            String phone = editTextPhone.getText().toString();

            if (name.length() == 0 || studentID.length() == 0
                    || DOB.length() == 0 || phone.length() == 0
                    || (!radioButtonMale.isChecked() && !radioButtonFemale.isChecked() && !radioButtonOther.isChecked())) {
                Toast.makeText(this, "Please fill out all required fields", Toast.LENGTH_SHORT).show();
            }
        });
    }
}