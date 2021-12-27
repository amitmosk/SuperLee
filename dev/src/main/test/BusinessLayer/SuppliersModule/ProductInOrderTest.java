//package BusinessLayer.SuppliersModule;
//
//import BusinessLayer.InventoryModule.Item;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.time.LocalDate;
//import java.util.HashMap;
//
//import static org.junit.Assert.*;
//
//public class ProductInOrderTest {
//    private ProductInOrder pio;
//
//    @Before
//    public void setUp() {
//        Item p=new Item("product",1,"producer",1,1,1, LocalDate.now(),1.2,2);
//
//        Contract c=new Contract(100.0,1,new HashMap<>(),p);
//        pio=new ProductInOrder(100,c);
//    }
//
//    @Test
//    public void testOrderMore(){
//        pio.orderMore(10);
//        assertEquals(pio.getQuantity(),110);
//        assertEquals(pio.getTotalPrice(),100*110,0.0);
//    }
//}