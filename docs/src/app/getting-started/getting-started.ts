import {Component} from '@angular/core';
import {Title} from '@angular/platform-browser';

@Component({
  templateUrl: './getting-started.html'
})
export class GettingStarted {
  langGroovy = ['groovy'];
  buildGradleSnippet = `implementation 'java.rastreio:rastreio:1.0.2'`;
  langXml = ['xml'];
  pomXmlSnippet = `<dependency>
  <groupId>java.rastreio</groupId>
  <artifactId>rastreio</artifactId>
  <version>1.0.2</version>
  <type>pom</type>
</dependency>`;
  ivyXmlSnippet = `<dependency org='java.rastreio' name='rastreio' rev='1.0.2'>
  <artifact name='rastreio' ext='pom' ></artifact>
</dependency>`;
  langJava = ['java'];
  rastreioTrackAsyncSnippet = `Rastreio.track("JT124720455BR", new Rastreio.Listener() {
  @Override
  public void onSuccess(TrackObject trackObject) {
    // Use this tracking object
  }
    
  @Override
  public void onFailure(Exception e) {
    // Report exception
    e.printStackTrace();
  }
});`;
  rastreioTrackSyncSnippet = `try {
  TrackObject trackObject = Rastreio.trackSync("JT124720455BR");

  // Use this tracking object
} catch (IOException e) {
  // Report exception
  e.printStackTrace();
}`;

  constructor(titleService: Title) {
    titleService.setTitle('rastreio-java');
  }
}
