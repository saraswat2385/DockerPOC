from jenkins

ENV JAVA_OPTS='-Djenkins.install.runSetupWizard=false'

USER root

ADD https://get.docker.com/builds/Linux/i386/docker-latest /usr/bin/docker
RUN chmod +x /usr/bin/docker

USER jenkins

COPY adminaccount.groovy /usr/share/jenkins/ref/init.groovy.d/admin-account.groovy
COPY plugins.txt /usr/share/jenkins/plugins.txt
RUN /usr/local/bin/plugins.sh /usr/share/jenkins/plugins.txt

# Groovy script to create the "SeedJob" (the standard way, not with DSL)
COPY build/create-seed-job.groovy /usr/share/jenkins/ref/init.groovy.d/create-seed-job.groovy

RUN mkdir -p /usr/share/jenkins/ref/jobs/SeedJob/workspace/
COPY jobdsl/* /usr/share/jenkins/ref/jobs/SeedJob/workspace/
RUN mkdir -p /usr/share/jenkins/ref/plugins

RUN mkdir -p ${JENKINS_HOME}/data
RUN mkdir -p ${JENKINS_HOME}/data/plugins

COPY jobdsl-template/ ${JENKINS_HOME}/data/jobdsl-template/
COPY scripts/ ${JENKINS_HOME}/data/scripts/
COPY plugins/ /usr/share/jenkins/ref/plugins/
COPY jenkins-xml/*.xml ${JENKINS_HOME}/

USER root
RUN chown jenkins:jenkins $(find /usr/share/jenkins/ref -type f -name '*.groovy')
RUN chown -R jenkins:jenkins /var/jenkins_home/data/*
USER jenkins
