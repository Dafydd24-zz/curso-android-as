package curso.android.com.holausuario;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtenemos una referencia a los controles de la interfaz
        final EditText txtNombre = (EditText)findViewById(R.id.TxtNombre);
        Button btnEnviar = (Button) findViewById(R.id.BtnHola);

        //Implementamos el evento click del botón
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creamos el Intent
                Intent vintent = new Intent(MainActivity.this, FrmSaludo.class);

                //Creamos la informacion a pasar entre actividades
                Bundle b = new Bundle();
                b.putString("nombre",txtNombre.getText().toString());

                vintent.putExtras(b);
               //vintent.putExtra("nombre",txtNombre.getText().toString());

                //Iniciamos la nueva actividad
                startActivity(vintent);

            }
        });



    }

}
