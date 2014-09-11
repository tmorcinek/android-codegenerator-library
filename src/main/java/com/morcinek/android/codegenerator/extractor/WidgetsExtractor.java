package com.morcinek.android.codegenerator.extractor;

import com.morcinek.android.codegenerator.model.Widget;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public interface WidgetsExtractor {

    List<Widget> extractWidgetsFromStream(InputStream inputStream) throws XPathExpressionException,
            ParserConfigurationException, SAXException, IOException;
}
