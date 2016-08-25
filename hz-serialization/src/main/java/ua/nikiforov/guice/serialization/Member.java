package ua.nikiforov.guice.serialization;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.hazelcast.core.Hazelcast;

public class Member {

    public static void main(String[] args) throws Exception {
        Guice.createInjector(new AbstractModule() {
            protected void configure() {
                requestStaticInjection(CookMealTask.class);
            }
        });

        Hazelcast.newHazelcastInstance();
        System.out.println("Hazelcast ua.nikiforov.guice.serialization.Member instance is running!");

        for (;;) {}
    }
}
