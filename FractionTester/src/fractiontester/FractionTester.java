package fractiontester;


/**
 * Fraction Tester allows the use to input fractions in a
 * variety of ways and perform operations on them.
 * 
 * @author Evan Coupal
 */
public class FractionTester {

    public static void blankLine() {
        System.out.println("");
    }

    public static void main(String[] args) {

        //CONSTRUCTING NEW FRACTIONS. NOTE THAT THIS CLASS OFFERS 2 DIFFERENT TYPES OF CONSTRUCTORS
        Fraction e = new Fraction(1, 2);
        Fraction f = new Fraction(4, 3, "my fraction");
        Fraction g = new Fraction(20, 80, "your fraction");

        blankLine();

        //USING THE display() METHOD
        e.display();
        f.display();
        g.display();

        blankLine();

        //USING THE reduce() METHOD
        g.reduce();
        g.display();

        blankLine();
      
        //USING THE toDecimal() METHOD
        double fDecimal = f.toDecimal();
        double gDecimal = g.toDecimal();
        System.out.println(f.label + " is equivalent to " + fDecimal);
        System.out.println(g.label + " is equivalent to " + gDecimal);

        blankLine();

        //USING METHODS THAT CREATE AND RETURN NEW FRACTION OBJECTS: reciprocal(), multiply(), power(), add()
        Fraction oneOverF = f.reciprocal();
        oneOverF.setLabel("1 / f");
        oneOverF.display();

        Fraction oneOverG = g.reciprocal();
        oneOverG.setLabel("1 / g");
        oneOverG.display();
        System.out.println("");

        Fraction prodFG = f.multiply(g);
        prodFG.setLabel("f x g");
        prodFG.display();
        prodFG.reduce();
        prodFG.display();
        System.out.println("");

        Fraction fSquared = f.multiply(f);
        fSquared.setLabel("f^2");
        fSquared.display();

        Fraction fCubed = f.power(3);
        fCubed.setLabel("f^3");
        fCubed.display();
        double fCubedDecimal = fCubed.toDecimal();
        System.out.println("f^3 is equivalent to " + fCubedDecimal);

        blankLine();
        
        Fraction fToTheFour = f.power(4);
        fToTheFour.setLabel("f^4");
        fToTheFour.display();
        
        blankLine();
        
        Fraction sumFG = f.add(g);
        sumFG.setLabel("f + g");
        sumFG.display();
        blankLine();
        
        Fraction divideFG = f.divide(g);
        divideFG.setLabel("f / g");
        divideFG.display();
        blankLine();
        
        
        //USING STATIC METHODS OF THE FRACTION CLASS: getGCD AND getLCM
        //STATIC MEANS THAT THE METHOD DOESN'T WORK WITH ANY PARTICULAR FRACTION OBJECT
        //THAT IS, THE METHOD BELONGS TO THE CLASS AS A WHOLE, AND NOT TO ANY PARTICULAR OBJECT OF THAT CLASS.
        //STATIC METHODS ARE CALLED INSIDE main() USING THE SYNTAX Fraction.staticMethodName() INSTEAD OF f.methodName() WHERE f IS SOME FRACTION OBJECT
        int gcd = Fraction.getGCD(12, 15);
        int lcm = Fraction.getLCM(12, 15);

        System.out.println("The GCD of 12 and 15 is " + gcd + ", and their LCM is " + lcm + "\n");
        
        blankLine();
        
        //Using the constructors of the Fraction class, create fraction in unique ways and display them.
        Fraction k = new Fraction(2.4, "k");
        Fraction m = new Fraction("18/5");
        k.display();
        Fraction kPlusM = m.add(k);
        kPlusM.display();
        
        blankLine();
        
        Fraction h = new Fraction(0.125, "h"); 
        Fraction i = new Fraction(2.5, "i"); 
        h.display();
        i.display();
    }

}
