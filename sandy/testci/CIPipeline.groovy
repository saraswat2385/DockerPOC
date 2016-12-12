pipelineJob("PipeLine JobDsl") {

  logRotator(60, 20, 1, -1)

  description('Pipe Line for CI')

  definition {
    cpsScm {
      scm {
        git {
          branch('*/master')
          remote {
            name('')
            refspec('')
            url('https://github.com/XbaPAASP/DockerPOC.git')
          }
        }
        scriptPath('testci/PipelineScript/pipeline.groovy')
      }
    }
  }
}
