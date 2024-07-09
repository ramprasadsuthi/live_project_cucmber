package dataManager;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReadExcelData {
	
	private static List<Map<String, String>> excelData;
    static String username;
    static String password;

	public static void main(String[] args) throws IOException {
		
		   ExcelDataReader reader = new ExcelDataReader();
		     String filePath = "TestData.xlsx";  // Replace with your actual file path
		     String sheetName = "loginDetails";            // Replace with your actual sheet name
		     excelData = reader.readExcelData(filePath, sheetName);
		     System.out.println(excelData);
		     
		     excelData.forEach(map -> {
		            map.forEach((key, value) -> System.out.println(key + " : " + value));
		            System.out.println(); // Print a blank line between maps
		        });
		     
		     excelData.stream()
	            .map(map -> map.entrySet()
	                .stream()
	                .map(entry -> entry.getKey() + " : " + entry.getValue())
	                .collect(Collectors.joining("\n")))
	            .forEach(System.out::println);
		

	}

}
