package Interfaces;

/**
 * Created with IntelliJ IDEA.
 * User: talbe
 * Date: 11/09/12
 * Time: 08:37
 * To change this template use File | Settings | File Templates.
 *
 * this interface supports generation of objects and fill it with data
 */
public interface ObjectDataGeneratorInterface {
   	//object
//	public <T> T generateObjectFromJson(String jsonObject, String outputClassString);
//	public <T> T generateObjectFromJson(String jsonObject, Class<T> outputClassObject);
//	public <T> T generateObjectFromXML(String xmlObject, Class<T> outputClassObject);
//	public <T> T generateObjectFromXML(String xmlObject, String outputClassString);
	public <T> T generateObject(Class tClass);
}
