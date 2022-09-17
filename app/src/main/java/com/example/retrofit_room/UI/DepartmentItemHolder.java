package com.example.retrofit_room.UI;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit_room.MainActivity;
import com.example.retrofit_room.R;

public class DepartmentItemHolder extends RecyclerView.ViewHolder {

    private TextView tvName;
    private ConstraintLayout clContainer;
    private View view;

    public DepartmentItemHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
        clContainer = itemView.findViewById(R.id.clContainer);
        tvName = itemView.findViewById(R.id.tvDepartmentName);

    }

    public void setupItem(String name) {
        tvName.setText(name);
        clContainer.setOnClickListener(view -> {
            Intent newScreen = new Intent(view.getContext(), MainActivity.class);
            view.getContext().startActivity(newScreen);
        });

    }

    public TextView getTvName() {
        return tvName;
    }
}
