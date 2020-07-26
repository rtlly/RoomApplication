package com.example.roomapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonViewHolder extends RecyclerView.ViewHolder {
    private TextView personName;
    private TextView personGender;
    private TextView personAge;

    public PersonViewHolder(@NonNull View itemView) {
        super(itemView);
        personName = itemView.findViewById(R.id.person_name);
        personGender = itemView.findViewById(R.id.person_gender);
        personAge = itemView.findViewById(R.id.person_age);
    }

    public void setName(String name) {
        personName.setText(name);
    }

    public void setGender(String gender) {
        personGender.setText(gender);
    }

    public void setAge(String age) {
        personAge.setText(age);
    }
}
