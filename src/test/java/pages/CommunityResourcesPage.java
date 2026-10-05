package pages;

import org.openqa.selenium.WebDriver;

public class CommunityResourcesPage {

    private WebDriver driver;

    public CommunityResourcesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCommunityResources() {
        driver.get("https://saucelabs.com/resources/topic-hub/community");
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isCommunityPageOpened() {
        return driver.getCurrentUrl().contains("community");
    }
}