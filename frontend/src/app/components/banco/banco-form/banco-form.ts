import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {Banco} from '../classes/banco';
import {FormsModule} from "@angular/forms";
import {BancoService} from '../banco-service';
import {TextInputComponent} from '../../../shared/text-input/text-input.component';
import {NumberInputComponent} from '../../../shared/number-input/number-input.component';

@Component({
    selector: 'app-banco-form',
    imports: [FormsModule, TextInputComponent, NumberInputComponent,],
    templateUrl: './banco-form.html',
    styleUrl: './banco-form.scss',
    providers: [BancoService],
    standalone: true,
})
export class BancoForm implements OnInit {

    model: Banco;

    constructor(private bancoService: BancoService,
                private cdr: ChangeDetectorRef) {
        this.model = new Banco();
    }

    ngOnInit(): void {
        this.bancoService.getById(3).subscribe(banco => {
            Object.assign(this.model, banco);
            this.cdr.markForCheck();
        });
    }

}
