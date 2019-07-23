THIS_SCRIPT_DIR=$(dirname $0)

echo ""
echo "Running Heart Beat Server in a Tomcat container as a WAR file"
echo ""

mvn -f ${THIS_SCRIPT_DIR}/hbs-server-in-war/pom.xml  tomcat7:run

echo ""
echo ""
