THIS_SCRIPT_DIR=$(dirname $0)

echo ""
echo "Running Heart Beat Server in a non-Web mode"
echo ""

# This script will run the code in the <profiles> section of below mentioned pom.xml

mvn -f ${THIS_SCRIPT_DIR}/hbs-server/pom.xml exec:java -P run-hbs-server-non-web 

echo ""
echo ""
