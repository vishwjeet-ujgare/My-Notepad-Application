
package com.mycompany.notepad_application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author DELL
 */
public class GUI implements ActionListener {

    JFrame window;
    JTextArea textarea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor, menuAbout;
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;

    JMenu menuFont, menuFontSize;
    JMenuItem iWordWrap, iFontArial, iFontCSMS, iFontTMR, iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28;
    JMenuItem iWhite, iBlack, iBlue;

    public static String newFileTitle = "New Untitled File - Notepad";

    MenuFile_Functions file = new MenuFile_Functions(this);
    MenuFormat_Functions format = new MenuFormat_Functions(this);

    MenuColor_Functions col = new MenuColor_Functions(this);

    public boolean wordWrapOn = false;

    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {
        createWindow();
        createTextarea();
        createMenuBar();
        createFileMenuItems();
        createEditMenuItems();
        createFormatMenuItems();
        createColorMenuItems();

        format.selectedFont = "Arial";
        format.createFont(16);
        col.changeColor("White");
        format.wordWrap();

        window.setVisible(true);
    }

    private void createWindow() {
        window = new JFrame(newFileTitle);
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createTextarea() {
        textarea = new JTextArea();
        scrollPane = new JScrollPane(textarea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }

    private void createMenuBar() {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColor = new JMenu("Color");
        menuBar.add(menuColor);

        menuAbout = new JMenu("About");
        menuBar.add(menuAbout);

    }

    private void createFileMenuItems() {
        iNew = new JMenuItem("New");
        menuFile.add(iNew);

        iOpen = new JMenuItem("Open");
        menuFile.add(iOpen);

        iSave = new JMenuItem("Save");
        menuFile.add(iSave);

        iSaveAs = new JMenuItem("Save AS");
        menuFile.add(iSaveAs);

        iExit = new JMenuItem("Exit");
        menuFile.add(iExit);

        // adding ActionListener
        iNew.addActionListener(this);
        iNew.setActionCommand("New");

        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");

        iSave.addActionListener(this);
        iSave.setActionCommand("Save");

        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("SaveAs");

        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
    }

    private void createEditMenuItems() {
    }

    private void createFormatMenuItems() {

        iWordWrap = new JMenuItem("Word Wrap : OFF");
        menuFormat.add(iWordWrap);

        //
        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        //Font 
        iFontArial = new JMenuItem("Arial");
        menuFont.add(iFontArial);

        iFontCSMS = new JMenuItem("Comic Sans MS");
        menuFont.add(iFontCSMS);

        iFontTMR = new JMenuItem("Time New Roman");
        menuFont.add(iFontTMR);

        //Font size
        iFontSize8 = new JMenuItem("8");
        menuFontSize.add(iFontSize8);

        iFontSize12 = new JMenuItem("12");
        menuFontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("16");
        menuFontSize.add(iFontSize16);

        iFontSize20 = new JMenuItem("20");
        menuFontSize.add(iFontSize20);

        iFontSize24 = new JMenuItem("24");
        menuFontSize.add(iFontSize24);

        iFontSize28 = new JMenuItem("28");
        menuFontSize.add(iFontSize28);

        //seting addClickLIstListeners
        iWordWrap.addActionListener(this);
        iWordWrap.setActionCommand("Word Wrap");

        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");

        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("CSMS");

        iFontTMR.addActionListener(this);
        iFontTMR.setActionCommand("TMR");

        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("8");

        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("12");

        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("16");

        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("20");

        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("24");

        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("28");

    }

    private void createColorMenuItems() {
        iWhite = new JMenuItem("White");
        menuColor.add(iWhite);

        iBlack = new JMenuItem("Black");
        menuColor.add(iBlack);

        iBlue = new JMenuItem("Blue");
        menuColor.add(iBlue);

        //
        iWhite.addActionListener(this);
        iWhite.setActionCommand("White");

        iBlack.addActionListener(this);
        iBlack.setActionCommand("Black");

        iBlue.addActionListener(this);
        iBlue.setActionCommand("Blue");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "New":
                file.newFile();
                break;
            case "Open":
                file.open();
                break;
            case "Save":
                file.save();
                break;
            case "SaveAs":
                file.saveAs();
                break;
            case "Exit":
                file.exit();
                break;
            case "Word Wrap":
                format.wordWrap();
                break;
            case "8":
                format.createFont(8);
                break;
            case "12":
                format.createFont(12);
                break;
            case "16":
                format.createFont(16);
                break;
            case "18":
                format.createFont(18);
                break;
            case "20":
                format.createFont(20);
                break;
            case "24":
                format.createFont(24);
                break;
            case "28":
                format.createFont(28);
                break;
            case "Arial":
                format.setFont("Arial");
                break;
            case "CSMS":
                format.setFont("Comic Sans MS");
                break;
            case "TMR":
                format.setFont("Times New Roman");
                break;
            case "White":
                col.changeColor(command);
                break;
            case "Black":
                 col.changeColor(command);
                break;
            case "Blue":
                 col.changeColor(command);
                break;

        }
    }

}
