package dataManager;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ReadExcelData2 {
	
	private static List<Map<String, String>> excelData;
    static String username;
    static String password;

	public static void main(String[] args) throws IOException {
		
		   ExcelDataReader reader = new ExcelDataReader();
		     String filePath = "TestData.xlsx";  // Replace with your actual file path
		     String sheetName = "loginDetails";            // Replace with your actual sheet name
		     excelData = reader.readExcelData(filePath, sheetName);
		     for (Map<String, String> rowData : excelData) {
		            username = rowData.get("username");
		            password = rowData.get("password");
		            System.out.println("Username : " + username);
		            System.out.println("Password : " + password);
		     }
		

	}

}
