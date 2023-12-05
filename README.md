# High scores microservice

This is an example of a small Micronaut microservice that combines sorting, filtering and "top N"/paging in its repository query methods.

If you have Docker installed and running, you can start the microservice with:

```shell
cd high-scores-microservice
./gradlew run
```

You can then add some scores with:

```shell
high-scores-microservice/post-scores.sh
```

You can then try querying the microservice with:

```shell
high-scores-microservice/get-rankings.sh
```
