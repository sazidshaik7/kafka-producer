GetMapping Request: http://localhost:8081/producer/sendMessage/sazid

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

Config: we can also create a new topic with the partitions and replications using NewTopic Spring Boot providing this feature instead of creating it manually.

BaseDir: C:\Users\sazid\Apps\Kafka

==> Start Zookeeper
C:\Users\sazid\Apps\Kafka> .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

==> Start Kafka Server
C:\Users\sazid\Apps\Kafka> .\bin\windows\kafka-server-start.bat .\config\server.properties 
 
==> create a topic with partitions and replications
C:\Users\sazid\Apps\Kafka> .\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --create --topic initial-topic --partitions 3 --replication-factor 1  

==> create a topic
C:\Users\sazid\Apps\Kafka> .\bin\windows\kafka-topics.bat --create --topic initial-topic --bootstrap-server localhost:9092


==> to see the topics 
C:\Users\sazid\Apps\Kafka> .\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --list  

==> to see the partitions in the specified topic
C:\Users\sazid\Apps\Kafka> .\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --describe --topic initial-topic

==> Publish messages from Producer to broker
C:\Users\sazid\Apps\Kafka> .\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic initial-topic

==> Listen messages via Consumer from broker
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic initial-topic