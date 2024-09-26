package view;

import javax.swing.*;
import java.nio.file.*;
import java.io.*;

public class RenameFile {
    public static void main(String[] args) {
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Selecione o arquivo que deseja copiar.");
            int returnVal1 = chooser.showOpenDialog(null);
            String fileFullPath = "";
            String fileName = "";

            if (returnVal1 == JFileChooser.APPROVE_OPTION) {
                System.out.println("Você escolheu abrir este arquivo: " + chooser.getSelectedFile().getName());
                fileFullPath = chooser.getSelectedFile().getAbsolutePath();
                fileName = chooser.getSelectedFile().getName();
                System.out.println("Caminho Completo do Arquivo: " + fileFullPath);
            } else {
                System.out.println("Que pena!");
                return;
            }

            chooser.setDialogTitle("Selecione a pasta de destino.");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnVal2 = chooser.showOpenDialog(null);
            String folderFullPath = "";

            if (returnVal2 == JFileChooser.APPROVE_OPTION) {
                folderFullPath = chooser.getSelectedFile().getAbsolutePath();
                System.out.println("Você escolheu abrir esta pasta: " + chooser.getSelectedFile().getName());
                System.out.println("Caminho Completo da Pasta: " + folderFullPath);
            } else {
                System.out.println("Que pena!");
                return; 
            }

            String newFileName = JOptionPane.showInputDialog("Digite o novo nome para o arquivo (sem extensão):");
            if (newFileName == null || newFileName.trim().isEmpty()) {
                System.out.println("Nome inválido!");
                return; 
            }

            String fileExtension = fileName.substring(fileName.lastIndexOf('.'));
            Path pathOrigin = Paths.get(fileFullPath);
            Path pathDestination = Paths.get(folderFullPath, newFileName + fileExtension);

            Files.copy(pathOrigin, pathDestination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Arquivo copiado e renomeado para: " + pathDestination.toString());

        } catch (Exception e) {
            System.out.println("Não foi possível copiar o arquivo.");
            e.printStackTrace(); 
        }
    }
}
