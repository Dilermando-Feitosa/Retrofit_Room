package com.example.retrofit_room.UI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit_room.R;

import java.util.List;

import com.example.retrofit_room.model.Department;

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentItemHolder> {

    private List<Department> departments;

    public DepartmentAdapter(List<Department> departments) {
        this.departments = departments;
    }

    public void configureDepartmentList(List<Department> departments) {
        this.departments = departments;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public DepartmentItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext())
                .inflate(
                        R.layout.departmentitem,
                        parent,
                        false
                );
        return new DepartmentItemHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentItemHolder holder, int position) {
        Department department = departments.get(position);

        holder.setupItem(department.getName());

    }


    @Override
    public int getItemCount() {

        return departments.size();
    }
}
