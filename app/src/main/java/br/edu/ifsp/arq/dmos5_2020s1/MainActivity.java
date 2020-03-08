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

    private Button converterButton;
    private EditText inputFarenheitEditText;
    private TextView outputCelsiusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        converterButton = findViewById(R.id.button_converter);
        inputFarenheitEditText = findViewById(R.id.editText_inputfarenheit);
        outputCelsiusTextView = findViewById(R.id.textView_outputCelsius);
        converterButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == converterButton) {
            converterValor();
        }
    }

    @SuppressLint("DefaultLocale")
    private void converterValor() {
        double valorConvertido;
        String valorConvertidoString;

        valorConvertidoString = inputFarenheitEditText.getText().toString();

        try {
            valorConvertido = Double.parseDouble(valorConvertidoString);
        } catch (NumberFormatException ex) {
            Toast.makeText(this, "Valor Invalido digitado!", Toast.LENGTH_SHORT).show();
            valorConvertido = 0;
        }

        outputCelsiusTextView.setText(String.format("%.2f ºC", ((valorConvertido - 32) / 1.8)));
    }
}
