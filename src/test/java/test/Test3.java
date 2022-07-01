package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.Test109Page;
import util.BrowserFactory;

public class Test3 extends BrowserFactory{
	Test109Page test109;
	
	@Before
	public void beforeRun() {
		init();
		test109 = PageFactory.initElements(driver, Test109Page.class);
	}
	
	@Test
	public void validateAllListItemsAreRemovedByRemoveButtonAndWhenToggleAllRadioButtonIsChecked() {
		test109.checkToggleAllCheckBox();
		test109.clickRemoveButton();
		test109.validateAllListItemsAreRemoved();
//		Method below is here to add the items back for others to use for their projects
		test109.addListItems();
		
	}
	
	@After
	public void afterRun() {
		tearDown();
	}
}
