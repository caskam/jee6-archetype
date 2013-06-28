#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util;

import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VersionTest {

	private static Logger LOG = LoggerFactory.getLogger(VersionTest.class);
	
	@Test
	public void testVersion()
	{
		try {
			LOG.debug("Version from filtered properties :"+ Version.VALUE);
			assertFalse("${parentArtifactId}.properties is not filtered", "${symbol_dollar}{app.version}".equals(Version.VALUE));
		} catch (ExceptionInInitializerError e) {
			LOG.error("${parentArtifactId}.properties could not be read");
			fail("Filtering is buggy under M2Eclipse, try cleaning the project or doing a 'touch' on ${parentArtifactId}.properties");
		}
	}
}
