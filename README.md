# rastreio-java

[![Build status](https://gitlab.com/rubenochiavone/rastreio-java/badges/master/pipeline.svg)](https://gitlab.com/rubenochiavone/rastreio-java/-/commits/master) [![Coverage report](https://gitlab.com/rubenochiavone/rastreio-java/badges/master/coverage.svg)](https://gitlab.com/rubenochiavone/rastreio-java/-/commits/master)

A Java library for tracking Correios' shipments. Heavily inspired by https://github.com/talesluna/rastrojs.

## Installation

`TODO: publish to jcenter and reference here.`

## Usage

```java
// Track object async
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

// Track object sync
try {
  TrackObject trackObject = Rastreio.trackSync("JT124720455BR");

  // Use this tracking object
} catch (IOException e) {
  // Report exception
  e.printStackTrace();
}
```

## License

Apache License 2.0. See [LICENSE.md](LICENSE.md).
