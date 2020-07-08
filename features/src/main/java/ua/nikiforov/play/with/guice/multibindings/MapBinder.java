package ua.nikiforov.play.with.guice.multibindings;

import ua.nikiforov.play.with.guice.multibindings.domain.IAnimal;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Map;

@Singleton
public class MapBinder {

    private final Map<String, IAnimal> animals;

    @Inject
    public MapBinder(Map<String, IAnimal> animals) {
        this.animals = animals;
    }

    public Map<String, IAnimal> getAnimals() {
        return animals;
    }

}
