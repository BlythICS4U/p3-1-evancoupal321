/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractiontester;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class FractionTest {

    /**
     * Test of display method, of class Fraction.
     */
    @Test
    public void testDisplay() {
        System.out.println("display");
        Fraction instance = new Fraction(3, 4);
        instance.display();
        assertEquals(instance.numerator, 3);
        assertEquals(instance.denominator, 4);
    }

    /**
     * Test of reduce method, of class Fraction.
     */
    @Test
    public void testReduce() {
        System.out.println("reduce");
        Fraction instance = new Fraction(9, 12);
        instance.reduce();
        assertEquals(instance.numerator, 3);
        assertEquals(instance.denominator, 4);
    }

    /**
     * Test of toDecimal method, of class Fraction.
     */
    @Test
    public void testToDecimal() {
        System.out.println("toDecimal");
        Fraction instance = new Fraction(3, 4);
        double result = instance.toDecimal();
        assertEquals(0.75, result, 0.0);
    }

    /**
     * Test of setLabel method, of class Fraction.
     */
    @Test
    public void testSetLabel() {
        System.out.println("setLabel");
        String name = "name";
        Fraction instance = new Fraction(3, 4);
        instance.setLabel(name);
        assertEquals(name, instance.label);
    }

    /**
     * Test of reciprocal method, of class Fraction.
     */
    @Test
    public void testReciprocal() {
        System.out.println("reciprocal");
        Fraction instance = new Fraction(3, 4);
        Fraction result = instance.reciprocal();
        assertEquals(instance.numerator, result.denominator);
        assertEquals(instance.denominator, result.numerator);
    }

    /**
     * Test of multiply method, of class Fraction.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        Fraction other = new Fraction(5, 6);
        Fraction instance = new Fraction(3, 4);
        Fraction expResult = new Fraction (15, 24);
        Fraction result = instance.multiply(other);
        assertEquals(expResult.numerator, result.numerator);
        assertEquals(expResult.denominator, result.denominator);
    }

    /**
     * Test of multiplyByInteger method, of class Fraction.
     */
    @Test
    public void testMultiplyByInteger() {
        System.out.println("multiplyByInteger");
        int i = 2;
        Fraction instance = new Fraction(3, 4);
        Fraction expResult = new Fraction (6, 4);
        Fraction result = instance.multiplyByInteger(i);
        assertEquals(expResult.numerator, result.numerator);
        assertEquals(expResult.denominator, result.denominator);
    }

    /**
     * Test of divide method, of class Fraction.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        Fraction other = new Fraction(5, 6);
        Fraction instance = new Fraction(3, 4);
        Fraction expResult = new Fraction (18, 20);
        Fraction result = instance.divide(other);
        assertEquals(expResult.numerator, result.numerator);
        assertEquals(expResult.denominator, result.denominator);
    }

    /**
     * Test of add method, of class Fraction.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Fraction other = new Fraction(5, 6);
        Fraction instance = new Fraction(3, 4);
        Fraction expResult = new Fraction(19, 12);
        Fraction result = instance.add(other);
        assertEquals(expResult.numerator, result.numerator);
        assertEquals(expResult.denominator, result.denominator);
    }

    /**
     * Test of power method, of class Fraction.
     */
    @Test
    public void testPower() {
        System.out.println("power");
        int exponent = 0;
        Fraction instance = new Fraction(3, 4);
        Fraction expResult = new Fraction(27, 64);
        Fraction result = instance.power(3);
        assertEquals(expResult.numerator, result.numerator);
        assertEquals(expResult.denominator, result.denominator);
    }

    /**
     * Test of getGCD method, of class Fraction.
     */
    @Test
    public void testGetGCD() {
        System.out.println("getGCD");
        int a = 12;
        int b = 15;
        int result = Fraction.getGCD(a, b);
        assertEquals(3, result);
    }

    /**
     * Test of getLCM method, of class Fraction.
     */
    @Test
    public void testGetLCM() {
        System.out.println("getLCM");
        int a = 12;
        int b = 15;
        int result = Fraction.getLCM(a, b);
        assertEquals(60, result);
    }

    /**
     * Test of decimalToFraction method, of class Fraction.
     */
    @Test
    public void testDecimalToFraction() {
        System.out.println("decimalToFraction");
        double d = 2.5;
        Fraction expResult = new Fraction (5, 2);
        Fraction result = Fraction.decimalToFraction(d);
        assertEquals(expResult.numerator, result.numerator);
        assertEquals(expResult.denominator, result.denominator);
    }
    
}
