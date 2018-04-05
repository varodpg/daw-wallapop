import { Routes, RouterModule } from '@angular/router';
import { IndexComponent } from './index/index.component';
import { SingleProductComponent } from './single-product/single-product.component';
import { CategoryComponent } from './category/category.component';

const appRoutes = [
    { path: 'index', component: IndexComponent},
    { path: 'singleProduct/:id', component: SingleProductComponent },
    { path: '', redirectTo: 'index', pathMatch: 'full' },
    { path: 'category', component: CategoryComponent },
]
export const routing = RouterModule.forRoot(appRoutes);