package br.ufjf.dcc196.igorknop.calculajuros;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class JurosCompostosActivity extends AppCompatActivity {
    private Double valorPresente;
    private Double valorFinal;
    private TextView textViewValorPresente;
    private EditText editTextTaxaDeJuros;
    private EditText editTextPeriodos;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juros_compostos);
        textViewValorPresente = findViewById(R.id.textViewValorPresente);
        Bundle extras = getIntent().getExtras();
        valorPresente = extras.getDouble("valorPresente");
        textViewValorPresente.setText(valorPresente.toString());

        editTextTaxaDeJuros = findViewById(R.id.editTextTaxaDeJuros);
        editTextPeriodos = findViewById(R.id.editTextPeriodos);
        textViewResultado = findViewById(R.id.textViewResultado);

    }

    public void retornarClick(View view){
        Intent resultado = new Intent();
        resultado.putExtra("valorFinal", valorFinal);
        setResult(MainActivity.RESULT_JUROS_COMPOSTOS, resultado);
        finish();
    }

    public void calcularClick(View view ){
        Double taxaDeJuros;
        Integer periodos;
        taxaDeJuros = Double.parseDouble(editTextTaxaDeJuros.getText().toString())/100.0;
        periodos = Integer.parseInt(editTextPeriodos.getText().toString());
        valorFinal = valorPresente*Math.pow(1+taxaDeJuros,periodos);
        textViewResultado.setText(valorFinal.toString());
    }
}