import {Component} from '@angular/core';
import {Title} from '@angular/platform-browser';

@Component({
  templateUrl: './changelog.html'
})
export class Changelog {
  constructor(titleService: Title) {
    titleService.setTitle('rastreio-java');
  }
}
