package curso.android.com.checkradio;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private CheckBox cbMarcame;
    private TextView lblMensaje;
    private RadioGroup rgOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbMarcame = (CheckBox)findViewById(R.id.ChkMarcame);

        cbMarcame.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cbMarcame.setText("Checkbox marcado!");
                }
                else {
                    cbMarcame.setText("Checkbox desmarcado!");
                }
            }
        });

        lblMensaje = (TextView)findViewById(R.id.LblSeleccion);
        rgOpciones = (RadioGroup)findViewById(R.id.gruporb);

        rgOpciones.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                lblMensaje.setText("ID opci�n seleccionada: " + checkedId);
            }
        });
    }
}
