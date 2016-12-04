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
    shell("mkdir -p ${WORKSPACE}/sandy/plugins \n cp -v \${JENKINS_HOME}/tmp_plugins/*.hpi \${WORKSPACE}/sandy/plugins/")
    dockerBuildAndPublish {
         repositoryName('xbapaasp/jenkins')
         tag('${BUILD_TIMESTAMP}')
         dockerHostURI('tcp://docker-host.internal.xbapaasp.com:2376')
         dockerRegistryURL('https://758718909236.dkr.ecr.us-west-2.amazonaws.com')
         buildContext('sandy')
         registryCredentials('AKIAIUOELJCIXCMXCACQ (docker-hub)')
         forcePull(false)
         createFingerprints(false)
         skipDecorate()
    }
	}
}
