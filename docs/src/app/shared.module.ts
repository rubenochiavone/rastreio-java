import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {HighlightModule} from 'ngx-highlightjs';
import {HighlightPlusModule} from 'ngx-highlightjs/plus';

import {MaterialModule} from './material.module';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    MaterialModule,
    ReactiveFormsModule,
    RouterModule,
    HighlightPlusModule,
    HighlightModule
  ],
  exports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MaterialModule,
    HighlightPlusModule,
    HighlightModule
  ]
})
export class SharedModule {}
