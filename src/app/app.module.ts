import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ComponentModule } from './components/component.module';
import { HttpClientModule } from '@angular/common/http';
import { ChartsModule } from 'ng2-charts';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    ComponentModule,
    HttpClientModule,
    AppRoutingModule,
    ChartsModule,
   
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}