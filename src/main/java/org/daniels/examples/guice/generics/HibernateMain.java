package org.daniels.examples.guice.generics;

import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.daniels.examples.guice.main.GuiceBindingsExampleMain;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.TypeLiteral;

public class HibernateMain {

    private final static Log logger = LogFactory.getLog(HibernateMain.class);

    public static void main(String[] args) {
        configureHibernate();
        configureStringOutput();
        configureRepository();
    }

    private static void configureHibernate() {
        GenericsModule module = new GenericsModule();
        Injector injector = Guice.createInjector(new Module[] { module });

        HibernateConnection<Integer> connection = injector.getInstance(new Key<HibernateConnection<Integer>>() {});

        connection = injector.getInstance(Key.get(new TypeLiteral<HibernateConnection<Integer>>() {}));

        logger.info(">>>> Session status: " + connection.getSessionStatus());
    }

    private static void configureStringOutput() {
        GenericsModule module = new GenericsModule();
        Injector injector = Guice.createInjector(new Module[] { module });

        StringOutput<Double> strOutput = injector.getInstance(Key.get(new TypeLiteral<StringOutput<Double>>() {}));

        logger.info(strOutput.toString());
    }

    private static void configureRepository() {
        GenericsModule module = new GenericsModule();
        Injector injector = Guice.createInjector(new Module[] { module });
        
        Repository<String> repository = injector.getInstance(Key.get(new TypeLiteral<Repository<String>>() {}));

        logger.info(repository);
        
    }

}
