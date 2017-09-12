[![Build Status](https://travis-ci.org/infinitenature/v-leaflet-zoomify.svg?branch=master)](https://travis-ci.org/infinitenature/v-leaflet-zoomify) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/966278e7962e4335b03f819faa6db88e)](https://www.codacy.com/app/dve/v-leaflet-zoomify?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=infinitenature/v-leaflet-zoomify&amp;utm_campaign=Badge_Grade)
# V-Leaflet Zoomify add-on project

This is [Leaflet.Zoomify](https://github.com/cmulders/Leaflet.Zoomify) add-on to to [v-leaflet Vaadin add-on](https://github.com/mstahv/v-leaflet)

## Usage

Add the maven add-on repo to your pom.xml:

```xml
<repositories>
   
   <!-- other repos if needed -->
   
   <repository>
      <id>vaadin-addons</id>
      <url>http://maven.vaadin.com/vaadin-addons</url>
   </repository>
</repositories>
```

Add the dependency to your pom.xml:

```xml
<dependencies>
   
   <!-- other dependencies -->
   
   <dependency>
      <groupId>org.infinitenature</groupId>
      <artifactId>v-leaflet-zoomify</artifactId>
      <version>0.0.3</version>
   </dependency>
</dependencies>
```

Use the ```LZoomifiyImage``` class:

```java
new LZoomifyImage("http://cmulders.github.io/Leaflet.Zoomify/examples/hubble-orion-nebula", "&copy; NASA, ESA, M. Robberto and the Hubble Space Telescope Orion Treasury Project Team");
```
## License

This add-on is published under the apache 2.0 license. The source of the java script code is licensed under the MIT license.

## Creating releases

1. Push your changes to e.g. Github 
2. Update pom.xml to contain proper SCM coordinates (first time only)
3. Use Maven release plugin (mvn release:prepare; mvn release:perform)
4. Upload the ZIP file generated to target/checkout/target directory to https://vaadin.com/directory service (and/or optionally publish your add-on to Maven central)

