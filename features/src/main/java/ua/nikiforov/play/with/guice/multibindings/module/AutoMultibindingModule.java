package ua.nikiforov.play.with.guice.multibindings.module;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;

import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Sets.newHashSet;

public class AutoMultibindingModule<T> extends AbstractModule {

    private final Class<T> classToScan;
    private final String[] packagesToScan;

    public AutoMultibindingModule(Class<T> classToScan, String... packagesToScan) {
        this.classToScan = classToScan;
        this.packagesToScan = packagesToScan;
    }

    @Override
    protected void configure() {
        var binder = Multibinder.newSetBinder(binder(), classToScan);
        try(var scanResult = new ClassGraph()
                .acceptPackages(getAllPackagesToScan())
                .scan()) {
            for (Class<? extends T> impl : findAllImplementations(scanResult)) {
                addBinding(binder, impl);
            }
        }
    }

    private String[] getAllPackagesToScan() {
        var packagesToScan = this.packagesToScan;
        if (packagesToScan.length == 0) {
            packagesToScan = new String[]{this.classToScan.getPackageName()};
        }
        return packagesToScan;
    }

    private Set<Class<? extends T>> findAllImplementations(ScanResult scanResult) {
        ClassInfo aClassInfo = checkNotNull(scanResult.getClassInfo(this.classToScan.getName()),
                "could not load class");
        Set<Class<? extends T>> res = newHashSet();
        for (ClassInfo classInfo : scanResult.getAllStandardClasses().getAssignableTo(aClassInfo)) {
            if (!classInfo.isAbstract()) {
                res.add(classInfo.loadClass(this.classToScan));
            }
        }
        return res;
    }

    private void addBinding(Multibinder<T> binder, Class<? extends T> type) {
        binder.addBinding().to(type);
    }

}
