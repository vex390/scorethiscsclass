/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScoreThisCSClass;


import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;
import java.nio.file.Files;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
/**
 * Write a description of class FileIO here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FileIO
{
    // instance variables - replace the example below with your own
    private String doc;

    /**
     * Constructor for objects of class FileIO
     */
    public FileIO()
    {
        // initialise instance variables
        doc = "";
        readFile();
    }

    public void executeOpen()
    {
        if(doc.length() < 10)
        {JOptionPane.showConfirmDialog(null,
                "There are no scores to show! Submit a score first.", "Title is a Title", JOptionPane.DEFAULT_OPTION);}
        else
        {   System.out.print ('\f');
            System.out.println(doc);
        }
    }

        public void readFile()
        {
            try(BufferedReader reader = new BufferedReader(new FileReader("ratings.txt")))
            {
                StringBuilder sb = new StringBuilder();
                String line = reader.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = reader.readLine();
                }
                doc = sb.toString();      
            }
            catch(IOException e)
            {

            }
        }

        public void executeSave(String details)
        {
            // put your code here
            doc = doc + System.lineSeparator() + details;
            try(FileWriter writer = new FileWriter("ratings.txt"))
            {

                writer.write(doc);
                writer.write(System.lineSeparator());          
                writer.close();
            }
            catch(FileNotFoundException e)
            {

            }
            catch(IOException e)
            {
                System.out.println("An error occured while writing");
            }
        }

        public void executeWipe()
        {
            doc = "";
            executeSave("");
        }
    }
