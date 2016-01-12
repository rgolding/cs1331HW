/**
*Represents a Instrument
*@author Rachel Golding
*October 20 2015
*@version 4.20
*/
public abstract class Instrument {
    protected double price;
    protected int serial;
/**
 * Gets Price of Instrument
 * @return a Price
 */
    public double getPrice() {
        return price;
    }
/**
 * Gets Serial Number
 * @return a serial number
 */
    public int getSerial() {
        return serial;
    }
/**
 * Plays sound for instrument
 *@return null
 */
    public abstract String play();
/**
 * Compares Two Instruments
 *@param  other   another instrument
 * @return a Boolean
 */
    public boolean equals(Instrument other) {
        return (serial == other.getSerial());

    }



}