package ua.nikiforov.play.with.guice.multibindings.module;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import ua.nikiforov.play.with.guice.multibindings.service.ServiceA;
import ua.nikiforov.play.with.guice.multibindings.service.IService;
import ua.nikiforov.play.with.guice.multibindings.service.ServiceB;

public class MultibindingModule extends AbstractModule {

    @Override
    protected void configure() {
        Multibinder<IService> binder = Multibinder.newSetBinder(binder(), IService.class);
        binder.addBinding().to(ServiceA.class);
        binder.addBinding().to(ServiceB.class);
    }

}
