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
public class InvalidCharaException extends Exception
{
    // instance variables - replace the example below with your own
    private String incorrectName;

    /**
     * Constructor for objects of class InvalidCharaException
     */
    public InvalidCharaException(String incorrect)
    {
        // initialise instance variables
        incorrectName = incorrect;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String errorMessage()
    {
        // put your code here
        return "People do not have names like this: " + incorrectName + "\nPlease enter a real name with no symbols";
    }
}