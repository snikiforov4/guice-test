package ua.nikiforov.play.with.guice.multibindings;

import ua.nikiforov.play.with.guice.multibindings.service.IService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Map;

@Singleton
public class MapBinder {

    private final Map<String, IService> services;

    @Inject
    public MapBinder(Map<String, IService> services) {
        this.services = services;
    }

    public Map<String, IService> getServices() {
        return services;
    }

}
