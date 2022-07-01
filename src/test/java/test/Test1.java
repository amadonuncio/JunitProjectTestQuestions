package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.Test109Page;
import util.BrowserFactory;

public class Test1 extends BrowserFactory{
	Test109Page test109;
	
	@Before
	public void beforeRun() {
		init();
		test109 = PageFactory.initElements(driver, Test109Page.class);
	}
	
	@Test
	public void validateAllCheckBoxesAreCheckedByCheckingToggleAllBox() {
		test109.checkToggleAllCheckBox();
		test109.validateAllCheckBoxesAreChecked();
	}
	
	@After
	public void afterRun() {
		tearDown();
	}
}
