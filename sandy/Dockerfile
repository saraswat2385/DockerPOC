from jenkins

ENV JAVA_OPTS='-Djenkins.install.runSetupWizard=false'

USER root

ADD https://get.docker.com/builds/Linux/i386/docker-latest /usr/bin/docker 
RUN chmod +x /usr/bin/docker

USER jenkins

COPY adminaccount.groovy /usr/share/jenkins/ref/init.groovy.d/admin-account.groovy
COPY plugins.txt /usr/share/jenkins/plugins.txt
RUN /usr/local/bin/plugins.sh /usr/share/jenkins/plugins.txt
