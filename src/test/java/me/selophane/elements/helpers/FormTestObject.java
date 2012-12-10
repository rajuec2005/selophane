package me.selophane.elements.helpers;

import me.selophane.elements.CheckBox;
import me.selophane.elements.Element;
import me.selophane.elements.Label;
import me.selophane.elements.Select;
import me.selophane.elements.impl.internal.ElementFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * declare elements of a form.
 */
public class FormTestObject {

    private WebDriver driver;

    @FindBy(id = "test1")
    public Element element;

    @FindBy(id = "test1")
    public WebElement webElement;

    @FindBy(id = "option1")
    public Select option1;

    @FindBy(id = "checkbox")
    public CheckBox checkbox;

    @FindBy(tagName = "label")
    public List<Label> labels;

    public FormTestObject(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Static factory for generating the class.
     *
     * @param driver The WebDriver for the session.
     * @return FormTestObject.
     */
    public static FormTestObject initialize(WebDriver driver) {
        return ElementFactory.initElements(driver, FormTestObject.class);
    }

    public void get() {
        PageLoader.get(driver, "forms.html");
    }

    public void close() {
        driver.close();
    }

}