import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import {APP_BASE_HREF} from '@angular/common';

import {SharedModule} from './shared.module';
import {AppComponent} from './app.component';
import {AppRoutingModule, DEMO_DECLARATIONS} from './app-routing.module';

import {HighlightModule, HIGHLIGHT_OPTIONS} from 'ngx-highlightjs';

export function getHighlightLanguages() {
  return {
    typescript: () => import('highlight.js/lib/languages/typescript'),
    scss: () => import('highlight.js/lib/languages/scss'),
    shell: () => import('highlight.js/lib/languages/shell'),
    xml: () => import('highlight.js/lib/languages/xml'),
    java: () => import('highlight.js/lib/languages/java'),
    groovy: () => import('highlight.js/lib/languages/groovy')
  };
}

@NgModule({
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    SharedModule,
    HighlightModule
  ],
  declarations: [
    AppComponent,
    DEMO_DECLARATIONS
  ],
  providers: [
    {
      provide: APP_BASE_HREF,
      useValue: '/'
    },
    {
      provide: HIGHLIGHT_OPTIONS,
      useValue: {
        languages: getHighlightLanguages()
      }
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
