mavenJob('CodeStabilitySpring3Hibernate') {
  description("Code Stability for application {{PROJ_ID}}")
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
  goals('clean compile -Dfindbugs.skip')
  rootPOM('pom.xml')
}
