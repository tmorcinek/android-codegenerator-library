package com.morcinek.android.codegenerator.extractor;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public interface PackageExtractor {

    public String extractPackageFromManifestStream(InputStream inputStream) throws XPathExpressionException,
            ParserConfigurationException, SAXException, IOException;
}
