import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';

import { HttpClient } from '@angular/common/http';

interface DummyResponse {
  status: string;
  message: string;
}

@Component({
  selector: 'app-welcome',
  standalone: true,
  imports: [CardModule, ButtonModule, RouterLink],
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.scss', '../app.component.scss']
})
export class WelcomeComponent {
  constructor(private http: HttpClient) {}


  onClick(): void {
    this.http.get<DummyResponse>('http://localhost:8080/dummy/test').subscribe((response: DummyResponse ) => {
      console.log(response);
    });
  }

}
