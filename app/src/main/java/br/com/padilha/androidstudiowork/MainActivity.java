package br.com.padilha.androidstudiowork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.padilha.androidstudiowork.controller.UsuarioController;
import br.com.padilha.androidstudiowork.model.Usuario;

public class MainActivity extends AppCompatActivity {

    private Button butTextLogin;
    private EditText editTextNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setButtonClick();
        initDB();
    }

    private void initView() {
        editTextNome = findViewById(R.id.edit_text_name); editTextNome.getText().toString();
        butTextLogin = findViewById(R.id.but_text_login);
    }

    private void setButtonClick() {
        butTextLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

    }

    private void initDB() {
        Usuario usur = new Usuario(
                1,
                "Filipe",
                20,
                "(51)98310-1049",
                "filipe.amaral.padilha@gmail.com",
                "F123p-"
        );

        UsuarioController usuarioController = new UsuarioController(getApplicationContext());
       // usuarioController.insert(usur);
        usuarioController.validateLogin("Filipe","filipe.amaral.padilha@gmail.com","F123p-");
    }

}