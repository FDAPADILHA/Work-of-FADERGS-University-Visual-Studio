package br.com.padilha.androidstudiowork.dataSource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.padilha.androidstudiowork.dataModel.UsuarioDataModel;
import br.com.padilha.androidstudiowork.model.Usuario;

public class AppDataBase extends SQLiteOpenHelper {

    public static final String DB_NAME = "DB_Cadastros.sqlite";
    public static final int DB_VERSION = 1;
    SQLiteDatabase db;

    public AppDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UsuarioDataModel.createTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insert(String tabela, ContentValues dados) {
        db = getWritableDatabase();
        boolean retorno = false;
        try {
            retorno = db.insert(tabela, null, dados) > 0;
            return retorno;
        } catch (Exception e) {
        }
        return retorno;

    }

    public boolean validateLogin(String name, String email, String pass, String tabela) {
        db = getWritableDatabase();
        String SQL = "SELECT * FROM " + tabela + " WHERE nome = ? AND email = ? AND senha = ?";
        Cursor cursor;
        cursor = db.rawQuery(SQL, new String[]{
                name, email, pass
        });
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

}
