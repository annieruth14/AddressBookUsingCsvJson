package com.bridgelabz.test.AddressBookCSVGSON;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileIOOperations {
	public static String FILE_NAME = "Address-Book-Data.txt";
	// Write Map to a file
			public void addMapToFile(Map<String, ArrayList<AddressBook>> mapOfAddressBook) {
				StringBuffer empBuffer = new StringBuffer();
				mapOfAddressBook.forEach((entry, value) -> {
					String mapEntry = entry.concat(" :");
					empBuffer.append(mapEntry);
					String mapValue = value.toString().concat("\n");
					empBuffer.append(mapValue);
				});
				try {
					Files.write(Paths.get(FILE_NAME), empBuffer.toString().getBytes());
				} catch (IOException e) {

				}
			}

			// Read from a file to Map
			public Map<String, ArrayList<AddressBook>> readFromFile() {
				Map<String, ArrayList<AddressBook>> mapFromFile = new HashMap<>();

				try {
					Files.lines(new File(FILE_NAME).toPath()).map(line -> line.trim()).forEach(line -> {
						// System.out.println(line);
						line = line.replace("[", "").replace("]", "");
						String[] lines = line.split(":");
						ArrayList<AddressBook> listFromFile = new ArrayList<>();
						for (int j = 0; j < lines.length; j++) {
							if (j >= 1) {
								String[] contacts = lines[j].split(",");
								for (int i = 0; i < contacts.length; i++) {
									contacts[i] = contacts[i].trim();
									String[] words = contacts[i].split(" ");
									listFromFile.add(new AddressBook(words[0], words[1], words[2], words[3], words[4],
											Integer.parseInt(words[5]), Long.parseLong(words[6]), words[7]));
								}
							}
						}
						mapFromFile.put(lines[0], listFromFile);
					});
					// System.out.println(mapFromFile.size());
				} catch (IOException e) {

				}
				return mapFromFile;
			}

}
