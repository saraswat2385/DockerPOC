mavenJob('ProjectStatsPluginGenerator') {
  description("I'll generate ProjectStatsPlugin")
  logRotator(-1, 10)
  scm {
    git {
    branch('*/master')
      remote {
        name('')
        refspec('')
        url('https://github.com/XbaPAASP/project-stats-plugin.git')
      }
    }
  }
  //please enable the maven in your jenkins form jenkins configuration
  goals('clean package')
  rootPOM('pom.xml')
  postBuildSteps {
    shell("cp -v \${WORKSPACE}/target/project-stats-plugin.hpi ${JENKINS_HOME}/data/plugins/")
  }
  publishers {
    downstream('JenkinsImageGenerator', 'SUCCESS')
  }
}
