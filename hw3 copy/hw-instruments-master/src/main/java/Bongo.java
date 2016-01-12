/**
*Represents a Bongo Percussion Instrument
*@author Rachel Golding
*October 20 2015
*@version 4.20
*/
public class Bongo extends Percussion {

    private String sound = "bum-bum-bum";
    private String drumOrOther = "drum";
/**
 * Bongo Instrument Contructor
 * @param price    Price of Instrument
 * @param serial Serial Number
 */
    public Bongo(double price, int serial) {

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
        return ("Bongo : Price: " + price + " : Serial: " + serial
            + " : Drum or Other: " + drumOrOther + " : Sound: "
            + sound + "\n");
    }

}