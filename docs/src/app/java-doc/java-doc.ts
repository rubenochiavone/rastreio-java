import {Component, ViewChild} from '@angular/core';

@Component({
  templateUrl: './java-doc.html'
})
export class JavaDoc {
  @ViewChild('javadocFrame')
  iframe : any;
  iframeStyle : HTMLStyleElement;

  constructor() {
    this.iframeStyle = document.createElement('style');
    this.iframeStyle.textContent = `div.topNav {
  display: none;
}

div.bottomNav {
  display: none;
}

div.subNav {
  display: none;
}
`;
  }

  applyStyle() {
    if (this.iframe
      && this.iframe.nativeElement
      && this.iframe.nativeElement.contentDocument
      && this.iframe.nativeElement.contentDocument.head) {
      this.iframe.nativeElement.contentDocument.head.appendChild(this.iframeStyle);
    }
  }
}
