/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrypass;

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
public class EntryControllerTest {
    
    public EntryControllerTest() {
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
     * Test of carEventDetected method, of class EntryController.
     */
    @Test
    public void testCarEventDetected() {
        System.out.println("carEventDetected");
        String detectorId = "S2222";
        boolean carDetected = false;
        EntryController instance = null;
        instance.carEventDetected(detectorId, carDetected);
       
    }

    /**
     * Test of buttonPushed method, of class EntryController.
     */
    @Test
    public void testButtonPushed() {
        System.out.println("buttonPushed");
        EntryController instance = null;
        instance.buttonPushed();
        
    }

    /**
     * Test of ticketInserted method, of class EntryController.
     */
    @Test
    public void testTicketInserted() {
        System.out.println("ticketInserted");
        String barcode = "";
        EntryController instance = null;
        instance.ticketInserted(barcode);
      
    }

    /**
     * Test of ticketTaken method, of class EntryController.
     */
    @Test
    public void testTicketTaken() {
        System.out.println("ticketTaken");
        EntryController instance = null;
        instance.ticketTaken();
        
    }

    /**
     * Test of notifyCarparkEvent method, of class EntryController.
     */
    @Test
    public void testNotifyCarparkEvent() {
        System.out.println("notifyCarparkEvent");
        EntryController instance = null;
        instance.notifyCarparkEvent();
        
    }
    
}
