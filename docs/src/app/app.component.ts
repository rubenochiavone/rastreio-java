import {Component, OnInit, NgZone, ViewChild} from '@angular/core';
import {Router, NavigationEnd} from '@angular/router';

import {environment} from '../environments/environment';

import {MdcDrawer, MdcTopAppBar} from '@angular-mdc/web';

const SMALL_WIDTH_BREAKPOINT = 1240;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent implements OnInit {
  version: string = environment.version;
  matcher: MediaQueryList;

  @ViewChild('topAppBar', {static: false}) topAppBar: MdcTopAppBar;
  @ViewChild('appDrawer', {static: false}) appDrawer: MdcDrawer;

  constructor(
    private _router: Router,
    private _ngZone: NgZone) {}

  isScreenSmall(): boolean {
    return this.matcher.matches;
  }

  ngOnInit() {
    if (environment.production) {
      this._router.events.subscribe(event => {
        if (event instanceof NavigationEnd) {
          (<any>window).ga('set', 'page', event.urlAfterRedirects);
          (<any>window).ga('send', 'pageview');
        }
      });
    }

    this.matcher = matchMedia(`(max-width: ${SMALL_WIDTH_BREAKPOINT}px)`);
    this.matcher.addListener((event: MediaQueryListEvent) => this._ngZone.run(() => event.matches));
  }

  onDrawerSelect(route?: string) {
    if (route) {
      this._router.navigate([route]);
    }

    if (this.isScreenSmall()) {
      this.appDrawer.open = false;
    }
  }
}
