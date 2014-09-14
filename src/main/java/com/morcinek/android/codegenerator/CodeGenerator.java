package com.morcinek.android.codegenerator;

import com.morcinek.android.codegenerator.extractor.ResourceExtractor;
import com.morcinek.android.codegenerator.extractor.model.Resource;
import com.morcinek.android.codegenerator.extractor.string.FileNameExtractor;
import com.morcinek.android.codegenerator.writer.CodeWriter;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class CodeGenerator {

    private ResourceExtractor resourceExtractor;
    private FileNameExtractor fileNameExtractor;

    private CodeWriter codeWriter;

    public CodeGenerator(ResourceExtractor resourceExtractor, FileNameExtractor fileNameExtractor, CodeWriter codeWriter) {
        this.resourceExtractor = resourceExtractor;
        this.fileNameExtractor = fileNameExtractor;
        this.codeWriter = codeWriter;
    }

    public String produceCode(InputStream inputStream, String filePath) throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
        List<Resource> resources = resourceExtractor.extractResourceObjectsFromStream(inputStream);
        String filename = fileNameExtractor.extractFromString(filePath);
        return codeWriter.produceJavaCode(resources, filename);
    }
}
