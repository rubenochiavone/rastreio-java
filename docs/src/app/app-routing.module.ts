import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {Changelog} from './changelog/changelog';
import {GettingStarted} from './getting-started/getting-started';
import {Home} from './home/home';
import {JavaDoc} from './java-doc/java-doc';

export const DOCS_DECLARATIONS = [
  GettingStarted,
  Home,
  JavaDoc
];

const routes: Routes = [
  {path: 'changelog', component: Changelog},
  {path: 'getting-started', component: GettingStarted},
  {path: 'home', component: Home, pathMatch: 'full'},
  {path: 'java-doc', component: JavaDoc},
  {path: '**', redirectTo: 'home'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    useHash: true,
    scrollPositionRestoration: 'enabled'
  })],
  exports: [RouterModule]
})
export class AppRoutingModule {}
