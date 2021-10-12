package br.com.padilha.androidstudiowork.controller;

import android.content.ContentValues;
import android.content.Context;

import br.com.padilha.androidstudiowork.dataModel.UsuarioDataModel;
import br.com.padilha.androidstudiowork.dataSource.AppDataBase;
import br.com.padilha.androidstudiowork.model.Usuario;

public class UsuarioController extends AppDataBase {

    ContentValues dadoDoObjeto;

    public UsuarioController(Context context) {
        super(context);
    }

    public boolean insert(Usuario obj) {
        dadoDoObjeto = new ContentValues();
        dadoDoObjeto.put(UsuarioDataModel.ID, obj.getId());
        dadoDoObjeto.put(UsuarioDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(UsuarioDataModel.IDADE, obj.getIdade());
        dadoDoObjeto.put(UsuarioDataModel.EMAIL, obj.getEmail());
        dadoDoObjeto.put(UsuarioDataModel.PHONE, obj.getPhone());
        dadoDoObjeto.put(UsuarioDataModel.SENHA, obj.getSenha());
        return insert(UsuarioDataModel.TABELA,dadoDoObjeto);
    }

    public boolean validateLogin(String name, String email, String pass){
        return validateLogin(name, email, pass, UsuarioDataModel.TABELA);

    }

}
