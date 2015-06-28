package curso.android.com.holausuario;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by macbookpro on 27/6/15.
 */
public class FrmSaludo extends Activity{

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);

        //localizar los controles
        TextView txtSaludo = (TextView) findViewById(R.id.TxtSaludo);

        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();

        //Construir el mensaje a mostrar
        txtSaludo.setText("Hola " + bundle.getString("nombre"));

    }
}
