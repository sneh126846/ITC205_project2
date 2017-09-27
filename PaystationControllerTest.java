/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpaystation;

import bcccp.carpark.ICarpark;
import bcccp.tickets.adhoc.IAdhocTicket;
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
public class PaystationControllerTest {
    
    public PaystationControllerTest(ICarpark carpark, IPaystationUI ui) {


        this.carpark_ = carpark;
	this.ui_ = ui;
        ui.registerController(this);		
	setState(PaystationController.STATE.IDLE);
    }
    
    @BeforeClass{
    public static void setUpClass(){
        adh = new AdhocTicket():
    }
    
    @AfterClass
    public static void tearDownClass() {
      adh = null;  
    }

    /**
     * Test of ticketInserted method, of class PaystationController.
     */
    @Test
    public void testTicketInserted() {
        System.out.println("ticketInserted");
        String barcode = "S1111";
        PaystationController instance = null;
        instance.ticketInserted(barcode);
        assertEquals(actual,expected);
    }

    /**
     * Test of ticketPaid method, of class PaystationController.
     */
    @Test
    public void testTicketPaid() {
        System.out.println("ticketPaid");
        PaystationController instance = null;
        instance.ticketPaid();
        assertTrue(amountispaid);
    }

    /**
     * Test of ticketTaken method, of class PaystationController.
     */
    @Test
    public void testTicketTaken() {
        System.out.println("ticketTaken");
        PaystationController instance = null;
        instance.ticketTaken();
        assertTrue(carexited);
    }
    
}

