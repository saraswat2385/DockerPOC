mavenJob('CodeCoverage Spring3Hibernate') {
  description("Code Coverage for spring3-Hibernate application")
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
  goals('clean cobertura:cobertura -Dfindbugs.skip')
  rootPOM('pom.xml')
}
