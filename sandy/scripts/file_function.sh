function create_jobdsl_file_from_template() {
  PROJ_ID=$1
  REPO_BRANCH=$2
  REPO_URL=$3
  FILE_TYPE=$4
  TEMPLATE_FILE=${JENKINS_HOME}/data/jobdsl-template/${FILE_TYPE}.template
  TARGET_DIR=${JENKINS_HOME}/jobs/SeedJob/workspace
  TARGET_FILE=${TARGET_DIR}/${FILE_TYPE}.groovy

  cp ${TEMPLATE_FILE} ${TARGET_FILE}
}
