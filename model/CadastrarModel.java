package model;
import controller.*;
import view.NavegadorDeRegistro;
import view.CadastrarView;

// import java.awt.*;
import java.sql.*;

    public class CadastrarModel {
        
        public static String cadastrarMYSQL(String db, String tbl, String campo, String campo2, String campo3, String nome, String email, String senha) {
        String retorno = "Nada aconteceu ainda...";
        try { 
        Connection conexao = MySQLConnectorModel.conectar();
        String strSqlInserirRegistro = "insert into `" + db + "`.`" + tbl + "` (`" + campo + "`, `" + campo2 + "`, `" + campo3 + "`) values ('" + nome + "', '" + email + "', '" + senha + "');";
        Statement stmSqlInserirRegistro = conexao.createStatement();

        // ResultSet resultado =
        stmSqlInserirRegistro.addBatch(strSqlInserirRegistro);
        stmSqlInserirRegistro.executeBatch();
        stmSqlInserirRegistro.close();
        retorno = "Registro inserido com sucesso!";
        System.out.println(retorno);
    } catch (Exception e) {
        retorno = "Ops! Ocorreu um erro: " + e;
        System.out.println(retorno);
    }
    return retorno;
    }

    public static boolean cadastrarUsuario(String login) {
        
        String nome = CadastrarView.usuarioJTextField.getText();
        String email = CadastrarView.emailJTextField.getText();
        String senha = CadastrarView.senhaJPasswordField.getText();
    
        try {
            Connection conexao = MySQLConnectorModel.conectar();
            String strSqlPesquisarEmail = "select * from `" + InterfaceController.dbPadrao + "`.`" + InterfaceController.tblPadrao + "` where `email` = '" + email + "';";
            Statement stmSqlPesquisarEmail = conexao.createStatement();
            ResultSet rstPesquisarEmail = stmSqlPesquisarEmail.executeQuery(strSqlPesquisarEmail);

            if (rstPesquisarEmail.next()) {
                CadastrarView.notificacaoJLabel.setText("Ops! Parece que há um cadastro com esse email. Por favor, verifique e tente novamente com outro email.");
            } else {
                CadastrarModel.cadastrarMYSQL(InterfaceController.dbPadrao, InterfaceController.tblPadrao, "nome", "email", "senha", nome, email, senha);
            }
            stmSqlPesquisarEmail.close();
            conexao.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            CadastrarView.notificacaoJLabel.setText("Ocorreu um erro ao cadastrar. Por favor, tente novamente.");
        }
    } else {
        CadastrarView.notificacaoJLabel.setText("Você deve aceitar os termos para cadastrar-se.");
    }
}