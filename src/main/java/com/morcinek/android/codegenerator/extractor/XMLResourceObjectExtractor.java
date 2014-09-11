package com.morcinek.android.codegenerator.extractor;

import com.morcinek.android.codegenerator.model.ResourceObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class XMLResourceObjectExtractor implements ResourceObjectExtractor {

    @Override
    public List<ResourceObject> extractResourceObjectsFromStream(InputStream inputStream) throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
        List<ResourceObject> resourceObjects = new ArrayList<ResourceObject>();
        NodeList nodeList = extractWidgetNodesWithId(inputStream);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            resourceObjects.add(new ResourceObject(getAttributeValue(node, "android:id"), node.getNodeName()));
        }
        return resourceObjects;
    }

    private String getAttributeValue(Node node, String attributeName) {
        return node.getAttributes().getNamedItem(attributeName).getNodeValue();
    }

    private NodeList extractWidgetNodesWithId(InputStream inputStream) throws ParserConfigurationException, SAXException,
            IOException, XPathExpressionException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // factory.setNamespaceAware(true); // never forget this!
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(inputStream);
        XPathFactory pathFactory = XPathFactory.newInstance();
        XPath xPath = pathFactory.newXPath();
        XPathExpression expression = xPath.compile("//*[@id]");
        return (NodeList) expression.evaluate(doc, XPathConstants.NODESET);
    }
}
