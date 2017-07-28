package curso.umg.gt.umgappproject;

/**
 * Created by repre on 27/07/2017.
 */

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;

public interface InstituteServicio {

    @GET("/Servicios")
    public void getServicio(Callback<List<Servicio>> callback);

    @GET("/Servicios/{id}")
    public void getServicioById(@Path("id") Integer id, Callback<Servicio> callback);

    @DELETE("/Servicios/{id}")
    public void deleteServicioById(@Path("id") Integer id, Callback<Servicio> callback);

    @PUT("/Servicios/{id}")
    public void updateServicioById(@Path("id") Integer id, @Body Servicio student,Callback<Servicio> callback);

    @POST("/Servicios")
    public void addServicio(@Body Servicio student, Callback<Servicio> callback);
}
