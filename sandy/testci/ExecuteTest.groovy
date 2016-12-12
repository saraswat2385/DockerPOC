mavenJob('TestExecutor Spring3Hibernate') {
  description("Test executor for spring3-Hibernat application")
  logRotator(-1, 10)
    scm {
      git {
      branch('*/master')
        remote {
          name('')
          refspec('')
          url('https://github.com/XbaPAASP/Spring3HibernateApp.git')
        }
      }
    }
  //please enable the maven in your jenkins form jenkins configuration
  goals('clean test -Dfindbugs.skip')
  rootPOM('pom.xml')
}
