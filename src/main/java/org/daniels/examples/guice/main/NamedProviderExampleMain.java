package org.daniels.examples.guice.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.daniels.examples.guice.api.UIConfiguration;
import org.daniels.examples.guice.bindings.MyConcreteFooClass;
import org.daniels.examples.guice.modules.NamedGuiceModule;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

public class NamedProviderExampleMain {

	private final transient Log logger = LogFactory.getLog(GuiceBindingsExampleMain.class);


	MyConcreteFooClass fooCoreteClass;
	UIConfiguration uiConfig;

	@Inject
	public NamedProviderExampleMain(final @Named("MyFoo") MyConcreteFooClass fooCoreteClass,
			@Named("uiConfig") final UIConfiguration uiConfig) {
		this.fooCoreteClass = fooCoreteClass;
		this.uiConfig = uiConfig;
	}

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new NamedGuiceModule());

		NamedProviderExampleMain main = injector.getInstance(NamedProviderExampleMain.class);

		main.showBindings();

	}

	private void showBindings() {
		logger.info("fooCoreteClass: " + fooCoreteClass);
		logger.info("uiConfig.value: " + uiConfig.getValue());
	}

}
