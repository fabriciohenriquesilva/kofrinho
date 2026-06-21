import {HttpClient} from '@angular/common/http';
import {Inject, inject} from '@angular/core';
import {Observable, take} from 'rxjs';

export class RestService<T extends { id?: number }> {

    protected _http: HttpClient = inject(HttpClient);
    protected _apiUrl: string;

    constructor(
        @Inject(String) protected _endpoint: string
    ) {
        this._apiUrl = `api/${this._endpoint}`;
    }

    getById(id: number | string) {
        const url = `${this._apiUrl}/${id}`;
        return this._http.get<T>(url).pipe(take(1));
    }

    save(entity: T): Observable<T> {
        if (entity.id) {
            return this.update(entity);
        }
        return this.create(entity);
    }

    remove(id: number): Observable<any> {
        return this._http.delete(`${this._apiUrl}/${id}`).pipe(take(1));
    }

    private create(entity: T): Observable<T> {
        return this._http.post<T>(this._apiUrl, entity).pipe(take(1));
    }

    private update(entity: T): Observable<T> {
        return this._http.put<T>(this._apiUrl, entity).pipe(take(1));
    }
}
