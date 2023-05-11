import {Component, OnInit} from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams, HttpResponse, HttpErrorResponse } from '@angular/common/http';
import {first, map, tap} from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [HttpClient]
})
export class AppComponent implements OnInit{
  title = 'Conversion Utility';
  supportedImperialLengths: string[] = [];
  supportedMetricLengths: string[] = [];
  supportedImperialMass: string[] = [];
  supportedMetricMass: string[] = [];
  supportedImperialTemp: string[] = [];
  supportedMetricTemp: string[] = [];
  TempOutput = '';
  MassOutput = '';
  LenOutput = '';
  TempInput = '';
  MassInput = '';
  LenInput = '';
  fromMass = '';
  toMass = '';
  fromLen = '';
  toLen = '';
  fromTemp = '';
  toTemp = '';

  constructor(private http: HttpClient) { }

  ngOnInit(): void {    


    this.http.get<string[]>('http://localhost:8083/supportedImperialLengths', { observe: 'response' }).pipe(
      first(),
      tap(result => console.log('Brandon: ', result)),
      map(result => result.body)
    ).subscribe(data => {
      this.supportedImperialLengths = data;
    });

    this.http.get<string[]>('http://localhost:8083/supportedMetricLengths', { observe: 'response' }).pipe(
      first(),
      tap(result => console.log('Brandon: ', result)),
      map(result => result.body)
    ).subscribe(data => {
      this.supportedMetricLengths = data;
    });

    this.http.get<string[]>('http://localhost:8083/supportedImperialMass', { observe: 'response' }).pipe(
      first(),
      tap(result => console.log('Brandon: ', result)),
      map(result => result.body)
    ).subscribe(data => {
      this.supportedImperialMass = data;
    });

    this.http.get<string[]>('http://localhost:8083/supportedMetricMass', { observe: 'response' }).pipe(
      first(),
      tap(result => console.log('Brandon: ', result)),
      map(result => result.body)
    ).subscribe(data => {
      this.supportedMetricMass = data;
    });

    this.http.get<string[]>('http://localhost:8083/supportedImperialTemp', { observe: 'response' }).pipe(
      first(),
      tap(result => console.log('Brandon: ', result)),
      map(result => result.body)
    ).subscribe(data => {
      this.supportedImperialTemp = data;
    });

    this.http.get<string[]>('http://localhost:8083/supportedMetricTemp', { observe: 'response' }).pipe(
      first(),
      tap(result => console.log('Brandon: ', result)),
      map(result => result.body)
    ).subscribe(data => {
      this.supportedMetricTemp = data;
    });
  }

  convTemp(): void {

    if (this.fromTemp === this.toTemp)
    {
      this.TempOutput = this.TempInput;
    }
    else if (this.fromTemp === 'CELSIUS')
    {
       try {
        this.http.get<any>('http://localhost:8083/celsiusToFarenheit/' + this.TempInput).subscribe(
          result => {
            this.TempOutput = result.message; // Extract value of "message" key
          },
          error => {
            console.log('An error occurred:', error);
          }
        );
      } catch (error) {
        console.log('An error occurred:', error);
        // Handle the error here
      }  
    }
    else if (this.fromTemp === 'FARENHEIT')
    {      
      try {
        this.http.get<any>('http://localhost:8083/farenheitToCelsius/' + this.TempInput).subscribe(
          result => {
            this.TempOutput = result.message; // Extract value of "message" key
          },
          error => {
            console.log('An error occurred:', error);
          }
        );
      } catch (error) {
        console.log('An error occurred:', error);
        // Handle the error here
      }  
    }
  }

  convMass(): void {
    try {
      this.http.get<any>('http://localhost:8083/Mass/' + this.MassInput + '/' + this.fromMass + '/' + this.toMass).subscribe(
        result => {
          this.MassOutput = result.message; // Extract value of "message" key
        },
        error => {
          console.log('An error occurred:', error);
        }
      );
    } catch (error) {
      console.log('An error occurred:', error);
      // Handle the error here
    }
  }

  convLen(): void {
    try {
      this.http.get<any>('http://localhost:8083/Length/' + this.LenInput + '/' + this.fromLen + '/' + this.toLen).subscribe(
        result => {
          this.LenOutput = result.message; // Extract value of "message" key
        },
        error => {
          console.log('An error occurred:', error);
        }
      );
    } catch (error) {
      console.log('An error occurred:', error);
      // Handle the error here
    }    
  }
}