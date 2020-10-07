# BenchmarkTest

This repository demonstrates using the `sbt-jmh` plugin to measure a few implementations of `foldLeft`.

## Running with Docker
[Install docker](https://docs.docker.com/get-docker/), then run the following from the repository root:
```
docker build . -t jmh-demo
```

Then you can run the demo with:
```
docker run --rm jmh-demo sbt jmh:run
```

This will take some time to complete (a few hours).

## Running with SBT
Install a recent JDK and [sbt](https://www.scala-sbt.org/) to your system, then run the the following at the repo root:
```
sbt jmh:run
```
