package curso.umg.gt.umgappproject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by L99 on 7/24/2017.
 */

public class ConexionLogin extends AsyncTask<String, Void, String> {
    Context context;
    AlertDialog alertDialog;

    ConexionLogin(Context ctx) {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String login_url = "http://umgandroid.txolja.com/login.php";
        String registro_url = "http://umgandroid.txolja.com/register.php";
        String update_url = "http://umgandroid.txolja.com/update.php";
        String delete_url = "http://umgandroid.txolja.com/delete.php";
        if (type.equals("login")) {
            try {
                String user_name = params[1];
                String user_pass = params[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&" + URLEncoder.encode("user_pass", "UTF-8") + "=" + URLEncoder.encode(user_pass, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (type.equals("registro")) {
            try {
                String usr_nombres = params[1];
                String usr_apellidos = params[2];
                String usr_edad = params[3];
                String usr_username = params[4];
                String usr_password = params[5];
                URL url = new URL(registro_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data =
                        URLEncoder.encode("u_nombres", "UTF-8") + "=" + URLEncoder.encode(usr_nombres, "UTF-8") + "&"
                                +URLEncoder.encode("u_apellidos", "UTF-8") + "=" + URLEncoder.encode(usr_apellidos, "UTF-8") + "&"
                                +URLEncoder.encode("u_edad", "UTF-8") + "=" + URLEncoder.encode(usr_edad, "UTF-8") + "&"
                                +URLEncoder.encode("u_username", "UTF-8") + "=" + URLEncoder.encode(usr_username, "UTF-8") + "&"
                                + URLEncoder.encode("u_password", "UTF-8") + "=" + URLEncoder.encode(usr_password, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (type.equals("delete")) {
            try {
                String delete_id = params[1];
                URL url = new URL(delete_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("delete_id", "UTF-8") + "=" + URLEncoder.encode(delete_id, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (type.equals("update")) {
            try {
                String del_id = params[1];
                String del_nom = params[2];
                String del_app = params[3];
                String del_edad = params[4];
                String del_user = params[5];
                String del_pass = params[6];
                URL url = new URL(update_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data =
                        URLEncoder.encode("del_id", "UTF-8") + "=" + URLEncoder.encode(del_id, "UTF-8") + "&"
                                +URLEncoder.encode("del_nom", "UTF-8") + "=" + URLEncoder.encode(del_nom, "UTF-8") + "&"
                                +URLEncoder.encode("del_app", "UTF-8") + "=" + URLEncoder.encode(del_app, "UTF-8") + "&"
                                +URLEncoder.encode("del_edad", "UTF-8") + "=" + URLEncoder.encode(del_edad, "UTF-8") + "&"
                                +URLEncoder.encode("del_user", "UTF-8") + "=" + URLEncoder.encode(del_user, "UTF-8") + "&"
                                + URLEncoder.encode("del_pass", "UTF-8") + "=" + URLEncoder.encode(del_pass, "UTF-8");


                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
//        super.onPreExecute();
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Estado");
    }

    @Override
    protected void onPostExecute(String result) {
        if(result.toString().equals("admin"))        {
// comentado x Luis Lopez            Intent i = new Intent(context, ServiciosActivity.class);
            Intent i = new Intent(context, MenuAdminActivity.class);
            context.startActivity(i);
//            Intent i = new Intent(context, ListaUsuarios.class);
//            context.startActivity(i);
        }else if(result.toString().equals("user")){
            Intent u = new Intent(context, EstudiantesActivity.class);
            context.startActivity(u);
        }
        else if(result.toString().equals("ingreso")){
            Intent ea = new Intent(context, ListaUsuarios.class);
            context.startActivity(ea);
        }
        else if(result.toString().equals("update")){
            Intent up = new Intent(context, ListaUsuarios.class);
            context.startActivity(up);
        }
        else if(result.toString().equals("delete")){
            Intent del = new Intent(context, ListaUsuarios.class);
            context.startActivity(del);
        }
        else
        {
            alertDialog.setMessage(result);
            alertDialog.show();
        }

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
