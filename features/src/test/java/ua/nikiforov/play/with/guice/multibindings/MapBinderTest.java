package ua.nikiforov.play.with.guice.multibindings;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.Test;
import ua.nikiforov.play.with.guice.multibindings.domain.IAnimal;
import ua.nikiforov.play.with.guice.multibindings.module.AnimalMapBinderModule;
import ua.nikiforov.play.with.guice.multibindings.module.AnimalMultibindingModule;

import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


class MapBinderTest {

    @Test
    void mapBindings() {
        Injector injector = Guice.createInjector(new AnimalMapBinderModule());
        MapBinder sut = injector.getInstance(MapBinder.class);
        assertThat(sut).describedAs("ZooService").isNotNull();
        Map<String, IAnimal> animals = sut.getAnimals();
        assertThat(animals).isNotEmpty()
                .hasSize(2)
                .containsKeys("zebra", "cat");
    }

}