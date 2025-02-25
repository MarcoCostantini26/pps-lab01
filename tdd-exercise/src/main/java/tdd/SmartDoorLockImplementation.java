package tdd;

public class SmartDoorLockImplementation implements SmartDoorLock{

    public static final int INITIAL_ATTEMPTS = 0;
    private boolean locked;
    private int pin;
    private int attempts;

    public SmartDoorLockImplementation() {
        this.locked = false;
        this.attempts = INITIAL_ATTEMPTS;
    }

    @Override
    public void setPin(int pin) {
        if(!this.isLocked() && !this.isBlocked()){
            this.pin = pin;
        }
    }

    @Override
    public void unlock(int pin) {
        if(this.pin == pin && !this.isBlocked() && this.isLocked()){
            this.locked = false;
        }else{
            this.attempts++;
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
        return this.attempts;
    }

    @Override
    public void reset() {

    }
}
