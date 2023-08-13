mvn clean install
mvn -f ./populator/pom.xml clean package
mvn -f ./searcher/pom.xml clean package
mvn -f ./indexer/pom.xml clean package