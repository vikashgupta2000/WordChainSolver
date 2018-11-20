package singleton;

import com.singleton.WordListSingleton;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class WordListSingletonTest {

    /**
     * This method is required to reset the instance of Singleton class before every test call
     * @throws SecurityException
     * @throws NoSuchFieldException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    @Before
    public void resetSingleton() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field instance = WordListSingleton.class.getDeclaredField("wordListSingleton");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    @Test
    public void shouldCreateOnlyOneInstanceIfCalledMultipleTimes() {
        WordListSingleton wordListSingleton1 = WordListSingleton.getInstance();
        WordListSingleton wordListSingleton2 = WordListSingleton.getInstance();
        assertEquals(wordListSingleton1, wordListSingleton2);
    }

    @Test
    public void shouldGroupDataByCharacterCountInAGroup() {
        WordListSingleton wordListSingleton = WordListSingleton.getInstance();
        wordListSingleton.addWord("ASD");
        wordListSingleton.addWord("QWE");
        wordListSingleton.addWord("123");
        wordListSingleton.addWord("abcd");

        Set<String> expectedDataWithThreeCharacter = new HashSet<String>() {{add("ASD"); add("QWE"); add("123");}};
        Set<String> actualDataWithThreeCharacter = wordListSingleton.getWordOfLength(3);

        Set<String> expectedDataWithFourCharacter = new HashSet<String>() {{add("abcd");}};
        Set<String> actualDataWithFourCharacter = wordListSingleton.getWordOfLength(4);

        assertEquals(3, actualDataWithThreeCharacter.size());
        assertEquals(expectedDataWithThreeCharacter, actualDataWithThreeCharacter);

        assertEquals(1, actualDataWithFourCharacter.size());
        assertEquals(expectedDataWithFourCharacter, actualDataWithFourCharacter);
    }

    @Test
    public void shouldCreateWordOnlyOnceEvenIfCalledMultipleTimes() {
        WordListSingleton wordListSingleton = WordListSingleton.getInstance();
        wordListSingleton.addWord("ASD");
        wordListSingleton.addWord("ASD");
        wordListSingleton.addWord("ASD");

        Set<String> expectedData = new HashSet<String>() {{add("ASD");}};
        Set<String> actualData = wordListSingleton.getWordOfLength(3);

        assertEquals(1, actualData.size());
        assertEquals(expectedData, actualData);
    }
}
