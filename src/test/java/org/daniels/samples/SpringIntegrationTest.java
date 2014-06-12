/**
 * Copyright (C) 2006 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.daniels.samples;

import static com.google.inject.spring.SpringIntegration.fromSpring;

import com.google.inject.AbstractModule;
import com.google.inject.CreationException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.google.inject.spring.SpringIntegration;

import junit.framework.TestCase;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author crazybob@google.com (Bob Lee)
 */
public class SpringIntegrationTest extends TestCase {

	public void testBindFromSpring() throws CreationException {
		final DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		RootBeanDefinition singleton = new RootBeanDefinition(Singleton.class);
		beanFactory.registerBeanDefinition("singleton", singleton);

		Injector injector = Guice.createInjector(new AbstractModule() {
			protected void configure() {
				bind(BeanFactory.class).toInstance(beanFactory);
				bind(Singleton.class).toProvider(
						fromSpring(Singleton.class, "singleton"));
		
			}
		});

		assertNotNull(injector.getInstance(Singleton.class));
		assertSame(injector.getInstance(Singleton.class),
				injector.getInstance(Singleton.class));

	}

	public void testBindAll() throws CreationException {
		final DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		RootBeanDefinition singleton = new RootBeanDefinition(Singleton.class);
		beanFactory.registerBeanDefinition("singleton", singleton);

		Injector injector = Guice.createInjector(new AbstractModule() {
			protected void configure() {
				SpringIntegration.bindAll(binder(), beanFactory);
			}
		});

		Key<Singleton> singletonKey = Key.get(Singleton.class,
				Names.named("singleton"));
	

		assertNotNull(injector.getInstance(singletonKey));
		assertSame(injector.getInstance(singletonKey),
				injector.getInstance(singletonKey));

	}

	static class Singleton {
	}

	static class Prototype {
	}
}
