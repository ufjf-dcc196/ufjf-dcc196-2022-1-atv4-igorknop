package br.ufjf.dcc196.igorknop.calculajuros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class JurosSimplesActivity extends AppCompatActivity {
    TextView textViewValorPresente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juros_simples);
        textViewValorPresente = findViewById(R.id.textViewValorPresente);
        Bundle extras = getIntent().getExtras();
        Double valorPresente = extras.getDouble("valorPresente");
        textViewValorPresente.setText(valorPresente.toString());
    }

    public void retornarClick(View view){
        finish();
    }

    public void calcularClick(View view ){

    }
}