from jenkins

ENV JAVA_OPTS='-Djenkins.install.runSetupWizard=false'

COPY adminaccount.groovy /usr/share/jenkins/ref/init.groovy.d/admin-account.groovy
COPY plugins.txt /usr/share/jenkins/plugins.txt
RUN /usr/local/bin/plugins.sh /usr/share/jenkins/plugins.txt
