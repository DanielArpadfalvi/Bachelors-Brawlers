import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss', '../app.component.scss']
})
export class LoginComponent {

  login(username: string, password: string) {
    console.log('Felhasználónév:', username);
    console.log('Jelszó:', password);
    return false;
  }
}
