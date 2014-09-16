package com.morcinek.android.codegenerator;

import com.morcinek.android.codegenerator.extractor.ResourceExtractor;
import com.morcinek.android.codegenerator.extractor.model.Resource;
import com.morcinek.android.codegenerator.extractor.string.FileNameExtractor;
import com.morcinek.android.codegenerator.codegeneration.TemplateCodeGenerator;
import com.morcinek.android.codegenerator.codegeneration.builders.file.ClassNameBuilder;
import com.morcinek.android.codegenerator.codegeneration.builders.file.PackageBuilder;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class CodeGenerator {

    private ResourceExtractor resourceExtractor;
    private FileNameExtractor fileNameExtractor;

    private TemplateCodeGenerator templateCodeGenerator;

    public CodeGenerator(ResourceExtractor resourceExtractor, FileNameExtractor fileNameExtractor, TemplateCodeGenerator templateCodeGenerator) {
        this.resourceExtractor = resourceExtractor;
        this.fileNameExtractor = fileNameExtractor;
        this.templateCodeGenerator = templateCodeGenerator;
    }

    public String produceCode(InputStream inputStream, String filePath) throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
        List<Resource> resources = resourceExtractor.extractResourceObjectsFromStream(inputStream);
        String filename = fileNameExtractor.extractFromString(filePath);
        return templateCodeGenerator.generateCode(resources, filename);
    }

    public String appendPackage(String packageName, String generateCode) {
        if (!packageName.isEmpty()) {
            return new PackageBuilder(packageName).builtString() + generateCode;
        }
        return generateCode;
    }

    public String getJavaFileName(String filePath) {
        String fileName = fileNameExtractor.extractFromString(filePath);
        return new ClassNameBuilder(fileName).builtString().concat(".java");
    }

    public InputStream getInputStreamFromString(String code) {
        return new ByteArrayInputStream(code.getBytes());
    }
}
