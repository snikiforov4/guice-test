package ua.nikiforov.play.with.guice.multibindings.module;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import ua.nikiforov.play.with.guice.multibindings.domain.Cat;
import ua.nikiforov.play.with.guice.multibindings.domain.IAnimal;
import ua.nikiforov.play.with.guice.multibindings.domain.Zebra;

public class AnimalMultibindingModule extends AbstractModule {

    @Override
    protected void configure() {
        Multibinder<IAnimal> uriBinder = Multibinder.newSetBinder(binder(), IAnimal.class);
        uriBinder.addBinding().to(Cat.class);
        uriBinder.addBinding().to(Zebra.class);
    }

}
