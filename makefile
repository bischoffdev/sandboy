build-and-test:
	mvn clean install
	mvn sandboy:report -f=examples/maven-example
	open examples/maven-example/target/sandboy-report/index.html