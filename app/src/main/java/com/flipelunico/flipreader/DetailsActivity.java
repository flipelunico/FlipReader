package com.flipelunico.flipreader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.flipelunico.flipreader.adapter.Entry;

/**
 * Created by flipelunico on 08-08-17.
 */

public class DetailsActivity extends AppCompatActivity {

    /**
     * Inicia una nueva instancia de la actividad
     *
     * @param activity Contexto desde donde se lanzará
     * @param Entry    Item a procesar
     */
    public static void createInstance(Activity activity, Entry entry) {
        Intent intent = getLaunchIntent(activity, entry);
        activity.startActivity(intent);


    }

    /**
     * Construye un Intent a partir del contexto y la actividad
     * de detalle.
     *
     * @param context Contexto donde se inicia
     * @param Entry    Identificador de la chica
     * @return Intent listo para usar
     */
    public static Intent getLaunchIntent(Context context, Entry entry) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra("Titulo", entry.get_title());
        intent.putExtra("Contenido", entry.get_content());
        intent.putExtra("Imagen", entry.get_visual_url());
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);

        Intent i = getIntent();
        String name = i.getStringExtra("Titulo");
        String detail = i.getStringExtra("Contenido");

        TextView  detailstext = (TextView) findViewById(R.id.detail);
        detailstext.setText(detail);

    }
}
