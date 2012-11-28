package DataGeneratorTests;

import DataGenerator.BasicDataGenerator;
import DataModel.DataGeneratorConsts;
import DataModel.DataGeneratorEnums;
import Interfaces.BasicDataGeneratorInterface;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: talbe
 * Date: 11/09/12
 * Time: 13:44
 * To change this template use File | Settings | File Templates.
 */
public class BasicDataGeneratorTests {

	private BasicDataGeneratorInterface basicDataGenerator;

	@Before
	public void setUp() throws Exception {
		basicDataGenerator = BasicDataGenerator.getInstance(0);
	}

	@Test
	public void generateShort() {
		System.out.println("Generating short ...");
		short rand = basicDataGenerator.generateShort();
		System.out.println("success : "+rand);
	}

	@Test
	public void generateByte() {
		System.out.println("Generating byte ...");
		byte rand = basicDataGenerator.generateByte();
		System.out.println("success : " + rand);
	}

	@Test
	public void generateIntegerWithSize() {
		System.out.println("Generating integer with size ...");
		int rand = basicDataGenerator.generateInteger(5);
		if (rand != -1) {
			System.out.println("success : " + rand);
			int counter = 1;
			while (rand / 10 != 0) {
				rand /= 10;
				counter ++;
			}
			Assert.assertTrue(counter == 5);
		}
		else
			System.out.println("Failed to generate ");
	}

	@Test
	public void generateInteger() {
		System.out.println("Generating integer ...");
		int rand = basicDataGenerator.generateInteger();
		System.out.println("success : "+rand);
	}

	@Test
	public void generateDouble() {
		System.out.println("Generating double ...");
		double rand = basicDataGenerator.generateDouble();
		System.out.println("success : "+rand);
	}

	@Test
	public void generateFloat() {
		System.out.println("Generating float ...");
		float rand = basicDataGenerator.generateFloat();
		System.out.println("success : "+rand);
	}

	@Test
	public void generateLong() {
		System.out.println("Generating long ...");
		long rand = basicDataGenerator.generateLong();
		System.out.println("success : "+rand);
	}

	@Test
	public void generateBoolean() {
		System.out.println("Generating boolean ...");
		boolean rand = basicDataGenerator.generateBoolean();
		System.out.println("success : '"+rand+"'");
	}

	@Test
	public void generateStringWithSize() {
		System.out.println("Generating String with size ...");
		final int size = Math.abs(basicDataGenerator.generateInteger(3));
		String rand = basicDataGenerator.generateString(DataGeneratorEnums.StringType.LOWER_OR_UPPER,size);
		Assert.assertNotNull(rand);
		Assert.assertTrue(rand.length() == size);
	}

	@Test
	public void generateString() {
		System.out.println("Generating string ...");
		String rand = basicDataGenerator.generateString(DataGeneratorEnums.StringType.LOWER_OR_UPPER);
		Assert.assertNotNull(rand);
	}

	@Test
	public void generateUpperCaseStringWithSize() {
		System.out.println("Generating UpperCase String with size ...");
		final int size = Math.abs(basicDataGenerator.generateInteger(3));
		String rand = basicDataGenerator.generateStringNoSpecialChars(DataGeneratorEnums.StringType.UPPER_CASE,size);
		Assert.assertNotNull(rand);
		Assert.assertEquals("Assert UpperCase",rand.toUpperCase(),rand);
		Assert.assertTrue(rand.length() == size);
		boolean isOk = true;
		for (int i=0;i<rand.length();i++) {
			final char ch = rand.charAt(i);
			if ((int)ch < DataGeneratorConsts.ASCII_UPPERCASE_INDEX_START || (int)ch > DataGeneratorConsts.ASCII_LOWERCASE_INDEX_END
					||  ((int)ch < DataGeneratorConsts.ASCII_UPPERCASE_INDEX_END && (int)ch > DataGeneratorConsts.ASCII_LOWERCASE_INDEX_START)) {
				isOk = false;
			}
		}
		Assert.assertTrue(isOk);

	}

	@Test
	public void generateUpperCaseString() {
		System.out.println("Generating UpperCase string ...");
		String rand = basicDataGenerator.generateStringNoSpecialChars(DataGeneratorEnums.StringType.UPPER_CASE);
		Assert.assertNotNull(rand);
		Assert.assertEquals("Assert Upper Case",rand.toUpperCase(),rand);
		boolean isOk = true;
		for (int i=0;i<rand.length();i++) {
			final char ch = rand.charAt(i);
			if ((int)ch < DataGeneratorConsts.ASCII_UPPERCASE_INDEX_START || (int)ch > DataGeneratorConsts.ASCII_LOWERCASE_INDEX_END
					||  ((int)ch < DataGeneratorConsts.ASCII_UPPERCASE_INDEX_END && (int)ch > DataGeneratorConsts.ASCII_LOWERCASE_INDEX_START)) {
				isOk = false;
			}
		}
		Assert.assertTrue(isOk);
	}

	@Test
	public void generateLowerCaseStringWithSize() {
		System.out.println("Generating LowerCase String with size ...");
		final int size = Math.abs(basicDataGenerator.generateInteger(3));
		String rand = basicDataGenerator.generateStringNoSpecialChars(DataGeneratorEnums.StringType.LOWER_CASE,size);
		Assert.assertNotNull(rand);
		Assert.assertEquals("Assert Lower Case",rand.toLowerCase(),rand);
		Assert.assertTrue(rand.length() == size);
		boolean isOk = true;
		for (int i=0;i<rand.length();i++) {
			final char ch = rand.charAt(i);
			if ((int)ch < DataGeneratorConsts.ASCII_UPPERCASE_INDEX_START || (int)ch > DataGeneratorConsts.ASCII_LOWERCASE_INDEX_END
					||  ((int)ch < DataGeneratorConsts.ASCII_UPPERCASE_INDEX_END && (int)ch > DataGeneratorConsts.ASCII_LOWERCASE_INDEX_START)) {
				isOk = false;
			}
		}
		Assert.assertTrue(isOk);
	}

	@Test
	public void generateLowerCaseString() {
		System.out.println("Generating LowerCase string ...");
		String rand = basicDataGenerator.generateStringNoSpecialChars(DataGeneratorEnums.StringType.LOWER_CASE);
		Assert.assertNotNull(rand);
		Assert.assertEquals("Assert Lower Case",rand.toLowerCase(),rand);
		boolean isOk = true;
		for (int i=0;i<rand.length();i++) {
			final char ch = rand.charAt(i);
			if ((int)ch < DataGeneratorConsts.ASCII_UPPERCASE_INDEX_START || (int)ch > DataGeneratorConsts.ASCII_LOWERCASE_INDEX_END
					||  ((int)ch < DataGeneratorConsts.ASCII_UPPERCASE_INDEX_END && (int)ch > DataGeneratorConsts.ASCII_LOWERCASE_INDEX_START)) {
				isOk = false;
			}
		}
		Assert.assertTrue(isOk);
	}

	@Test
	public void generateLowerCaseChar() {
		System.out.println("Generating LowerCase char ...");
		final char rand = basicDataGenerator.generateLowerCaseChar();
		Assert.assertTrue(((int)rand >= DataGeneratorConsts.ASCII_LOWERCASE_INDEX_START && (int)rand <= DataGeneratorConsts.ASCII_LOWERCASE_INDEX_END));
	}

	@Test
	public void generateUpperCaseChar() {
		System.out.println("Generating UpperCase char ...");
		final char rand = basicDataGenerator.generateUpperCaseChar();
		Assert.assertTrue(((int)rand >= DataGeneratorConsts.ASCII_UPPERCASE_INDEX_START && (int)rand <= DataGeneratorConsts.ASCII_UPPERCASE_INDEX_END));
	}

	@Test
	public void generateCharEnglishChar() {
		System.out.println("Generating English char ...");
		final char rand = basicDataGenerator.generateCharEnglishChar();
		Assert.assertTrue((((int)rand >= DataGeneratorConsts.ASCII_LOWERCASE_INDEX_START && (int)rand <= DataGeneratorConsts.ASCII_LOWERCASE_INDEX_END)
				|| ((int)rand >= DataGeneratorConsts.ASCII_UPPERCASE_INDEX_START && (int)rand <= DataGeneratorConsts.ASCII_UPPERCASE_INDEX_END)));
	}

	@Test
	public void generateChar() {
		Assert.assertNotNull(basicDataGenerator.generateLowerCaseChar());
	}
}
