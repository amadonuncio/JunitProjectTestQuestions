package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.Test109Page;
import util.BrowserFactory;

public class Test2 extends BrowserFactory{
	Test109Page test109;
	
	@Before
	public void beforeRun() {
		init();
		test109 = PageFactory.initElements(driver, Test109Page.class);
	}
	
	@Test
	public void validateCheckedSingleItemIsRemovedByRemoveButton() {
//		I chose to have an item added to show it being deleted to not effect the other items
		test109.addAListItem();
		
		test109.checkAListItemCheckBox();
		test109.clickRemoveButton();
		test109.validateListItemIsRemoved();
		
	}
	
	@After
	public void afterRun() {
		tearDown();
	}
}
