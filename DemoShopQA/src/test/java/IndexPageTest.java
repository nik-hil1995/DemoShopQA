import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rwb.baseTest.BaseClass;
import com.rwb.pageObjects.IndexPage;

public class IndexPageTest extends BaseClass {
   
	IndexPage indexpage;
	String expectedTitle = "ToolsQA Demo Site – ToolsQA – Demo E-Commerce Site";
	
	@BeforeMethod
	public void setup() {
		LaunchApp();
	}

	@AfterMethod
	public void teardonw() {
		driver.quit();
	}

	@Test
	public void verifylogo() {
		indexpage = new IndexPage();
		boolean result = indexpage.validateLogo();
		Assert.assertTrue(result);
	}

	@Test
	public void verifytitle() {
		String actualtitle = indexpage.getTitle();
		Assert.assertEquals(actualtitle, expectedTitle);
	}

}
