package otus.appium.extension;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import otus.appium.modules.GuiceModule;
import otus.appium.providers.AndroidWebDriverProvider;

public class AndroidExtension implements BeforeAllCallback, BeforeEachCallback, AfterEachCallback {

  private Injector injector;

  @Override
  public void beforeAll(ExtensionContext extensionContext) {
    Configuration.browserSize = null;
    Configuration.browser = AndroidWebDriverProvider.class.getName();
    injector = Guice.createInjector(new GuiceModule());
  }

  @Override
  public void beforeEach(ExtensionContext extensionContext) {
    extensionContext.getTestInstance().ifPresent(instance -> {
      injector.injectMembers(instance);
    });
  }

  @Override
  public void afterEach(ExtensionContext extensionContext) {
    Selenide.closeWebDriver();
  }
}
