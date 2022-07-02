package Lab06;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class Bai4 {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		System.out.println("Kiếm tra đăng nhập website Guru99/V4");
		driver.get("https://www.demo.guru99.com/v4");
		driver.findElement(By.name("uid")).sendKeys("mngr394913");
		driver.findElement(By.name("password")).sendKeys("revegAz");
		driver.findElement(By.name("btnLogin")).click();
	}

	@Test
	public void DangNhap() {
		assertEquals(driver.getCurrentUrl(), "https://www.demo.guru99.com/v4/manager/Managerhomepage.php");
		System.out.println("Đăng nhập thành công");
	}

//Kiểm thử tiêu đề
	@Test
	public void Kiemtralogindungtieude() {
		String tieude = driver.getTitle();
		assertEquals(tieude, "Guru99 Bank Manager HomePage");
		System.out.println("Tiêu đề trang web là:" + tieude);
	}

	@Test
	public void Kiemtralogindungchaomung() {
		String chaomung = driver.findElement(By.className("heading3")).getText();
		assertEquals(chaomung, "Welcome To Manager's Page of Guru99 Bank");
		System.out.println("Dòng chữ chào mừng có nội dung là: " + chaomung);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
