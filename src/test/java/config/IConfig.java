package config;

import ru.qatools.properties.DefaultValue;
import ru.qatools.properties.Property;

/**
 * Created by apashchenko on 18.06.2017.
 */
public interface IConfig {

    @Property("path.appium")
    @DefaultValue("http://0.0.0.0:4723/wd/hub")
    String getAppiumHubUrl();

    @Property("android.device")
    @DefaultValue("Nexus_6P_API_24")
    String getAndroidDeviceName();
}
