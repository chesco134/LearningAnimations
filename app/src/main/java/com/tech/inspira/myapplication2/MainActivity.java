package com.tech.inspira.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textoAnimacion;
    private Animation mAnimation;
    private Animation overshotAnim;
    private TextView overshotText;
    private Animation rotationAnimation;
    private TextView rotationText;
    private Animation dilatacionAnim;
    private TextView textoDilatacion;
    private Animation alfaAnim;
    private TextView textoConAlfa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_main);
        textoAnimacion = (TextView)findViewById(R.id.my_main_texto_animacion);
        rotationText = (TextView)findViewById(R.id.my_main_rotacion);
        textoDilatacion = (TextView) findViewById(R.id.my_main_dilatacion);
        textoConAlfa = (TextView) findViewById(R.id.my_main_alfa);
        mAnimation = AnimationUtils.loadAnimation(this,R.anim.traslacion_derecha);
        overshotAnim = AnimationUtils.loadAnimation(this,R.anim.animacion);
        rotationAnimation = AnimationUtils.loadAnimation(this,R.anim.rotation);
        dilatacionAnim = AnimationUtils.loadAnimation(this,R.anim.escala);
        alfaAnim = AnimationUtils.loadAnimation(this,R.anim.alfa);
        alfaAnim.setRepeatMode(Animation.RESTART);
        alfaAnim.setRepeatCount(20);
        textoConAlfa.startAnimation(alfaAnim);
        textoConAlfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(alfaAnim);
            }
        });
        dilatacionAnim.setRepeatMode(Animation.RESTART);
        dilatacionAnim.setRepeatCount(20);
        textoDilatacion.startAnimation(dilatacionAnim);
        textoDilatacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(dilatacionAnim);
            }
        });
        rotationAnimation.setRepeatCount(20);
        rotationAnimation.setRepeatMode(Animation.RESTART);
        rotationText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(rotationAnimation);
            }
        });
        rotationText.startAnimation(rotationAnimation);
        overshotText = (TextView)findViewById(R.id.my_main_overshot_text);
        //mAnimation.setFillAfter(true);
        mAnimation.setRepeatCount(Animation.RESTART);
        mAnimation.setRepeatCount(20);
        textoAnimacion.startAnimation(mAnimation);
        overshotAnim.setRepeatMode(Animation.RESTART);
        overshotAnim.setRepeatCount(20);
        overshotText.setAnimation(overshotAnim);
        overshotText.append("\nRepeatMode: " + overshotAnim.getRepeatMode()
                + "\nRepeatCount: " + overshotAnim.getRepeatCount());
        textoAnimacion.append("\nEl presente texto ha sido añadido");
        textoAnimacion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                view.startAnimation(mAnimation);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}