/**
*Represents a Intrument Doesn't Exist Exception
*@author Rachel Golding
*October 20 2015
*@version 4.20
*/
public class InstrumDoesntExistException extends Exception {
/**
 * Represents Instrument Doesn't Exist Exception
 */
    public InstrumDoesntExistException() {
        super("Can't sell somethin you ain't have, cowboy");
    }
}