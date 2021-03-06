package com.netflix.astyanax.recipes.locks;

/**
 * Base interface to acquiring and release a row lock
 *
 * Usage:
 *
 * DistributedRowLock lock = new SomeLockImplementation(...); try {
 * lock.acquire(); // Do something ... } catch (BusyLockException) { // The lock
 * was already taken by a different process } catch (StaleLockException) { //
 * The row has a stale lock that needs to be addressed // This is usually caused
 * when no column TTL is set and the client // crashed before releasing the
 * lock. The DistributedRowLock should // have the option to auto delete stale
 * locks. } finally { lock.release(); }
 *
 * @author elandau
 *
 */
public interface DistributedRowLock {
    void acquire() throws BusyLockException, StaleLockException, Exception;

    void release() throws Exception;
}
