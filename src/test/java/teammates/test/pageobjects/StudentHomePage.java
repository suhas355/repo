package teammates.test.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class StudentHomePage extends AppPage {
	
	@FindBy(id = "regkey")
	protected WebElement keyTextBox;
	
	@FindBy(id = "button_join_course")
	protected WebElement joinButton;
	
	public StudentHomePage(Browser browser) {
		super(browser);
	}

	@Override
	protected boolean containsExpectedPageContents() {
		return containsExpectedPageContents(getPageSource());
	}

	public static boolean containsExpectedPageContents(String pageSource) {
		return pageSource.contains("<h1>Student Home</h1>");
	}

	public StudentHelpPage clickHelpLink() {
		studentHelpTab.click();
		waitForPageToLoad();
		switchToNewWindow();
		return changePageType(StudentHelpPage.class);
	}

	public void clickHomeTab() {
		studentHomeTab.click();
		waitForPageToLoad();
		
	}

	public void fillKey(String key) {
		fillTextBox(keyTextBox, key);
		
	}

	public StudentHomePage clickJoinButton() {
		joinButton.click();
		waitForPageToLoad();
		return this;
	}

}