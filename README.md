# Twitter Sream

This a Kafka Stream Project (Twitter-app) it is simply streams messages from twitter as producer and streaming it for a consumers.
the code is writen in Intellij, so to run this app in your machine you will need java 8 jdk, maven 3.6 kafka and zookeeper. all of them can be downloaded on oracle website 
you will also need a twitter dev acount and some configrations such as your tokens.

# Starting zookeeper
I am using git bash on Windows machine and I start zookeeper with two differnt ways:
1- bin/windows/zookeeper-server-start.bat config/zookeeper.properties // git bash
2- bin\windows\zookeeper-server-start.bat config\zookeeper.properties // cmd

If you are using mack or linux you can just start it with:
bin/zookeeper-server-start.sh config/zookeeper.properties

# starting kafka
kafka on windows machine can be started with:
bin/windows/kafka-server-start.bat config/server.properties // or
bin\windows\kafka-server-start.bat config\server.properties

on mack or linux:
bin/kafka-server-start.sh config/server.properties

# creating topics
in this project we are creating two topics:
word-count-input and word-count-output
1- 2- bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 2 --topic twitter_tweets


# creating kafka consumer
Before you create kafka consumer make sure that you created your topics
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 \
    --topic twitter_tweet \
    --from-beginning \
    --formatter kafka.tools.DefaultMessageFormatter \
    --property print.key=true \
    --property print.value=true \
    --property key.deserializer=org.apache.kafka.common.serialization.StringDeserializer \
    --property value.deserializer=org.apache.kafka.common.serialization.LongDeserializer


# creating kafka producer
this is what we are going to produce our messages to kafka and will be using the our twitter topic that will grab tweets if they match the keyword we entered 
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic twitter_tweets





