import java.util.concurrent.Semaphore;

public class PersonLock {
    private PersonLock(){}
    private static class PersonHolder {
        private static final PersonLock INSTANCE = new PersonLock();
    }

    public static PersonLock getLock() {return PersonHolder.INSTANCE;}

    private Semaphore readLock = new Semaphore(10);

    private Semaphore writeLock = new Semaphore(1);

    public void getReadLock() throws InterruptedException {
        readLock.acquire();
    }

    public void getWriteLock() throws InterruptedException {
        writeLock.acquire();
    }

    public void releaseReadLock() {
        readLock.release();
    }

    public void releaseWriteLock() {
        writeLock.release();
    }
}
