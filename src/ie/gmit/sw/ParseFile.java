package ie.gmit.sw;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ParseFile
{
	//Throws exception if file not Found
	public Map<String, Double> parse(String DataFile) throws FileNotFoundException
	{
		Map<String, Double> temporary = new ConcurrentHashMap<String, Double>();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(DataFile)));
		return temporary;
	}
}
