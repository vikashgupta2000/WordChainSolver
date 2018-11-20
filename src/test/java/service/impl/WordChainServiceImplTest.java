package service.impl;

import com.service.WordChainService;
import com.service.impl.WordChainServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

public class WordChainServiceImplTest {

    @Test
    public void shouldReturnNullIfNoRelationFound() {
        WordChainService wordChainService = new WordChainServiceImpl();
        Set<String> inputData = new HashSet<String>(){{add("CAT"); add("COT"); add("COG");}};

        List<String> output = wordChainService.evaluate("CAT", "DOG" , inputData);
        assertNull(output);
    }

    @Test
    public void shouldReturnListIfRelationFound() {
        WordChainService wordChainService = new WordChainServiceImpl();
        Set<String> inputData = new HashSet<String>(){{add("CAT"); add("COT"); add("COG"); add("DOG");}};
        List<String> expectedOutput = new ArrayList<String>(){{add("CAT"); add("COT"); add("COG"); add("DOG");}};
        List<String> actualOutput = wordChainService.evaluate("CAT", "DOG" , inputData);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void shouldReturnListWithMinimumRelationsIfRelationFound() {
        WordChainService wordChainService = new WordChainServiceImpl();
        Set<String> inputData = new HashSet<String>(){{
            add("CAT"); add("POT");
            add("COT"); add("MOG");
            add("COG"); add("FOG");
            add("JOG"); add("TOG");
            add("HOG"); add("NOG");
            add("DOG");}};
        List<String> expectedOutput = new ArrayList<String>(){{add("CAT"); add("COT"); add("COG"); add("DOG");}};
        List<String> actualOutput = wordChainService.evaluate("CAT", "DOG" , inputData);

        assertEquals(expectedOutput, actualOutput);
    }
}
