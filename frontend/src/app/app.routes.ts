import { Routes } from '@angular/router';
import {BancoList} from './components/banco/banco-list/banco-list';
import {BancoForm} from './components/banco/banco-form/banco-form';

export const routes: Routes = [
    {
        path: 'bancos',
        component: BancoList
    },
    {
        path: 'bancos/edit/:id',
        component: BancoForm
    },
    {
        path: 'bancos/create',
        component: BancoForm
    },
];
