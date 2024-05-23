import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class SILab2Test {


    @Test
    void testCheckCartEveryBranch() {

        RuntimeException ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 100));
        assertEquals("allItems list can't be null!", ex.getMessage());


        assertTrue(SILab2.checkCart(List.of(), 0));


        assertTrue(SILab2.checkCart(List.of(new Item(null, "123456", 100, 0)), 100));


        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(new Item("Item1", "12a456", 100, 0)), 100));
        assertEquals("Invalid character in item barcode!", ex.getMessage());


        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(new Item("Item1", null, 100, 0)), 100));
        assertEquals("No barcode!", ex.getMessage());


        assertFalse(SILab2.checkCart(List.of(new Item("Item1", "123456", 200, 0.1f)), 180));


        assertTrue(SILab2.checkCart(List.of(new Item("Item1", "012345", 400, 0.1f)), 370));


        assertTrue(SILab2.checkCart(List.of(new Item("Item1", "012345", 400, 0f)), 400));


        assertTrue(SILab2.checkCart(List.of(new Item("Item1", "123456", 100, 0), new Item("Item2", "654321", 300, 0.2f)), 460));
    }


    @Test
    void testCheckCartMultipleCondition() {

        assertTrue(SILab2.checkCart(List.of(new Item("Item1", "012345", 400, 0.1f)), 370));


        assertTrue(SILab2.checkCart(List.of(new Item("Item1", "112345", 400, 0.1f)), 440));


        assertTrue(SILab2.checkCart(List.of(new Item("Item1", "012345", 400, 0f)), 400));


        assertTrue(SILab2.checkCart(List.of(new Item("Item1", "112345", 400, 0f)), 400));


        assertTrue(SILab2.checkCart(List.of(new Item("Item1", "012345", 200, 0.1f)), 220));


        assertTrue(SILab2.checkCart(List.of(new Item("Item1", "112345", 200, 0.1f)), 220));


        assertTrue(SILab2.checkCart(List.of(new Item("Item1", "012345", 200, 0f)), 200));


        assertTrue(SILab2.checkCart(List.of(new Item("Item1", "112345", 200, 0f)), 200));
    }
}
