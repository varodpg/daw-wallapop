import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from "@angular/common/http";
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HeaderComponent } from './header/header.component';
import { HttpModule } from '@angular/http';
import { JsonpModule } from '@angular/http';

import { routing } from './app.routing';
import { IndexComponent } from './index/index.component';
import { FooterComponent } from './footer/footer.component';
import { ProductService } from './service/product.service';
import { SingleProductComponent } from './single-product/single-product.component';
import { CategoryComponent } from './category/category.component';
import { AddProductComponent } from './add-product/add-product.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { LoginService } from './login/login.service';
import { UserService } from './service/user.service';
import { DashboardService } from './service/dashboard.service';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { PublicDashboardComponent } from './public-dashboard/public-dashboard.component';
import { SearchComponent } from './search/search.component';
import { EditSingleProductComponent } from './edit-single-product/edit-single-product.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    IndexComponent,
    FooterComponent,
    SingleProductComponent,
    CategoryComponent,
    AddProductComponent,
    DashboardComponent,
    LoginComponent,
    PublicDashboardComponent,
    SearchComponent,
    EditSingleProductComponent
  ],
  imports: [
    BrowserModule,
    NgbModule.forRoot(),
    routing,
    HttpModule,
    JsonpModule,
    HttpClientModule,
    FormsModule,
    AngularFontAwesomeModule
  ],
  providers: [
    ProductService, 
    LoginService,
    UserService,
    DashboardService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
