package war_deps.via_war;

import static org.junit.Assert.fail;

import org.junit.Test;

public class TestClasspath {
	@Test
	public void testLocalDependencyAvailability() {
		testClassAvailability("org.apache.commons.lang3.StringUtils");
	}

	@Test
	//This fails because of https://jira.codehaus.org/browse/MWAR-253
	public void testWarTransitiveDependencyAvailability() {
		testClassAvailability("war_deps.dependency.a.SomeClass");
	}

	protected void testClassAvailability(String className) {
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			fail("Class " + className + " not available on classpath");
		}
	}
}
