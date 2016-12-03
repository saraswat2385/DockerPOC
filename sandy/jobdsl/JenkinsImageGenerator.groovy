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
    shell('#!/bin/bash \n cd sandy \n docker build -t xbapaasp/jenkins .')
	}
}
