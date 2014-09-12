package com.morcinek.android.codegenerator.extractor;

import com.morcinek.android.codegenerator.extractor.string.ResourceIdExtractor;
import com.morcinek.android.codegenerator.extractor.string.ResourceTypeExtractor;
import com.morcinek.android.codegenerator.extractor.string.StringExtractor;
import com.morcinek.android.codegenerator.extractor.model.Resource;
import com.morcinek.android.codegenerator.extractor.model.ResourceId;
import com.morcinek.android.codegenerator.extractor.model.ResourceType;
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
public class XMLResourceExtractor implements ResourceExtractor {

    private StringExtractor<ResourceId> resourceIdExtractor;

    private StringExtractor<ResourceType> resourceTypeExtractor;

    public static XMLResourceExtractor createResourceExtractor() {
        return new XMLResourceExtractor(new ResourceIdExtractor(), new ResourceTypeExtractor());
    }

    protected XMLResourceExtractor(StringExtractor<ResourceId> resourceIdExtractor, StringExtractor<ResourceType> resourceTypeExtractor) {
        this.resourceIdExtractor = resourceIdExtractor;
        this.resourceTypeExtractor = resourceTypeExtractor;
    }

    @Override
    public List<Resource> extractResourceObjectsFromStream(InputStream inputStream) throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
        List<Resource> resources = new ArrayList<Resource>();
        NodeList nodeList = extractWidgetNodesWithId(inputStream);
        for (int i = 0; i < nodeList.getLength(); i++) {
            resources.add(getResourceObject(nodeList.item(i)));
        }
        return resources;
    }

    private Resource getResourceObject(Node node) {
        ResourceId resourceId = resourceIdExtractor.extractFromString(getIdAttributeValue(node));
        ResourceType resourceType = resourceTypeExtractor.extractFromString(node.getNodeName());
        return new Resource(resourceId, resourceType);
    }

    private String getIdAttributeValue(Node node) {
        return node.getAttributes().getNamedItem("android:id").getNodeValue();
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
