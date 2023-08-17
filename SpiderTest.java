@Slf4j
public class SpiderTest {
    public static void test() {
        String url = "https://www.arealme.com/";
        String remoteDriverUrl = "http://localhost:8888";
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments(HEADLESS);
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(remoteDriverUrl), options);
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(35));
            String pageSource = driver.getPageSource();
            log.info(pageSource);
        } catch (Exception e) {
            log.error("error:", e);
        } finally {
            if (driver != null) driver.quit();
        }
    }
}
