package org.daniels.examples.guice.provider;

import org.daniels.examples.guice.api.UIConfiguration;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

public class UIConfigurationProvider implements Provider<UIConfiguration> {

	@Inject
	public UIConfigurationProvider() {
	}

	@Override
	@Singleton
	@Named("uiConfig")
	public UIConfiguration get() {
		return new UIConfiguration();
	}

}