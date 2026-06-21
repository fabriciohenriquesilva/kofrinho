import {Component, ElementRef, EventEmitter, forwardRef, Input, Output, Renderer2, ViewChild} from '@angular/core';
import {ControlValueAccessor, NG_VALUE_ACCESSOR, FormsModule} from '@angular/forms';

const TEXT_FIELD_VALUE_ACESSOR: any = {
    provide: NG_VALUE_ACCESSOR,
    useExisting: forwardRef(() => TextInputComponent),
    multi: true
}

@Component({
    selector: 'app-text-input',
    standalone: true,
    imports: [FormsModule],
    templateUrl: './text-input.component.html',
    styleUrl: './text-input.component.scss',
    providers: [TEXT_FIELD_VALUE_ACESSOR]
})
export class TextInputComponent implements ControlValueAccessor {

    private _value?: string;

    @ViewChild('textInputElement', {static: true})
    elementRef!: ElementRef<HTMLInputElement>;

    // @Input() field: string = "";
    @Input() label: string = "";
    @Input({required: true}) name: string = "";
    @Input() placeholder: string = "";
    @Input() hint?: string;
    @Input() error?: string;
    @Input() isReadOnly: boolean = false;
    @Input() isDisabled: boolean = false;
    @Input() required: boolean = false;
    @Input() width: number = 350;

    @Output()
    valueChange: EventEmitter<string> = new EventEmitter<string>();

    constructor(private _renderer: Renderer2) {
    }

    @Input()
    get value(): string {
        return this._value!;
    }

    set value(value: string | undefined) {
        if (value !== this._value) {
            this._value = value as string;
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
