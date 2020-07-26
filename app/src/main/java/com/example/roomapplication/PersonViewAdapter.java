package com.example.roomapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonViewAdapter extends RecyclerView.Adapter<PersonViewHolder> {
    private List<Person> dataSet;

    public PersonViewAdapter(List<Person> dataSet) {
        this.dataSet = dataSet;
    }


    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_item, parent, false);
        PersonViewHolder viewHolder = new PersonViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Person person = dataSet.get(position);
        holder.setName(person.getName());
        holder.setGender(String.valueOf(person.getGender()));
        holder.setAge(String.valueOf(person.getAge()));
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
