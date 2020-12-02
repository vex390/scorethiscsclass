/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScoreThisCSClass;

/**
 *
 * @author Daniel
 */
public class Class implements Admin
{
    // instance variables - replace the example below with your own
    private int difficulty;
    private String name;
    private String prof;
    private int profQuality;
    private boolean passed;
    private String passOrFail;
    /**
     * Constructor for objects of class Class
     */
    public Class(int difficulty, int profQuality, String name, String prof, boolean passed)
    {
        // initialise instance variables
        this.difficulty = difficulty;
        this.profQuality = profQuality;
        this.name = name;
        this.prof = prof;
        this.passed = passed;
        if(passed)
        {passOrFail = "passed";}
        else passOrFail = "failed";
    }

    public String toString()
    {
        return "Difficulty: " + difficulty + "/5" + System.lineSeparator() + "Professor: " + prof + System.lineSeparator() + "Teaching Quality: " + profQuality + "/5" + System.lineSeparator() + "Scored by: " + name + " (" + passOrFail + ")" + System.lineSeparator() + "\n";
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void fixTeacherRating()
    {
        // put your code here
        if(profQuality < 5)
        profQuality++;
    }
    
    public void boostNewStudentMorale()
    {
        if(difficulty > 1)
        difficulty--;
    }
}