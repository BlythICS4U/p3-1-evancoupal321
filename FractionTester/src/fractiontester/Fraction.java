package fractiontester;

public class Fraction {

    int numerator;
    int denominator;
    String label;

    static double pi = 3.1415;

    public Fraction(int n, int d) {
        numerator = n;
        denominator = d;
        label = "";
    }

    public Fraction(int n, int d, String l) {
        this.numerator = n;
        this.denominator = d;
        this.label = l;
    }

    //ADD A 3rd CONSTRUCTOR THAT LETS THE USER CREATE A FRACTION FROM A DECIMAL. 
    //FOR EXAMPLE, Fraction f = new Fraction(0.375)  WOULD SET f TO 3/8.
    //HINT: MAKE USE OF THE reduce() METHOD AT THE END.
    
    public void display() {
        String printedFrac = this.numerator + "/" + this.denominator; //IMPROVE THIS SO THAT ONLY THE NUMERATOR GETS PRINTED IF THE DENOMINATOR = 1

        if (label.equals("")) {
            System.out.println(printedFrac);
        } else {
            System.out.println(label + " = " + printedFrac);
        }
    }

    public void reduce() {
        int gcd = getGCD(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    public double toDecimal() {
        return (double) numerator / denominator;
    }

    public void setLabel(String name) {
        this.label = name;
    }

    public Fraction reciprocal() {
        Fraction recip = new Fraction(denominator, numerator);
        return recip;
    }

    public Fraction multiply(Fraction other) {
        int n1, n2, d1, d2, LCM;

        n1 = this.numerator;
        d1 = this.denominator;

        n2 = other.numerator;
        d2 = other.denominator;

        return new Fraction(n1 * n2, d1 * d2);
    }

    public Fraction multiplyByInteger(int i) {
        int newNumerator = numerator * i;

        return new Fraction(newNumerator, denominator);
    }

    //CODE THE divide() METHOD HERE. MAKE USE OF THE reciprocal() AND multiply() METHODS ABOVE
    
    //CODE THE add() METHOD HERE.  IT SHOULD LOOK VERY MUCH LIKE THE multiply() METHOD
    
    //CODE THE power() METHOD HERE.
    
    
    //The following 4 methods are "static". 
    //This means that the user doesn't have to create a new Fraction object to use them.
    //Static methods are just "helper methods" that don't require information about any particular Fraction object.
    //To call a static method inside main, you use <CLASS NAME>.<METHOD NAME> instead of <OBJECT VARIABLE NAME>.<METHOD NAME>  
    //For example, Fraction.decimalToFraction(0.33)
    
    public static int getGCD(int a, int b) {
        int max, min, rem;

        max = Math.max(a, b);
        min = Math.min(a, b);

        rem = max % min;

        while (rem > 0) {
            max = min;
            min = rem;
            rem = max % min;
        }

        return min;
    }

    public static int getLCM(int a, int b) {
        //CODE THIS USING THE GCD-LCM-PRODUCT THEOREM
        //http://www.cut-the-knot.org/Curriculum/Arithmetic/GcdLcm.shtml
        return -1;
    }

    public static Fraction decimalToFraction(double d) {

        double numerator = d;
        int denominator = 1;

        while (!isWholeNumber(numerator)) {
            numerator *= 10;
            denominator *= 10;
        }

        int numer = (int) numerator;

        Fraction f = new Fraction(numer, denominator);
        f.reduce();

        return f;

    }

    //This method is "private" instead of "public" because it's only needed by other methods in the class, and not by main().
    //The user has no access to it from main().
    private static boolean isWholeNumber(double d) {
        return d == Math.round(d);
    }

}
