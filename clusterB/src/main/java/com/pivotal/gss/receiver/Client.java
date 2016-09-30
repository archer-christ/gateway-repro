package com.pivotal.gss.receiver;

import com.gemstone.gemfire.cache.InterestResultPolicy;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;

import java.io.IOException;

/**
 * Created by smanvi on 9/29/16.
 */
public class Client {


    public static void main(String args[]) {
        Client client = new Client();
        client.launch();
    }

    private void launch() {
        ClientCache clientCache = new ClientCacheFactory().set("cache-xml-file", "/Users/smanvi/Workspace_piv/gateway-repro/clusterB/src/main/resources/client-cache.xml").create();
        Region<Object, Object> customerRegion = clientCache.getRegion("Customer");
        customerRegion.registerInterest("ALL_KEYS", InterestResultPolicy.KEYS);

        try {
            System.out.println("Enter to kill client");
            System.in.read();
            System.out.println("Killing Client");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
