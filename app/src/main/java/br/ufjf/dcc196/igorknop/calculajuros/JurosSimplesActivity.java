package br.ufjf.dcc196.igorknop.calculajuros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class JurosSimplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juros_simples);
    }

    public void retornarClick(View view){
        finish();
    }

    public void calcularClick(View view ){

    }
}