package DataGeneratorTests;

import DataGenerator.ObjectsDataGenerator;
import Interfaces.ObjectDataGeneratorInterface;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: talbe
 * Date: 27/11/12
 * Time: 18:43
 * To change this template use File | Settings | File Templates.
 */
public class ObjectDataGeneratorTests {

	private ObjectDataGeneratorInterface objectDataGeneratorInterface;

	public static class Mockb {
		private int num2;
		private String str2;

		@Override
		public String toString() {
			return num2+","+str2;
		}
	}

	public static class Mock {
		private int num;
		private String str;
		private long[] numArr;
		private Mockb[] mocks;

		@Override
		public String toString() {
			return String.valueOf(num)+","+str+","+numArrToString()+","+mocksToString();
		}

		public String mocksToString() {
			StringBuilder sb = new StringBuilder();
			for (int i=0;i<mocks.length;i++) {
				sb.append(mocks[i].toString()+",");
			}
			return sb.toString();
		}

		public String numArrToString() {
			StringBuilder sb = new StringBuilder();
			for (int i=0;i<numArr.length;i++) {
				sb.append(numArr[i]+",");
			}
			return sb.toString();
		}
	}

	@Before
	public void setUp() {
		objectDataGeneratorInterface = ObjectsDataGenerator.getInstance(0);
	}

	@Test
	public void testObjectCreation() {
		Mock mock = objectDataGeneratorInterface.generateObject(Mock.class);
		Assert.assertNotNull(mock);
	}

}
