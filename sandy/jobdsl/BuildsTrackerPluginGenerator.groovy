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
    shell("cp -v \${WORKSPACE}/target/buildstracker.hpi \${JENKINS_HOME}/data/plugins/")
  }
  publishers {
    downstream('JenkinsImageGenerator', 'SUCCESS')
  }
}
