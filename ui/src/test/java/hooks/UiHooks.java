package hooks;

import Drivers.PlaywrightInstanceProvider;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class UiHooks {

    @Before(value = "@ui", order = 1)
    public void preparePlaywrightInstance() {
        PlaywrightInstanceProvider.getInstance().preparePlaywrightInstance();
    }

    @After(value = "@ui", order = 1)
    public void tearDownPlaywright() {
        PlaywrightInstanceProvider.clear();
    }
}
