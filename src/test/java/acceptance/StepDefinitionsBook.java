package acceptance;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.assertEquals;
import com.lejap59.booklibrary.Book;

 /** Steps definitions for book-library.feature */
public class StepDefinitionsBook {
 private String server = System.getProperty("booklibrary.url");
 private RestTemplate restTemplate = new RestTemplate();
 private String title;
 private String author;
 private Integer ISBN;   
 private String result;
 
 @Given("^Book (.*) by (.*) with ISBN number (.*)$")
    public void BookBy (String title, String author, Integer ISBN) throws Throwable {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }
 
 @When("^I store the book in the library$")
    public void i_store_the_book() throws Throwable {
        String url = String.format("%s/addBook?title=%s&author=%s&ISBN=%s", server, title, author, ISBN);
        result = restTemplate.getForObject(url, String.class);
    }
 
 @Then("^I am able to retrieve the book by the ISBN number$")
    public void i_am_able_to_retrieve(String expectedResult) throws Throwable {
        result = String.format("%s/findBook?ISBN=%s", server, ISBN);
        System.out.println(result);
        assertEquals(expectedResult, result);
    }
}