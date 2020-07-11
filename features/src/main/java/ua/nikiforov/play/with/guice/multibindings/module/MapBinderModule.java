package ua.nikiforov.play.with.guice.multibindings.module;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import ua.nikiforov.play.with.guice.multibindings.service.ServiceA;
import ua.nikiforov.play.with.guice.multibindings.service.IService;
import ua.nikiforov.play.with.guice.multibindings.service.ServiceB;

import static ua.nikiforov.play.with.guice.multibindings.ServiceUtils.getServiceNameByClass;

public class MapBinderModule extends AbstractModule {

    @Override
    protected void configure() {
        MapBinder<String, IService> binder =
                MapBinder.newMapBinder(binder(), String.class, IService.class);
        registerBindings(binder, ServiceA.class);
        registerBindings(binder, ServiceB.class);
    }

    private void registerBindings(MapBinder<String, IService> binder, Class<? extends IService> aClass) {
        binder.addBinding(getServiceNameByClass(aClass)).to(aClass);
    }

}
