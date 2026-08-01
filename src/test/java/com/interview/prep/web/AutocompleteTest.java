package com.interview.prep.web;

import com.interview.prep.base.BaseTest;
import com.interview.prep.utility.CustomListeners;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static com.interview.prep.web.DriverFactory.getDriver;

@Listeners(CustomListeners.class)
public class AutocompleteTest extends BaseTest {

    @Test
    public void testAutoCompleteByText() {
        navigateTo("/autocomplete");
        AutocompletePage autocompletePage = new AutocompletePage(getDriver());
        //Typing in Textbox
        autocompletePage.typeKeyWord("U");
        //Filtering first WebElement suggestion with keyword
        Optional<WebElement> suggestion=autocompletePage.getAutoCompleteSuggest()
                .stream()
                .filter(p-> p.getText().trim().contains("Ukraine"))
                .findFirst();
        // Clicking on first suggestion with keyword text
        suggestion.ifPresent(WebElement::click);
        autocompletePage.clickSubmit();
        //Asserting text displayed after form submission
        Assert.assertEquals(autocompletePage.getTextDisplayed(),"Ukraine");
    }

    @Test
    public void testAutoCompleteByTextContains() throws InterruptedException {
        navigateTo("/autocomplete");
        AutocompletePage autocompletePage = new AutocompletePage(getDriver());
        //Typing in Textbox
        autocompletePage.typeKeyWord("J");
        //Storing List of WebElement suggestion with keyword
        List<WebElement> suggestions=autocompletePage.getAutoCompleteSuggest();

        //Filtering element with Attribute value
        for (WebElement ele:suggestions){
            String suggestionText= ele.findElement(By.tagName("input")).getAttribute("value");
            if (suggestionText.contains("Japan")){
                ele.click();
                break;
            }
        }
        // Clicking on first suggestion with keyword text
        autocompletePage.clickSubmit();
        //Asserting text displayed after form submission
        Assert.assertEquals(autocompletePage.getTextDisplayed(),"Japan");
        Thread.sleep(1000);
    }
}
