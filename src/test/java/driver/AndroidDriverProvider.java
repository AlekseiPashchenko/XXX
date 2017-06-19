package driver;

import com.codeborne.selenide.WebDriverProvider;
import config.RevConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;

/**
 * Created by apashchenko on 18.06.2017.
 */

public class AndroidDriverProvider implements WebDriverProvider {
    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        capabilities.setCapability(MobileCapabilityType.VERSION, "7.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("deviceName",RevConfig.CONF.getAndroidDeviceName());
        //capabilities.setCapability("deviceName","Nexus_4_API_23");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability(APP_PACKAGE, "com.revolut.revolut.test");
        capabilities.setCapability(APP_ACTIVITY, "com.revolut.ui.login.pin.LoginActivity");

        try {
            //return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            return new AndroidDriver(new URL(RevConfig.CONF.getAppiumHubUrl()), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
