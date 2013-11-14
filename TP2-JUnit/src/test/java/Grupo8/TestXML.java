package Grupo8;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

public class TestXML {

	public static void main(String[] args) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		DOMImplementation implementation = builder.getDOMImplementation();
		Document document = implementation.createDocument(null, "Reporte", null);
		document.setXmlVersion("1.0");
		Element documento = document.getDocumentElement();

		//Suite1
		Element elemento1 = document.createElement("NombreDelSuite");// sin espacios!
		Text valor1 = document.createTextNode("Suite 1");
		elemento1.appendChild(valor1);		
		documento.appendChild(elemento1);
		
		//Test1
		Element elemento2 = document.createElement("testForATag");// sin espacios!
		Text valor2 = document.createTextNode("Failure");
		elemento2.appendChild(valor2);
		elemento2.setAttribute("name", "value");		
		elemento1.appendChild(elemento2);
		
		//Test2
		Element elemento3 = document.createElement("testForSkippedTestWithTag");// sin espacios!
		Text valor3 = document.createTextNode("OK");
		elemento3.appendChild(valor3);
		elemento3.setAttribute("name", "value");
		elemento1.appendChild(elemento3);

		//Test3
		Element elemento4 = document.createElement("testForVariousTags");// sin espacios!
		Text valor4 = document.createTextNode("Error");
		elemento4.appendChild(valor4);
		elemento4.setAttribute("name", "value");
		elemento1.appendChild(elemento4);

		//Suite2
		Element elemento5 = document.createElement("NombreDelSuite");// sin espacios!
		Text valor5 = document.createTextNode("Suite2");
		elemento5.appendChild(valor5);
		elemento5.setAttribute("name", "value");
		documento.appendChild(elemento5);

		//Test1
		Element elemento6 = document.createElement("testForTagsAndRegex");// sin espacios!
		Text valor6 = document.createTextNode("Failure");
		elemento6.appendChild(valor6);
		elemento6.setAttribute("name", "value");
		elemento5.appendChild(elemento6);

		//Test2
		Element elemento7 = document.createElement("testForVariousTagsAndNames");// sin espacios!
		Text valor7 = document.createTextNode("OK");
		elemento7.appendChild(valor7);
		elemento7.setAttribute("name", "value");
		elemento5.appendChild(elemento7);

		//Test3
		Element elemento8 = document.createElement("testForElapsedTime");// sin espacios!
		Text valor8 = document.createTextNode("Error");
		elemento8.appendChild(valor8);
		elemento8.setAttribute("name", "value");
		elemento5.appendChild(elemento8);
		
		Source source = new DOMSource(document);
		Result result = new StreamResult(new java.io.File("resultado.xml")); 
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.transform(source, result);
		System.out.println("sonrie la vida es bella");
	}

}
