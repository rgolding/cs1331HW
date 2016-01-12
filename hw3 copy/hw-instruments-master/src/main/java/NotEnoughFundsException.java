/**
*Represents a Not Enough Funds Exception
*@author Rachel Golding
*October 20 2015
*@version 4.20
*/
public class NotEnoughFundsException extends Exception {
/**
 * Represents Not enough funds Exception
 */
    public NotEnoughFundsException() {
        super("Not enough money rock star, try again");
    }
}