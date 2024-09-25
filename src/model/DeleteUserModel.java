package model;
import controller.*;

// import java.awt.*;
import java.sql.*;

public class DeleteUserModel {
    public static String deleteUsuario(String id) {
        try {
            Connection conexao = MySQLConnectorModel.conectar();
            String strSqlDeletarRegistro = "delete from `" + InterfaceController.dbPadrao + "`.`" + InterfaceController.tblPadrao + "`  where `id` = " + id + ";";
            Statement stmSqlDeletarRegistro = conexao.createStatement();
            stmSqlDeletarRegistro.addBatch(strSqlDeletarRegistro);
            stmSqlDeletarRegistro.executeBatch();
            stmSqlDeletarRegistro.close();

            String strSqlProximoRegistro = "select * from `" + InterfaceController.dbPadrao + "`.`" + InterfaceController.tblPadrao + "`  where `id` >= " + id + ";";
            Statement stmSqlProximoRegistro = conexao.createStatement();
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
            rstSqlProximoRegistro.next();
            String[] resultado = {
                rstSqlProximoRegistro.getString("id"),
                rstSqlProximoRegistro.getString("nome"),
                rstSqlProximoRegistro.getString("email")
            };
            stmSqlProximoRegistro.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}