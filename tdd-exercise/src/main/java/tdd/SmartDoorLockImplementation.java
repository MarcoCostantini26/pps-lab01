package tdd;

public class SmartDoorLockImplementation implements SmartDoorLock{

    public static final int INITIAL_ATTEMPTS = 0;
    public static final int MAX_ATTEMPTS = 4;
    private boolean locked;
    private boolean blocked;
    private int pin;
    private int attempts;

    public SmartDoorLockImplementation() {
        this.locked = false;
        this.blocked = false;
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
        if(this.isDoorUnlockable(pin)){
            this.locked = false;
        }else{
            this.increasingAttemptsVerifingMaxAttempts();
        }
    }

    private boolean isDoorUnlockable(int pin){
        if(this.pin == pin && !this.isBlocked() && this.isLocked()){
            return true;
        }else{
            return false;
        }
    }

    private void increasingAttemptsVerifingMaxAttempts(){
        if(this.getFailedAttempts() == this.getMaxAttempts()){
            this.blocked = true;
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
        return this.blocked;
    }

    @Override
    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    @Override
    public int getFailedAttempts() {
        return this.attempts;
    }

    @Override
    public void reset() {

    }
}
