package ua.nikiforov.guice.serialization;

import javax.inject.Singleton;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@Singleton
public class Oven {
    private final String uid;
    private AtomicLong localPiesCnt;

    public Oven() {
        uid = UUID.randomUUID().toString();
        localPiesCnt = new AtomicLong(0);
    }

    public void cook(String pieName) {
        System.out.println(pieName + " cooked by " + uid);
        long localPiesCnt = this.localPiesCnt.incrementAndGet();
        System.out.println("local order cnt: " + localPiesCnt);
    }
}
