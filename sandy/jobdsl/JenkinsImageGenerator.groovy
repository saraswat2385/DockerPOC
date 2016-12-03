job('JenkinsImageGenerator') {
  description("I\'ll generate jenkins image for XbaPAASP")
  logRotator(-1, 10)
  scm {
    git {
    branch('*/master')
      remote {
        name('')
        refspec('')
        url('https://github.com/XbaPAASP/DockerPOC.git')
      }
    }
  }
  steps {
    dockerBuildAndPublish {
         repositoryName('xbapaasp/jenkins')
         tag('${BUILD_TIMESTAMP}')
         dockerHostURI('tcp://docker-host.internal.xbapaasp.com:2376')
         dockerRegistryURL('758718909236.dkr.ecr.us-west-2.amazonaws.com')
         buildContext('sandy')
         registryCredentials('docker-hub')
         forcePull(false)
         createFingerprints(false)
         skipDecorate()
    }
	}
}
