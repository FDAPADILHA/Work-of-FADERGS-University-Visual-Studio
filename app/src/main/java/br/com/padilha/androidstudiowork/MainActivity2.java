package br.com.padilha.androidstudiowork;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

    private void setClick(){
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsuarioController usuarioController = new UsuarioController(getApplicationContext());
                Usuario usur = new Usuario(
                        1,
                        nome.getText().toString(),
                        Integer.parseInt(idade.getText().toString()),

                        "filipe.amaral.padilha@gmail.com",
                        "F123p-"
                );
                usuarioController.insert(usur);
            }
        });

    }

}