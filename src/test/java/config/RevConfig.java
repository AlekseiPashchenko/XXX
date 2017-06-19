package config;

import ru.qatools.properties.PropertyLoader;

/**
 * Created by apashchenko on 18.06.2017.
 */
public class RevConfig {
    public static final IConfig CONF = PropertyLoader.newInstance().populate(IConfig.class);
}
