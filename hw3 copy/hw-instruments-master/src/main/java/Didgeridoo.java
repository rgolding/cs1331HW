/**
*Represents a Didgeridoo Brass Instrument
*@author Rachel Golding
*October 20 2015
*@version 4.20
*/
public class Didgeridoo extends Brass {

    private String sound = "dig-a-doooooo";
    private String valveOrSlide = "Valve";
/**
 * Represents Didgeridoo
 * @param price    price of instrum
 * @param serial    serial number
 */
    public Didgeridoo(double price, int serial) {

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
        return ("Didgeridoo : Price: " + price + " : Serial: " + serial
            + " : valveOrSlide: " + valveOrSlide + " : Sound: "
            + sound + "\n");
    }

}