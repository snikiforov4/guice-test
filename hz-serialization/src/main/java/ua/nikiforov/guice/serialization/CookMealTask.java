package ua.nikiforov.guice.serialization;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.HazelcastInstanceAware;

import javax.inject.Inject;
import java.io.Serializable;

public class CookMealTask implements Serializable, Runnable, HazelcastInstanceAware {

    @Inject
    private static transient Oven oven;
    private transient HazelcastInstance hzInstance;
    private final String meal;

    public CookMealTask(String meal) {
        this.meal = meal;
    }

    public void run() {
        oven.cook(meal);
        long orderCnt = hzInstance.getAtomicLong("orderCnt").incrementAndGet();
        System.out.println("orderCnt: " + orderCnt);
    }

    @Override
    public void setHazelcastInstance(HazelcastInstance hazelcastInstance) {
        hzInstance = hazelcastInstance;
    }
}
