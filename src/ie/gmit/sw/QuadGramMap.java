package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class QuadGramMap
{
	public static final int GRAM_SIZE = 4;

	public Map<String, Integer> parsequadGramMap() throws FileNotFoundException
	{

		Map<String, Integer> quadGramMap = new ConcurrentHashMap<String, Integer>();

		BufferedReader BufferedReader = new BufferedReader(new FileReader("4grams.txt"));

		return null;

	}
}