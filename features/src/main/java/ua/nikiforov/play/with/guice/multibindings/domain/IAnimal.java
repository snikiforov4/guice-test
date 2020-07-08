package ua.nikiforov.play.with.guice.multibindings.domain;

import static ua.nikiforov.play.with.guice.multibindings.AnimalUtils.getAnimalNameByClass;

public interface IAnimal {

    String getSound();

    default String getName() {
        return getAnimalNameByClass(getClass());
    }

}
