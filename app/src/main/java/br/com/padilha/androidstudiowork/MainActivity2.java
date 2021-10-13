package br.com.padilha.androidstudiowork;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

import br.com.padilha.androidstudiowork.controller.UsuarioController;
import br.com.padilha.androidstudiowork.model.Usuario;

public class MainActivity2 extends AppCompatActivity {

    private ActionBar actionBar;
    private EditText nome, email, idade, celular, senha;
    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        initView();
        setClick();
    }

    private void initView() {
        nome = findViewById(R.id.cadastro_text_name);
        email = findViewById(R.id.cadatro_text_email);
        idade = findViewById(R.id.cadastro_idade);
        celular = findViewById(R.id.cadastro_celular);
        senha = findViewById(R.id.cadastro_text_password);
        enviar = findViewById(R.id.but_text_enviar);
    }

    private void setClick() {
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!verification()){
                    Toast.makeText(getApplicationContext(), R.string.cadastro_msg_preencher, Toast.LENGTH_LONG).show();
                } else {
                    UsuarioController usuarioController = new UsuarioController(getApplicationContext());
                    Usuario usur = new Usuario(
                            generatorId(),
                            nome.getText().toString(),
                            Integer.parseInt(idade.getText().toString()),
                            celular.getText().toString(),
                            email.getText().toString(),
                            senha.getText().toString()
                    );
                    usuarioController.insert(usur);
                    Toast.makeText(getApplicationContext(), R.string.cadastro_sucesso, Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });

    }

    private int generatorId() {
        Random gerador = new Random();
        return gerador.nextInt(500);

    }

    private boolean verification(){
        if (nome.getText().length() == 0) {
           return false;
        }
        if (email.getText().length() == 0) {
            return false;
        }
        if (idade.getText().length() == 0) {
            return false;
        }
        if (celular.getText().length() == 0) {
            return false;
        }
        if (senha.getText().length() == 0) {
            return false;
        }
        return true;
    }

}