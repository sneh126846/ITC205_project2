/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carsensor;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author snehpatel
 */
public class CarsensorTest {
    
    public CarsensorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Carsensor.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Carsensor.main(args);
        
    }

    /**
     * Test of registerResponder method, of class Carsensor.
     */
    @Test
    public void testRegisterResponder() {
        System.out.println("registerResponder");
        ICarSensorResponder responder = null;
        Carsensor instance = null;
        instance.registerResponder(responder);
        
    }

    /**
     * Test of deregisterResponder method, of class Carsensor.
     */
    @Test
    public void testDeregisterResponder() {
        System.out.println("deregisterResponder");
        ICarSensorResponder responder = null;
        Carsensor instance = null;
        instance.deregisterResponder(responder);
        

    /**
     * Test of getId method, of class Carsensor.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Carsensor instance = null;
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of carIsDetected method, of class Carsensor.
     */
    @Test
    public void testCarIsDetected() {
        System.out.println("carIsDetected");
        Carsensor instance = null;
        boolean expResult = false;
        boolean result = instance.carIsDetected();
        assertEquals(expResult, result);
       
    }
    
}
