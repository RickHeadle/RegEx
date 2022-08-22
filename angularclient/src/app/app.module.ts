import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {CreateRegexComponent} from './create-regex/create-regex.component';
import {UpdateRegexComponent} from './update-regex/update-regex.component';
import {RegexDetailsComponent} from './regex-details/regex-details.component';
import {RegexListComponent} from './regex-list/regex-list.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateRegexComponent,
    UpdateRegexComponent,
    RegexDetailsComponent,
    RegexListComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
