THIS_SCRIPT_DIR=$(dirname $0)

echo ""
echo "Running Heart Beat Client with Server in a non-Web mode"
echo ""

# This script will run the code in the <profiles> section of below mentioned pom.xml

mvn -f ${THIS_SCRIPT_DIR}/hbs-client/pom.xml exec:java -P run-client-with-server-non-web 

echo ""
echo ""
