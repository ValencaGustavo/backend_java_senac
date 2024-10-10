package model;

import static java.nio.file.StandardCopyOption.*;
import java.nio.file.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import controller.*;

public class NovoCadastroModel extends NovoCadastroController {
    public static void novoCadastro(String nome, String email, String senha) {
        try {
            Connection conexao = MySQLConnectorModel.conectar();
            
            String strSqlPesquisarEmail = "SELECT * FROM `" + dbPadrao + "`.`" + tblPadrao + "` WHERE `email` = ?;";
            PreparedStatement pstmtPesquisarEmail = conexao.prepareStatement(strSqlPesquisarEmail);
            pstmtPesquisarEmail.setString(1, email);
            
            ResultSet rstPesquisarEmail = pstmtPesquisarEmail.executeQuery();
            
            if (rstPesquisarEmail.next()) {
                notificarUsuario("Ops! Parece que há um cadastro com esse email. Por favor, verifique e tente novamente com outro email.");
            } else {
                String strSqlCadastrarRegistro = "INSERT INTO `" + dbPadrao + "`.`" + tblPadrao + "` (`nome`, `email`, `senha`, `profile_picture`) VALUES (?, ?, ?, ?);";
                PreparedStatement pstmtCadastrarRegistro = conexao.prepareStatement(strSqlCadastrarRegistro);
                pstmtCadastrarRegistro.setString(1, nome);
                pstmtCadastrarRegistro.setString(2, email);
                pstmtCadastrarRegistro.setString(3, senha);
                
                if (!fileFullName.isEmpty()) {
                    File imgFile = new File(fileFullPath);
                    FileInputStream fis = new FileInputStream(imgFile);
                    pstmtCadastrarRegistro.setBinaryStream(4, fis, (int) imgFile.length());
                } else {
                    pstmtCadastrarRegistro.setNull(4, Types.BLOB); // caso não tenha imagem
                }

                pstmtCadastrarRegistro.executeUpdate();
                notificarUsuario("Cadastro realizado com sucesso!");
                fileFullName = "";
                fileFullPath = "";
            }
            pstmtPesquisarEmail.close();
        } catch (Exception e) {
            notificarUsuario("Não foi possível realizar o cadastro. Por favor, verifique e tente novamente.");
            System.out.println("Erro: " + e);
        }
    }

    public static void copyFile() {
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Selecione o arquivo que deseja copiar");
            chooser.setApproveButtonText("Copiar arquivo");
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files only", "jpg", "gif", "png");
            chooser.setFileFilter(filter);
            chooser.setAcceptAllFileFilterUsed(false);

            int returnVal1 = chooser.showOpenDialog(null);
            
            if (returnVal1 == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();
                if (selectedFile != null) {
                    String fileFullPath = selectedFile.getAbsolutePath(); // origem
                    String selectedFileName = selectedFile.getName();
                    
                    String[] fileNameAndExtension = selectedFileName.split("[.]");
                    String fileExtension = fileNameAndExtension[fileNameAndExtension.length - 1];
                    String fileName = "file_" + Math.random() + "." + fileExtension;

                    String folderFullPath = System.getProperty("user.dir") + "\\src\\view\\img";
                    Path pathOrigin = Paths.get(fileFullPath);
                    String fileFullPathDestination = folderFullPath + "\\" + fileName;
                    Path pathDestination = Paths.get(fileFullPathDestination);
                    
                    if (fileFullPath.length() > 0 && folderFullPath.length() > 0) {
                        Files.copy(pathOrigin, pathDestination, REPLACE_EXISTING);
                        System.out.println("Arquivo " + selectedFile.getName() + " copiado/colado com sucesso.");
                        memorizarArquivo(fileFullPathDestination, fileName);
                        mostrarFoto();
                        notificarUsuario("Imagem foi cadastrada com sucesso.");
                    } else {
                        notificarUsuario("Ops! Não foi possível selecionar o arquivo. Por favor tente novamente mais tarde.");
                    }
                } else {
                    notificarUsuario("Nenhum arquivo foi selecionado.");
                }
            } else {
                notificarUsuario("Operação de seleção de arquivo cancelada.");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Imprime o erro completo para depuração
            notificarUsuario("Ops! Houve algum problema com a seleção do arquivo. Por favor tente novamente mais tarde.");
        }
    }

    public static void removerArquivoModel(String fullPath) {
        try {
            Path pathDestination = Paths.get(fullPath);
            Files.delete(pathDestination);
            JOptionPane.showMessageDialog(null, "Arquivo carregado, não utilizado, removido com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ops! Houve um problema ao remover o arquivo carregado não utilizado. Por favor, continue com a saída do sistema.");
            System.err.println("Erro: " + e);
        }
    }
}
