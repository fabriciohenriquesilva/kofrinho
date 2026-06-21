import {Component, ElementRef, EventEmitter, Input, Output, Renderer2, ViewChild, forwardRef} from '@angular/core';
import {ControlValueAccessor, FormsModule, NG_VALUE_ACCESSOR} from '@angular/forms';
import {TextInputComponent} from '../text-input/text-input.component';

const NUMBER_FIELD_VALUE_ACESSOR: any = {
    provide: NG_VALUE_ACCESSOR,
    useExisting: forwardRef(() => NumberInputComponent),
    multi: true
}

@Component({
    selector: 'app-number-input',
    imports: [FormsModule],
    templateUrl: './number-input.component.html',
    styleUrl: './number-input.component.scss',
    providers: [NUMBER_FIELD_VALUE_ACESSOR]
})
export class NumberInputComponent implements ControlValueAccessor {

    private _value?: number;

    @ViewChild('numberInputElement', {static: true})
    elementRef!: ElementRef<HTMLInputElement>;

    // @Input() field: string = "";
    @Input() label: string = "";
    @Input() name: string = "";
    @Input() placeholder: string = "";
    @Input() hint?: string;
    @Input() error?: string;
    @Input() isReadyOnly: boolean = false;
    @Input() isDisabled: boolean = false;
    @Input() required: boolean = false;
    @Input() min?: number;
    @Input() max?: number;
    @Input() step: number = 1;
    @Input() width: number = 135;

    @Output()
    valueChange: EventEmitter<number> = new EventEmitter<number>();

    constructor(private _renderer: Renderer2) {
    }

    @Input()
    get value(): number {
        return this._value!;
    }

    set value(value: number | undefined) {
        if (value !== this._value) {
            this._value = value as number;
            this.onChangeCb(value);
            this.valueChange.emit(value);
        }
    }

    onChangeCb: (_: any) => void = () => {
    };

    onTouchedCb: (_: any) => void = () => {
    };

    writeValue(value: any): void {
        if (value !== this._value) {
            this._value = value;
        }
    }

    registerOnChange(fn: any): void {
        this.onChangeCb = fn;
    }

    registerOnTouched(fn: any): void {
        this.onTouchedCb = fn;
    }

    setDisabledState?(isDisabled: boolean): void {
        this._renderer.setProperty(this.elementRef.nativeElement, 'disabled', isDisabled);
    }
}
