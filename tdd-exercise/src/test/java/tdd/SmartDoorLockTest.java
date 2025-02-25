package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    public static final int TESTING_PIN = 1234;
    private static final int TESTING_NEW_PIN = 1235;
    public static final int TESTING_WRONG_PIN = 1236;

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

    @Test
    public void testSettingPinWithDoorLock(){
        final SmartDoorLock smartDoorLock = new SmartDoorLockImplementation();
        smartDoorLock.setPin(TESTING_PIN);
        smartDoorLock.lock();
        smartDoorLock.setPin(TESTING_NEW_PIN);
        smartDoorLock.unlock(TESTING_NEW_PIN);
        assertEquals(true, smartDoorLock.isLocked());
    }

    @Test
    public void testIncreasingOfAttemptsCounter(){
        final SmartDoorLock smartDoorLock = new SmartDoorLockImplementation();
        assertEquals(0, smartDoorLock.getFailedAttempts());
        smartDoorLock.setPin(TESTING_PIN);
        smartDoorLock.lock();
        smartDoorLock.unlock(TESTING_WRONG_PIN);
        assertEquals(1, smartDoorLock.getFailedAttempts());
    }
}
