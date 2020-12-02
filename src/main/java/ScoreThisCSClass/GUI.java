/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScoreThisCSClass;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import java.util.List;
import javax.swing.ComboBoxModel;
/**
 * Write a description of class GUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class GUI 
{
    // instance variables - replace the example below 
    private JFrame frame;
    private String nameGiven;
    private String profNameGiven;
    private String classNumGiven;
    private JComboBox<String> classList;
    private ButtonGroup classDifficulty;
    private ButtonGroup teachingQuality;
    private boolean passed;
    private FileIO io;
    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        classDifficulty = new ButtonGroup();
        teachingQuality = new ButtonGroup();        
        makeFrame();
        frame.setVisible(true);
        io = new FileIO();
    }

    /**
     * An example of a method - replace this comment 
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    private void makeFrame()
    {
        // put your code here
        frame = new JFrame("HI!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        JMenu optionsMenu = new JMenu("Options");
        menubar.add(optionsMenu);
        JMenuItem about = new JMenuItem("What is this?");
        about.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    about();
                }
            });

        optionsMenu.add(about);
        JMenuItem quit = new JMenuItem("Exit");
        quit.addActionListener(new ActionListener(){ 

                public void actionPerformed(ActionEvent e) 
                {
                    quit();
                }
            });
        optionsMenu.add(quit);

        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setLayout(new BorderLayout(0, 0));
        contentPane.setBorder(new EmptyBorder( 15, 15, 15, 15));

        JLabel title = new JLabel("Rate this CS Class", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 20));
        title.setForeground(new Color(0,153,153));
        contentPane.add(title, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();

        GridLayout mainItems = new GridLayout(7,1);
        mainItems.setVgap(15);
        centerPanel.setLayout(mainItems);

        JPanel nameField = new JPanel();
        nameField.setLayout(new FlowLayout());
        nameField.add(new JLabel ("Your first and/or last name: "));
        JTextField name = new JTextField(12);

        name.getDocument().addDocumentListener(new DocumentListener() {

                public void changedUpdate(DocumentEvent e)
                {try{nameGiven = e.getDocument().getText(0, e.getDocument().getLength());}
                    catch(BadLocationException d)
                    {System.out.println("Something funky happened with your name");}}

                public void insertUpdate(DocumentEvent e)
                {try{nameGiven = e.getDocument().getText(0, e.getDocument().getLength());}
                    catch(BadLocationException d)
                    {System.out.println("Something funky happened with your name");}}

                public void removeUpdate(DocumentEvent e)
                {try{nameGiven = e.getDocument().getText(0, e.getDocument().getLength());}
                    catch(BadLocationException d)
                    {System.out.println("Something funky happened with your name");}}
            });
        nameField.add(name);

        centerPanel.add(nameField);

        JPanel profNameField = new JPanel();
        profNameField.setLayout(new FlowLayout());
        profNameField.add(new JLabel ("Professor's name: "));
        JTextField profNameBox = new JTextField(12);

        profNameBox.getDocument().addDocumentListener(new DocumentListener() {

                public void changedUpdate(DocumentEvent e)
                {try{profNameGiven = e.getDocument().getText(0, e.getDocument().getLength());}
                    catch(BadLocationException d)
                    {System.out.println("Something funky happened with the prof's name");}}

                public void insertUpdate(DocumentEvent e)
                {try{profNameGiven = e.getDocument().getText(0, e.getDocument().getLength());}
                    catch(BadLocationException d)
                    {System.out.println("Something funky happened with the prof's name");}}

                public void removeUpdate(DocumentEvent e)
                {try{profNameGiven = e.getDocument().getText(0, e.getDocument().getLength());}
                    catch(BadLocationException d)
                    {System.out.println("Something funky happened with the prof's name");}}
            });

        profNameField.add(profNameBox);

        centerPanel.add(profNameField);

        JPanel classNum = new JPanel();

        classNum.setLayout(new FlowLayout());
        classNum.add(new JLabel("Pick your CS class to score: "));

        String classNumList[] = {"CS101", "CS121", "CS122", "CS160", "CS161", "CS162", "CS195", "CS260", "CS262", "CS271"};
        classList = new JComboBox<>(classNumList);

        classNum.add(classList);
        centerPanel.add(classNum);

        JPanel scores = new JPanel();
        scores.add(new JLabel("Scores"));
        centerPanel.add(scores);

        JPanel difficultyRating = new JPanel();
        difficultyRating.setLayout(new FlowLayout());

        difficultyRating.add(new JLabel("Difficulty: "));

        JRadioButton one = new JRadioButton("1");
        one.setActionCommand("1");
        difficultyRating.add(one);
        JRadioButton two = new JRadioButton("2");
        two.setActionCommand("2");
        difficultyRating.add(two);
        JRadioButton three = new JRadioButton("3", true);
        three.setActionCommand("3");
        difficultyRating.add(three);
        JRadioButton four = new JRadioButton("4");
        four.setActionCommand("4");
        difficultyRating.add(four);
        JRadioButton five = new JRadioButton("5");
        five.setActionCommand("5");
        difficultyRating.add(five);

        classDifficulty.add(one);
        classDifficulty.add(two);
        classDifficulty.add(three);
        classDifficulty.add(four);
        classDifficulty.add(five);

        centerPanel.add(difficultyRating);

        JPanel classQuality = new JPanel();
        classQuality.setLayout(new FlowLayout());

        classQuality.add(new JLabel("Teaching Quality: "));

        JRadioButton oneq = new JRadioButton("1");
        oneq.setActionCommand("1");
        teachingQuality.add(oneq);
        JRadioButton twoq = new JRadioButton("2");
        twoq.setActionCommand("2");
        teachingQuality.add(twoq);
        JRadioButton threeq = new JRadioButton("3", true);
        threeq.setActionCommand("3");
        teachingQuality.add(threeq);
        JRadioButton fourq = new JRadioButton("4");
        fourq.setActionCommand("4");
        teachingQuality.add(fourq);
        JRadioButton fiveq = new JRadioButton("5");
        fiveq.setActionCommand("5");
        teachingQuality.add(fiveq);

        classQuality.add(oneq);
        classQuality.add(twoq);
        classQuality.add(threeq);
        classQuality.add(fourq);
        classQuality.add(fiveq);

        centerPanel.add(classQuality);

        JPanel panelPassed = new JPanel();
        JCheckBox checkPassed = new JCheckBox("I passed this class.");
        checkPassed.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    JCheckBox temp = (JCheckBox)e.getSource();
                    passed = temp.isSelected();
                }
            });

        panelPassed.add(checkPassed);
        centerPanel.add(panelPassed);

        contentPane.add(centerPanel, BorderLayout.CENTER);
        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout());
        JLabel submitText = new JLabel("Submit Score?");
        bottom.add(submitText);
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    checkNames();
                }
            }
        );
        bottom.add(submitButton);

        JButton showList = new JButton("Show Scores");
        showList.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    io.executeOpen();

                }
            }
        );
        bottom.add(showList);

        JButton clearList = new JButton("Clear Scores");
        clearList.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    System.out.print ('\f');
                    io.executeWipe();
                    JOptionPane.showConfirmDialog(null,
                        "Wipe was successful!", "Title is a Title", JOptionPane.DEFAULT_OPTION);
                }
            }
        );
        bottom.add(clearList);
        contentPane.add(bottom, BorderLayout.SOUTH);
        frame.pack();

    }

    public void showFrame()
    {
        frame.setVisible(true);
    }

    public void checkNames()
    {

        try
        {
            if((!nameGiven.matches("(\\w+ ?\\w*)"))||nameGiven.matches("\\D*\\d+\\D*"))
            {throw new InvalidCharaException(nameGiven);}
            if((!profNameGiven.matches("\\w+ ?\\w*"))||(profNameGiven.matches("\\D*\\d+\\D*")))
            {throw new InvalidCharaException(profNameGiven);}
            submit();
        }

        catch(NullPointerException s)
        {
            JOptionPane.showMessageDialog(frame, "Whoops! You must enter a name! Try entering your name and a professor's name before submitting.");
        }

        catch(InvalidCharaException e)
        {

            JOptionPane.showMessageDialog(frame, e.errorMessage());

        }

    }

    public void submit()
    {
        Integer difficulty = new Integer(classDifficulty.getSelection().getActionCommand());
        Integer quality = new Integer(teachingQuality.getSelection().getActionCommand());
        classNumGiven = classList.getSelectedItem().toString();
        CsClass csClass = new CsClass(classNumGiven, difficulty.intValue(), quality.intValue(), nameGiven, profNameGiven, passed);
        io.executeSave(csClass.toString());
        JOptionPane.showConfirmDialog(null,
            "Submition was successful!", "Title is a Title", JOptionPane.DEFAULT_OPTION);
    }

    public void quit()
    {
        System.exit(0);
    }

    public void about()
    {
        JOptionPane.showMessageDialog(frame, "Score this CS Class v1.0\n-Created by Daniel Frank-\n2013\nThis program will save your rating for a computer science class for any professor.");

    }
}
