# rastreio-java

[![Build status](https://gitlab.com/rubenochiavone/rastreio-java/badges/master/pipeline.svg)](https://gitlab.com/rubenochiavone/rastreio-java/-/commits/master) [![Coverage report](https://gitlab.com/rubenochiavone/rastreio-java/badges/master/coverage.svg)](https://gitlab.com/rubenochiavone/rastreio-java/-/commits/master)

A Java library for tracking Correios' shipments. Heavily inspired by https://github.com/talesluna/rastrojs.

## Installation

### Gradle

```groovy
implementation 'java.rastreio:rastreio:1.0.4'
```

### Maven

```xml
<dependency>
  <groupId>java.rastreio</groupId>
  <artifactId>rastreio</artifactId>
  <version>1.0.4</version>
  <type>pom</type>
</dependency>
```

### Ivy

```xml
<dependency org='java.rastreio' name='rastreio' rev='1.0.4'>
  <artifact name='rastreio' ext='pom' ></artifact>
</dependency>
```

## Usage

Track object async:

```java
Rastreio.track("JT124720455BR", new Rastreio.Listener() {
  @Override
  public void onSuccess(TrackObject trackObject) {
    // Use this tracking object
  }
   
  @Override
  public void onFailure(Exception e) {
    // Report exception
    e.printStackTrace();
  }
});
```

Track object sync:

```java
try {
  TrackObject trackObject = Rastreio.trackSync("JT124720455BR");

  // Use this tracking object
} catch (IOException e) {
  // Report exception
  e.printStackTrace();
}
```

## Docs

Check documentation at [https://rubenochiavone.github.io/rastreio-java](https://rubenochiavone.github.io/rastreio-java).

## License

Apache License 2.0. See [LICENSE.md](LICENSE.md).
