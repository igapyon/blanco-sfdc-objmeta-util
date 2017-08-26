package blanco.sfdc.objmeta.util;

import java.io.File;
import java.io.IOException;

import com.sforce.soap.partner.PartnerConnection;
import com.sforce.ws.ConnectionException;

/**
 * 
 * 
 * mvn archetype:generate -DgroupId=blanco.sfdc.objmeta.util
 * -DartifactId=blanco-sfdc-objmeta-util
 * -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
 *
 */
public class App {
	public static void main(String[] args) throws IOException, ConnectionException {
		System.out.println("Hello World!");

		final PartnerConnection conn = SFDCPartnerUtil.connect(new File("sfdc.properties"));

		final String[] allNames = SFDCPartnerUtil.getAllObjectNames(conn);
		for (String look : allNames) {
			System.out.println(look);
		}
	}
}
