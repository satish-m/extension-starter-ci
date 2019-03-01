FROM appdynamics/machine:4.5 AS MA


ADD target/Extension-Starter-*.zip /opt/appdynamics/monitors

RUN unzip -q "/opt/appdynamics/monitors/Extension-Starter-*.zip" -d /opt/appdynamics/monitors
#RUN find /opt/appdynamics/monitors/ -name '*.zip' -delete

CMD ["sh", "-c", "java ${MACHINE_AGENT_PROPERTIES} -jar /opt/appdynamics/machineagent.jar"]