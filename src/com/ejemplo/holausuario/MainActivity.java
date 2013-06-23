package com.ejemplo.holausuario;

import android.os.Bundle;
//import android.app.Activity;
import android.content.Intent;
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

	private DrawerLayout mDrawer;
	private ListView navList;
	String[] names;
	Resources res;
	TabHost tabs;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        
        //************************************************pestañas
        res = getResources();
        
        tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();
         
        TabHost.TabSpec spec=tabs.newTabSpec("mitab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Ubicación",
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
        this.mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

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

                //Creamos la información a pasar entre actividades
                Bundle b = new Bundle();
                b.putString("NOMBRE", txtNombre.getText().toString());

                //Añadimos la información al intent
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
	    		//Creamos el Intent pasando la actividad llamadora y la actividad a llamar
                Intent intent = new Intent(MainActivity.this, FrmSaludo.class);
                
                //Creamos la información a pasar entre actividades
                Bundle b = new Bundle();
                b.putString("NOMBRE", "Hi");

                //Añadimos la información al intent
                intent.putExtras(b);
                
                //Iniciamos la nueva actividad
                startActivity(intent);
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
