package com.example.roomapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

public class SubmitActivity extends AppCompatActivity {
    private EditText name;
    private EditText gender;
    private EditText age;
    private RoomApplication application;
    private final int GENDER_FEMALE = 0;
    private final int GENDER_MALE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        application = (RoomApplication) getApplication();
        name = findViewById(R.id.name);
        gender = findViewById(R.id.gender);
        age = findViewById(R.id.age);

        Button submit = findViewById(R.id.create_person);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPerson();
            }
        });
    }

    private void createPerson() {
        int genderValue = Integer.valueOf(gender.getText().toString());
        int ageValue = Integer.valueOf(age.getText().toString());

        if (!validInput()) {
            return;
        }
        Person newPerson = new Person(name.getText().toString(), genderValue, ageValue);

        LocalDataSource localDataSource = application.getLocalDataSource();

        localDataSource.personDao().createPerson(newPerson)
        .subscribe(insertObserver());
    }

    private SingleObserver<Long> insertObserver() {
        return new SingleObserver<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(Long aLong) {
                Toast toast = Toast.makeText(getApplicationContext(), "you have succeeded insert a person to database", Toast.LENGTH_SHORT);
                toast.show();
            }

            @Override
            public void onError(Throwable e) {
                Toast toast = Toast.makeText(getApplicationContext(), "sorry, you failed insert a person to database", Toast.LENGTH_SHORT);
                toast.show();
            }
        };
    }


    private boolean validInput() {
        boolean valid = true;
        int genderValue = Integer.valueOf(gender.getText().toString());
        int ageValue = Integer.valueOf(age.getText().toString());
        if (ageValue <= 0) {
            age.setError("age must be bigger than zero");
            valid = false;
        }

        if (genderValue != GENDER_FEMALE && genderValue != GENDER_MALE) {
            gender.setError("gender should be zero or one");
            valid = false;
        }

        return valid;
    }
}
