package ua.nikiforov.play.with.guice.multibindings.module;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import ua.nikiforov.play.with.guice.multibindings.domain.Cat;
import ua.nikiforov.play.with.guice.multibindings.domain.IAnimal;
import ua.nikiforov.play.with.guice.multibindings.domain.Zebra;

import static ua.nikiforov.play.with.guice.multibindings.AnimalUtils.getAnimalNameByClass;

public class AnimalMapBinderModule extends AbstractModule {

    @Override
    protected void configure() {
        MapBinder<String, IAnimal> uriBinder =
                MapBinder.newMapBinder(binder(), String.class, IAnimal.class);
        registerBindings(uriBinder, Cat.class);
        registerBindings(uriBinder, Zebra.class);
    }

    private void registerBindings(MapBinder<String, IAnimal> uriBinder, Class<? extends IAnimal> aClass) {
        uriBinder.addBinding(getAnimalNameByClass(aClass)).to(aClass);
    }

}
