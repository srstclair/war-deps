package war_deps.via_pom;

import static org.junit.Assert.fail;

import org.junit.Test;

public class TestClasspath {
	@Test
	public void testLocalDependencyAvailability() {
		testClassAvailability("org.apache.commons.lang3.StringUtils");
	}
	
	@Test
	public void testWarTransitiveDependencyAvailability() {
		testClassAvailability("war_deps.dependency.a.SomeClass");
	}

	private void testClassAvailability(String className) {
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			fail("Class " + className + " not available on classpath");
		}
	}

}
