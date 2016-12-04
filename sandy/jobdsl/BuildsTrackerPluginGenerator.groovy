mavenJob('BuildsTrackerPluginGenerator') {
  description("I'll generate BuildsTrackerPlugin")
  logRotator(-1, 10)
  scm {
    git {
    branch('*/master')
      remote {
        name('')
        refspec('')
        url('https://github.com/XbaPAASP/buildstracker.git')
      }
    }
  }
  //please enable the maven in your jenkins form jenkins configuration
  goals('clean package')
  rootPOM('pom.xml')
  postBuildSteps {
    shell("#!/bin/bash \n mkdir - \${JENKINS_HOME}/tmp_plugins \n cp -v \${WORKSPACE}/target/buildstracker.hpi \${JENKINS_HOME}/tmp_plugins/")
  }
  publishers {
    downstream('JenkinsImageGenerator', 'SUCCESS')
  }
}
