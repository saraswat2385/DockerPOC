job('Jobs Creator') {
    description("I\'ll create the jobs")
    logRotator(-1, 10)
    scm {
        github('OpsTree/ContinuousIntegration', 'master')
    }
}
