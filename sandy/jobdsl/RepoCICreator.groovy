job('CI Generator') {
  description("I\'ll setup the CI of a git repo")
  logRotator(-1, 10)
  parameters {
    stringParam('GIT_URL', 'https://github.com/OpsTree/ContinuousIntegration.git', 'URL of git repo for which CI setup need to be done')
  }
  steps {
    shell('echo "Doing the CI setup of repo ${GIT_URL}"')
	}
}
