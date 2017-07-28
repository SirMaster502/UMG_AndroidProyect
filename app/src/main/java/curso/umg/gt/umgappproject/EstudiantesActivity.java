package curso.umg.gt.umgappproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class EstudiantesActivity extends AppCompatActivity implements android.view.View.OnClickListener {

    RestService restService;
    TextView semestre_Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restService = new RestService();
        setContentView(R.layout.activity_estudiantes);

        //la llamada para cargar del servidor de datos los servicios
        restService.getService().getServicio(new Callback<List<Servicio>>() {
            @Override
            public void success(List<Servicio> servicios, Response response) {
                ListView lv = (ListView) findViewById(R.id.listView);

                EstudianteCustomAdapter estudiantesCustomAdapter = new EstudianteCustomAdapter(EstudiantesActivity.this, R.layout.activity_estudiante_view, servicios);
                lv.setAdapter(estudiantesCustomAdapter);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(EstudiantesActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        refreshScreen();
    }

    private void refreshScreen() {

        //la llamada para cargar del servidor de datos los servicios
        restService.getService().getServicio(new Callback<List<Servicio>>() {
            @Override
            public void success(List<Servicio> servicios, Response response) {
                ListView lv = (ListView) findViewById(R.id.listView);

                EstudianteCustomAdapter estudiantesCustomAdapter = new EstudianteCustomAdapter(EstudiantesActivity.this, R.layout.activity_estudiante_view, servicios);
                lv.setAdapter(estudiantesCustomAdapter);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(EstudiantesActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
