package com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.RegistrationPages;


import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class SMSecurityQuestionsPage extends PageObject {
    private String questionBlock = "/parent::div/parent::div/preceding-sibling::p/parent::li";
    private String buttonAccessMyScore = "//*[@class='vv-btn w-100 vv-btn-big d-inline-block ']";
    private String answerTemplate = "//label[contains(text(), '%s')]";
    private String NoneOfTheAbove1 = "//label[contains(text(), '$')]/parent::div/following-sibling::div[4]/label[contains(text(), 'None of the Above')]"; //xpath to find concrete None of the Above answear for question with $
    private String NoneOfTheAbove2 = "//label[contains(text(), '1995')]/parent::div/following-sibling::div[4]/label[contains(text(), 'None of the Above')]"; //xpath to find concrete None of the Above answear for question with years
    private List<String> listAnswers = Arrays.asList("Bond", "New Hampshire", "Bowen", "Iec", "Ashwood"); // list for correct answers
    private WebElement findElementByXpath(String xpath) {
        return getDriver().findElement(By.xpath(xpath));
    }

    private Map<String, Boolean> mapIsClicked = new HashMap<String, Boolean>() { // map to define which question is already answered (false by default for all)
        {
            put("//*[@data-question='1']", false);
            put("//*[@data-question='2']", false);
            put("//*[@data-question='3']", false);
        }
    };

    private boolean isNoneAdded = false; // variable which defines if None of the above answer is already added to the list

    public void setAnswers(int numberOfCorrectAnswers) { //numberOfCorrectAnswers variable is passing from feature file where user can specify how many correct answers he needs
        if (numberOfCorrectAnswers > 3) { //check for numbers > 3. If user passes 4 by mistake, it will be converted to 3
            numberOfCorrectAnswers = 3;
        }
         else if (numberOfCorrectAnswers < 0) {//check for numbers < 3. If user passes -1 by mistake, it will be converted to 0
            numberOfCorrectAnswers = 0;
        }
        List<WebElement> list = Arrays.asList(new WebElement[4]); // list for correct answers and number of question blocks where they were found
        for (String l : listAnswers) { //iteration through the list of correct answers to check whether each element of the list present on a page or not
            try { //this try is needed to catch the NoSuchElementException thrown by isDisplayed() method in case element was not displayed
                getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); //this wait is needed to let all elements on a page be loaded
                if (findElementByXpath(String.format(answerTemplate, l)).isDisplayed()) { // check if answer is present on a page for each element in list of correct answers(for first iteration xpath will be '//label[contains(text(), 'Bond')]')
                    int index = Integer.parseInt(findElementByXpath(String.format(answerTemplate, l) + questionBlock).getAttribute("data-question")); // index is needed to define in which block of questions correct answer was found
                    list.set(index - 1, findElementByXpath(String.format(answerTemplate, l))); // here we put the correct answer which was found to the <index> place in a list. Example: if answear 'Bond' was found in second question block, it will be put to the second position of the list.
                    if (findElementByXpath(NoneOfTheAbove1).isDisplayed() && !isNoneAdded) { //the same as if statement above but for None of the Above answer for questions with $
                        int index1 = Integer.parseInt(findElementByXpath(NoneOfTheAbove1 + questionBlock).getAttribute("data-question"));
                        isNoneAdded = true;
                        list.set(index1 - 1, findElementByXpath(NoneOfTheAbove1));
                    } else if ((findElementByXpath(NoneOfTheAbove2)).isDisplayed() && !isNoneAdded) { //the same as if statement above but for None of the Above answer for questions with years
                        int index1 = Integer.parseInt(findElementByXpath(NoneOfTheAbove2 + questionBlock).getAttribute("data-question"));
                        isNoneAdded = true;
                        list.set(index1 - 1, findElementByXpath(NoneOfTheAbove2));
                    }
                }
            } catch (NoSuchElementException e) { // here we are catching the exception which throws the isDisplayed() and doing the continue which means that we are moving to the next loop iteration because answer was not found on a page
                continue;
            }
            if(list.size()==3)
            {
                break;
            }
        }
        int j = 0;
        for (int k = 0; k < list.size(); k++) { // loop through the list formed above to click on answers
            if (list.get(k) != null) { // check if list item with index 'k' is not null. It could be null in case correct answers were found only in e.g. 2 and 3 block but were not found in 1 block. Then value with index 1 in the list will be NULL.
                if (j == numberOfCorrectAnswers) { // check we didn't exceed the number of correct answers. If user specified 2 answers we will do break from this loop when 'j' will be equal to 2. Each time we select correct answer, j is increasing by 1.
                    if (k == 3) {
                        mapIsClicked.put("//*[@data-question='4']", false); // here we are adding a new value to the map(mapIsClicked) for additional question, which appears after user answered only 1 question correctly.
                    }
                    break;
                }
                j++;
                int exceptionCount = 0;
                do {
                        try { //this try is needed to catch the StaleElementReferenceException.
                            Coordinates cor = ((Locatable) list.get(k)).getCoordinates(); // this and next rows are needed to scroll page to the concrete answer to make it possible to click on it
                            cor.inViewPort();
                            list.get(k).click(); // click on concrete answer
                            exceptionCount = 4; //
                        } catch (StaleElementReferenceException e) {
                            ++exceptionCount;
                        }
                    } while (exceptionCount <= 3); // try to locate the element 3 times
                switch (k) { // is needed to define which question is already answered. If question 2 was answered map value will be "//*[@data-question='2']", true. Previously it was false for all questions as we defined this on the top.
                    case 0:
                        mapIsClicked.put("//*[@data-question='1']", true);
                        break;
                    case 1:
                        mapIsClicked.put("//*[@data-question='2']", true);
                        break;
                    case 2:
                        mapIsClicked.put("//*[@data-question='3']", true);
                        break;
                    case 3:
                        if (getDriver().findElement(By.xpath("//*[@data-question='4']")).isDisplayed()) { // for additional question
                            mapIsClicked.put("//*[@data-question='4']", true);
                        }
                        break;
                    default:
                }
            }
        }
        List<WebElement> listAnswersOnPageWebElements;
        List<String> listAnswersOnPageStrings = new ArrayList<>();
        for (Map.Entry<String, Boolean> entry : mapIsClicked.entrySet()) { // loop for the map where we defined which question is answered. It is needed to answer all questions, because if one of the question is not answered you will not be able to proceed with registration.
            if (!entry.getValue()) { // if some question has false value in the map 'mapIsClicked'
                listAnswersOnPageWebElements = getDriver().findElements(By.xpath(entry.getKey() + "/div/div/label")); // we get all answers for that question as WebElements to the list
                if (listAnswersOnPageWebElements.size() == 0) {  // in case nothing is added in this iteration we move to the next iteration
                    continue; //move to the next iteration
                }
                for (WebElement l : listAnswersOnPageWebElements) { // we are getting the text of each answer in a block of question and put them to the list of String to be able to pass that answer to the xpath then
                    listAnswersOnPageStrings.add(l.getText());
                }
                listAnswersOnPageStrings.removeAll(listAnswers); // from the list formed above we delete all entries of correct answers using the list of correct answers 'listAnswers'
                Coordinates cor = ((Locatable) findElementByXpath(String.format(answerTemplate, listAnswersOnPageStrings.get(0)))).getCoordinates(); // scroll to the first answer of not answered question (correct answer will not be chosen for sure because we removed them above)
                cor.inViewPort();
                findElementByXpath(String.format(answerTemplate, listAnswersOnPageStrings.get(0))).click(); // click on first answer of non-answered question block
                listAnswersOnPageStrings.clear(); // clear the list to fill it again on next iteration for next not answered question
            }
        } //as a result we have all questions answered with number of correct answers which was specified by user and and first answer for each question which was not answered and we are able to  click on access my score button now.
    } // this method could be also used for answering the additional question which appears after the user answered only one question correct on first registration step

    public void clickAccessMyScore() {
        findElementByXpath(buttonAccessMyScore).click();
    }

    public boolean isBlockedSSNTextDisplayed()
    {
        return findElementByXpath("//*[@class='vv-text-01 vv-message-description']/span").getText().contains("Please come back in 30 days");
    }
}
