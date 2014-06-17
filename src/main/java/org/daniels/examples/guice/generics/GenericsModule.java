package org.daniels.examples.guice.generics;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.TypeLiteral;

public class GenericsModule extends AbstractModule {
    @Override
    protected void configure() {
        
        bind(new TypeLiteral<HibernateConnection<Integer>>(){}).to(HibernateConnectionImpl.class);
        bind(new TypeLiteral<StringOutput<Double>>(){});
        
        
        bind(new TypeLiteral<Repository<String>>(){}).to(new TypeLiteral<RepositoryImpl<String>>(){});
        
        //bind(new TypeLiteral<HibernateConnection<Integer>>(){}).toProvider(HibernateConnectionProvider.class).in(Scopes.SINGLETON);

    }
    
    

}


