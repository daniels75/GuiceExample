package org.daniels.examples.guice.main;

import static org.daniels.examples.constants.Constants.JDBC;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.daniels.examples.guice.bindings.AnotherConcreteClass;
import org.daniels.examples.guice.bindings.AnotherConcreteFooClass;
import org.daniels.examples.guice.bindings.MyConcreteClass;
import org.daniels.examples.guice.bindings.MyConcreteFooClass;
import org.daniels.examples.guice.modules.SimpleGuiceModule;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

public class GuiceBindingsExampleMain implements GuiceCartMain {

    private final transient Log logger = LogFactory.getLog(GuiceBindingsExampleMain.class);

    AnotherConcreteClass another;
    AnotherConcreteFooClass anotherFoo;
    MyConcreteClass myConcreteClass;
    MyConcreteFooClass fooCoreteClass;

    @Inject
    public GuiceBindingsExampleMain(AnotherConcreteClass another,
                                    @Named("AnotherFoo") AnotherConcreteFooClass anotherFoo,
                                    MyConcreteClass myConcreteClass,
                                    @Named("MyFoo") MyConcreteFooClass fooCoreteClass)
                                    {
 
        this.another = another;
        this.anotherFoo = anotherFoo;
        this.myConcreteClass = myConcreteClass;
        this.fooCoreteClass = fooCoreteClass;
                
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new SimpleGuiceModule());

        GuiceBindingsExampleMain main = injector.getInstance(GuiceBindingsExampleMain.class);

        main.showBindings();

    }

    private void showBindings() {
        logger.info("another: " + another);
        logger.info("anotherFoo: " + anotherFoo);
        logger.info("myConcreteClass: " + myConcreteClass);
        logger.info("fooCoreteClass: " + fooCoreteClass);
    }
}
