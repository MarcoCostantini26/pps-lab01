package tdd;

public class SmartDoorLockImplementation implements SmartDoorLock{

    private boolean locked;
    private int pin;

    public SmartDoorLockImplementation() {
        this.locked = false;
    }

    @Override
    public void setPin(int pin) {
        if(!this.isLocked() || !this.isBlocked()){
            this.pin = pin;
        }
    }

    @Override
    public void unlock(int pin) {
        if(pin == this.pin && !this.isBlocked()){
            this.locked = false;
        }
    }

    @Override
    public void lock() {
        this.locked = true;
    }

    @Override
    public boolean isLocked() {
        return this.locked;
    }

    @Override
    public boolean isBlocked() {
        return false;
    }

    @Override
    public int getMaxAttempts() {
        return 0;
    }

    @Override
    public int getFailedAttempts() {
        return 0;
    }

    @Override
    public void reset() {

    }
}
