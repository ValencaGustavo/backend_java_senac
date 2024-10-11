package controller;

import java.sql.*;
import model.*;

public class NavegadorDeRegistro {
    
    public static String[] FirstRegister(String db, String tbl) throws Exception {
        Connection connection = MySQLConnectorModel.conectar();
        String strSqlFirstRegister = "select * from `" + db + "`.`" + tbl + "` order by `id` asc limit 1;";
        Statement stmFirstRegister = connection.createStatement();

        ResultSet rstSqlFirstRegiter = stmFirstRegister.executeQuery(strSqlFirstRegister);
        rstSqlFirstRegiter.next();
        String[] result = {
            rstSqlFirstRegiter.getString("id"),
            rstSqlFirstRegiter.getString("nome"),
            rstSqlFirstRegiter.getString("email"),
        };

        stmFirstRegister.close();
        return result;
    }

    public static String[] NextRegister(String db, String tbl, String id) throws Exception {
        Connection connection = MySQLConnectorModel.conectar();
        int idPerson = Integer.parseInt(id);
        int nextID = idPerson + 1;
        if (nextID >= 1) {
                String strSqlLastRegister = "select * from `" + db + "`.`" + tbl + "` order by `id` asc;";
                Statement stmNextRegister = connection.createStatement();

                try {
                    ResultSet rstSqlNextRegister = stmNextRegister.executeQuery(strSqlLastRegister);
                    String[] result = {"", "", "", ""};

                    while (rstSqlNextRegister.next()) {
                        if (id.equals(rstSqlNextRegister.getString("id"))) {
                            rstSqlNextRegister.next();
                            result[0] = rstSqlNextRegister.getString("id");
                            result[1] = rstSqlNextRegister.getString("nome");
                            result[2] = rstSqlNextRegister.getString("email");
                            result[3] = rstSqlNextRegister.getString("senha");
                            break;
                        }
                    }
                    rstSqlNextRegister.close();
                    if (result[0] == "") {
                        return null;
                    } else {
                        return result;
                    }
                } catch (Exception e) {
                    System.out.println("Parece que você já está no primeiro registro");
                    return null;
                }
        } else {
            return null;
        }
    }
    
    public static String[] PreviousRegister(String db, String tbl, String id) throws Exception {
        Connection connection = MySQLConnectorModel.conectar();
        int idPerson = Integer.parseInt(id);
        int nextID = idPerson - 1;
        if (nextID >= 1) {
                String strSqlLastRegister = "select * from `" + db + "`.`" + tbl + "` order by `id` desc;";
                Statement stmNextRegister = connection.createStatement();

                try {
                    ResultSet rstSqlNextRegister = stmNextRegister.executeQuery(strSqlLastRegister);
                    String[] result = {"", "", "", ""};

                    while (rstSqlNextRegister.next()) {
                        if (id.equals(rstSqlNextRegister.getString("id"))) {
                            rstSqlNextRegister.next();
                            result[0] = rstSqlNextRegister.getString("id");
                            result[1] = rstSqlNextRegister.getString("nome");
                            result[2] = rstSqlNextRegister.getString("email");
                            break;
                        }
                    }
                    rstSqlNextRegister.close();
                    if (result[0] == "") {
                        return null;
                    } else {
                        return result;
                    }
                } catch (Exception e) {
                    System.out.println("Parece que já está no ultimo registro");
                    return null;
                }
        } else {
            return null;
        }
    }

    public static String[] LastRegister(String db, String tbl) throws Exception {
        Connection connection = MySQLConnectorModel.conectar();
        try {
            String strSqlLastRegister = "select * from `" + db + "`.`" + tbl + "` order by `id` desc limit 1;";
            Statement stmLastRegister = connection.createStatement();
            ResultSet rstSqlLastRegiter = stmLastRegister.executeQuery(strSqlLastRegister);
            rstSqlLastRegiter.next();
            String[] result = {
                rstSqlLastRegiter.getString("id"),
                rstSqlLastRegiter.getString("nome"),
                rstSqlLastRegiter.getString("email"),
                rstSqlLastRegiter.getString("senha")
            };
            rstSqlLastRegiter.close();
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public static String[] DeleteRegister(String db, String tbl, String campo1, String id) throws Exception {

        String retorno = "Oi!!!!";
            try {
                Connection connection = MySQLConnectorModel.conectar();
                String strSqlDeleteRegister = "delete from `" + db + "`.`" + tbl + "` where `" + campo1 + "` = ?;";
                PreparedStatement rstSqlDeleteRegiter = connection.prepareStatement(strSqlDeleteRegister);
                rstSqlDeleteRegiter.setString(1, id);
                int linhasDel = rstSqlDeleteRegiter.executeUpdate();
                rstSqlDeleteRegiter.close();
                connection.close();

                if (linhasDel > 0) {
                    retorno = "Registro exluido com sucesso";
                } else {
                    retorno = "Registro não encontrado";
                }
                System.out.println(retorno);
            } catch (Exception e) {
                System.out.println("Opsss!! Ocorreu um erro: " + e);
                System.out.println(retorno);
            }
        return null;
    }

    public static String[] UpdateRegister(String db, String tbl, String nome, String email, String id, String senha) throws Exception {

        String retorno = "Oi!!!!";
            try {
                Connection connection = MySQLConnectorModel.conectar();
                String strSqlUpdateRegister = "update `" + db + "`.`" + tbl + "` set `nome` = '" + nome + "', `email` = '" + email + "', `senha` = '" + senha + "';";
                Statement stmSqlUpdateRegiter = connection.createStatement();
                stmSqlUpdateRegiter.addBatch(strSqlUpdateRegister);
                stmSqlUpdateRegiter.executeBatch();
                stmSqlUpdateRegiter.close();
                retorno = "tmj";
            } catch (Exception e) {
                System.out.println("Opsss!! Ocorreu um erro: " + e);
                System.out.println(retorno);
            }
        return null;
    }

    public static boolean newRegister(String db, String tbl,String campo1, String campo2, String campo3, String campo4, String nome, String email, String senha, String imagePath) throws Exception {
        try {
            Connection connection = MySQLConnectorModel.conectar();
            String strSqlCadastrarRegistro = "insert into `" + InterfaceController.dbPadrao + "`.`" + InterfaceController.tblPadrao + "` (`" + campo1 + "`,`" + campo2 + "`, `" + campo3 + "`, `" + campo4 + "`) values ('" + nome + "','" + email + "', '" + senha + "', '" + imagePath + "');";
            Statement stmSqlCadastrarRegistro = connection.createStatement();
            stmSqlCadastrarRegistro.addBatch(strSqlCadastrarRegistro);
            stmSqlCadastrarRegistro.executeBatch();
            stmSqlCadastrarRegistro.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static String[] searchRegister(String db, String tbl, String campo1, String campo2, String search) throws Exception {

        String retorno = "Oiiii!!!";
        String[] resultado = new String[4];
        try {
            Connection conexao = MySQLConnectorModel.conectar();
            String strSqlsearchRegister = "select id, nome, email, senha FROM `" + db + "`.`" + tbl + "` where `" + campo1 + "` = '" + search + "' OR `" + campo2 + "` = '" + search + "' order by `id` asc;";
            Statement stmSqlsearchRegister = conexao.createStatement();
            ResultSet resultSet = stmSqlsearchRegister.executeQuery(strSqlsearchRegister);
    
            if (resultSet.next()) {
                resultado[0] = resultSet.getString("id");
                resultado[1] = resultSet.getString("nome");
                resultado[2] = resultSet.getString("email");
                // resultado[3] = resultSet.getString("senha");
            }

            stmSqlsearchRegister.close();
            retorno = "Deu certo";
            System.out.println("Msg: " + retorno);
        } catch (Exception e) {
            System.out.println("Error " + e);
            retorno = "Deu errado";
            resultado[0] = "Erro";
            resultado[1] = "Erro";
            resultado[2] = "Erro";
            // resultado[3] = "Erro";
        }
        return resultado;
    }
    
}