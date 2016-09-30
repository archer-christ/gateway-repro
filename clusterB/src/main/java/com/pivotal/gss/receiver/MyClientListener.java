package com.pivotal.gss.receiver;

import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;

import java.util.Properties;

/**
 * Created by smanvi on 9/29/16.
 */
public class MyClientListener extends CacheListenerAdapter implements Declarable{

    @Override
    public void afterCreate(EntryEvent event) {
        Object key = event.getKey();
        System.out.println("RECEIVED : "+key);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void init(Properties properties) {
    }
}
