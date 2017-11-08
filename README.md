- to build: mvn clean install


- to run: java -jar target/tutorial-0.0.1-SNAPSHOT.jar


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
