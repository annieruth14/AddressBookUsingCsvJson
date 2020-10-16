package com.bridgelabz.test.AddressBookCSVGSON;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class ReadWriteUsingCsv {
	private static final String CSV_FILE_PATH = "users-write.csv";
	public boolean writeIntoCsv() throws IOException {
		boolean result = false;
		try (
				Writer writer = Files.newBufferedWriter(Paths.get(CSV_FILE_PATH ));
				 CSVWriter csvWriter = new CSVWriter(writer,
		                    CSVWriter.DEFAULT_SEPARATOR,
		                    CSVWriter.NO_QUOTE_CHARACTER,
		                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
		                    CSVWriter.DEFAULT_LINE_END);
			)
		{
			String[] headerRecord = {"First_name", "Last_name", "Address","City"," State" ,"Zip", "Phone", "Email"};
            csvWriter.writeNext(headerRecord);

            csvWriter.writeNext(new String[]{"Annie", "Ruth", "NBU" , "Siliguri" , "WB" , "789456" , "8945613112", "ruth3@gmail.com"});
            csvWriter.writeNext(new String[]{"Neha", "Clare", "Kadamtala" , "Mirik" , "TN" , "34567" , "894561355", "neha@gmail.com"});
            csvWriter.writeNext(new String[]{"Kiran", "Bed", "Shantinagar" , "Kurseong" , "AP" , "45336" , "899946132", "kiran6@gmail.com"});
            csvWriter.writeNext(new String[]{"Ankita", "Sarkar", "Sevoke" , "Mirik" , "WB" , "74556" , "8945613555", "ankita2@gmail.com"});
            csvWriter.writeNext(new String[]{"Portia", "Das", "Silla" , "Siliguri" , "JK" , "7867888" , "894444432", "portia@gmail.com"});
            result = true;
            return result;
		}
	}
	
	public int readFromCsv() throws IOException {
		int countPerson = 0;
		try (
				Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
			)
		{	
			 	ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
	            strategy.setType(AddressBook.class);
	          
	            String[] memberFieldsToBindTo = {"first_name", "last_name", "address","city","state","zip","phone","email"};
	            strategy.setColumnMapping(memberFieldsToBindTo);

	            CsvToBean<AddressBook> csvToBean = new CsvToBeanBuilder(reader)
	                    .withMappingStrategy(strategy)
	                    .withSkipLines(1)
	                    .withIgnoreLeadingWhiteSpace(true)
	                    .build();

	            Iterator<AddressBook> personIterator = csvToBean.iterator();
	            
	            while (personIterator.hasNext()) {
	            	AddressBook addressBook = personIterator.next();
	                System.out.println("First Name : " + addressBook.getFirst_name());
	                System.out.println("Last Name : " + addressBook.getLast_name());
	                System.out.println("Address : " + addressBook.getAddress());
	                System.out.println("City : " + addressBook.getCity());
	                System.out.println("State : " + addressBook.getState());
	                System.out.println("Name : " + addressBook.getZip());
	                System.out.println("PhoneNo : " + addressBook.getPhone());
	                System.out.println("Email : " + addressBook.getEmail());
	                System.out.println("---------------------------");
	                countPerson++;
	            }
		}
		return countPerson;
	}
}
