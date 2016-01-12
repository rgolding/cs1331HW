
import java.util.ArrayList;
import java.util.List;
/**
*Represents a Musician
*@author Rachel Golding
*October 20 2015
*@version 4.20
*/
public class Musician {
    private List<Instrument> instruments = new ArrayList<Instrument>();
    private String name;
    private double funds;
/**
 * Represents a Musician
 * @param instruments  arraylist of instruments
 * @param name  name of musician
 * @param funds  how much moneys they gots
 */
    public Musician(ArrayList<Instrument> instruments, String name,
        double funds) {

        this.instruments = instruments;
        this.name = name;
        this.funds = funds;
    }
/**
 * Represents a Instruments Number
 * @return instrument size array lsit
 */

    public int getInstrumNum() {
        return instruments.size();
    }
/**
 * Represents Name of Musician
 * @return name of musician
 */

    public String getName() {
        return name;

    }
/**
 * Represents funds of Musician
 * @return funds of musician
 */
    public double getFunds() {
        return funds;
    }
/**
 * Represents Purchasing of Instruments
 * @param i Instrument
 */
    public void purchase(Instrument i) {
        //Check serial number first to see if you can buy it
        try {

            if (instruments.contains(i)) {
                throw new SerialNumberException();
            }
            if (funds - i.getPrice() < 0) {
                throw new NotEnoughFundsException();

            }

            if ((!instruments.contains(i)) && (funds - i.getPrice() >= 0)) {
                instruments.add(i);
                funds = funds - i.getPrice();


            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
/**
 * Represents Selling of Instruments
 * @param i Instrument
 */
    public void sell(Instrument i) {
        try {
            if (!instruments.contains(i)) {
                throw new InstrumDoesntExistException();
            }
            if (instruments.size() == 1) {
                throw new LastInstrumentException();
            }
            instruments.remove(i);
            funds = funds + i.getPrice();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }


    }
/**
 * Represents Purchasing of Instruments
 * @return string of insturments and funds
 */
    public String toString() {
        /*for(int i = 0; i < instruments.getInstrumNum(); i++) {
            System.out.println(i);
        }
        */
        System.out.println(instruments);

        return ("I got $" + funds);
    }



}