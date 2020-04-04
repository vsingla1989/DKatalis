package com.dkatalis.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CSVReader {

	public static Map<String, String> readCSV(String filePath, int row) throws IOException
	{
		HashMap<String,String> rowData= new HashMap<String,String>();
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String[] headers = (reader.readLine()).split(",");
		
		String line=null;
		for(int i=1;i<=row;i++)
		{
			line= reader.readLine();		
		}
		
		String[] lineData = line.split(",");
		
		for(int i=0;i<lineData.length;i++)
		{
			rowData.put(headers[i], lineData[i]);
		}
		
		return rowData;
	}
}
