/**
 * 
 */
import java.io.File;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
/**
 * @author SOLON
 *
 */
public class SerializeToXML {

	static String outputContactsFile = "contacts.xml";//output contacts to xml

	/**
	 * @param args
	 */

	private void serialize(Contacts map, String xmlFile ) {
		try {
			JAXBContext jxbCntxt = JAXBContext.newInstance(Contacts.class);
			Marshaller marshaller = jxbCntxt.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			// output file to console
			marshaller.marshal(map, System.out);
			// save to xml file
			marshaller.marshal(map, new File(xmlFile));
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
