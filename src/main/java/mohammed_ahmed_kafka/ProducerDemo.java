package mohammed_ahmed_kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

// create our class
public class ProducerDemo {
    public static void main(String[] args) {
        // print hello world to make sure everything work
        //System.out.println("hello world");
        String bootstrapServers = "localhost:9092";
        // create producer properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG , bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // create producer
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        // create producer record
        ProducerRecord<String, String> record =
                new ProducerRecord<String, String>( "first_topic", "hello world");
        // send data
        // this step is asynchronaous
        producer.send(record);

        // flush data (to send data to kafka)
        producer.flush();

        // close roducer
        producer.close();
        
    }
}
