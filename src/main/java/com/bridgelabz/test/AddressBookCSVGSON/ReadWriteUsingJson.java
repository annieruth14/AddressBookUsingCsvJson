package com.bridgelabz.test.AddressBookCSVGSON;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ReadWriteUsingJson {
	private static final String JSON_FILE_PATH = "users-write.json";
	public boolean writeIntoJson(){
		try {
				List<AddressBook> address = Arrays.asList( 
						new AddressBook("Annie", "Ruth", "NBU" , "Siliguri" , "WB" , 789456 , 89613112, "ruth3@gmail.com") ,
						new AddressBook("Neha", "Clare", "Kadamtala" , "Mirik" , "TN" , 34567 , 894561355, "neha@gmail.com") ,
						new AddressBook("Kiran", "Bed", "Shantinagar" , "Kurseong" , "AP" , 45336 , 899946132, "kiran6@gmail.com") ,
						new AddressBook("Ankita", "Sarkar", "Sevoke" , "Mirik" , "WB" , 74556 , 894561555, "ankita2@gmail.com") ,
						new AddressBook("Portia", "Das", "Silla" , "Siliguri" , "JK" , 7867888 , 894444432, "portia@gmail.com") 
				);
				Gson gson = new GsonBuilder().setPrettyPrinting().create();

				// create a writer
			    Writer writer = Files.newBufferedWriter(Paths.get(JSON_FILE_PATH));

			    // convert user object to JSON file
			    gson.toJson(address, writer);

			    // close writer
			    writer.close();
			    return true;
		}
		catch(Exception e) {
			
		}
		return false;
	}
	public int readFromJson() {
		try {
			 // create Gson instance
		    Gson gson = new Gson();
		    
		    // create a reader
		    Reader reader = Files.newBufferedReader(Paths.get(JSON_FILE_PATH));
		  
		    // convert JSON string to User object
		    List<AddressBook> address = Arrays.asList(gson.fromJson(reader, AddressBook[].class));

		    // print books
		    address.forEach(System.out::println);
		    int count = address.size();

		    // close reader
		    reader.close();
		    return count;
		}
		catch(Exception e) {
			
		}
		return 0;
	}
}
