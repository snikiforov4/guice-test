package ua.nikiforov.play.with.guice.multibindings;

public final class ServiceUtils {

    private ServiceUtils() {
    }

    public static String getServiceNameByClass(Class<?> aClass) {
        return aClass.getSimpleName().toLowerCase();
    }

}
