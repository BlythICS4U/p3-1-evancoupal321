# p3-1 OOP Fraction Class Practice

Make the following additions/modifications to the included FractionTester project

1. Add the following methods to the Fraction class

```
public Fraction add(Fraction other) { ... }
```
Example usage in main()
```
Fraction f = new Fraction(3,4);
Fraction g = new Fraction(1,3);
Fraction fPlusG = f.add(g)
fPlusG.setLabel("f + g")
fPlusG.display()
```
Output
```
f + g = 13/12
```

```
public Fraction power(int exponent) { ... }
```
Example usage in main()
```
Fraction h = new Fraction(3, 2);
Fraction hToThe5 = f.power(5);
hToThe5.setLabel("h^5");
hToThe5.display();
```
Output
```
h^5 = 243/32
```

```
public Fraction divide(Fraction other) { ... }
```
Example usage in main()
```
Fraction f = new Fraction(3,4);
Fraction g = new Fraction(1,3);
Fraction fDivideG = f.divide(g)
fDivideG.setLabel("f / g")
fDivideG.display()
```
Output
```
f / g = 9/4
```

```
public Fraction(double d) { ... }  //creates the fractional equivalent of decimal d
public Fraction(String s) { ... }  //creates a fraction from a String, such as “3/4”
```
Example usage in main()
```
Fraction k = new Fraction(2.4, "k");
Fraction m = new Fraction("18/5")
k.display();
Fraction kPlusM = m.add(k);
kPlusM.display();
```
Output
```
k = 12/5
30/5
```

```
public static int getLCM(int a, int b) { ... }
```
Example usage in main()
```
int gcd = Fraction.getGCD(12, 15);
int lcm = Fraction.getLCM(12, 15); //CODE THE getLCM() METHOD
System.out.println("The GCD of 12 and 15 is " + gcd + ", and their LCM is " + lcm + "\n");
```
Output
```
The GCD of 12 and 15 is 3, and their LCM is 60
```

2. Add proper documentation to the Fraction class.
  * Class summary
  * Document each field
  * Document all public methods
  * Document all non-intuitive blocks of code
