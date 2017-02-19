package com.edu.server.connection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlManager {

	/**
	 * 获得xml文件所对应的Document对象
	 * 
	 * @param uri
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static Document getDoc(String uri)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		return db.parse(uri);
	}

	/**
	 * 获得xml中每个子节点的文本内容，装在集合中
	 * 
	 * @param doc
	 * @return
	 */
	public static List<String> getChildElementValues(Document doc) {
		List<String> childElementValues = new ArrayList<String>();
		Element rootElement = doc.getDocumentElement();
		NodeList childElementList = rootElement.getElementsByTagName("*");
		for (int i = 0; i < childElementList.getLength(); i++) {
			Element childElement = (Element) childElementList.item(i);
			String childElementValue = childElement.getTextContent();
			childElementValues.add(childElementValue);
		}
		return childElementValues;
	}

	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {
		Document doc = getDoc("src/com/edu/server/connection/db.xml");
		List<String> childElementValues = getChildElementValues(doc);
		for (String childElementValue : childElementValues) {
			System.out.println(childElementValue);
		}
	}

}
