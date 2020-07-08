package ua.nikiforov.play.with.guice.multibindings;

import ua.nikiforov.play.with.guice.multibindings.domain.IAnimal;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Set;

@Singleton
public class Multibinder {

    private final Set<IAnimal> animals;

    @Inject
    public Multibinder(Set<IAnimal> animals) {
        this.animals = animals;
    }

    public Set<IAnimal> getAnimals() {
        return animals;
    }
}
