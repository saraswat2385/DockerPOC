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
    shell('#!/bin/bash \n cd sandy \n docker build -t xbapaasp/jenkins . \n docker tag xbapaasp/jenkins 758718909236.dkr.ecr.us-west-2.amazonaws.com/xbapaasp/jenkins:1.0 \n docker push 758718909236.dkr.ecr.us-west-2.amazonaws.com/xbapaasp/jenkins')
	}
}
