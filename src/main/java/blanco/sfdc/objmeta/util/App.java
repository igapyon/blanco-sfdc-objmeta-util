package blanco.sfdc.objmeta.util;

import java.io.File;
import java.io.IOException;

import com.sforce.soap.partner.PartnerConnection;

/**
 * 
 * 
 * mvn archetype:generate -DgroupId=blanco.sfdc.objmeta.util
 * -DartifactId=blanco-sfdc-objmeta-util
 * -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello World!");

		final PartnerConnection conn = SFDCPartnerUtil.connect(new File("sfdc.properties"));

	}
}
