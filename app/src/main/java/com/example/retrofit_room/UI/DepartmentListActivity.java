package com.example.retrofit_room.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.retrofit_room.R;
import com.example.retrofit_room.RetrofitConfig;

import java.util.ArrayList;
import java.util.List;

import com.example.retrofit_room.model.Department;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.retrofit_room.service.DepartmentService;

public class DepartmentListActivity extends AppCompatActivity {

    private DepartmentAdapter adapter;
    private RecyclerView rvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_list);
        DepartmentService service = RetrofitConfig
                .newInstance()
                .departmentService();

        adapter = new DepartmentAdapter(new ArrayList<>());
        rvList = findViewById(R.id.rvDepartmentList);
        rvList.setAdapter(adapter);

        service.getAllDepartments().enqueue(new Callback<List<Department>>() {
            @Override
            public void onResponse(Call<List<Department>> call, Response<List<Department>> response) {
                List<Department> lista = response.body();

                adapter.configureDepartmentList(lista);

                for (Department item : lista
                ) {
                    Log.i(">>>", item.getName());
                }
            }

            @Override
            public void onFailure(Call<List<Department>> call, Throwable t) {
                Toast.makeText(DepartmentListActivity.this, "Falha na Request!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}