package com.example.paulinhocorazza.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnSalvar;
    private EditText inputNome;
    private TextView textoNome;
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNome = (EditText) findViewById(R.id.editText);
        textoNome = (TextView) findViewById(R.id.textView);
        btnSalvar = (Button) findViewById(R.id.button);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if(inputNome.getText().toString().equals("")){

                    Toast.makeText(MainActivity.this,"Por favor preencher o nome",Toast.LENGTH_SHORT).show();
                }
                else{
                    editor.putString("nome",inputNome.getText().toString());
                    editor.commit();
                }
            }
        });

        //recuperando dados

        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
        if(sharedPreferences.contains("nome")){
            String nomeUsuario = sharedPreferences.getString("nome","usuario não definido");
            textoNome.setText(nomeUsuario);
        }
        else{
            textoNome.setText("Olá usuário não definido");
        }
    }
}
