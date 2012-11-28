package Interfaces;

import DataModel.DataGeneratorEnums;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: talbe
 * Date: 11/09/12
 * Time: 08:37
 * To change this template use File | Settings | File Templates.
 *
 * this interface supports different basic data generation for strings and numbers
 */
public interface BasicDataGeneratorInterface {
	public int generateInteger();
	public int generateInteger(int size);
	public short generateShort();
	public long generateLong();
	public double generateDouble();
	public float generateFloat();
	public boolean generateBoolean();
	public char generateLowerCaseChar();
	public char generateUpperCaseChar();
	public char generateCharEnglishChar();
	public char generateChar();
	public byte generateByte();
	public String generateString(DataGeneratorEnums.StringType stringType);
	public String generateString(DataGeneratorEnums.StringType stringType,int size);
	public String generateStringNoSpecialChars(DataGeneratorEnums.StringType stringType);
	public String generateStringNoSpecialChars(DataGeneratorEnums.StringType stringType,int size);
	public void setSeed(int seed);
}
