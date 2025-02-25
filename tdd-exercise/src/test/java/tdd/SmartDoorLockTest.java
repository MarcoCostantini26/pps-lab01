package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    @Test
    public void todo() {
        assertTrue(true);
    }

    @Test
    public void testInitialStateOfSmartDoor(){
        final SmartDoorLock smartDoorLock = new SmartDoorLockImplementation();
        assertEquals(false, smartDoorLock.isLocked());
    }
}
