package org.daniels.examples.guice.modules;

import org.daniels.examples.guice.api.UIConfiguration;
import org.daniels.examples.guice.bindings.MyConcreteFooClass;
import org.daniels.examples.guice.provider.UIConfigurationProvider;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class NamedGuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MyConcreteFooClass.class).annotatedWith(Names.named("MyFoo")).to(MyConcreteFooClass.class);
        bind(UIConfiguration.class).annotatedWith(Names.named("uiConfig")).toProvider(UIConfigurationProvider.class).asEagerSingleton();
    }

}
