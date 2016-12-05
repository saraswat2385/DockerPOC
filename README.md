# DockerPOC
I'm a repo to do docker poc

## Features
* I'll setup a jenkins server that will have the initial setup turned off.
* The jenkins setup will have an admin user already in place.
* The jenkins setup comes with a pre-installed plugins such as git, maven, job-dsl.. you can install more plugins by adding an entry in plugins.txt.
* The jenkins setup comes with 5 pre-bundled jenkins jobs
  * SeedJob: This is a a seed job that creates the rest of the 4 jobs, if you want to add more pre-bundled jobs you just need the put the dsl of those jenkins jobs in jobdsl folder.
  * RepoCICreator: This jenkins job can do the CI setup of a project, right now it can setup the code stability and code coverage jenkins jobs of a maven based java project, but we can add more capabilities as and when needed.
  * ProjectStatsPluginGenerator: This jenkins job creates the artifact(hpi) for Project stats plugin.
  * BuildsTrackerPluginGenerator: This jenkins job creates the artifact(hpi) for Builds Tracker plugin.
  * JenkinsImageGenerator: This jenkins job creates the image of current jenkins setup, with the above 2 custom plugins installed and uploads it to a private docker repository(ECR).

## How to get Started

* Use terraform to create the setup
  * Clone the terraform repo
    * https://github.com/XbaPAASP/Terraform
  * Run the terraform docker container
    * make build
    * make run
  * Run terraform
    * terraform plan
    * terraform apply
  * login to docker ci server
    * ssh docker-ci.internal.xbapaasp.com
    * Run the jenkins docker container
      * aws ecr get-login --region us-west-2
      * docker run -d -p 8080:8080 758718909236.dkr.ecr.us-west-2.amazonaws.com/xbapaasp/jenkins
      * Figure out the ELB
      * Login to jenkins server and set the AWS credentials
        * http://docker-ci-682371895.us-west-2.elb.amazonaws.com/credentials/
