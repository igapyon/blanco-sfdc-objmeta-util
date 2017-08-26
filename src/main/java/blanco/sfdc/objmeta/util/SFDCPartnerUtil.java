/*
 *  blanco-sfdc-objmeta-util
 *  Copyright (C) 2017  Toshiki Iga
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
/*
 *  Copyright 2017 Toshiki Iga
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package blanco.sfdc.objmeta.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.sforce.soap.partner.PartnerConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

public class SFDCPartnerUtil {
	public static final boolean IS_TRACE = true;

	public static PartnerConnection connect(final File fileProperties) throws IOException {
		try {
			final ConnectorConfig connectorCfg = new ConnectorConfig();

			final Properties prop = new Properties();
			final InputStream inStream = new FileInputStream(fileProperties);
			prop.load(new BufferedInputStream(inStream));
			inStream.close();

			final String url = prop.getProperty("url", "https://login.salesforce.com/services/Soap/u/40.0");
			final String user = prop.getProperty("user");
			final String pass = prop.getProperty("pass");
			if (IS_TRACE) {
				System.err.println("SFDC url: " + url);
				System.err.println("     user: " + user);
			}

			connectorCfg.setAuthEndpoint(url);
			connectorCfg.setUsername(user);
			connectorCfg.setPassword(pass);

			return new PartnerConnection(connectorCfg);
		} catch (ConnectionException ex) {
			throw new IOException("SFDC connection failed: " + ex.toString(), ex);
		}
	}
}
