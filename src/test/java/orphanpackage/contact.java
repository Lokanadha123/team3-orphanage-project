package orphanpackage;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class contact {
WebDriver driver;
 
  @BeforeMethod
 public void beforeMethod() throws Exception {
 String path1="D:\\chromedriver.exe";
 System.setProperty("webdriver.chrome.driver", path1);
 driver=new ChromeDriver();
 driver.get("C://Users//itctesting38//Documents//theressa orphanage//contact.html");
 }
  @Test(dataProvider="getData")
  public void test(String name,String email,String phone,String message) {
	  driver.findElement(By.id("form-tag")).sendKeys(name);
		
		driver.findElement(By.name("E-mail")).sendKeys(email);
	
		driver.findElement(By.name("Name1")).sendKeys(phone);
		
		driver.findElement(By.name("Description")).sendKeys(message);
		
		//driver.findElement(By.id("send-mess")).sendKeys("click");
  }
  @DataProvider
  public String[][] getData() throws Exception {
  File src=new File("C:\\Users\\itctesting38\\Documents\\excel4contact.xlsx");
  FileInputStream fis=new FileInputStream(src);
  XSSFWorkbook wb=new XSSFWorkbook(fis);
  XSSFSheet sheet=wb.getSheet("Sheet1");
  int Rows=sheet.getPhysicalNumberOfRows();
  int cols=sheet.getRow(0).getLastCellNum();

  String[][] data=new String[Rows-1][cols];
  for(int i=0;i<Rows-1;i++)
  {
  for(int j=0;j<cols;j++)
  {
  DataFormatter df=new DataFormatter();
  data[i][j]= df.formatCellValue(sheet.getRow(i+1).getCell(j));

  }
  System.out.println();
  }
  wb.close();
  fis.close();
  return data;
  }
  @AfterMethod
  public void afterMethod() {
  driver.quit();
  }
 



}
