/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notepad_application;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuFile_Functions {

    GUI gui;
    String fileName;
    String fileAddress;

    public MenuFile_Functions(GUI gui) {
        this.gui = gui;
    }

    public void newFile() {
        gui.textarea.setText("");
        gui.window.setTitle(gui.newFileTitle);
        fileName = null;
        fileAddress = null;
    }

    public void open() {
        FileDialog fd = new FileDialog(gui.window, "Select and click on open", FileDialog.LOAD);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName+"- Notepad");
            try {
                BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
                gui.textarea.setText("");
                String line = null;

                while ((line = br.readLine()) != null) {
                    gui.textarea.append(line + "\n");
                }
                br.close();
            } catch (Exception e) {
                System.out.println("Exception Occured : " + e);
            }
        }
    }

    public void save() {
        if ((fileName == null) && (fileAddress == null)) {
            saveAs();
        } else {

            try {
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(gui.textarea.getText());
                fw.close();
            } catch (IOException ex) {
                System.out.println("Erroe occured while creating file : " + ex);
            }

        }
    }

    public void saveAs() {
        FileDialog fd = new FileDialog(gui.window, "Save As", FileDialog.SAVE);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName+"- Notepad");

            try {
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(gui.textarea.getText());
                fw.close();
            } catch (IOException ex) {
                System.out.println("Erroe occured while creating file : " + ex);
            }

        }
    }
    
    public void exit()
    {
       System.exit(0);
    }
}
