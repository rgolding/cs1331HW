/**
*Represents a Ukulele Stringed Instrument
*@author Rachel Golding
*October 20 2015
*@version 4.20
*/
public class Ukulele extends Stringed {

    private String sound = "strummy-la-di-da";
    private int numStrings = 4;
/**
 * Ukulele Instrument Contructor
 * @param price    Price of Instrument
 * @param serial Serial Number
 */
    public Ukulele(double price, int serial) {

        this.price = price;
        this.serial = serial;
    }
/**
 *Plays sound of Instrument
 * @return sound string of sound
 */
    public String play() {
        return sound;
    }
/**
 * toString of Bongos
 * @return string of name, price, serial, sound
 */
    public String toString() {
        return ("Ukulele : Price: " + price + " : Serial: " + serial
            + " : Number of Strings: " + numStrings + " : Sound: "
            + sound + "\n");
    }

}