package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    public static final int TESTING_PIN = 1234;
    private static final int TESTING_NEW_PIN = 1235;
    public static final int TESTING_WRONG_PIN = 1236;
    public static final int MAX_ATTEMPTS = 4;
    public static final int FAILED_ATTEMPTS_AFTER_RESET = 0;
    public static final int INITIAL_ATTEMPTS = 0;
    public static final int VALUE_HIGHER_THAN_MAX_ATTEMPTS = 6;

    @Test
    public void testInitialStateOfSmartDoor(){
        final SmartDoorLock smartDoorLock = new SmartDoorLockImplementation();
        assertFalse(smartDoorLock.isLocked());
    }

    @Test
    public void testSetPin(){
        final SmartDoorLock smartDoorLock = new SmartDoorLockImplementation();
        smartDoorLock.setPin(TESTING_PIN);
        smartDoorLock.lock();
        smartDoorLock.unlock(TESTING_PIN);
        assertFalse(smartDoorLock.isLocked());
    }

    @Test
    public void testSettingPinWithDoorLock(){
        final SmartDoorLock smartDoorLock = new SmartDoorLockImplementation();
        smartDoorLock.setPin(TESTING_PIN);
        smartDoorLock.lock();
        smartDoorLock.setPin(TESTING_NEW_PIN);
        smartDoorLock.unlock(TESTING_NEW_PIN);
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    public void testIncreasingOfAttemptsCounter(){
        final SmartDoorLock smartDoorLock = new SmartDoorLockImplementation();
        assertEquals(0, smartDoorLock.getFailedAttempts());
        smartDoorLock.setPin(TESTING_PIN);
        smartDoorLock.lock();
        smartDoorLock.unlock(TESTING_WRONG_PIN);
        assertEquals(1, smartDoorLock.getFailedAttempts());
        smartDoorLock.unlock(TESTING_PIN);
        assertEquals(1, smartDoorLock.getFailedAttempts());
    }

    @Test
    public void testBlockedDoorAfterMaxAttempts(){
        final SmartDoorLock smartDoorLock = new SmartDoorLockImplementation();
        smartDoorLock.setPin(TESTING_PIN);
        smartDoorLock.lock();
        for(int i = 0; i <= MAX_ATTEMPTS; i++){
            smartDoorLock.unlock(TESTING_WRONG_PIN);
        }
        assertTrue(smartDoorLock.isBlocked());
    }

    @Test
    public void testLockDoorWithPinNotSetted(){
        final SmartDoorLock smartDoorLock = new SmartDoorLockImplementation();
        assertThrows(IllegalStateException.class, smartDoorLock::lock);
    }

    @Test
    public void testResetDoor(){
        final SmartDoorLock smartDoorLock = new SmartDoorLockImplementation();
        smartDoorLock.setPin(TESTING_PIN);
        smartDoorLock.lock();
        for(int i = 0; i <= MAX_ATTEMPTS; i++){
            smartDoorLock.unlock(TESTING_WRONG_PIN);
        }
        smartDoorLock.reset();
        assertAll(
                () -> assertThrows(IllegalStateException.class, smartDoorLock::lock),
                () -> assertEquals(FAILED_ATTEMPTS_AFTER_RESET, smartDoorLock.getFailedAttempts()),
                () -> assertFalse(smartDoorLock.isBlocked()),
                () -> assertFalse(smartDoorLock.isLocked())
        );
    }

    @Test
    public void testEdgeCaseUnlockMultipleTimeWithBlockedDoor(){
        final SmartDoorLock smartDoorLock = new SmartDoorLockImplementation();
        smartDoorLock.setPin(TESTING_PIN);
        smartDoorLock.lock();
        for(int i = 0; i < VALUE_HIGHER_THAN_MAX_ATTEMPTS; i++){
            smartDoorLock.unlock(TESTING_WRONG_PIN);
        }
        assertAll(
                () -> assertTrue(smartDoorLock.isBlocked()),
                () -> assertEquals(VALUE_HIGHER_THAN_MAX_ATTEMPTS, smartDoorLock.getFailedAttempts())
        );
    }

    @Test
    public void testEdgeCaseUnlockDoorWithOpenDoor(){
        final SmartDoorLock smartDoorLock = new SmartDoorLockImplementation();
        smartDoorLock.setPin(TESTING_PIN);
        smartDoorLock.unlock(TESTING_PIN);
        assertAll(
                () ->  assertFalse(smartDoorLock.isLocked()),
                () -> assertEquals(INITIAL_ATTEMPTS, smartDoorLock.getFailedAttempts())
        );
    }
}
