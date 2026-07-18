import {Component} from '@angular/core';
import {RouterLink} from '@angular/router';

@Component({
    selector: 'sidebar',
    imports: [RouterLink],
    templateUrl: './sidebar.html',
    styleUrl: './sidebar.scss',
    standalone: true,
})
export class Sidebar {

    isCollapsed = false;

    toggleMenu(): void {
        this.isCollapsed = !this.isCollapsed;
    }

    menuItems: MenuItem[] = [
        {id: 1, label: 'Dashboard', path: 'home', icon: 'ph ph-house', active: true},
        {
            id: 2,
            label: 'Cadastros',
            path: 'cadastros',
            icon: 'ph ph-folder',
            children: [
                {
                    id: 201,
                    label: 'Bancos',
                    path: 'bancos'
                },
                {
                    id: 12,
                    label: 'Contas',
                    path: 'contas'
                }
            ]
        },
        {id: 3, label: 'Lançamentos', path: 'lancamentos', icon: 'ph ph-money'},
        {id: 4, label: 'Veículos', path: 'veiculos', icon: 'ph ph-car'},
        {id: 5, label: 'Relatórios', path: 'reports', icon: 'ph ph-presentation-chart'},
        {id: 6, label: 'Configurações', path: 'configs', icon: 'ph ph-gear'},
    ];
}

interface MenuItem {
    id: number;
    label: string;
    icon?: string;
    active?: boolean;
    path: string;
    children?: MenuItem[];
}
