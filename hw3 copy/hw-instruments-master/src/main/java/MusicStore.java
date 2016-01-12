
import java.util.ArrayList;
//import java.util.List;
/**
*Represents a Music Store for Testing
*@author Rachel Golding
*October 20 2015
*@version 4.20
*/
public class MusicStore {
/**
 * Represents Cases of Exceptions and Stuff
 * @param args for stuff
 */
    public static void main(String[] args) {


        Instrument testUkulele = new Ukulele(500.00, 1234);
        Instrument testUkulele2 = new Ukulele(500.00, 1234);
        Instrument testUkulele3 = new Ukulele(0, 0000);
        //System.out.println(testUkulele.play());
        Instrument testFlute = new Flute(123.00, 1235);
        Instrument testFlute2 = new Flute(123.00, 1235);
        Instrument testFlute3 = new Flute(0, 0000);
        //System.out.println(testFlute.play());
        Instrument testDidgeridoo = new Didgeridoo(100.00, 1236);
        Instrument testDidgeridoo2 = new Didgeridoo(100.00, 1236);
        Instrument testDidgeridoo3 = new Didgeridoo(0, 0002);
        //System.out.println(testDidgeridoo.play());
        Instrument testBongo = new Bongo(50.00, 1237);
        Instrument testBongo2 = new Bongo(50.00, 1237);
        Instrument testBongo3 = new Bongo(10000, 0003);
        //System.out.println(testBongo.play());

        ArrayList<Instrument> testArray = new ArrayList<Instrument>();
        testArray.add(testUkulele);
        testArray.add(testFlute);
        //for (Instrument instrum:testArray) {
        //  System.out.println(instrum.toString());
        //}
        ArrayList<Instrument> testArray2 = new ArrayList<Instrument>();
        testArray2.add(testDidgeridoo);
        testArray2.add(testBongo);

        ArrayList<Instrument> testArray3 = new ArrayList<Instrument>();
        testArray3.add(testUkulele);




        Musician test1 = new Musician(testArray, "TSwizzle", 1000);
        System.out.println(test1.toString());
        test1.purchase(testUkulele2);
        test1.purchase(testFlute2);
        //test1.purchase(testBongo);
        System.out.println(test1.toString());

        test1.sell(testUkulele2);
        test1.sell(testBongo);
        System.out.println(test1.toString());



        Musician test2 = new Musician(testArray2, "Rachel", 100);
        System.out.println(test2.toString()); //Didgeridoo and Bongo
        test2.purchase(testBongo); //Already has, throws exception
        test2.purchase(testUkulele2); // Can buy, funds--> $0
        test2.purchase(testUkulele); // Can't buy, too expensive,throw exception
        System.out.println(test2.toString()); // Didgeridoo, Bongo, andUkulele 2
        test2.sell(testBongo); // Sells, makes money
        test2.sell(testFlute); // Can't sell, doesn't have
        System.out.println(test2.toString()); //Didgeridoo, Ukulele2



        Musician test3 = new Musician(testArray3, "Josh", 500);
        System.out.println(test3.toString());
        test3.purchase(testDidgeridoo);
        System.out.println(test3.toString());
        test3.purchase(testDidgeridoo);
        System.out.println(test3.toString());
        test3.purchase(testBongo3);
        System.out.println(test3.toString());
        test3.sell(testUkulele);
        System.out.println(test3.toString());
        test3.sell(testBongo);
        System.out.println(test3.toString());
        test3.sell(testDidgeridoo);
        System.out.println(test3.toString());

































    }
}
