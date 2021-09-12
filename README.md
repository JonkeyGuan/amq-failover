# amq-failover

## producer
```
cd producer
./mvnw clean spring-boot:run -DBROKER_URL="failover(tcp://192.168.2.206:31234,tcp://192.168.2.206:31235)"
```

## consumer
```
cd consumer
./mvnw clean spring-boot:run -DBROKER_URL="failover(tcp://192.168.2.206:31234,tcp://192.168.2.206:31235)"
```
