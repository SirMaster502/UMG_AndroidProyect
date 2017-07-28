package curso.umg.gt.umgappproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class DetalleServiciosActivity extends AppCompatActivity implements android.view.View.OnClickListener{

    Button btGuardar, btEliminar;
    Button btCerrar;
    EditText editTextNombre;
    EditText editTextDescripcion;
    EditText editTextHorario;
    private int _Servicio_Id = 0;
    RestService restService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restService = new RestService();
        setContentView(R.layout.activity_detalle_servicios);

        btGuardar = (Button) findViewById(R.id.btnGuardar);
        btEliminar = (Button) findViewById(R.id.btnBorrar);
        btCerrar = (Button) findViewById(R.id.btnCerrar);

        editTextNombre = (EditText) findViewById(R.id.editTextServicio);
        editTextDescripcion = (EditText) findViewById(R.id.editTextDescripcion);
        editTextHorario = (EditText) findViewById(R.id.editTextHorario);

        btGuardar.setOnClickListener(this);
        btEliminar.setOnClickListener(this);
        btCerrar.setOnClickListener(this);

        _Servicio_Id = 0;
        Intent intent = getIntent();
        _Servicio_Id = intent.getIntExtra("semestre_Id", 0); //serv_id es el nombre del textview que se declara en ServiciosActivity
        if (_Servicio_Id>0){
            restService.getService().getServicioById(_Servicio_Id, new Callback<Servicio>() {
                @Override
                public void success(Servicio servicio, Response response) {
                    editTextNombre.setText(servicio.Nombre);
                    editTextDescripcion.setText(servicio.Descripcion);
                    editTextHorario.setText(servicio.Horario);
                }

                @Override
                public void failure(RetrofitError error) {
                    Toast.makeText(DetalleServiciosActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                }
            });
        }

    }

    @Override
    public void onClick(View view) {
        if (findViewById(R.id.btnBorrar) == view){
            restService.getService().deleteServicioById(_Servicio_Id, new Callback<Servicio>() {
                @Override
                public void success(Servicio servicio, Response response) {
                    Toast.makeText(DetalleServiciosActivity.this, "Se eliminó el servicio", Toast.LENGTH_LONG).show();
                }

                @Override
                public void failure(RetrofitError error) {
                    Toast.makeText(DetalleServiciosActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                }
            });

            finish();
        }else if (view == findViewById(R.id.btnCerrar)){
            finish();
        }else if (findViewById(R.id.btnGuardar) == view){
            Servicio servicio = new Servicio();
            Integer status = 0;
            servicio.Nombre = editTextNombre.getText().toString();
            servicio.Descripcion = editTextDescripcion.getText().toString();
            servicio.Horario = editTextHorario.getText().toString();
            servicio.Id_servicio = _Servicio_Id;

            if (_Servicio_Id == 0){
                restService.getService().addServicio(servicio, new Callback<Servicio>() {
                    @Override
                    public void success(Servicio servicio, Response response) {
                        Toast.makeText(DetalleServiciosActivity.this, "Se agregó el servicio", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(DetalleServiciosActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });
            }else {
                restService.getService().updateServicioById(_Servicio_Id, servicio, new Callback<Servicio>() {
                    @Override
                    public void success(Servicio servicio, Response response) {
                        Toast.makeText(DetalleServiciosActivity.this, "Se actualizó el servicio", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(DetalleServiciosActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        }
    }
}
