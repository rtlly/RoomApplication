package com.example.roomapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class ViewActivity extends AppCompatActivity {
    private List<Person> persons = new ArrayList<>();
    private RoomApplication application;
    private RecyclerView personView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        application = (RoomApplication) getApplication();

        findAllPersons();

        personView = findViewById(R.id.person_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        personView.setLayoutManager(linearLayoutManager);
    }

    private void findAllPersons() {
        LocalDataSource localDataSource = application.getLocalDataSource();
        Observer<List<Person>> personObserver = new Observer<List<Person>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Person> people) {
                persons = people;
                PersonViewAdapter adapter = new PersonViewAdapter(persons);
                personView.setAdapter(adapter);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        localDataSource.personDao().findAllPersons()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(personObserver);
    }
}
