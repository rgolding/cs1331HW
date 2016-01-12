/**
*Represents a Flute Woodwind Instrument
*@author Rachel Golding
*October 20 2015
*@version 4.20
*/
public class Flute extends Woodwind {

    private String sound = "fluty-flute-flute";
    private String fluteOrReed = "Flute";
/**
 * Flute Instrument Contructor
 * @param price    Price of Instrument
 * @param serial Serial Number
 */
    public Flute(double price, int serial) {

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
        return ("Flute : Price: " + price + " : Serial : " + serial
            + " : Flute or Reed: " + fluteOrReed + " : Sound : "
            + sound + "\n");
    }

}