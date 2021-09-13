# amq-failover

## producer
```
cd producer
./mvnw clean spring-boot:run -Dspring-boot.run.arguments="--BROKER_URL=(tcp://192.168.2.201:31234,tcp://192.168.2.201:31235)"
```

## consumer
```
cd consumer
./mvnw clean spring-boot:run -Dspring-boot.run.arguments="--BROKER_URL=(tcp://192.168.2.201:31234,tcp://192.168.2.201:31235)"
```
