package curso.umg.gt.umgappproject;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
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

public class ServiciosActivity extends AppCompatActivity implements android.view.View.OnClickListener {

    Button btListar, btAgregar;
    RestService restService;
    TextView semestre_Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restService = new RestService();
        setContentView(R.layout.activity_servicios);

//        btListar = (Button) findViewById(R.id.btnListar);
//        btListar.setOnClickListener(this);


    }

    public void openListaEstudiantes(View view) {
        startActivity(new Intent(this,ListaUsuarios.class));
    }

    public void openRegistroEstudiante(View view) {
        startActivity(new Intent(this,Registro.class));
    }

    @Override
    public void onResume() {

        super.onResume();
        refreshScreen();
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

                CustomAdapter customAdapter = new CustomAdapter(ServiciosActivity.this, R.layout.activity_servicios_view, servicios);

                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        semestre_Id = (TextView) view.findViewById(R.id.semestre_Id);
                        String serviceId = semestre_Id.getText().toString();
                        Intent objIndent = new Intent(getApplicationContext(), DetalleServiciosActivity.class);
                        objIndent.putExtra("semestre_Id", Integer.parseInt(serviceId));
                        startActivity(objIndent);
                    }
                });
                lv.setAdapter(customAdapter);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(ServiciosActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
