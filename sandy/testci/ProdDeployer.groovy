freeStyleJob('ProdDeployer') {
    description("Prod Deployer of spring3-Hibernat application")
    logRotator(-1, 10)
    steps {
      shell('echo "Deploying artifact to Prod"')  
    }
}
