package Test;

import java.io.IOException;

import org.testng.annotations.Test;

import googleList.GoogleList;
import herokuapp.HerokuApp;
import testautomationpractice.TestAutomation;

public class NewTest {

  @Test(enabled = false)
  public void TestAutomationTest() throws InterruptedException {
	  TestAutomation ta = new TestAutomation();
	  
//	  ta.Testing();
//	  ta.Tabs();
//	  ta.Button();
//	  ta.simpleAlert();
//	  ta.confirmationAlert();
//	  ta.promptBtn();
	  ta.mouseHover();
	  ta.doubleClick();
	  ta.dragDrop();

	  ta.staticTable();
	  ta.dynamicTable();
  }
  
  @Test(enabled = false)
  public void googleList()
  {
	  GoogleList gl = new GoogleList();
//	  gl.storingList();
  }
  
  @Test(enabled = true)
  public void herokuapp() throws InterruptedException, IOException
  {
	  HerokuApp ha = new HerokuApp();
//	  ha.abTesting();
//	  ha.addRemove();
//	  ha.basicAuth();
//	  ha.assertLogin();
//	  ha.checkBox();
//	  ha.disapperingElement();
//	  ha.dragAndDrop();
//	  ha.dropDrown();
//	  ha.alert();
//	  ha.entryAd();
//	  ha.dynamicLoading();
//	  ha.multipleWindow();
//	  ha.scroll();
//	  ha.infiniteScroll();
//	  ha.fileUpload();
//	  ha.brokenImages();
//	  ha.challengingDom();
//	  ha.iframes();
//	  ha.keyPresses();
//	  ha.loginPage();
//	  ha.captureScreenshot("ss1", "./screenshots");
//	  ha.dataTable();
	  ha.dynamicControl();
	  
	  
  }
  
  
}
