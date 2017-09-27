package entrypass;

import bcccp.carpark.Carpark;
import bcccp.carpark.ICarSensor;
import bcccp.carpark.ICarSensorResponder;
import bcccp.carpark.ICarpark;
import bcccp.carpark.ICarparkObserver;
import bcccp.carpark.IGate;
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
public class EntryControllerTest {
    
    public EntryControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        ICarSensor ui;
        ICarSensor os;
        ICarSensor is;
        adhocTicketDAO = new AdhocTicketDAO(new AdhocTicketFactory());
        seasonTickteDAO = new seasonTicketDAO(new TicketusagerecordFactory());
    }
    
    @AfterClass
    public static void tearDownClass() {
        adhocTicketDAO = null;
        seasonTicketDAO = null;
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        adhocTicketDAO = null;
        seasonTicketDAO = null;
    }

    /**
     * Test of carEventDetected method, of class EntryController.
     */
    @Test
    public void testCarEventDetected() {
        System.out.println("carEventDetected");
        String detectorId = "S1111";
        boolean carDetected = true;
        EntryController instance = null;
        instance.carEventDetected(detectorId, carDetected);
        assertEquals(expected,actual);
    }

    /**
     * Test of buttonPushed method, of class EntryController.
     */
    @Test
    public void testButtonPushed() {
        System.out.println("buttonPushed");
        EntryController instance = null;
        instance.buttonPushed();
        assertTrue("s1111");
    }

    /**
     * Test of ticketInserted method, of class EntryController.
     */
    @Test
    public void testTicketInserted() {
        System.out.println("ticketInserted");
        String barcode = "RF34112";
        EntryController instance = null;
        instance.ticketInserted(barcode);
        assertTrue(TicketInUse):
    }

    /**
     * Test of ticketTaken method, of class EntryController.
     */
    @Test
    public void testTicketTaken() {
        System.out.println("ticketTaken");
        EntryController instance = null;
        instance.ticketTaken();
        assertFalse(TicketIsValid);
    }

    /**
     * Test of notifyCarparkEvent method, of class EntryController.
     */
    @Test
    public void testNotifyCarparkEvent() {
        System.out.println("notifyCarparkEvent");
        EntryController instance = null;
        instance.notifyCarparkEvent();
        assertTrue(CarHasExited());
    }
    
}
