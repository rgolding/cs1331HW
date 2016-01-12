/**
*Represents a Stringed Instrument
*@author Rachel Golding
*October 20 2015
*@version 4.20
*/
public abstract class Stringed extends Instrument {
    protected int numStrings;
/**
 * Represents the Number of Strings that a Stringed Instrum has
 * @return numStrings number of strings
 */

    public int getNumStrings() {
        return numStrings;
    }
}