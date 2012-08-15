package net.comes.care.common.evaluation;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;

public class ACDataReader extends Reader {

	private final LineNumberReader internalReader;
	public static final String ACDATA_REGEX = "(^##;.*;20\\d{2};(0[1-9]|1[0-2]);([0-2]\\d|3[0-1]);([0-1]\\d|2[0-4]);([0-5]\\d|60);([0-5]\\d|60);.+;\\d+;\\d+;\\d{1,3}(\\.\\d{1,2})?;\\d{1,3}(\\.\\d{1,2})?;\\d{1,3}(\\.\\d{1,2})?(;\\d{1,3}(\\.\\d{1,2})?)?(;\\d{1,3}(\\.\\d{1,2})?)?$)";

	public ACDataReader(InputStream in) {
		internalReader = new LineNumberReader(new InputStreamReader(in));
	}

	public ACDataReader(Reader in) {
		internalReader = new LineNumberReader(in);
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public String readACData() throws IOException {
		return validate(internalReader.readLine());
	}
	
	/**
	 * 
	 * @param line
	 * @throws IOException
	 */
	private String validate(String line) throws IOException {
		if (line != null && line.matches(ACDATA_REGEX))
			throw new IOException("Line " + line + "doesn't match regex \n " + ACDATA_REGEX);
		return line;
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		return internalReader.read(cbuf, off, len);
	}

	@Override
	public void close() throws IOException {
		internalReader.close();
	}

}
