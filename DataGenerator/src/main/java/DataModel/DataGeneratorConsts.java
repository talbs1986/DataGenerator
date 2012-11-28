package DataModel;

/**
 * Created with IntelliJ IDEA.
 * User: talbe
 * Date: 11/09/12
 * Time: 18:08
 * To change this template use File | Settings | File Templates.
 *
 * this class is used for grouping all the consts used in the code
 */
public abstract class DataGeneratorConsts {
	public final static int ASCII_UPPERCASE_INDEX_START = 65;
	public final static int ASCII_UPPERCASE_INDEX_END = 90;
	public final static int ASCII_LOWERCASE_INDEX_START = 97;
	public final static int ASCII_LOWERCASE_INDEX_END = 122;
	public final static int ASCII_UPPER_LOWER_CASE_DIFFERENCE = ASCII_LOWERCASE_INDEX_START - ASCII_UPPERCASE_INDEX_END;
	public final static int ASCII_ENGLISH_LETTERS_AMOUNT = ASCII_LOWERCASE_INDEX_END-ASCII_LOWERCASE_INDEX_START;
}
