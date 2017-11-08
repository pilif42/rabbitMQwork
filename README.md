- before building:
    - RabbitMQ details are defined in:
            - application.yml for a local RabbitMQ
            - application-cloud.yml for a RabbitMQ in the Cloud
    - Queue read is defined in application.yml: see messaging.queueName
    - Msgs read from queue are written to /Users/philippebrossier/code_perso/rabbitMQwork/queueDump.csv : see hard-coding in OutputServiceImpl


- to build:
    - mvn clean install


- to run:
    - /Users/philippebrossier/code_perso/rabbitMQwork/queueDump.csv requires deletion?
    - vs a local RabbitMQ: java -jar target/tutorial-0.0.1-SNAPSHOT.jar
    - vs a RabbitMQ in the Cloud:  java -jar -Dspring.profiles.active=cloud target/tutorial-0.0.1-SNAPSHOT.jar


- to test:
    - put msg on queue Action.Notify:
            - open Chrome at http://localhost:16672/#/queues
            - select queue Action.Notify
            - select 'Publish message'
                - add properties below:
                    - delivery_mode: 2
                    - content_type: text/xml
                    - Encoding: string
                - add payload:
                    - use content of actionInstructionForManualTest.xml under /resources/actionsvc/xsd
