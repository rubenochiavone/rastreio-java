# rastreio-java-docs

`rastreio-java` documentation project.

## Setup

First of all generate java documentation using `gradle`:

```shell
./gradlew javadoc
```

Then copy generated HTML files from `build/docs/javadoc` to `docs/src/javadoc` folder:

```shell
rm -rf docs/src/javadoc/*
cp -rfa build/docs/javadoc/* docs/src/javadoc/
```

After everything is in place setup docs project:

```shell
cd docs
yarn
```

## Build & serve

Build docs project and serve it:

```shell
yarn start
```

## Dist

To generate distribution files do:

```shell
yarn build
```

After this command release content will be in `docs/dist` folder.
