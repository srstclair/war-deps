# war-deps

Example project to demonstrate how transitive dependencies in wars are handled in Maven via the
maven-war-plugin.

The take away messages are:

* Adding a war dependencys to a project doesn't add the war's transitive dependencies to the classpath.
* In order to add a war dependency's transitive dependencies to the classpath, another dependency to the
  war project's pom must be declared (see [war-deps-overlay/pom.xml](war-deps-overlay/pom.xml).

Running `mvn clean install -fn` on this project will result in war-deps-via-war failing, since SomeClass will
not be on its classpath.

See the following for more details:

* https://jira.codehaus.org/browse/MWAR-253
* http://stackoverflow.com/questions/1769586/maven-war-dependency
* http://stackoverflow.com/questions/14728040/wtp-m2e-not-deploying-transitive-dependencies

## Modules

* **war-deps-dependency-a**: Contains SomeClass, which other modules will look for on the classpath.
* **war-deps-dependency-b**: Depends on war-dependency-a to test transitive dependency hierarchy behavior.
* **war-deps-overlay**: A war project using war-deps-war as an overlay which requires dependencies on war-deps-war's
   war and pom to get war-deps-war's transitive dependencies on the classpath.
* **war-deps-via-pom**: Project with a dependency on war-deps-war's pom (**does** have war-deps-war's transitive dependencies on classpath).
* **war-deps-via-war**: Project with a dependency on war-deps-war's war (**does not** have war-deps-war's transitive dependencies on classpath).
* **war-deps-war**: War project with a dependency on war-deps-dependency-b (and a transitive dependency on war-deps-dependency-a).
