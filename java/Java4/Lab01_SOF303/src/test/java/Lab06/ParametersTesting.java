package Lab06;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTesting {

  @Parameters({"BrowserName"})
  @Test
  public void OpenBrowser(String BrowserName){
    System.out.println("browser passed as :-"+ BrowserName);
  }
  @Parameters({"UserName","Password"})
  @Test
  public void FillLoginForm(String UserName,String Passcode){
    System.out.println("UserName passed as :-"+ UserName);
    System.out.println("Passcode passed as :-"+ Passcode);
  }
}
