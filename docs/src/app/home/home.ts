import {Component} from '@angular/core';
import {Title} from '@angular/platform-browser';

@Component({
  templateUrl: './home.html'
})
export class Home {
  constructor(titleService: Title) {
    titleService.setTitle('rastreio-java');
  }
}
