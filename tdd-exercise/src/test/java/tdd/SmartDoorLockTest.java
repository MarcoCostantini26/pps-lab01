package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    public static final int TESTING_PIN = 1234;

    @Test
    public void todo() {
        assertTrue(true);
    }

    @Test
    public void testInitialStateOfSmartDoor(){
        final SmartDoorLock smartDoorLock = new SmartDoorLockImplementation();
        assertEquals(false, smartDoorLock.isLocked());
    }

    @Test
    public void testSetPin(){
        final SmartDoorLock smartDoorLock = new SmartDoorLockImplementation();
        smartDoorLock.setPin(TESTING_PIN);
        smartDoorLock.lock();
        smartDoorLock.unlock(TESTING_PIN);
        assertEquals(false, smartDoorLock.isLocked());
    }
}
