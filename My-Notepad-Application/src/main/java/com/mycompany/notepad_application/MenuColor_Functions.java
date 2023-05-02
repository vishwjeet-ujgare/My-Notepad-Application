/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notepad_application;

import java.awt.Color;

/**
 *
 * @author DELL
 */
public class MenuColor_Functions {

    GUI gui;

    public MenuColor_Functions(GUI gui) {
        this.gui = gui;
    }

    public void changeColor(String col) {
        switch (col) {
            case "White":
                gui.window.getContentPane().setBackground(Color.white);
                gui.textarea.setBackground(Color.white);
                gui.textarea.setForeground(Color.black);
                break;
            case "Black":
                gui.window.getContentPane().setBackground(Color.black);
                gui.textarea.setBackground(Color.black);
                gui.textarea.setForeground(Color.white);
                break;
            case "Blue":
                gui.window.getContentPane().setBackground(Color.blue);
                gui.textarea.setBackground(Color.blue);
                gui.textarea.setForeground(Color.white);
                break;
        }

    }

}
