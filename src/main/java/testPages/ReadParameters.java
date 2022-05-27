package testPages;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;

public class ReadParameters {

    static Document document;

    public ReadParameters() throws Exception {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        document = documentBuilder.parse(ReadParameters.class.getClassLoader().getResourceAsStream("data.xml"));
    }

    public String getParameter(String category, String parameter) throws Exception {
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();
        XPathExpression exp = xpath.compile(String.format("//%s[@name='%s']", category, parameter));
        NodeList nl = (NodeList) exp.evaluate(document.getFirstChild(), XPathConstants.NODESET);
        return nl.item(0).getAttributes().getNamedItem("value").getNodeValue();
    }

    public String getPublicUrl(String stand) throws Exception {
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();
        XPathExpression exp = xpath.compile(String.format("//url[@name='%s']", stand));
        NodeList nl = (NodeList) exp.evaluate(document.getFirstChild(), XPathConstants.NODESET);
        return nl.item(0).getNodeValue();
    }
}
