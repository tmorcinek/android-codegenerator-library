package com.morcinek.android.codegenerator.extractor;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class XMLPackageExtractor implements PackageExtractor {

    @Override
    public String extractPackageFromManifestStream(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(inputStream);
        Element manifest = (Element) doc.getElementsByTagName("manifest").item(0);
        return manifest.getAttribute("package");
    }
}
