package ua.nikiforov.play.with.guice.multibindings;

import ua.nikiforov.play.with.guice.multibindings.service.IService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Set;

@Singleton
public class MultiBinder {

    private final Set<IService> services;

    @Inject
    public MultiBinder(Set<IService> services) {
        this.services = services;
    }

    public Set<IService> getServices() {
        return services;
    }
}
