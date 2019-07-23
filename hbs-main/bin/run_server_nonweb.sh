THIS_SCRIPT_DIR=$(dirname $0)


LOG_FILE_PATH=/tmp/heart-beat-solution/hbs-server/run-hbs-server-non-web
LOG_FILE_NAME=server-non-web.log
LOG_FILE_FULL_PATH="${LOG_FILE_PATH}/${LOG_FILE_NAME}"

mkdir -p ${LOG_FILE_PATH}

echo ""
echo "Running Heart Beat Server in a non-Web mode"
echo "Logs at ${LOG_FILE_FULL_PATH}"
echo ""

# This script will run the code in the <profiles> section of below mentioned pom.xml
mvn -f ${THIS_SCRIPT_DIR}/../hbs-server/pom.xml exec:java -P run-hbs-server-non-web >${LOG_FILE_FULL_PATH} 2>&1 &

echo ""
echo ""
