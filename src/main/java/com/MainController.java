package com;

import com.adapter.WordChainInputAdapter;
import com.adapter.WordChainOutputAdapter;
import com.exception.WordChainException;
import com.handler.FileReaderHandler;
import com.service.WordChainService;
import com.service.impl.WordChainServiceImpl;

public class MainController {
    public static void main(String[] args) throws WordChainException {
        String wordListPath = args[0];
        String fileRelationPath = args[1];

        WordChainInputAdapter wordChainInputAdapter = new WordChainInputAdapter();
        FileReaderHandler fileReaderHandler = new FileReaderHandler();
        wordChainInputAdapter.insertData(fileReaderHandler.read(wordListPath));

        WordChainService wordChainService = new WordChainServiceImpl();
        WordChainOutputAdapter wordChainOutputAdapter = new WordChainOutputAdapter(wordChainService);
        wordChainOutputAdapter.processWordRelation(fileReaderHandler.read(fileRelationPath));
    }
}
