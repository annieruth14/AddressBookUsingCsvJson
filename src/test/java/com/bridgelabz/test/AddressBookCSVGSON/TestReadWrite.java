package com.bridgelabz.test.AddressBookCSVGSON;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class TestReadWrite {
	ReadWriteUsingCsv readWriteCSV = new ReadWriteUsingCsv();
	ReadWriteUsingJson readWriteJSON = new ReadWriteUsingJson();
	
	@Test
	public void givenString_whenAddedToCsv_shouldReturnTrue() throws IOException {
		boolean result = readWriteCSV.writeIntoCsv();
		Assert.assertTrue(result);
	}
	
	@Test
	public void givenCsvFile_whenRead_shouldReturnNoOfEntries() throws IOException {
		int count = readWriteCSV.readFromCsv();
		Assert.assertEquals(count, 5);
	}
	
	@Test
	public void givenString_whenAddedToJson_shouldReturnTrue() throws IOException {
		boolean result = readWriteJSON.writeIntoJson();
		Assert.assertTrue(result);
	}
	
	@Test
	public void givenJsonFile_whenRead_shouldReturnNoOfEntries() throws IOException {
		int countEntries = readWriteJSON.readFromJson();
		Assert.assertEquals(countEntries, 5);
	}
}
