FROM jenkins

USER root
RUN apt-get update \
      && apt-get install -y sudo \
      && rm -rf /var/lib/apt/lists/*
RUN echo "jenkins ALL=NOPASSWD: ALL" >> /etc/sudoers

ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false

COPY basic-security.groovy /usr/share/jenkins/ref/init.groovy.d/basic-security.groovy
USER jenkins
COPY plugins.txt /usr/share/jenkins/plugins.txt
RUN /usr/local/bin/plugins.sh /usr/share/jenkins/plugins.txt
