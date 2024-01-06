package client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fileprocessors.StockFileData;
import fileprocessors.StockFileReader;

public class StockFileApplication {

	public static void main(String args[]) throws IOException {
		StockFileReader fr = new StockFileReader("table.csv");

		List<HashMap<String, Double>> dataResult = populateStockFileData(fr.getHeaders(), fr.readFileData());
		StockFileData fileData = new StockFileData();
		fileData.addData(dataResult);
		fileData.printData();
		System.out.println(dataResult.size());
	}


	public static List<HashMap<String, Double>> populateStockFileData(List<String> headers, List<String> lines) {
		List<HashMap<String, Double>> dataResult = new ArrayList<>();
		for (String line : lines) {
			String [] values = line.split(",");
			int cnt = 0;
			HashMap<String, Double> headerValueMap = new HashMap<>();

			for (String value : values){
				double dval = Double.parseDouble(value);
				headerValueMap.put(headers.get(cnt), dval);
				cnt++;
			}
			dataResult.add(headerValueMap);
		}
		return dataResult;
	}

	
	
}
