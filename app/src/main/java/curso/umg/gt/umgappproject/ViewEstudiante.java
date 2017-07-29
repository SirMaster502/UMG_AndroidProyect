package curso.umg.gt.umgappproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;


public class ViewEstudiante extends AppCompatActivity {

    private TextView tv_id,tv_nom,tv_app,tv_edad, tv_user, tv_pass;
    private String se_id,se_nom,se_app,se_edad,se_user,se_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_estudiante);

        tv_id = (TextView) findViewById(R.id.e_etId);
        tv_nom = (TextView) findViewById(R.id.e_etNombres);
        tv_app = (TextView) findViewById(R.id.e_etApellidos);
        tv_edad = (TextView) findViewById(R.id.e_etEdad);
        tv_user = (TextView) findViewById(R.id.e_etUserName);
        tv_pass = (TextView) findViewById(R.id.e_etPassword);

        Intent objIntent = this.getIntent();

        se_id = objIntent.getStringExtra("id");
        se_nom = objIntent.getStringExtra("nombres");
        se_app = objIntent.getStringExtra("apellidos");
        se_edad = objIntent.getStringExtra("edad");
        se_user = objIntent.getStringExtra("username");
        se_pass = objIntent.getStringExtra("password");

        tv_id.setText(se_id);
        tv_nom.setText(se_nom);
        tv_app.setText(se_app);
        tv_edad.setText(se_edad);
        tv_user.setText(se_user);
        tv_pass.setText(se_pass);

    }
    public void updateEstudiante(View view){
        String uid =  tv_id.getText().toString();
        String unom =  tv_nom.getText().toString();
        String uapp =  tv_app.getText().toString();
        String uedad =  tv_edad.getText().toString();
        String uuser =  tv_user.getText().toString();
        String upass =  tv_pass.getText().toString();
        String tipoOperacion = "update";
        ConexionLogin conexionLogin = new ConexionLogin(this);
        conexionLogin.execute(tipoOperacion, uid, unom,uapp,uedad,uuser,upass);

    }

    public void deleteEstudiante(View view){
        String did =  tv_id.getText().toString();
        String tipoOperacion = "delete";
        ConexionLogin conexionLogin = new ConexionLogin(this);
        conexionLogin.execute(tipoOperacion, did);

    }

    public void confirmDeleteEstudiante(final View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("¿Esta seguro de eliminar el estudiante?");

        alertDialogBuilder.setPositiveButton("Si",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        deleteEstudiante(view);
                    }
                });

        alertDialogBuilder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
