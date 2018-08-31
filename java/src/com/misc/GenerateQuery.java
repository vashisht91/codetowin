package com.misc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateQuery {

	public static void main(String[] args) {
		
		String query = "Insert into WMS912PSR03.PRTDSC   (COLNAM, COLVAL, LOCALE_ID, LNGDSC, SHORT_DSC) Values   ('prtnum|prt_client_id|wh_id_tmpl', 'ITEMNUMBER|E1200|DCNAME', 'US_ENGLISH', 'Rear Elliptical Bicycle Safety Light', 'Rear Elliptical Bicy');\n";
		List<String> list = Arrays.asList(
				"11001","11004","11005","11006","11013","11014","11015","11016","11019","11020","11021","11022","11023","11032","11034","11044","11045","11046","11047","11054","11056","11057","11058","11059","11061","11066","11067","11068","11069","11070","11071","11082","11083","11084","11086","11088","11089","11091","11099","11100","11101","11105","11200","11201","11202","11203","11204","11205","11206","11207","11208","11209","11210","11211","11212","11213","11214","11215","11216","11217","11218"
				);
		
		List<String> listDCs = Arrays.asList(
				"----","DC0001","DC0002","DC1001","DC1002","DC1003","DC1004","DC1005","DC1006"
				);
		
		List<String> listUOMs = Arrays.asList(
				"CS","EA","IP","LA","PA"
				);
		for(int k=0;k<listDCs.size();k++){
			StringBuilder builder = new StringBuilder();
			String queryNew = query.replaceAll("DCNAME", listDCs.get(k));
			for(int j=0;j<list.size();j++){
				
			/*	for(int l=0;l<listUOMs.size();l++) {
				
				String queryNew2 = queryNew.replaceAll("UOMNAME", listUOMs.get(l));
	*/			
					for(int i=1;i<=1539;i++) {
						builder.append(queryNew.replaceAll("ITEMNUMBER", list.get(j)+"_"+i));
					}
//				}
			}
			builder.append("commit;");
			File file = new File("C:\\JDA\\WM_Item_Insert_Scripts\\prtdsc\\query"+k+".sql");
			FileWriter writer;
			try {
				writer = new FileWriter(file);		
				writer.write(builder.toString());
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
