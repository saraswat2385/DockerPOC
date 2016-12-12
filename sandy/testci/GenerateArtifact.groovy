mavenJob('ArtifactGenerator') {
  description("Artifact Generator for spring3-Hibernate application")
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
  goals('clean package -Dfindbugs.skip')
  rootPOM('pom.xml')
}
