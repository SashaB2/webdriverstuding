package libs;

import org.openqa.selenium.Platform;

public  class Global {

    /**
     * Find out on wich platform runs application
     * Uses for configuration
     * @param platform put expected platform
     * @return
     */
    public static boolean isPlatform(Platform platform){
        return Platform.getCurrent().is(platform);
    }
}
