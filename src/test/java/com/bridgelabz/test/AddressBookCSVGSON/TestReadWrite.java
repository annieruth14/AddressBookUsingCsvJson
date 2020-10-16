package com.bridgelabz.test.AddressBookCSVGSON;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class TestReadWrite {
	ReadWriteUsingCsv readWriteCSV = new ReadWriteUsingCsv();
	
	@Test
	public void givenString_whenAddedToCsv_shouldReturnTrue() throws IOException {
		boolean result = readWriteCSV.writeIntoCsv();
		Assert.assertTrue(result);
	}
	
	@Test
	public void givenCsvFile_whenRead_shouldReturnNoOfEntries() throws IOException {
		int count = readWriteCSV.readFromCsv();
		System.out.println(count);
		Assert.assertEquals(count, 5);
	}
	
	
}
