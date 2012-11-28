package Interfaces;

/**
 * Created with IntelliJ IDEA.
 * User: talbe
 * Date: 11/09/12
 * Time: 08:37
 * To change this template use File | Settings | File Templates.
 *
 * this interface supports different extended data generation for strings like email and phone number
 */
public interface ExtendedDataGeneratorInterface extends BasicDataGeneratorInterface{
	//extended
	public String generateEmail();
	public String generateLocalPhoneNumber(boolean withHyphen);
	public String generateMobilePhoneNumber(boolean withHyphen);
	public String generateAbroadPhoneNumber(boolean withHyphen);
}
