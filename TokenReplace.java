package bac.ctcs;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenReplacer {

    private Pattern tokenPattern;

    public TokenReplacer() {
        tokenPattern = Pattern.compile("\\$\\{([^}]+)\\}");
    }

	static String readFile(String path, Charset encoding) 
	  throws IOException 
	{
	  byte[] encoded = Files.readAllBytes(Paths.get(path));
	  return new String(encoded, encoding);
	}

	public static String extractFileData() throws IOException {
		String str = new Scanner(new File("C://Jaxb//first.xml")).useDelimiter("\\z").next();
		System.out.println("str--->"+str);
		final Charset charset=Charset.forName("ISO-8859-1");
		String sttr = readFile("C://Jaxb//first.xml",charset);
		System.out.println("sttr--->"+sttr);
        return sttr;
		
	}

	private static void write( String str) throws IOException{
		
		FileOutputStream fileStream = new FileOutputStream(new File("C://Jaxb//first.xml"));
		OutputStreamWriter writer = new OutputStreamWriter(fileStream, "UTF-8");
		writer.write(str);
		writer.close();
	} 
	
    public static void main(String[] args) throws IOException {

    	//String  str ="hello ${abc.com} hr r u hw is ${bcd.com} and hw is cute ${efg.com}";
    	Map<String, String> maps = new HashMap<String, String>();
    	maps.put("abc.com", "Umashankar");
    	maps.put("bcd.com", "Jyoti");
    	maps.put("efg.com", "Shambhavi");
    	String  str = extractFileData();
    	TokenReplacer tokenReplacer = new TokenReplacer();
    	String replacedVal = tokenReplacer.replaceTokens(str , maps);
    	write(replacedVal);
    	System.out.println("hello-->"+replacedVal);
    	}

    public String replaceTokens(String text, Map<String, String> valuesByKey) {
        StringBuilder output = new StringBuilder();
        Matcher tokenMatcher = tokenPattern.matcher(text);

        int cursor = 0;
        while (tokenMatcher.find()) {
            // A token is defined as a sequence of the format "{...}".
            // A key is defined as the content between the brackets.
            int tokenStart = tokenMatcher.start();
            int tokenEnd = tokenMatcher.end();
            int keyStart = tokenMatcher.start(1);
            int keyEnd = tokenMatcher.end(1);

            output.append(text.substring(cursor, tokenStart));

            String token = text.substring(tokenStart, tokenEnd);
            String key = text.substring(keyStart, keyEnd);

            if (valuesByKey.containsKey(key)) {
                String value = valuesByKey.get(key);
                output.append(value);
            } else {
                output.append(token);
            }

            cursor = tokenEnd;
        }
        output.append(text.substring(cursor));

        return output.toString();
    }

}
