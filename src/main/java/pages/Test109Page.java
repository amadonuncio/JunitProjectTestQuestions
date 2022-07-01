package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test109Page {
	WebDriver driver;
	String beforeListItem = "input[name = 'todo[";
	String afterListItem = "]']";

	public Test109Page(WebDriver driver) {
		this.driver = driver;
	}

//	Element Lists
	@FindBy(how = How.CSS, using = "input[name = 'allbox']")
	WebElement TOGGLE_ALL_CHECK_BOX_ELEMENT;
	@FindBy(how = How.CSS, using = "input[value = 'Remove']")
	WebElement REMOVE_BUTTON_ELEMENT;
	@FindBy(how = How.CSS, using = "input[name = 'data']")
	WebElement ADD_INPUT_BOX_ELEMENT;
	@FindBy(how = How.CSS, using = "input[value = 'Add']")
	WebElement ADD_BUTTON_ELEMENT;
	@FindBy(how = How.CSS, using = "input[name = 'todo[0]']")
	WebElement LIST_ITEM_0_CHECK_BOX_ELEMENT;
	@FindBy(how = How.CSS, using = "input[name = 'todo[1]']")
	WebElement LIST_ITEM_1_CHECK_BOX_ELEMENT;
	@FindBy(how = How.CSS, using = "input[name = 'todo[2]']")
	WebElement LIST_ITEM_2_CHECK_BOX_ELEMENT;
	@FindBy(how = How.CSS, using = "input[name = 'todo[3]']")
	WebElement LIST_ITEM_3_CHECK_BOX_ELEMENT;
	@FindBy(how = How.CSS, using = "input[name = 'todo[4]']")
	WebElement LIST_ITEM_4_CHECK_BOX_ELEMENT;
	@FindBy(how = How.CSS, using = "input[name = 'todo[5]']")
	WebElement LIST_ITEM_5_CHECK_BOX_ELEMENT;

//	Methods
	public void checkToggleAllCheckBox() {
		TOGGLE_ALL_CHECK_BOX_ELEMENT.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateAllCheckBoxesAreChecked() {
		try {
			for (int i = 0; i <= 4; i++) {
				Assert.assertTrue("Not all check boxes are checked.",
						driver.findElement(By.cssSelector(beforeListItem + i + afterListItem)).isSelected());
			}
			System.out.println("All items are checked!");
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void checkAListItemCheckBox() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(LIST_ITEM_5_CHECK_BOX_ELEMENT)).click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void addAListItem() {
		ADD_INPUT_BOX_ELEMENT.sendKeys("List Item 5");
		ADD_BUTTON_ELEMENT.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void addListItems() {
		for (int i = 0; i <= 4; i++) {
			ADD_INPUT_BOX_ELEMENT.sendKeys("List Item " + i);
			ADD_BUTTON_ELEMENT.click();
		}
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickRemoveButton() {
		REMOVE_BUTTON_ELEMENT.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateListItemIsRemoved() {
		try {
			Assert.assertFalse("The list item was not removed.", LIST_ITEM_5_CHECK_BOX_ELEMENT.isDisplayed());
		} catch (NoSuchElementException e) {
//			e.printStackTrace(); //We committed so the console looks cleaner
			System.out.println("Item is removed!");
		}

	}

	public void validateAllListItemsAreRemoved() {
		try {
			for (int i = 0; i <= 4; i++) {
				Assert.assertFalse("Not all list items were removed. ",driver.findElement(By.cssSelector(beforeListItem + i + afterListItem)).isDisplayed());
			}
		} catch (NoSuchElementException e) {
//			e.printStackTrace(); //We committed so the console looks cleaner
			System.out.println("All list items are removed!");
		}

	}
}
