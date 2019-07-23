THIS_SCRIPT_DIR=$(dirname $0)

LOG_FILE_PATH=/tmp/heart-beat-solution/hbs-server/run-hbs-server-in-web
LOG_FILE_NAME=server-in-web.log
LOG_FILE_FULL_PATH="${LOG_FILE_PATH}/${LOG_FILE_NAME}"

mkdir -p ${LOG_FILE_PATH}

echo ""
echo "Running Heart Beat Server in a Tomcat container as a WAR file"
echo "Logs at ${LOG_FILE_FULL_PATH}"
echo ""


mvn -f ${THIS_SCRIPT_DIR}/../hbs-server-in-war/pom.xml  tomcat7:run >${LOG_FILE_FULL_PATH} 2>&1 &

echo ""
echo ""
