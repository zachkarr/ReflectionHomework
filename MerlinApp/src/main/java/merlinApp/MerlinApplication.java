package merlinApp;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

import merlinApp.vo.RuneStone;

public class MerlinApplication {

	private static final String runeStoneFile = "./runeStone.csv";
	
	public static void main(String[] args) throws IOException, CsvValidationException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Reader reader = Files.newBufferedReader(Paths.get(runeStoneFile));
		CSVReader headerReader = new CSVReader(reader);
		String[] headerRow = headerReader.readNext();
		reader.reset();
		CsvToBean<RuneStone> runeRecords = new CsvToBeanBuilder<RuneStone>(reader).withType(RuneStone.class).withSkipLines(0).build();
		List<RuneStone> runeRecordList = runeRecords.parse();
		String decipheredMessage = "";
		for (RuneStone r : runeRecordList) {
			for (int i = 0; i < headerRow.length; i++) {
				/* TODO: 
				   1. Must use Reflection to get the "get" methods from RuneStone value object. (RuneStone.java file in the vo package)
				   2. After retrieving the method, invoke it, to get each phrase
				   3. Extract the "good" character at the correct position - i.e. The "good" character of scribe0 = the first character. For scribe1 = the second character, and so on....  
				   4. Combine (concatenate) all the "good" characters to form the magic phrase.
				   5. Should be able to do this easily in four lines of code, 
				      but will start taking off points if the lines of code becomes exceedingly high
				*/
			}
		}
		System.out.println(decipheredMessage);
		headerReader.close();
	}
}
