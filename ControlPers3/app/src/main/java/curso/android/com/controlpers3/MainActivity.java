package curso.android.com.controlpers3;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {
	
	private SelectorColor ctlColor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ctlColor = (SelectorColor)findViewById(R.id.scColor);
        
        ctlColor.setOnColorSelectedListener(new OnColorSelectedListener() 
        {
			public void onColorSelected(int color) 
			{

				//Aquí se trataría el color seleccionado (parámetro 'color')
				//...
			}
		});
    }
}
