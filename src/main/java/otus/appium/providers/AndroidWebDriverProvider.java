package otus.appium.providers;

import static otus.appium.common.Constants.SELENIUM_ADDRESS;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class AndroidWebDriverProvider implements WebDriverProvider {

  private final String platformName = System.getProperty("platformName");
  private final String platformVersion = System.getProperty("platformVersion");
  private final String baseSelenoidUrl = System.getProperty("remote.url");

  private final String baseLocalUrl = System.getProperty("local.url");
  private final boolean remote = "true".equals(System.getProperty("remote"));

  @Nonnull
  @Override
  public WebDriver createDriver(@Nonnull Capabilities capabilities) {
    UiAutomator2Options options = new UiAutomator2Options();

    if (remote) {
      options.setCapability("browserName", platformName);
      options.merge(capabilities);
      options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
      options.setPlatformName(platformName);
      options.setPlatformVersion(platformVersion);
      options.setApp("home/Andy-253457-1c7cb2.apk");

      Map<String, Object> selenoidOptions = new HashMap<>();
      selenoidOptions.put("enableVNC", true);
      //selenoidOptions.put("enableVideo", true);
      selenoidOptions.put("enableLog", true);
      options.setCapability("selenoid:options", selenoidOptions);
      options.setCapability("defaultCommandTimeout", 120);
    } else {
      //Для локального запуска + нужно baseUrl указывать с портом 4723
      options.setDeviceName("Galaxy_A51_API_22");
      options.setPlatformVersion("5.1");
      options.setApp("C:\\Users\\anser\\CourseAQA\\course-otus-appium-test\\src\\test\\resources\\Andy-253457-1c7cb2.apk");
    }

    try {
      if (remote) {
        System.out.println("baseSelenoidUrl " + baseSelenoidUrl);
        return new AndroidDriver(new URL(SELENIUM_ADDRESS), options);
      } else {
        return new AndroidDriver(new URL(baseLocalUrl), options);
      }
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }
}
