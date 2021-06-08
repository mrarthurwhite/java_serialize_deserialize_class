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
    public static void main(String[] args) {
		Contacts cmap = new Contacts();
		cmap.getMap().put("mr.arthur.white@gmail.com", "Arthur White");
		cmap.getMap().put("arthur.uthersonn@gmail.com", "Arthur Uthersonn");

		// serialize the object map
		SerializeToXML sxml = new SerializeToXML();
		sxml.serialize(cmap,outputContactsFile);
		sxml.deSerialize(outputContactsFile);// deserealize the map
	}
	

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

	private void deSerialize(String xmlFile ) {
		try {
			JAXBContext jxbCntxt = JAXBContext.newInstance(Contacts.class);
			Unmarshaller unmarshaller = jxbCntxt.createUnmarshaller();
			Contacts cmap= (Contacts) unmarshaller.unmarshal(new File(xmlFile));
			System.out.println("Number of contacts :  " + cmap.getMap().size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
