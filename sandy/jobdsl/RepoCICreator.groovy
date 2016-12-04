job('CI Generator') {
  description("I\'ll setup the CI of a git repo")
  logRotator(-1, 10)
  parameters {
    stringParam('PROJ_ID', 'ContinuousIntegration', 'Project identifier')
    stringParam('REPO_BRANCH', 'master', 'Branch on which CI needs to be done')
    stringParam('GIT_URL', 'https://github.com/XbaPAASP/Spring3HibernateApp.git', 'URL of git repo for which CI setup need to be done')
  }
  steps {
    shell('#!/bin/bash \n source ${JENKINS_HOME}/data/scripts/file_function.sh \n echo "Doing the CI setup of repo ${GIT_URL}" \n echo "Doing the CI setup of repo ${GIT_URL}" \n create_jobdsl_file_from_template ${PROJ_ID} ${REPO_BRANCH} ${GIT_URL} CodeCoverage \n create_jobdsl_file_from_template ${PROJ_ID} ${REPO_BRANCH} ${GIT_URL} CodeStability \n create_jobdsl_file_from_template ${PROJ_ID} ${REPO_BRANCH} ${GIT_URL} ImageGenerator')
	}
  publishers {
    downstream('SeedJob', 'SUCCESS')
  }
}
