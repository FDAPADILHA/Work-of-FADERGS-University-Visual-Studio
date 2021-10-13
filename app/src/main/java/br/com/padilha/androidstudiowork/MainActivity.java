package br.com.padilha.androidstudiowork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.padilha.androidstudiowork.controller.UsuarioController;
import br.com.padilha.androidstudiowork.model.Usuario;

public class MainActivity extends AppCompatActivity {

    private Button butTextLogin;
    private EditText editTextNome;
    private UsuarioController usuarioController;
    private Button butRegister;
    private EditText editTextEmail;
    private EditText editTextPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuarioController = new UsuarioController(getApplicationContext());
        initView();
        setButtonClick();
        initDB();
    }

    private void initView() {
        editTextNome = findViewById(R.id.edit_text_name);
        editTextEmail = findViewById(R.id.edit_text_email);
        editTextPass = findViewById(R.id.edit_text_password);
        butTextLogin = findViewById(R.id.but_text_login);
        butRegister = findViewById(R.id.but_text_login2);
    }

    private void setButtonClick() {
        butTextLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (usuarioController.validateLogin(
                        editTextNome.getText().toString(),
                        editTextEmail.getText().toString(),
                        editTextPass.getText().toString()
                )) {
                    Toast.makeText(getApplicationContext(), R.string.sucesso_login, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), R.string.button_login_msg_error, Toast.LENGTH_LONG).show();
                }

            }
        });

        butRegister.setOnClickListener(new View.OnClickListener() {
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
        usuarioController.validateLogin("Filipe", "filipe.amaral.padilha@gmail.com", "F123p-");
    }

}