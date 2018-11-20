package handler;

import com.exception.WordChainException;
import com.handler.FileReaderHandler;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileReaderHandlerTest {

    @Test
    public void readFileTestshouldReadTheFileData() throws WordChainException {
        FileReaderHandler fileReaderHandler = new FileReaderHandler();
        List<String> actualData = fileReaderHandler.read("src/test/resources/sampleInputFile.txt");
        List<String> expectedData = new ArrayList<String>() {{add("ASD"); add("QWE"); add("123");}};
        assertEquals(3, actualData.size());
        assertEquals(expectedData, actualData);
    }

    @Test(expected = WordChainException.class)
    public void readFileTestShouldThrowErrorIfFileNotPresent() throws WordChainException {
        FileReaderHandler fileReaderHandler = new FileReaderHandler();
        fileReaderHandler.read("src/test/resources/fileNotPresent.txt");
    }
}
