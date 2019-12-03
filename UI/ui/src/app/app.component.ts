import {ChangeDetectorRef, Component} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AppService} from "./app.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ui';

  public user: FormGroup;

  constructor(private fb: FormBuilder,
              private router: Router,
              private cdf: ChangeDetectorRef,
              private appService: AppService) {
    this.user = this.fb.group({
      'mobile': [null, Validators.compose([Validators.required, Validators.maxLength(11) , Validators.minLength(11)])],
      'password': [null, Validators.compose([Validators.required, Validators.minLength(4)])]
    });
  }

  signup() {
    if (this.user.valid) {
      this.cdf.detectChanges();
      this.appService.signup(this.user.value).subscribe(
        status => {
          alert(status);
          this.cdf.detectChanges();
          this.router.navigate(['/pages']).then();
        }
      )
    } else {
      alert("请输入正确格式！");
    }
  }
}
