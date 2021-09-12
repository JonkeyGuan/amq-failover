# amq-failover

## producer
```
cd producer
mvn clean spring-boot:run -D"BROKER_URL=failover(tcp://192.168.2.206:31234,tcp://192.168.2.206:31235)"
```

## consumer
```
cd consumer
mvn clean spring-boot:run -D"BROKER_URL=failover(tcp://192.168.2.206:31234,tcp://192.168.2.206:31235)"
```
