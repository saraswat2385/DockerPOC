job('CI Generator') {
  description("I\'ll setup the CI of a git repo")
  logRotator(-1, 10)
  parameters {
    stringParam('GIT_URL', 'https://github.com/OpsTree/ContinuousIntegration.git', 'URL of git repo for which CI setup need to be done')
  }
  steps {
    shell('#!/bin/bash \n source ${JENKINS_HOME}/data/scripts/file_function.sh \n echo "Doing the CI setup of repo ${GIT_URL}" \n echo "Doing the CI setup of repo ${GIT_URL}" \n create_jobdsl_file_from_template a b ${GIT_URL} CodeCoverage')
	}
}
