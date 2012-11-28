package DataGenerator;

import DataModel.DataGeneratorEnums;
import Interfaces.ExtendedDataGeneratorInterface;
import Interfaces.ObjectDataGeneratorInterface;
import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: talbe
 * Date: 11/09/12
 * Time: 08:54
 * To change this template use File | Settings | File Templates.
 */
public class ObjectsDataGenerator implements ObjectDataGeneratorInterface {

	private static ExtendedDataGeneratorInterface extendedInstance;
	private static volatile ObjectDataGeneratorInterface objectInstance;
	private static Gson gson;


	private ObjectsDataGenerator(int seed) {
		extendedInstance = ExtendedDataGenerator.getInstance(seed);
		gson = new Gson();
	}

	public static ObjectDataGeneratorInterface getInstance(int seed) {
		if (objectInstance == null) {
			objectInstance = new ObjectsDataGenerator(seed);
		}
		else {
			extendedInstance = ExtendedDataGenerator.getInstance(seed);
		}
		return objectInstance;
	}

//	@Override
//	public <T> T generateObjectFromJson(String jsonObject, String outputClassString) {
//		T result = null;
//		try {
//			Class<T> clazz = (Class<T>)Class.forName(outputClassString);
//			if (clazz != null)
//				return generateObjectFromJson(jsonObject,clazz);
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
//
//	@Override
//	public <T> T generateObjectFromJson(String jsonObject, Class<T> outputClassObject) {
//		T result = null;
//		try {
//			result = gson.fromJson(jsonObject,outputClassObject);
//			result = generateObject(result.getClass());
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return result;  //To change body of implemented methods use File | Settings | File Templates.
//	}
//
//	@Override
//	public <T> T generateObjectFromXML(String xmlObject, String outputClassString) {
////		XMLSerializer xmlSerializer = new XMLSerializer();
////		JSON json = xmlSerializer.read(xmlObject);
//		//OR
////		JSONObject xmlJSONObj = XML.toJSONObject(TEST_XML_STRING);
////		String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
//		return null;  //To change body of implemented methods use File | Settings | File Templates.
//	}
//
//	@Override
//	public <T> T generateObjectFromXML(String xmlObject, Class<T> outputClassObject) {
//		return null;  //To change body of implemented methods use File | Settings | File Templates.
//	}

	@Override
	public <T> T generateObject(final Class tClass) {
		T result = null;
		try {
			result = (T)tClass.getConstructor(new Class<?>[]{}).newInstance();
			final Field[] tFields = tClass.getDeclaredFields();
			for (Field field : tFields) {
				final Class fieldType = field.getType();
				final Object fieldValue;
				field.setAccessible(true);
				if (fieldType.isPrimitive() || fieldType.equals(String.class)) {
					fieldValue = getPrimitiveValue(fieldType);
				}
				else if (fieldType.isArray()) {
					final int arrayLength = extendedInstance.generateInteger(1);
					Class concreteArrayFieldType = fieldType.getComponentType();
					if (concreteArrayFieldType.isPrimitive()) {
						fieldValue = getPrimitiveArrayValues(concreteArrayFieldType);
					}
					else {
						Object[] arrField = (Object[])Array.newInstance(concreteArrayFieldType,arrayLength);
						for (int i=0;i<arrField.length;i++)
							arrField[i] = generateObject(concreteArrayFieldType);
						fieldValue = arrField;
					}
				}
				else
					fieldValue = generateObject(fieldType);
				field.set(result,fieldValue);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	private Object getPrimitiveValue(Class fieldType) {
		Object result = null;
		if (fieldType.equals(int.class)) {
			result = extendedInstance.generateInteger();
		}
		else if (fieldType.equals(short.class)) {
			result = extendedInstance.generateShort();
		}
		else if (fieldType.equals(long.class)) {
			result = extendedInstance.generateLong();
		}
		else if (fieldType.equals(double.class)) {
			result = extendedInstance.generateDouble();
		}
		else if (fieldType.equals(float.class)) {
			result = extendedInstance.generateFloat();
		}
		else if (fieldType.equals(String.class)) {
			final int strSize = extendedInstance.generateInteger(2);
			result = extendedInstance.generateStringNoSpecialChars(DataGeneratorEnums.StringType.LOWER_OR_UPPER, strSize);
		}
		else if (fieldType.equals(char.class)) {
			result = extendedInstance.generateChar();
		}
		else if (fieldType.equals(byte.class)) {
			result = extendedInstance.generateByte();
		}
		else if (fieldType.equals(boolean.class)) {
			result = extendedInstance.generateBoolean();
		}
		return result;
	}

	private Object getPrimitiveArrayValues(Class arrayFieldType) {
		Object result = null;
		final int arrayLength = extendedInstance.generateInteger(1);
		if (arrayFieldType.equals(int.class)) {
			result = Array.newInstance(int.class,arrayLength);
			for (int i=0;i<arrayLength;i++)
				((int[])result)[i] = extendedInstance.generateInteger();
		}
		else if (arrayFieldType.equals(short.class)) {
			result = Array.newInstance(short.class, arrayLength);
			for (int i=0;i<arrayLength;i++)
				((short[])result)[i] = extendedInstance.generateShort();
		}
		else if (arrayFieldType.equals(long.class)) {
			result = Array.newInstance(long.class,arrayLength);
			for (int i=0;i<arrayLength;i++)
				((long[])result)[i] = extendedInstance.generateLong();
		}
		else if (arrayFieldType.equals(double.class)) {
			result = Array.newInstance(double.class, arrayLength);
			for (int i=0;i<arrayLength;i++)
				((double[])result)[i] = extendedInstance.generateDouble();
		}
		else if (arrayFieldType.equals(float.class)) {
			result = Array.newInstance(float.class, arrayLength);
			for (int i=0;i<arrayLength;i++)
				((float[])result)[i] = extendedInstance.generateFloat();
		}
		else if (arrayFieldType.equals(String.class)) {
			result = Array.newInstance(String.class, arrayLength);
			for (int i=0;i<arrayLength;i++) {
				final int strSize = extendedInstance.generateInteger(2);
				((String[])result)[i] = extendedInstance.generateStringNoSpecialChars(DataGeneratorEnums.StringType.LOWER_OR_UPPER,strSize);
			}
		}
		else if (arrayFieldType.equals(char.class)) {
			result = Array.newInstance(char.class, arrayLength);
			for (int i=0;i<arrayLength;i++)
				((char[])result)[i] = extendedInstance.generateChar();
		}
		else if (arrayFieldType.equals(byte.class)) {
			result = Array.newInstance(byte.class, arrayLength);
			for (int i=0;i<arrayLength;i++)
				((byte[])result)[i] = extendedInstance.generateByte();
		}
		else if (arrayFieldType.equals(boolean.class)) {
			result = Array.newInstance(boolean.class, arrayLength);
			for (int i=0;i<arrayLength;i++)
				((boolean[])result)[i] = extendedInstance.generateBoolean();
		}
		return result;
	}

}
