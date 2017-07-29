package curso.umg.gt.umgappproject;


import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class ListaUsuarios extends AppCompatActivity {
    ListView lv;
    ArrayAdapter<String> adapter;
    ArrayList<HashMap<String,String>> listStu = new ArrayList<HashMap<String, String>>();
    String listU = "http://umgandroid.txolja.com/listUsers.php";
    InputStream is = null;
    String line = null;
    String result =null;
    String[] data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);
        lv = (ListView) findViewById(R.id.lvUser);

        //Allow network in main thread
        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        //Retrive
        getDataUser();

        //adapter
//        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);
//        lv.setAdapter(adapter);

        //adapter 2

        ListAdapter adapter1 = new SimpleAdapter(
                ListaUsuarios.this,listStu,
                R.layout.list_item,
                new String[]{"id","nombres","apellidos","edad","username"},
                new int[]
                        {R.id.ee_id,R.id.ee_nombres,R.id.ee_apellidos,R.id.ee_edad,R.id.ee_username});
        lv.setAdapter(adapter1);



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListaUsuarios.this, ViewEstudiante.class);
                HashMap<String, String> map = (HashMap) adapterView.getItemAtPosition(i);
                String esId = map.get("id").toString();
                String esNom = map.get("nombres").toString();
                String esApp = map.get("apellidos").toString();
                String esEdad = map.get("edad").toString();
                String esUser = map.get("username").toString();
                String esPass = map.get("password").toString();
                intent.putExtra("id", esId);
                intent.putExtra("nombres", esNom);
                intent.putExtra("apellidos", esApp);
                intent.putExtra("edad", esEdad);
                intent.putExtra("username", esUser);
                intent.putExtra("password", esPass);
                startActivity(intent);
            }
        });


    }

    private void getDataUser(){
        try {
            URL url = new URL(listU);
            HttpURLConnection con=(HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            is=new BufferedInputStream(con.getInputStream());



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Leer el contenido
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();

            while ((line =br.readLine())!= null ){
                sb.append(line+"\n");
            }
            is.close();
            result = sb.toString();
        }catch (Exception e){
            e.printStackTrace();
        }

        //Parse Json Data
        try{
            JSONArray ja = new JSONArray(result);
            JSONObject jo = null;

            data = new String[ja.length()];

            for (int i=0; i<ja.length();i++){
                jo=ja.getJSONObject(i);
                String id = (jo.getString("id"));
                String name = jo.getString("nombres");
                String ape = jo.getString("apellidos");
                String edad = jo.getString("edad");
                String username = jo.getString("username");
                String password = jo.getString("password");
                data[i]= "Id: "+id
                        +"\nNombres: "+name
                        +"\nApellidos: "+ape
                        +"\nFecha de Nacimiento: "+edad
                        +"\nUsername: "+username
                        +"\nPassword:"+password;
                HashMap<String,String> students = new HashMap<>();
                students.put("id",id);
                students.put("nombres",name);
                students.put("apellidos",ape);
                students.put("edad",edad);
                students.put("username",username);
                students.put("password",password);
                listStu.add(students);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
