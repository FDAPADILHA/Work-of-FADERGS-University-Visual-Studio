package br.com.padilha.androidstudiowork.dataModel;

public class UsuarioDataModel {

    // Nome da Tabela
    public static final String TABELA = "tbl_usuario";
    // Atributos da Tabela
    public static final String ID = "idUser";
    public static final String NOME = "nome";
    public static final String IDADE = "idade";
    public static final String EMAIL = "email";
    public static final String PHONE = "numCel";
    public static final String SENHA = "senha";
    // QUERY para criar a tabela
    public static String queryCriarTabela = "";
    public static String createTable(){
        queryCriarTabela += "CREATE TABLE " + TABELA + "(";
        queryCriarTabela += ID + " integer primary key, ";
        queryCriarTabela += NOME + " text, ";
        queryCriarTabela += IDADE + " integer, ";
        queryCriarTabela += EMAIL + " text, ";
        queryCriarTabela += PHONE + " text, ";
        queryCriarTabela += SENHA + " text";
        queryCriarTabela += ")";
        return queryCriarTabela;
    }

}
