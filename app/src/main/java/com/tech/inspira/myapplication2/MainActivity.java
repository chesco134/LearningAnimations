package com.tech.inspira.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/********************************************************************************
 *
 * La presente es una clase que encierra diferentes tipos de animación básica.
 * Busca ejemplificar el uso de la clase Animation y el contenido del directorio
 * de recursos "anim".
 *
 * ********************************************************************************/

public class MainActivity extends AppCompatActivity {

    /** Zona de etiquetas en pantalla **/
    private TextView textoMovimientoHorizontal;
    private TextView overshotText;
    private TextView textoGiratorio;
    private TextView textoDilatacion;
    private TextView textoConAlfa;

    /** Zona de objetos de animación **/
    // Cada objeto de animación representa un archivo en el directorio res/anim.

    private Animation animacionDeMovimientoHorizontal;
    private Animation overshotAnim;
    private Animation animacionDeGiro;
    private Animation animacionDeDilatacion;
    private Animation animacionDeEfectoAlfa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Ésta línea tiene que ir a fuerzas.
        setContentView(R.layout.my_main); // Ésta línea dice cuál pantalla será mostrada.

        /** A continuación sigue un proceso de inicialización de atributos **/
        /** Primero se pasan los componentes visuales del xml al objeto java **/
        textoMovimientoHorizontal = (TextView)findViewById(R.id.my_main_texto_animacion);
        overshotText = (TextView) findViewById(R.id.my_main_overshot_text);
        textoGiratorio = (TextView)findViewById(R.id.my_main_rotacion);
        textoDilatacion = (TextView) findViewById(R.id.my_main_dilatacion);
        textoConAlfa = (TextView) findViewById(R.id.my_main_alfa);
        /** Cada uno de los R.id.* debe existir dentro del xml de la pantalla a mostrar **/

        /** A continuación se cargarán los archivos de animación del directorio res/anim **/
        animacionDeMovimientoHorizontal = AnimationUtils.loadAnimation(this,R.anim.traslacion_derecha);
        overshotAnim = AnimationUtils.loadAnimation(this,R.anim.overshot);
        animacionDeGiro = AnimationUtils.loadAnimation(this,R.anim.rotation);
        animacionDeDilatacion = AnimationUtils.loadAnimation(this,R.anim.dilatacion);
        animacionDeEfectoAlfa = AnimationUtils.loadAnimation(this,R.anim.efecto_alfa);

        /** Después debemos colocar ciertas banderas en los objetos de animación antes creados **/
        animacionDeMovimientoHorizontal.setRepeatCount(Animation.RESTART); // Reinicia la animación.
        animacionDeMovimientoHorizontal.setRepeatCount(20); // Se repetirá 20 veces.
        //animacionDeMovimientoHorizontal.setFillAfter(true);
        overshotAnim.setRepeatMode(Animation.RESTART);
        overshotAnim.setRepeatCount(20);
        animacionDeGiro.setRepeatMode(Animation.RESTART);
        animacionDeGiro.setRepeatCount(20);
        animacionDeDilatacion.setRepeatMode(Animation.RESTART);
        animacionDeDilatacion.setRepeatCount(20);
        animacionDeEfectoAlfa.setRepeatMode(Animation.RESTART);
        animacionDeEfectoAlfa.setRepeatCount(20);

        /** Posteriormente se redefinen algunos textos a algunas etiquetas de la pantalla **/
        overshotText.append("\nRepeatMode: " + overshotAnim.getRepeatMode()
                + "\nRepeatCount: " + overshotAnim.getRepeatCount());
        textoMovimientoHorizontal.append("\nEl presente texto ha sido añadido");

        /** Luego procedemos a iniciar cada una de las animaciones **/
        textoMovimientoHorizontal.startAnimation(animacionDeMovimientoHorizontal);
        overshotText.setAnimation(overshotAnim);
        textoGiratorio.startAnimation(animacionDeGiro);
        textoDilatacion.startAnimation(animacionDeDilatacion);
        textoConAlfa.startAnimation(animacionDeEfectoAlfa);

        /** Finalmente colocamos una acción a cada etiqueta responder a pulsaciones sobre ella **/
        textoMovimientoHorizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // Simplemente reiniciamos la animación.
                view.startAnimation(animacionDeMovimientoHorizontal);
            }
        });
        textoGiratorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animacionDeGiro);
            }
        });
        textoDilatacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animacionDeDilatacion);
            }
        });
        textoConAlfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animacionDeEfectoAlfa);
            }
        });
    }
}