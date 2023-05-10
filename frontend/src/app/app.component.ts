import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
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


    this.http.get<string[]>('http://localhost:8083/supportedImperialLengths').pipe(
      first(),
      tap(result => console.log('Brandon: ', result)),
      map(result => this.supportedImperialLengths = result)
    ).subscribe();

    this.http.get<string[]>('http://localhost:8083/supportedMetricLengths').pipe(
      first(),
      tap(result => console.log('Brandon: ', result)),
      map(result => this.supportedMetricLengths = result)
    ).subscribe();

    this.http.get<string[]>('http://localhost:8083/supportedImperialMass').pipe(
      first(),
      tap(result => console.log('Brandon: ', result)),
      map(result => this.supportedImperialMass = result)
    ).subscribe();

    this.http.get<string[]>('http://localhost:8083/supportedMetricMass').pipe(
      first(),
      tap(result => console.log('Brandon: ', result)),
      map(result => this.supportedMetricMass = result)
    ).subscribe();

    this.http.get<string[]>('http://localhost:8083/supportedImperialTemp').pipe(
      first(),
      tap(result => console.log('Brandon: ', result)),
      map(result => this.supportedImperialTemp = result)
    ).subscribe();

    this.http.get<string[]>('http://localhost:8083/supportedMetricTemp').pipe(
      first(),
      tap(result => console.log('Brandon: ', result)),
      map(result => this.supportedMetricTemp = result)
    ).subscribe();
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