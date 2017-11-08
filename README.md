- before building:
    - RabbitMQ details are defined in application.yml
    - queue read is defined in action-instruction-inbound-flow.xml : see queueNames
    - msgs read from queue are written to /Users/philippebrossier/code_perso/rabbitMQwork/queueDump.csv : see hard-coding in OutputServiceImpl


- to build: mvn clean install


- to run:
    - /Users/philippebrossier/code_perso/rabbitMQwork/queueDump.csv requires deletion?
    - java -jar target/tutorial-0.0.1-SNAPSHOT.jar


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
