package org.Selenium.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public interface ConifgReader {

	// Read the properties file
	// Create global Variables and assign the value

	void configReader();
	
	List<String> readActitimeTestData();
}
