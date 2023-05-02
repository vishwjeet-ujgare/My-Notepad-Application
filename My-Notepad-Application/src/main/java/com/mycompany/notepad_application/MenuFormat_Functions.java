/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notepad_application;

import java.awt.Font;

/**
 *
 * @author DELL
 */
public class MenuFormat_Functions {

    GUI gui;
    String selectedFont;
    Font arial, comicSansMS, timesNewRoman;

    public MenuFormat_Functions(GUI gui) {
        this.gui = gui;
    }

    public void wordWrap() {
        if (gui.wordWrapOn == false) {
            gui.wordWrapOn = true;
            gui.iWordWrap.setText("Word Wrap : ON");
            gui.textarea.setLineWrap(true);
            gui.textarea.setWrapStyleWord(true);
        } else if (gui.wordWrapOn == true) {
            gui.wordWrapOn = false;
            gui.iWordWrap.setText("Word Wrap : OFF");
            gui.textarea.setLineWrap(false);
            gui.textarea.setWrapStyleWord(false);
        }
    }

    public void createFont(int fontSize) {
        arial = new Font("Arial", Font.PLAIN, fontSize);
        comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
        setFont(selectedFont);
    }

    public void setFont(String font) {
        selectedFont = font;
        switch (selectedFont) {
            case "Arial":
                gui.textarea.setFont(arial);
                break;
            case "Comic Sans MS":
                gui.textarea.setFont(comicSansMS);
                break;
            case "Times New Roman":
                gui.textarea.setFont(timesNewRoman);
                break;
        }

    }

}
