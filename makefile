help: ## Show this help
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'
.PHONY: help

build-and-test: ## Build and test the Maven example project
	./mvnw clean install
	./mvnw sandboy:report -f=examples/maven-example
	open examples/maven-example/target/sandboy-report/index.html
.PHONY: build-and-test

show-versions: ## Show most recent dependency versions
	./mvnw versions:display-dependency-updates  versions:display-plugin-updates -ntp
.PHONY: show-versions

deploy: ## Deploy the plugin
	./mvnw clean deploy -B -Prelease -no-transfer-progress

set-maven-version: ## Change the version of the Maven wrapper
	@if test -z "$(MAVEN_VERSION)"; then echo "No MAVEN_VERSION set!"; exit 1; fi
	mvn wrapper:wrapper -Dmaven=${MAVEN_VERSION}
	@./mvnw --version
.PHONY: set-maven-version