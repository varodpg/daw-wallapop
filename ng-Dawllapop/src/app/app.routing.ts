import { Routes, RouterModule } from '@angular/router';
import { IndexComponent } from './index/index.component';
import { SingleProductComponent } from './single-product/single-product.component';

const appRoutes = [
    { path: 'index', component: IndexComponent},
    { path: 'singleProduct/:id', component: SingleProductComponent },
    { path: '', redirectTo: 'index', pathMatch: 'full' }
]
export const routing = RouterModule.forRoot(appRoutes);