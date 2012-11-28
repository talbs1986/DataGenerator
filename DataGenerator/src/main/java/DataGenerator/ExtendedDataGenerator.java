package DataGenerator;

import DataModel.DataGeneratorEnums;
import Interfaces.BasicDataGeneratorInterface;
import Interfaces.ExtendedDataGeneratorInterface;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: talbe
 * Date: 11/09/12
 * Time: 08:53
 * To change this template use File | Settings | File Templates.
 */
public class ExtendedDataGenerator extends BasicDataGenerator implements ExtendedDataGeneratorInterface {

	protected static volatile ExtendedDataGeneratorInterface extendedInstance;

	private ExtendedDataGenerator(int seed) {
		super.setSeed(seed);
		random = new Random(seed);
	}

	public static ExtendedDataGeneratorInterface getInstance(int seed) {
		if (extendedInstance == null) {
			extendedInstance = new ExtendedDataGenerator(seed);
		}
		else {
			extendedInstance.setSeed(seed);
		}
		return extendedInstance;
	}

	@Override
	public String generateEmail() {
		final String suffix = baseInstance.generateStringNoSpecialChars(DataGeneratorEnums.StringType.LOWER_OR_UPPER, 3);
		final String account = baseInstance.generateStringNoSpecialChars(DataGeneratorEnums.StringType.LOWER_OR_UPPER, 5);
		final String domain = baseInstance.generateStringNoSpecialChars(DataGeneratorEnums.StringType.LOWER_OR_UPPER, 6);
		return account+"@"+domain+"."+suffix;
	}

	@Override
	public String generateLocalPhoneNumber(boolean withHyphen) {
		final String area = "0"+String.valueOf(baseInstance.generateInteger(1));
		final String phone = String.valueOf(baseInstance.generateInteger(7));
		if (withHyphen)
			return area+"-"+phone ;
		else
			return area+phone;
	}

	@Override
	public String generateMobilePhoneNumber(boolean withHyphen) {
		final String cellularPrefix = "0"+String.valueOf(baseInstance.generateInteger(2));
		final String phone = String.valueOf(baseInstance.generateInteger(7));
		if (withHyphen)
			return cellularPrefix+"-"+phone ;
		else
			return cellularPrefix+phone;
	}

	@Override
	public String generateAbroadPhoneNumber(boolean withHyphen) {
		final String countryPrefix = "+"+String.valueOf(baseInstance.generateInteger(3));
		final String area = String.valueOf(baseInstance.generateInteger(1));
		final String phone = String.valueOf(baseInstance.generateInteger(7));
		if (withHyphen)
			return countryPrefix+"-"+area+phone ;
		else
			return countryPrefix+area+phone;
	}
}
