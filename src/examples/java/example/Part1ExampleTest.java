package example;

import junit.framework.Assert;
import me.selophane.elements.CheckBox;
import me.selophane.elements.helpers.PageLoader;
import me.selophane.elements.impl.CheckBoxImpl;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Part2ExampleTest uses original WebDriver PageFactory.
 * This is to show the awkwardness of manually wrapping WebElements.
 *
 * @see <a href="http://elisarver.com/blog/2012/12/09/wrapping-webelement-1/">Wrapping WebElement Part 1</a>
 */
public class Part1ExampleTest {
    @FindBy(id = "checkbox")
    WebElement checkBox;

    @Test
    public void simple() {
        WebDriver driver = new FirefoxDriver();
        PageFactory.initElements(driver, this);
        
        PageLoader.get(driver, "forms.html");
        CheckBox wrappedCheckBox = new CheckBoxImpl(checkBox);
        
        Assert.assertFalse(wrappedCheckBox.isChecked());
        wrappedCheckBox.check();
        Assert.assertTrue(wrappedCheckBox.isChecked());
        
        driver.close();
    }
}