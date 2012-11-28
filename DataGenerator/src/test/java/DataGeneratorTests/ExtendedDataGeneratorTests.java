package DataGeneratorTests;

import DataGenerator.ExtendedDataGenerator;
import Interfaces.ExtendedDataGeneratorInterface;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
* Created with IntelliJ IDEA.
* User: talbe
* Date: 11/09/12
* Time: 13:44
* To change this template use File | Settings | File Templates.
*/
public class ExtendedDataGeneratorTests {

	private ExtendedDataGeneratorInterface extendedDataGenerator;

	@Before
	public void setUp() throws Exception {
		extendedDataGenerator = ExtendedDataGenerator.getInstance(0);
	}

	@Test
	public void generateEmail() {
		System.out.println("Generating email ...");
		final String rand = extendedDataGenerator.generateEmail();
		Assert.assertTrue(rand.contains("@"));
		Assert.assertTrue(rand.contains("."));
		Assert.assertTrue(rand.length() == 16);
	}

	@Test
	public void generateLocalPhoneWithHyphen() {
		System.out.println("Generating local phone number with hyphen ...");
		final String rand = extendedDataGenerator.generateLocalPhoneNumber(true);
		Assert.assertTrue(rand.contains("-"));
		Assert.assertTrue(rand.length() == 10);
	}

	@Test
	public void generateLocalPhone() {
		System.out.println("Generating local phone number ...");
		final String rand = extendedDataGenerator.generateLocalPhoneNumber(false);
		Assert.assertTrue(!rand.contains("-"));
		Assert.assertTrue(rand.length() == 9);
	}

	@Test
	public void generateMobilePhoneWithHyphen() {
		System.out.println("Generating mobile phone number with hyphen ...");
		final String rand = extendedDataGenerator.generateMobilePhoneNumber(true);
		Assert.assertTrue(rand.contains("-"));
		Assert.assertTrue(rand.length() == 11);
	}

	@Test
	public void generateMobilePhone() {
		System.out.println("Generating mobile phone number ...");
		final String rand = extendedDataGenerator.generateMobilePhoneNumber(false);
		Assert.assertTrue(!rand.contains("-"));
		Assert.assertTrue(rand.length() == 10);
	}

	@Test
	public void generateAbroadPhoneWithHyphen() {
		System.out.println("Generating abroad phone number with hyphen ...");
		final String rand = extendedDataGenerator.generateAbroadPhoneNumber(true);
		Assert.assertTrue(rand.contains("-"));
		Assert.assertTrue(rand.contains("+"));
		Assert.assertTrue(rand.length() == 13);
	}

	@Test
	public void generateAbroadPhone() {
		System.out.println("Generating abroad phone number ...");
		final String rand = extendedDataGenerator.generateAbroadPhoneNumber(false);
		Assert.assertTrue(!rand.contains("-"));
		Assert.assertTrue(rand.contains("+"));
		Assert.assertTrue(rand.length() == 12);
	}
}
