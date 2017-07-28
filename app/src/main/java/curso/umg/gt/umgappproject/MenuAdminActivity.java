package curso.umg.gt.umgappproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MenuAdminActivity extends AppCompatActivity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);

    }

    public void goAddService(View view) {
        Intent intent = new Intent(getApplicationContext(), DetalleServiciosActivity.class);
        startActivity(intent);
    }

    public void goAdduser (View view){
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
    }

    public void listUser (View view){
        Intent intent = new Intent(this, ListaUsuarios.class);
        startActivity(intent);
    }

    public void listservices (View view){
        Intent intent = new Intent(this, ServiciosActivity.class);
        startActivity(intent);
    }

}
