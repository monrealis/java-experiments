package eu.vytenis.patterns.decorator;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.List;

public class XmlSerializerRemovingPrefixes extends XmlSerializerDecorator {
    public XmlSerializerRemovingPrefixes(XmlSerializer serializer) {
        super(serializer);
    }

    @Override
    public String serialize(Document document) {
        return super.serialize(prepareCopy(document));
    }

    private Document prepareCopy(Document document) {
        Document d = clone(document);
        removePrefixesRecursively(d);
        removeXmlnsAttributesRecursively(d);
        return d;
    }

    private void removePrefixesRecursively(Node node) {
        removePrefixIfElement(node);
        getChildNodes(node).stream().forEach(this::removePrefixesRecursively);
    }

    private List<Node> getChildNodes(Node node) {
        List<Node> r = new ArrayList<>();
        for (int i = 0; i < node.getChildNodes().getLength(); ++i)
            r.add(node.getChildNodes().item(i));
        return r;
    }

    private <T extends Node> void removePrefixIfElement(T node) {
        if (node.getNodeType() == Node.ELEMENT_NODE)
            node.setPrefix("");
    }

    private void removeXmlnsAttributesRecursively(Node node) {
        removeXmlAttributesIfElement(node);
        getChildNodes(node).stream().forEach(this::removeXmlnsAttributesRecursively);
    }

    private void removeXmlAttributesIfElement(Node node) {
        if (node.getNodeType() != Node.ELEMENT_NODE)
            return;
        removeXmlnsAttributes((Element) node);
    }

    private void removeXmlnsAttributes(Element element) {
        getAttributes(element).stream().filter(this::isXmlnsAttribute).forEach(element::removeAttributeNode);
    }

    private boolean isXmlnsAttribute(Attr attr) {
        return attr.getName().startsWith("xmlns:");
    }

    private List<Attr> getAttributes(Element element) {
        return getAttributes(element.getAttributes());
    }

    private List<Attr> getAttributes(NamedNodeMap attrs) {
        List<Attr> r = new ArrayList<>();
        for (int i = 0; i < attrs.getLength(); ++i)
            r.add((Attr) attrs.item(i));
        return r;
    }

    private Document clone(Document document) {
        Document d = createDocument();
        Node el = d.importNode(document.getDocumentElement(), true);
        d.appendChild(el);
        return d;
    }

    private Document createDocument() {
        try {
            return tryCreateDocument();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    private Document tryCreateDocument() throws ParserConfigurationException {
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        f.setNamespaceAware(true);
        return f.newDocumentBuilder().newDocument();
    }
}
