package controller;
import model.*;
import view.*;

import java.sql.*;
import java.awt.*;
import javax.swing.*;

public class Logar extends JFrame {
    public static void logar() {
        try {
            if (LoginFrame.usuarioJTextField.getText().trim().length() == 0) {
                LoginFrame.notificacaoJLabel.setText(Helper.setHtmlFormat("É necessário digitar um login para acessar! Por favor, verifique e tente novamente."));
                LoginFrame.usuarioJTextField.requestFocus();
            } else if (String.valueOf(LoginFrame.senhaJPasswordField.getPassword()).trim().length() == 0) {
                LoginFrame.notificacaoJLabel.setText(Helper.setHtmlFormat("É necessário digitar uma senha para acessar! Por favor, verifique e tente novamente."));
                LoginFrame.senhaJPasswordField.requestFocus();
            } else {
                boolean achouUsuario = Login.loginUsuario(LoginFrame.usuarioJTextField.getText(), String.valueOf(LoginFrame.senhaJPasswordField.getPassword()).trim());
                if (achouUsuario == true) {
                    EditarCadastro appMenuFrame = new EditarCadastro();
                    appMenuFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    LoginFrame.application.dispose();
                } else {
                    LoginFrame.notificacaoJLabel.setText(Helper.setHtmlFormat("Não foi encontrado o login e/ou senha digitados! Por favor, verifique e tente novamente."));
                }
            }
        } catch (Exception ex) {
            LoginFrame.notificacaoJLabel.setText(Helper.setHtmlFormat("Ops! Deu ruim no banco de dados, veja o erro: " + ex));
        }        
    }
}