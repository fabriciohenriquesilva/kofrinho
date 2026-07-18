import { Routes } from '@angular/router';
import {BancoList} from './components/banco/banco-list/banco-list';
import {BancoForm} from './components/banco/banco-form/banco-form';

export const routes: Routes = [
    {
        path: 'cadastros/bancos',
        component: BancoList
    },
    {
        path: 'cadastros/bancos/edit/:id',
        component: BancoForm
    },
    {
        path: 'cadastros/bancos/create',
        component: BancoForm
    },
];
