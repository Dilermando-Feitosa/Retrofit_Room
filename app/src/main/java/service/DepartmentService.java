package service;

import java.util.List;

import model.Department;
import model.DepartmentPost;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface DepartmentService {

    @GET("/departments")
    Call<List<Department>> getAllDepartments();

    @POST("/departments")
    Call<Department> createDepartment(@Body DepartmentPost dto);

    @GET("/departments/{department_id}")
    Call<Department> getDepartmentByID(@Path("department_id") Long id);

    @PUT("/departments/{department_id}")
    Call<Department> alterar(
            @Path("department_id") Long id,
            @Body DepartmentPost dto
    );

}
