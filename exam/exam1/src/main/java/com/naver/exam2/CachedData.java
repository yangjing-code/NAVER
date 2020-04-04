package com.naver.exam2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CachedData {

    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private Lock writeLock = reentrantReadWriteLock.writeLock();
    private Lock readLock = reentrantReadWriteLock.readLock();

    private List<String> cacheData = new ArrayList<>();
    private Boolean isCacheNeedRefresh = true;

    public void processCachedData() {
        if (isCacheNeedRefresh) {
            writeLock.lock();
            Refresh();
            writeLock.unlock();
        } else {
            readLock.lock();
            readCache();
            readLock.unlock();
        }
    }

    public void Refresh() {
        System.out.println("Refresh Cache" +  cacheData.toString());
    }

    public void readCache() {
        System.out.println("Read Cache" +  cacheData.toString());
    }
}
