package br.edu.ifsp.arq.dmos5_2020s1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button converterButtonCelsius;
    private Button converterButtonFarenheit;
    private EditText inputEditText;
    private TextView outputTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        converterButtonCelsius = findViewById(R.id.button_converterPCelsius);
        converterButtonFarenheit = findViewById(R.id.button_converterPFarenheit);
        inputEditText = findViewById(R.id.editText_input);
        outputTextView = findViewById(R.id.textView_output);
        converterButtonCelsius.setOnClickListener(this);
        converterButtonFarenheit.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == converterButtonCelsius) {
            converterValor(1);
        } else {
            if(v == converterButtonFarenheit){
                converterValor(2);
            }
        }
    }

    @SuppressLint("DefaultLocale")
    private void converterValor(int opcao) {
        double valorConvertido;
        String valorConvertidoString;

        valorConvertidoString = inputEditText.getText().toString();

        try {
            valorConvertido = Double.parseDouble(valorConvertidoString);
        } catch (NumberFormatException ex) {
            Toast.makeText(this, "Valor Invalido digitado!", Toast.LENGTH_SHORT).show();
            valorConvertido = 0;
        }

        if(opcao == 1){
            outputTextView.setText(String.format("%.2f ºC", ((valorConvertido - 32) / 1.8)));
        } else {
            if(opcao == 2){
                outputTextView.setText(String.format("%.2f ºF", ((valorConvertido * 1.8) + 32 )));
            }
        }

    }
}
