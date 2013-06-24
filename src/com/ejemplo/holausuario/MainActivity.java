package com.ejemplo.holausuario;

import android.os.Bundle;
import android.app.AlertDialog;
//import android.app.Dialog;
import android.content.DialogInterface;
//import android.app.Activity;
//import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.View;
//import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
//import android.widget.Button;
//import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.Toast;

public class MainActivity extends android.support.v4.app.FragmentActivity implements AdapterView.OnItemClickListener {

	DrawerLayout mDrawer;
	private ListView navList;
	String[] names;
	Resources res;
	TabHost tabs;
	
	final CharSequence[] itemsUnidadesMetricas = {"Kilometros", "Millas", "Yardas"};
	final CharSequence[] itemsIdioma = {"Ingl�s", "Espa�ol", "Frances"};
	AlertDialog.Builder builder;
	Toast toast;
	AlertDialog alert;
	int valorItemIdioma=1;
	int valorItemUnidadesMetricas=0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        
        //************************************************pesta�as
        res = getResources();
        
        tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();
         
        TabHost.TabSpec spec=tabs.newTabSpec("mitab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Ubicaci�n",
            res.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);
         
        spec=tabs.newTabSpec("mitab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Datos",
            res.getDrawable(android.R.drawable.ic_dialog_info));
        tabs.addTab(spec);
         
        tabs.setCurrentTab(0);
        
        tabs.setOnTabChangedListener(new OnTabChangeListener() {
			public void onTabChanged(String tabId) {
				
			}
		});
        
        
        //**********************************************************vista
        
        this.navList = (ListView) findViewById(R.id.left_drawer);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        // Load an array of options names
        names= getResources().getStringArray(
                R.array.nav_options);
 
        // Set previous array as adapter of the list
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, names);
        navList.setAdapter(adapter);
        navList.setOnItemClickListener(this);
        
        
        
        
        
        
        
/*        
      //Obtenemos una referencia a los controles de la interfaz
        final EditText txtNombre = (EditText)findViewById(R.id.txtNombre);
        Button btnHola = (Button)findViewById(R.id.botonHola);
        
        btnHola.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//Creamos el Intent pasando la actividad llamadora y la actividad a llamar
                Intent intent = new Intent(MainActivity.this, FrmSaludo.class);

                //Creamos la informaci�n a pasar entre actividades
                Bundle b = new Bundle();
                b.putString("NOMBRE", txtNombre.getText().toString());

                //A�adimos la informaci�n al intent
                intent.putExtras(b);

                //Iniciamos la nueva actividad
                startActivity(intent);				
			}
		});
*/
    }


	@Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
	    //Toast.makeText(this, "Pulsado " + names[i], Toast.LENGTH_SHORT).show();
	    //mDrawer.closeDrawers();
	    switch(i){
	    	//unidades metricas
	    	case 1:
	    		builder = new AlertDialog.Builder(this);
	    		builder.setTitle("�Unidades Metricas preferidas?");
	    		builder.setSingleChoiceItems(itemsUnidadesMetricas, valorItemUnidadesMetricas, new DialogInterface.OnClickListener() {
	    		    public void onClick(DialogInterface dialog, int item) {
	    		        toast = Toast.makeText(getApplicationContext(), "Haz elegido la opcion: " + itemsUnidadesMetricas[item] , Toast.LENGTH_SHORT);
	    		        toast.show();
	    		        valorItemUnidadesMetricas=item;
	    		        dialog.cancel();
	    		    }
	    		});
	    		alert = builder.create();
	    		alert.show();
	    	break;
	    	
	    	case 2:
	    		builder = new AlertDialog.Builder(this);
	    		builder.setTitle("�Idioma preferido?");
	    		builder.setSingleChoiceItems(itemsIdioma, valorItemIdioma, new DialogInterface.OnClickListener() {
	    		    public void onClick(DialogInterface dialog, int item) {
	    		        Toast toast = Toast.makeText(getApplicationContext(), "Haz elegido la opcion: " + itemsIdioma[item] , Toast.LENGTH_SHORT);
	    		        toast.show();
	    		        valorItemIdioma=item;
	    		        //para cerrar el dialogo al dar click
	    		        dialog.cancel();
	    		    }
	    		});
	    		alert = builder.create();
	    		alert.show();
	    	break;
	    }
	    
    }
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
