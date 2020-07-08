package ua.nikiforov.guice.factory;

import javax.inject.Singleton;
import java.util.UUID;

@Singleton
public class ValueSupplier {
    private final String value = UUID.randomUUID().toString();

    public String value() {
        return this.value;
    }
}
