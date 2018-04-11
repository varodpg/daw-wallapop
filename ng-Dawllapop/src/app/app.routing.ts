import { Routes, RouterModule } from '@angular/router';
import { IndexComponent } from './index/index.component';
import { SingleProductComponent } from './single-product/single-product.component';
import { CategoryComponent } from './category/category.component';
import { AddProductComponent } from './add-product/add-product.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { PublicDashboardComponent } from './public-dashboard/public-dashboard.component';
import { SearchComponent } from './search/search.component';
import { EditSingleProductComponent } from './edit-single-product/edit-single-product.component';

const appRoutes = [
    { path: 'index', component: IndexComponent},
    { path: 'singleProduct/:id', component: SingleProductComponent },
    { path: '', redirectTo: 'index', pathMatch: 'full' },
    { path: 'category', component: CategoryComponent },
    { path: 'category/:id', component: CategoryComponent},
    { path: 'addProduct', component: AddProductComponent},
    { path: 'dashboard', component: DashboardComponent},
    { path: 'login', component: LoginComponent},
    { path: 'publicDashboard/:id', component: PublicDashboardComponent },
    { path: 'search/:search', component: SearchComponent},
    { path: 'edit/:id', component: EditSingleProductComponent}
]
export const routing = RouterModule.forRoot(appRoutes);