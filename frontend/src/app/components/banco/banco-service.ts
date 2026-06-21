import {RestService} from '../../shared/services/rest-service';
import {Banco} from './classes/banco';
import {Injectable} from '@angular/core';

@Injectable({
    providedIn: 'root',
})
export class BancoService extends RestService<Banco> {

    constructor() {
        super('bancos');
    }

}
