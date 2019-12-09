package fractiontester;

public class Fraction {

    int numerator; //The numerator, or top number, of the fraction
    
    int denominator; //The denominator, or bottom number, of the fraction
    
    String label; //The name given to the fraction

    static double pi = 3.1415;
    
    /**
     * Create a fraction given a numerator and a denominator (no label)
     * 
     * @param n The numerator of the fraction
     * @param d The denominator of the fraction
     */
    public Fraction(int n, int d) {
        numerator = n;
        denominator = d;
        label = "";
    }

    /**
     * Create a fraction given a numerator and a denominator (with label)
     * 
     * @param n The numerator of the fraction
     * @param d The denominator of the fraction
     * @param l The label of the fraction
     */
    public Fraction(int n, int d, String l) {
        this.numerator = n;
        this.denominator = d;
        this.label = l;
    }
    
    /**
     * Create a fraction given a decimal number (includes label)
     * 
     * @param d Decimal number to be converted to Fraction
     * @param l The label of the fraction
     */
    public Fraction (double d, String l)
    {
        this.label = l;
        String number = Double.toString(d); //The double as a String
        int point = number.indexOf(".");
        
        String numerator = number.substring(0, point) + number.substring(point+1, number.length()); //Take away the decimal point for the numeraotr
        this.numerator = Integer.parseInt(numerator); 
        
        int numDecimals = number.length() - point - 1; //Calculate number of decimal places for the denominator
        this.denominator = (int)Math.pow(10, numDecimals);
        
        this.reduce(); //Finally, reduce the fraction
    }
    
    /**
     * Created a Fraction from a string (no label)
     * 
     * @param s The string to be converted to Fraction
     */
    public Fraction (String s)
    {
        int slash = s.indexOf("/");
        this.numerator = Integer.parseInt(s.substring(0, slash)); //Take the numeratoe
        this.denominator = Integer.parseInt(s.substring(slash+1, s.length())); //Take the denominator
        this.label = "";
    }
    
    /**
     * Displays a Fraction for reading.
     */
    public void display() {
        String printedFrac;
        if (this.denominator != 1)
        {
            printedFrac = this.numerator + "/" + this.denominator; //If the denominator is not 1, print the fraction in its usual form
        }
        else
        {
            printedFrac = Integer.toString(this.numerator); //If it is 1, print the numerator as a whole number
        }
        if (label.equals("")) {
            System.out.println(printedFrac); //If there is no label, simply print the fraction
        } else {
            System.out.println(label + " = " + printedFrac); //If there is a label, print "Label = Fraction"
        }
    }

    /**
     * Reduces a fraction to its simplest form.
     */
    public void reduce() {
        int gcd = getGCD(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    /**
     * Converts a fraction to a decimal.
     * 
     * @return The fraction as a decimal
     */
    public double toDecimal() {
        return (double) numerator / denominator;
    }

    /**
     * Sets a label to a Fraction
     * 
     * @param name The label to be given to the Fraction
     */
    public void setLabel(String name) {
        this.label = name;
    }

    /**
     * Returns the reciprocal of a given fraction.
     * 
     * @return The reciprocal of the fraction.
     */
    public Fraction reciprocal() {
        Fraction recip = new Fraction(denominator, numerator); //Flips the fraction to get the reciprocal
        return recip;
    }

    /**
     * Multiplies two fractions together.
     * 
     * @param other The fraction being multiplied with this one.
     * @return The product of the two fractions
     */
    public Fraction multiply(Fraction other) {
        int n1, n2, d1, d2, LCM;

        n1 = this.numerator;
        d1 = this.denominator;

        n2 = other.numerator;
        d2 = other.denominator; //Sets int values for the values of the fractions

        return new Fraction(n1 * n2, d1 * d2); //Multiplies the Fractions
    }

    /**
     * Multiply a fraction by an integer
     * 
     * @param i The integer being multiplied
     * @return The product of the two values
     */
    public Fraction multiplyByInteger(int i) {
        int newNumerator = numerator * i;

        return new Fraction(newNumerator, denominator);
    }

    /**
     * Divides one fraction by another
     * 
     * @param other The divisor of the equation
     * @return The quotient of the two fractions
     */
    public Fraction divide(Fraction other)
    {
        Fraction recip = other.reciprocal();
        return this.multiply(recip); //Multiplies the fraction by its reciprocal
    }
    
    /**
     * Adds two fractions together
     * 
     * @param other The fraction being added with this one
     * @return The sum of the two fractions
     */
    public Fraction add(Fraction other)
    {
        Fraction sum = new Fraction(0, 0);
        sum.denominator = this.denominator * other.denominator; //Sets denominator to a common multiple
        sum.numerator = this.numerator * other.denominator + other.numerator * this.denominator; //Takes the numerators (multiplied due ot the setting of the denominators) and adds them
        sum.reduce(); //Reduce the fraction and return
        return sum;
    }
    
    /**
     * Returns a fraction to the power of a exponent
     * 
     * @param exponent The exponent being applied to the fraction
     * @return The result of the powering
     */
    public Fraction power(int exponent)
    {
        Fraction power = new Fraction(0, 0);
        power.numerator = (int)Math.pow(this.numerator, exponent);
        power.denominator = (int)Math.pow(this.denominator, exponent);
        return power;
    }
    
    
    //The following 4 methods are "static". 
    //This means that the user doesn't have to create a new Fraction object to use them.
    //Static methods are just "helper methods" that don't require information about any particular Fraction object.
    //To call a static method inside main, you use <CLASS NAME>.<METHOD NAME> instead of <OBJECT VARIABLE NAME>.<METHOD NAME>  
    //For example, Fraction.decimalToFraction(0.33)
    
    /**
     * Returns the greatest common denominator of two integers
     * 
     * @param a One integer
     * @param b Another integer
     * @return the GCD of the two integers
     */
    public static int getGCD(int a, int b) {
        int max, min, rem;

        max = Math.max(a, b); //Finds out which of the 2 numbers are larger and smaller
        min = Math.min(a, b);

        rem = max % min; //Checks if the numbers are multiples of each other 

        while (rem > 0) { //Simplifies the numbers to one multiple worth of min
            max = min;
            min = rem;
            rem = max % min; //Tries again to check if the numbers are multiples of each other
        }

        return min;
    }

    /**
     * Returns the lowest common multiple of two integers
     * 
     * @param a One integer
     * @param b Another integer
     * @return the LCM of the two integers
     */
    public static int getLCM(int a, int b) {
        int lcm = a * b / Fraction.getGCD(a, b);
        return lcm;
    }

    /**
     * Converts a decimal to a Fraction (an existing fraction, unlike the constructor I added
     * 
     * @param d The decimal to be converted to a fraction
     * @return The fraction after it has been converted
     */
    public static Fraction decimalToFraction(double d) {

        double numerator = d; //Multiplies both side by 10 until the numerator is whole
        int denominator = 1;

        while (!isWholeNumber(numerator)) {
            numerator *= 10;
            denominator *= 10;
        }

        int numer = (int) numerator; //Converts the numerator to an integer

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
