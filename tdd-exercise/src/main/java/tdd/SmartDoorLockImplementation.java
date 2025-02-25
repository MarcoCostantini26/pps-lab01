package tdd;

public class SmartDoorLockImplementation implements SmartDoorLock{

    public static final int INITIAL_ATTEMPTS = 0;
    public static final int MAX_ATTEMPTS = 4;
    public static final int INITIAL_PIN = 0;
    private boolean locked;
    private boolean blocked;
    private int pin;
    private int attempts;

    public SmartDoorLockImplementation() {
        this.locked = false;
        this.blocked = false;
        this.attempts = INITIAL_ATTEMPTS;
        this.pin = INITIAL_PIN;
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
        return this.pin == pin && !this.isBlocked();
    }

    private void increasingAttemptsVerifingMaxAttempts(){
        this.attempts++;
        if(this.getFailedAttempts() >= this.getMaxAttempts()){
            this.blocked = true;
        }
    }

    @Override
    public void lock() {
        if(isPinSetted()){
            this.locked = true;
        }else{
            throw new IllegalStateException("The Pin is not setted");
        }

    }

    private boolean isPinSetted(){
        return this.pin != INITIAL_PIN;
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
        this.locked = false;
        this.blocked = false;
        this.pin = INITIAL_PIN;
        this.attempts = INITIAL_ATTEMPTS;
    }
}
