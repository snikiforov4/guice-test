package ua.nikiforov.play.with.guice.multibindings;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ua.nikiforov.play.with.guice.multibindings.module.AutoMultibindingModule;
import ua.nikiforov.play.with.guice.multibindings.module.MapBinderModule;
import ua.nikiforov.play.with.guice.multibindings.module.MultibindingModule;
import ua.nikiforov.play.with.guice.multibindings.service.IService;
import ua.nikiforov.play.with.guice.multibindings.service.ServiceA;
import ua.nikiforov.play.with.guice.multibindings.service.ServiceB;

import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BindingsTest {

    @Nested
    @DisplayName("multi bindings")
    class MultiBindingsTest {

        @Test
        void manual() {
            Injector injector = Guice.createInjector(new MultibindingModule());
            MultiBinder sut = injector.getInstance(MultiBinder.class);
            assert sut != null;
            Set<IService> services = sut.getServices();

            assertThat(services).isNotEmpty()
                    .containsExactlyInAnyOrder(
                            injector.getInstance(ServiceA.class),
                            injector.getInstance(ServiceB.class)
                    );
        }

        @Test
        void auto() {
            Injector injector = Guice.createInjector(new AutoMultibindingModule<>(IService.class));
            MultiBinder sut = injector.getInstance(MultiBinder.class);
            assert sut != null;
            Set<IService> services = sut.getServices();

            assertThat(services).isNotEmpty()
                    .containsExactlyInAnyOrder(
                            injector.getInstance(ServiceA.class),
                            injector.getInstance(ServiceB.class)
                    );
        }

    }

    @Nested
    @DisplayName("map binder")
    class MapBinderTest {

        @Test
        void manual() {
            Injector injector = Guice.createInjector(new MapBinderModule());
            MapBinder sut = injector.getInstance(MapBinder.class);
            assert sut != null;

            Map<String, IService> services = sut.getServices();
            assertThat(services).isNotEmpty()
                    .hasSize(2)
                    .containsValues(
                            injector.getInstance(ServiceA.class),
                            injector.getInstance(ServiceB.class)
                    );

        }

    }

}
