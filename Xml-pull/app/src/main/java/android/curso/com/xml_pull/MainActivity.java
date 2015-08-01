package android.curso.com.xml_pull;

import java.util.List;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

    private Button btnCargar;
    private TextView txtResultado;

    private List<Noticia> noticias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCargar = (Button)findViewById(R.id.btnCargar);
        txtResultado = (TextView)findViewById(R.id.txtResultado);

        btnCargar.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                //Sin Tarea AsÌncrona
                //RssParserPull saxparser =
                //	new RssParserPull("http://212.170.237.10/rss/rss.aspx");

                //noticias = saxparser.parse();

                //Tratamos la lista de noticias
                //Por ejemplo: escribimos los tÌtulos en pantalla
                //txtResultado.setText("");
                //for(int i=0; i<noticias.size(); i++)
                //{
                //	txtResultado.setText(
                //		txtResultado.getText().toString() +
                //			System.getProperty("line.separator") +
                //			noticias.get(i).getTitulo());
                //}

                //Con Tarea AsÌncrona
                CargarXmlTask tarea = new CargarXmlTask();
                tarea.execute("http://212.170.237.10/rss/rss.aspx");
            }
        });
    }

    //Tarea AsÌncrona para cargar un XML en segundo plano
    private class CargarXmlTask extends AsyncTask<String,Integer,Boolean> {

        protected Boolean doInBackground(String... params) {

            RssParserPull saxparser =
                    new RssParserPull(params[0]);

            noticias = saxparser.parse();

            return true;
        }

        protected void onPostExecute(Boolean result) {

            //Tratamos la lista de noticias
            //Por ejemplo: escribimos los tÌtulos en pantalla
            txtResultado.setText("");
            for(int i=0; i<noticias.size(); i++)
            {
                txtResultado.setText(
                        txtResultado.getText().toString() +
                                System.getProperty("line.separator") +
                                noticias.get(i).getTitulo());
            }
        }
    }

}
