import { RegisterPageComponent } from './register-page/register-page.component';
import { LoginComponent } from './login/login.component';
import { Routes } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import { SidemenuComponent } from './sidemenu/sidemenu.component';
import { MagicShopComponent } from './magic-shop/magic-shop.component';
import { WeaponShopComponent } from './weapon-shop/weapon-shop.component';
import { MapComponent } from './map/map.component';
import { FightComponent } from './fight/fight.component';

export const routes: Routes = [
    { path: 'register', component: RegisterPageComponent },
    { path: 'sidemenu', component: SidemenuComponent },
    { path: 'login', component: LoginComponent },
    { path: 'welcome', component: WelcomeComponent },
    { path: 'magicshop', component: MagicShopComponent },
    { path: 'weaponshop', component: WeaponShopComponent },
    { path: 'map', component: MapComponent },
    { path: 'fight', component: FightComponent},
    { path: '**', redirectTo: '/welcome' },
];
