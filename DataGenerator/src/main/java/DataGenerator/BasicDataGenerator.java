package DataGenerator;

import DataModel.DataGeneratorEnums;
import Interfaces.BasicDataGeneratorInterface;
import DataModel.DataGeneratorConsts;


import java.util.Random;

/**
* Created with IntelliJ IDEA.
* User: talbe
* Date: 11/09/12
* Time: 08:53
* To change this template use File | Settings | File Templates.
*/
public class BasicDataGenerator implements BasicDataGeneratorInterface {

	protected static Random random;
	protected static int seed;
	protected volatile static BasicDataGeneratorInterface baseInstance;

	protected BasicDataGenerator(){}

	private BasicDataGenerator(int seed) {
		this.seed = seed;
		random = new Random(seed);
	}

	public static BasicDataGeneratorInterface getInstance(int seed){
		if (baseInstance == null) {
			baseInstance = new BasicDataGenerator(seed);
		}
		else {
			baseInstance.setSeed(seed);
		}
		return baseInstance;
	}

	@Override
	public int generateInteger() {
		return random.nextInt();
	}

	@Override
	public int generateInteger(int size) {
		int result = -1;
		if (size > 0) {
			result = 0;
			for (int i=0;i<size;i++) {
				final int rand = random.nextInt(10);
				if (rand != 0)
					result += rand*Math.pow(10,i);
				else
					result += Math.pow(10,i);
			}
		}
		return result;
	}

	@Override
	public short generateShort() {
		return (short)random.nextInt();
	}

	@Override
	public byte generateByte() {
		byte[] result = new byte[1];
		random.nextBytes(result);
		return result[0];
	}

	@Override
	public long generateLong() {
		return random.nextLong();
	}

	@Override
	public double generateDouble() {
		return random.nextDouble();
	}

	@Override
	public float generateFloat() {
		return random.nextFloat();
	}

	@Override
	public boolean generateBoolean() {
		return random.nextBoolean();
	}

	@Override
	public char generateChar() {
		char ch = (char)Math.abs(random.nextInt(256)) ;
		return ch;
	}

	@Override
	public char generateLowerCaseChar() {
		return (char)(DataGeneratorConsts.ASCII_LOWERCASE_INDEX_START + random.nextInt(DataGeneratorConsts.ASCII_ENGLISH_LETTERS_AMOUNT));
	}

	@Override
	public char generateUpperCaseChar() {
		return (char)(DataGeneratorConsts.ASCII_UPPERCASE_INDEX_START + random.nextInt(DataGeneratorConsts.ASCII_ENGLISH_LETTERS_AMOUNT));
	}

	@Override
	public char generateCharEnglishChar() {
		int ch = DataGeneratorConsts.ASCII_UPPERCASE_INDEX_START +
		random.nextInt(DataGeneratorConsts.ASCII_LOWERCASE_INDEX_END - DataGeneratorConsts.ASCII_UPPERCASE_INDEX_START);
		if (ch > DataGeneratorConsts.ASCII_UPPERCASE_INDEX_END && ch < DataGeneratorConsts.ASCII_LOWERCASE_INDEX_START)
			ch += DataGeneratorConsts.ASCII_UPPER_LOWER_CASE_DIFFERENCE;
		return (char)ch;
	}

	@Override
	public String generateString(DataGeneratorEnums.StringType stringType) {
		final int size = Math.abs(generateInteger(3));
		return generateString(stringType,size);
	}

	@Override
	public String generateString(DataGeneratorEnums.StringType stringType,int size) {
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<size;i++) {
			sb.append(generateChar());
		}
		String result = sb.toString();
		if (stringType == DataGeneratorEnums.StringType.LOWER_CASE)
			result = result.toLowerCase();
		else if (stringType == DataGeneratorEnums.StringType.UPPER_CASE)
			result = result.toUpperCase();

		return result;
	}

	@Override
	public String generateStringNoSpecialChars(DataGeneratorEnums.StringType stringType, int size) {
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<size;i++) {
			sb.append(generateCharEnglishChar());
		}
		String result = sb.toString();
		if (stringType == DataGeneratorEnums.StringType.LOWER_CASE)
			result = result.toLowerCase();
		else if (stringType == DataGeneratorEnums.StringType.UPPER_CASE)
			result = result.toUpperCase();

		return result;
	}

	@Override
	public String generateStringNoSpecialChars(DataGeneratorEnums.StringType stringType) {
		final int size = Math.abs(generateInteger(3));
		return generateStringNoSpecialChars(stringType,size);
	}

	public void setSeed(int seed) {
		this.seed = seed;
	}
}
