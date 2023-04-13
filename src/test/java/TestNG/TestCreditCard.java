package TestNG;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCreditCard {

	@Test(groups = { "Regression" })
	@Parameters("studentNames")
	public void testCreditCard1(String str) {
		System.out.println("This is Credit Card test1");
		System.out.println("name is:" + str);
	}

	@Test(groups = { "Sanity", "Integration" })
	public void testCreditCard2() {
		System.out.println("This is Credit Card test2");
	}

	@Test(groups = { "Regression" }, dataProvider = "CCUserData")
	public void testCreditCard3(String CCN, String Name, String Pin, String MPin) {
		System.out.println("This is Credit Card test3");
		System.out.println(CCN + " ; " + Name + " ; " + Pin + " ; " + MPin);
	}

	@BeforeClass(alwaysRun = true)
	public void testCreditCardIssue() {
		System.out.println("This is Credit Card issue method and run before all the test");
	}

	@BeforeMethod(alwaysRun = true)
	public void testCreditCardBalance() {
		System.out.println("This execute before credit card test");
	}

	@BeforeSuite(alwaysRun = true)
	public void accountLogin() {
		System.out.println("This execute before running bank related user test");
	}

	@AfterSuite(alwaysRun = true)
	public void accountLogOut() {
		System.out.println("This execute after completing bank related user test");
	}

	@AfterMethod(alwaysRun = true)
	public void TestResetBalance() {
		System.out.println("This execute after credit card test");
	}

	@AfterClass(alwaysRun = true)
	public void TestCreditCardRevoke() {
		System.out.println("This method executes after all the credit card test");
	}

	@AfterGroups(alwaysRun = true, groups = { "Sanity" })
	public void testAfterGroups() {
		System.out.println("This will run after every group");
	}

	@BeforeGroups(alwaysRun = true, groups = { "Sanity" })
	public void testBeforeGroups() {
		System.out.println("This will run before every group");
	}

	@DataProvider(name = "CCUserData")
	public Object[][] TestData() throws IOException {
		Object[][] UserData = null;
		FileInputStream file = new FileInputStream("C:\\Users\\Dell\\OneDrive\\Desktop\\Testdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Data");
		XSSFCell cell;
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getLastCellNum();
		
		System.out.println("Rows are: "+rowCount);
		System.out.println("Colmns are: "+colCount);
		UserData = new Object[rowCount][colCount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				cell = sheet.getRow(i).getCell(j);
				CellType s= cell.getCellType();
				Object cellData = null;
				switch(s) {
				
				case BOOLEAN:
					cellData = cell.getBooleanCellValue();
					break;
				
				
				case STRING:
					cellData = cell.getStringCellValue();
					break;
					
				case NUMERIC:
					cellData = cell.getNumericCellValue();
					break;
					
				case BLANK:
					cellData = "";
					break;
				
					default:
						break;			
				
				}

				UserData[i][j]= cellData;
			}

		}

		return UserData;
	}

}
