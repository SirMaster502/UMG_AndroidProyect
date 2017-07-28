package curso.umg.gt.umgappproject;

/**
 * Created by repre on 28/07/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class EstudianteCustomAdapter extends ArrayAdapter<Servicio>{

    public EstudianteCustomAdapter(Context context, int resource, List<Servicio> student) {
        super(context, resource, student);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.activity_estudiante_view, parent, false);
        }

        Servicio servicio = getItem(position);

        if (servicio != null) {
            TextView tvSemestreId = (TextView) v.findViewById(R.id.semestre_Id);
            TextView tvSemestreNombre = (TextView) v.findViewById(R.id.servicio_nombre);
            TextView tvSemestreDescripcion = v.findViewById(R.id.servicio_descripcion);
            TextView tvSemestreHorario = v.findViewById(R.id.servicio_horario);
            tvSemestreId.setText( Integer.toString(servicio.Id_servicio));

            tvSemestreNombre.setText(servicio.Nombre);
            tvSemestreDescripcion.setText(servicio.Descripcion);
            tvSemestreHorario.setText(servicio.Horario);
        }

        return v;
    }

}
