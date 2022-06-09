package br.ufjf.dcc196.igorknop.calculajuros;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int RESULT_JUROS_SIMPLES = 1;
    public static final int RESULT_JUROS_COMPOSTOS = 2;
    ActivityResultLauncher<Intent> launcher;
    EditText editTextValorPresente;
    TextView textViewValorFinal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextValorPresente = findViewById(R.id.editTextValorPresente);
        textViewValorFinal = findViewById(R.id.textViewValorFinal);
        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>(){

                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Double valorFinal;
                        Bundle extras;
                        switch (result.getResultCode()){
                            case RESULT_JUROS_SIMPLES:
                                extras = result.getData().getExtras();
                                valorFinal = extras.getDouble("valorFinal");
                                textViewValorFinal.setText("Simples: R$"+valorFinal.toString());
                                break;
                            case RESULT_JUROS_COMPOSTOS:
                                extras = result.getData().getExtras();
                                valorFinal = extras.getDouble("valorFinal");
                                textViewValorFinal.setText("Compostos: R$"+valorFinal.toString());
                                break;
                        }

                    }
                }
        );

    }

    public void jurosSimplesClick(View view){
        try {
            Double valorPresente = Double.parseDouble(editTextValorPresente.getText().toString());
            Intent intent = new Intent(MainActivity.this, JurosSimplesActivity.class);
            intent.putExtra("valorPresente", valorPresente);
            //startActivityForResult(intent, REQUEST_JUROS_SIMPLES);
            launcher.launch(intent);
        } catch (Exception e){
            editTextValorPresente.selectAll();
            editTextValorPresente.requestFocus();
        }

    }
    public void jurosCompostosClick(View view){
        try {
            Double valorPresente = Double.parseDouble(editTextValorPresente.getText().toString());
            Intent intent = new Intent(MainActivity.this, JurosCompostosActivity.class);
            intent.putExtra("valorPresente", valorPresente);
//            startActivityForResult(intent, REQUEST_JUROS_COMPOSTOS);
            launcher.launch(intent);
        } catch (Exception e){
            e.printStackTrace();
            editTextValorPresente.selectAll();
            editTextValorPresente.requestFocus();
        }

    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(resultCode == RESULT_OK){
//            Bundle extras = data.getExtras();
//            Double valorFinal = extras.getDouble("valorFinal");
//            if(requestCode == REQUEST_JUROS_SIMPLES){
//                textViewValorFinal.setText("Simples: R$"+valorFinal.toString());
//            }else if(requestCode == REQUEST_JUROS_COMPOSTOS){
//                textViewValorFinal.setText("Compostos: R$"+valorFinal.toString());
//
//            }
//
//        }
//    }
}