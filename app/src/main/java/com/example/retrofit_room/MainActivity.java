package com.example.retrofit_room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;

import java.util.List;

import model.Department;
import model.DepartmentPost;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.DepartmentService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DepartmentService service = RetrofitConfig
                .newInstance()
                .departmentService();

        //createDepartment(service);
        getDepartmentById(service);

        service.getAllDepartments().enqueue(new Callback<List<Department>>() {
            @Override
            public void onResponse(Call<List<Department>> call, Response<List<Department>> response) {
                List<Department> lista = response.body();

                for (Department item : lista
                ) {
                    Log.i(">>>", item.getName());
                }
            }

            @Override
            public void onFailure(Call<List<Department>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Falha na Request!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    ;

    private void createDepartment(DepartmentService service) {
        DepartmentPost dto = new DepartmentPost();
        dto.setName("Mirellla Departamento");
        service.createDepartment(dto).enqueue(new Callback<Department>() {
            @Override
            public void onResponse(Call<Department> call, Response<Department> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(
                            getApplicationContext(),
                            "Departamento Criado com Sucesso!",
                            Toast.LENGTH_LONG
                    ).show();
                } else {
                    Toast.makeText(
                            getApplicationContext(),
                            "Erro ao criar um Departamento",
                            Toast.LENGTH_LONG
                    ).show();
                }
            }

            @Override
            public void onFailure(Call<Department> call, Throwable t) {

            }
        });

    }

    private void getDepartmentById(DepartmentService service) {
        Long id = 1675L;
        service.getDepartmentByID(id).enqueue(new Callback<Department>() {

            @Override
            public void onResponse(Call<Department> call, Response<Department> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(
                            getApplicationContext(),
                            response.body().getName(),
                            Toast.LENGTH_LONG
                    ).show();
                } else {
                    Toast.makeText(
                            getApplicationContext(),
                            "Departamento inexistente",
                            Toast.LENGTH_LONG
                    ).show();

                }

            }

            @Override
            public void onFailure(Call<Department> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Falha na Request!", Toast.LENGTH_SHORT).show();

            }
        }
        );
    }

}
