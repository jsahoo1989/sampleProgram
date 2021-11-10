package com.aires.utilities;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.DbFunctions;
import com.aires.businessrules.constants.PDTConstants;

public class TesProc {
	public static String  path;
	public static FileInputStream fis = null;
	private static HSSFWorkbook workbook = null;
	private static HSSFSheet sheet = null;
	
	public static int getRandomNumber(int min, int max) {
		Random r = new Random();
		int result = r.nextInt(max-min) + min;
		return result;
	}
	
	 public static void main(String[] args)  {
			/*String airShipmentCost = DbFunctions.getAirShipmentCost("250", "US", "DE", "PIT", "FRK", "NYC", "FRK");
			Log.info("Shipment cost=="+airShipmentCost);
			
			String surfaceShipmentCost = DbFunctions.getSurfaceShipmentCost("2000", "FR", "DE", "546");
			Log.info("Surface Shipment cost=="+surfaceShipmentCost);
			
			String tempStorageCost = DbFunctions.getSeaSurfaceTempStorageCost("30", "2000", "PA", "DE", "PIT", "FRK", "Destination");
			Log.info("Temp Storage cost=="+tempStorageCost);*/
			
			String permStorageCost = DbFunctions.getInternationalPermanentStorageCost("US", "DE", "PIT", "FRK", "2000");
			Log.info("Permanent Storage cost=="+permStorageCost);
			
			String num = "280,578.00";
			Log.info("num=="+num.replaceAll(",", ""));
			
			Log.info("random num="+getRandomNumber(0,9));
			/*try {
				String result = EmailUtil.searchEmailAndReturnResult(AiresConstants.HOST_EMAIL_DOMAIN, "airesautomationTransferee@aires.com",
						AiresConstants.AUTO_EMAIL_PWD, AiresConstants.DELEGATE_EMAIL_SENDER, "MobilityX Password", AiresConstants.TRANSFEREE_PASSWORD);
				Log.info("result=="+result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			/*path = System.getProperty("user.home")+"//Downloads//"+"ActivityHistory_Trend.xls";
			Xls_Reader xls = new Xls_Reader(path);
			if(xls.isSheetExist("Initiation Trends")) {
				
				sheet = workbook.getSheet("Initiation Trends");

			}*/
			
		/*	path = System.getProperty("user.home")+"//Downloads//"+"ActivityHistory_Trend.xls";
			try {
				fis = new FileInputStream(path);
				workbook = new HSSFWorkbook(fis);
				sheet = workbook.getSheet("Initiation Trends");
		        //get all rows in the sheet
				Log.info("FirstRownum=="+sheet.getFirstRowNum());
				Log.info("LastRownum=="+sheet.getLastRowNum());
		        int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		        Log.info("rowcount="+rowCount);
		        
		        ArrayList<String> originalList = new ArrayList<String>();
		        ArrayList<String> sortedlist = new ArrayList<String>();
		        
		        //iterate over all the row to print the data present in each cell.
		        for(int i=4;i<=rowCount;i++){
		            
		            //get cell count in a row
		            int cellcount=sheet.getRow(i).getLastCellNum();
		            
		            //iterate over each cell to print its value
		            System.out.println("Row"+ i+" data is :");
		            
		            //for(int j=0;j<cellcount;j++){
		                System.out.print(sheet.getRow(i).getCell(0).getStringCellValue() +",");
		                String[] quarterArr = sheet.getRow(i).getCell(0).getStringCellValue().split(" ");
		                originalList.add(quarterArr[1]+" "+quarterArr[0]);
		                sortedlist.add(quarterArr[1]+" "+quarterArr[0]);
		                //sortedlist.add(sheet.getRow(i).getCell(0).getStringCellValue());
		                Collections.sort(sortedlist, Collections.reverseOrder());
		            //}
		            System.out.println();
		        }
		        Log.info("originalList=="+originalList);
		        Log.info("sortedlist=="+sortedlist);
		        Log.info("equal=="+originalList.equals(sortedlist));
				fis.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			
	 }
}
