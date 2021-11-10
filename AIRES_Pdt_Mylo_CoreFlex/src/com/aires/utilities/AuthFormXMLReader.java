package com.aires.utilities;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.aires.businessrules.constants.PDTConstants;

import org.w3c.dom.Element;

public class AuthFormXMLReader {
	
	public AuthFormXMLReader() throws Exception {			
	 } 
	
	public String getXmlNodeValue(String attributeName) throws Exception, IOException {
		File fXmlFile = new File(getDocumentPath("default_datamap.xml"));
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		NodeList nList = doc.getElementsByTagName("DataElement");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			Element eElement = (Element) nNode;
			NodeList id = eElement.getElementsByTagName("domain-mapper");
			String semanticName = ((Element)id.item(0)).getAttribute("semantic-name");
			System.out.println("Value is : " + eElement.getAttribute("value"));
	        if(semanticName.contains(attributeName)){
	        	return eElement.getAttribute("value");
	        	}	        
			}
		return null;		
		}	    
	
		private String getDocumentPath(String documentName) {
			
			String _documentPath = System.getProperty(PDTConstants.USER_DIR) + PDTConstants.FILE_PATH + documentName;
			return _documentPath.replace("/", "\\");
		}		
}
	

		


			


