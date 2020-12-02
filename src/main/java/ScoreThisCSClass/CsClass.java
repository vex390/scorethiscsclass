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
public class CsClass extends Class
{
    // instance variables - replace the example below with your own
    private String classNum;

    /**
     * Constructor for objects of class CsClass
     */
    public CsClass(String classNum, int difficulty, int profQuality, String name, String prof, boolean passed)
    {
        // initialise instance variables
        super(difficulty, profQuality, name, prof, passed);
        this.classNum = classNum;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String getClassNum()
    {
        // put your code here
        return classNum;
    }
    
    public String toString()
    {
        return classNum + System.lineSeparator() + super.toString();
    }
}
