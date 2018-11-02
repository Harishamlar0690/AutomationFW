package pageclasses;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
	
	protected WebDriver driver;
	protected WebDriverWait wait ;
	public JavascriptExecutor javaScriptExecutor=null;

	public BasePage(WebDriver _driver) {
		driver=_driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
		javaScriptExecutor=(JavascriptExecutor) driver;
	}
	
	public void waitUntilElementVisible(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitUntilElementToBeClickable(WebElement element)
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void pause(int time)
	{
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public void explicitlyWaitUntilVisible(WebElement element, long timeout) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try{
			new FluentWait<>(driver)
					.withTimeout(timeout, TimeUnit.SECONDS)
					.pollingEvery(timeout, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class)
					.until(ExpectedConditions.visibilityOf(element));
		}finally{		
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	}
	
	
	/*
	private static final Logger log = LoggerFactory.getLogget(Copy.class, getSimpleName());
	
	public static final int POLLING_INTERVAL_LONG_MS = GlobalConfig.get().getPollingIntervalLongMs();
	public static final int POLLING_INTERVAL_SHORT_MS = GlobalConfig.get().getPollingIntervalShortMs();
	public static final int IMPLICIRE_WAIT_S = GlobalConfig.get().getIMpliciteWaitSec();
	public static final int MAX_TEXT_CHUNK_SIZE = GlobalConfig.get().getMaxTextChunkSize();
	public static final int WAIT_FOR_ELEMENT_AND_CLICK = GlobalConfig.get().getWaitForElementForClick();


	public WebDriver getDriver() {
		return driver;
	}

	protected JavascriptExecutor getExecutor() {
		return (JavascriptExecutor) getDriver();
	}

	protected void safeClick(By Locator) {
		WebElement element = getDriver().findElement(Locator);
		safeClick(element);
	}

	
	protected void safeClick(WebElement element) {
		try{
			element.click();
		} catch(Exception e) {
			log.debug("Falling back to Javascript click");
			log.tarce("Falling back to Javascript click on {} bcoz of error: {}", elemet, e.getLocalizeMess);
			executorClick(element);
		}
	}

	protected void executorClick(By Locator) {
		WebElement elemt = getDriver.findElement(locator);
		executorClick(element);
	}

	protected void executorClick(WebElement element) {
		getExecutor().executrScript("arguments[0].click();", element);
	}

	protected void waitForAndClick(By Locator) {
		WaitTillElementAppears(locator, WAIT_FOR_ELEMENT_AND_CLICK); 
		safeClick(locator);
	}

	protected void heightElement(By Locator) {
		WebElement elemt = getDriver.findElement(locator);
		executorClick(element);
	}

	protected void heightElement(WebElement element) {
		getExecutor().executrScript("arguments[0].style.border='3px dotted red'", element);
	}

	protected void setToMargine(WebElement element, inr marginValueInPixel) {
		getExecutor().executrScript(String.format("arguments[0].style.margineTop='%dpx'", margineValueInPixels), element);
	}

	protected void scrollIntoView(By Locator) {
		WebElement elemt = getDriver.findElement(locator);
		scrollIntoView(element);
	}
	
	protected void scrollIntoView(WebElement element) {
		getExecutor().executrScript("arguments[0].scrollIntoView()", element);
	}

	protected void waitTillElementAppears(final By locator, long timeout) {
		getDriver().manage(),timeouts().implicitlyWait(OL, TimeUnit.SECONDS);
		long startTime= System.currentTimeMillis();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
					.withTimeout(timeout, TimeUnit.SECONDS)
					.pollingEvery(POLLING_INTERVAL_LONG_MS, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class);
		wait.untill(new Function<WebDriver, WebElement>() {
			public WebElemet apply(WebDriver driver) {
				return getDriver().findElement(locator);
			}
		});
		long endTime = System.currentTimeMillis();
		log.trace("Time Diff from element visisble:"+ String.valueOf(endTime - startTime));
		getDriver().manage().timeOuts().implicitlyWait(IMPLICITE_WAIT_S, TimeUnit.SECONDS);
	}

	protected void waitTillElementAppearsInMilliSeconds(final By locator, long timeout) {
		getDriver().manage(),timeouts().implicitlyWait(OL, TimeUnit.SECONDS);
		long startTime= System.currentTimeMillis();
		Wait<WebDriver> wait = new FluentWait<>(getDriver())
					.withTimeout(timeout, TimeUnit.MILLISECONDS)
					.pollingEvery(POLLING_INTERVAL_LONG_MS, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class);
		wait.untill(new Function<WebDriver, WebElement>() {
			public WebElemet apply(WebDriver driver) {
				return getDriver().findElement(locator);
			}
		});
		long endTime = System.currentTimeMillis();
		log.trace("Time Diff from element visisble:"+ String.valueOf(endTime - startTime));
		getDriver().manage().timeOuts().implicitlyWait(IMPLICITE_WAIT_S, TimeUnit.SECONDS);
	}

	protected void waitTillObjectDisappears(final By locator, long timeout) {
		getDriver().manage(),timeouts().implicitlyWait(OL, TimeUnit.SECONDS);
		long startTime= System.currentTimeMillis();
		Wait<WebDriver> wait = new FluentWait<>(getDriver())
					.withTimeout(timeout, TimeUnit.SECONDS)
					.pollingEvery(POLLING_INTERVAL_LONG_MS, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class);
		wait.untill(new Function<WebDriver, WebElement>() {
			public WebElemet apply(WebDriver driver) {
				return getDriver().findElement(locator);
			}
		});
		long endTime = System.currentTimeMillis();
		log.trace("Time Diff from element disappearance:"+ String.valueOf(endTime - startTime));
		getDriver().manage().timeOuts().implicitlyWait(IMPLICITE_WAIT_S, TimeUnit.SECONDS);
	}

	public static String escapeTexrForXpath(String textForXpath) {
		if(textForXpath.contains("\"")) {
			return "'" + textForXpath + "'";
		}
		return "\"" + textForXpath + "\"";
	}

	protected void explicitlyWaitUntilVisible(WebElement element, long timeout) {
		getDriver().manage(),timeouts().implicitlyWait(OL, TimeUnit.SECONDS);
		try{
			new FluentWait<>(getDriver())
					.withTimeout(timeout, TimeUnit.SECONDS)
					.pollingEvery(POLLING_INTERVAL_LONG_MS, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class)
					.until(ExpectedConditions.visibilityOf(element));
		}finally{		
			getDriver().manage().timeOuts().implicitlyWait(IMPLICITE_WAIT_S, TimeUnit.SECONDS);
		}
	}

	protected void explicitlyWaitUntilVisible(By locator, long timeout) {		
		try{
			waitTillElementAppears(locator, timeout);
			getDriver().manage(),timeouts().implicitlyWait(OL, TimeUnit.SECONDS);
			explicitlyWaitUntilVisible(getDriver().findElement(locator), timeout);
			
		}catch (NoSuchElementException e) {
			throw new TimeoutException(e.getMessage());
		} finally {		
			getDriver().manage().timeOuts().implicitlyWait(IMPLICITE_WAIT_S, TimeUnit.SECONDS);
		}
	}

	protected void explicitlyWaitUntilVisibleMilliseconds(By locator, long timeout) {		
		try{
			getDriver().manage().timeouts().implicitlyWait(OL, TimeUnit.MILLISECONDS);		
			new FluentWait<>(getDriver())
					.withTimeout(timeout, TimeUnit.SECONDS)
					.pollingEvery(POLLING_INTERVAL_SHORT_MS, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class)
					.until(ExpectedConditions.visibilityOfAllElements(locator));
		}finally{		
			getDriver().manage().timeOuts().implicitlyWait(IMPLICITE_WAIT_S, TimeUnit.SECONDS);
		}
	}

	protected void explicitlyWaitUntilVisibleMilliSeconds(By locator, long timeout) {		
		try{
			waitTillElementAppears(locator, timeout);
			getDriver().manage(),timeouts().implicitlyWait(OL, TimeUnit.SECONDS);
			explicitlyWaitUntilVisible(getDriver().findElement(locator), timeout);
			
		}catch (NoSuchElementException e) {
			throw new TimeOutException(e.getMessage());
		} finally {		
			getDriver().manage().timeOuts().implicitlyWait(IMPLICITE_WAIT_S, TimeUnit.SECONDS);
		}
	}

	
	protected void waitForAlert(long timeout) {		
		Wait<WebDriver> wait = new FluentWait<>(getDriver())
					.withTimeout(timeout, TimeUnit.SECONDS)
					.pollingEvery(POLLING_INTERVAL_LONG_MS, TimeUnit.MILLISECONDS)
					.ignoring(NoAlertPresentException.class);

		wait.untill(ExpectedConditions.alertIsPresent());
	}

	public Boolean isElementVisible(By locator) {
		try {
			explicitlyWaitUntilVisibleMilliseconds(locator, 200);
			return true;
		}catch(TimeOutException | NoSuchElementException | StaleElementReferenceException e) {
			return false;
		}
	}
	
	protected WebElement getSubElement(WebElement parentElement, By subElementLocator, lond timeout) {
		try{
			getDriver().manage(),timeouts().implicitlyWait(OL, TimeUnit.SECONDS);		
			return parentElement.findElement(subElementLocator);
		}finally{		
			getDriver().manage().timeOuts().implicitlyWait(IMPLICITE_WAIT_S, TimeUnit.SECONDS);
		}
	}
	
	protected List<WebElement> getSubElement(WebElement parentElement, By subElementLocator, lond timeout) {
		try{
			getDriver().manage(),timeouts().implicitlyWait(OL, TimeUnit.SECONDS);		
			return parentElement.findElement(subElementLocator);
		}finally{		
			getDriver().manage().timeOuts().implicitlyWait(IMPLICITE_WAIT_S, TimeUnit.SECONDS);
		}
	}

	protected void centerViewVerticallyOnElement(WebElement element) {
		int elementPositionInView = ((RemoteWebElement) element).getCoordinates().inViewPort().getY();	
		int viewPortHeight = getDriver().manage().window().getSize().getHeight();
		int posDiff = elementPositionInView  - viewPortHeight / 2;
		getExecutor().executrScript(String.format("window.scrollBy(0, %s)", posDiff)) ;
	}

	protected void centerViewVerticallyOnElement(By locator) {
		WebElement element = getDriver().findElement(locator);
		centerViewVerticallyOnElement(element);
	}

	
	protected void resetElementScrollTop(WebElement element) {		
		getExecutor().executrScript(String.format("arguments[0].scrollTop=0", element)) ;
	}

	public void waitForPageToLoad(long timeout) {
		long startTime = System.currentTimeMillies();
		while((System.currentTimeMillies() - startTime) < timeout * 1000) {
			boolean pageLoaded = getExecutor().executrScript("returnDocument.readyState").equals("complete");
			if(pageLoaded){
				return;
			}else {
				Sleeper.mSleep(500);
			}
		}
		throw new TimeOutException(String.format("page did not load in %s seconds", timeout))
	}
*/}
