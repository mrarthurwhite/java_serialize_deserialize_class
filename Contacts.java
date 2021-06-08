/**
 * 
 */
import javax.xml.bind.annotation.XmlRootElement;

import java.util.LinkedHashMap;

/**
 * @author SOLON
 *
 */
@XmlRootElement (name="contacts")

public class Contacts {

	private  LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
	public LinkedHashMap<String, String> getMap() {
		return map;
	}


	public void setMap(LinkedHashMap<String, String> map) {
		this.map = map;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}



