/**
*Represents a Serial Number Exception
*@author Rachel Golding
*October 20 2015
*@version 4.20
*/
public class SerialNumberException extends Exception {
/**
 * Represents Serial Number Exception
 */
    public SerialNumberException() {
        super("same serial number, try again");
    }
}