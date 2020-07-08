package ua.nikiforov.play.with.guice.multibindings;

public final class AnimalUtils {

    private AnimalUtils() {
    }

    public static String getAnimalNameByClass(Class<?> aClass) {
        return aClass.getSimpleName().toLowerCase();
    }

}
