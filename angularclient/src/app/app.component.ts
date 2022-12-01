import {Component, OnInit} from '@angular/core';
import {RegExService} from "./regex.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title: string;
  data: any = [];

  constructor(private regExService: RegExService) {
    this.title = 'Spring Boot - Angular Application';
  }

  ngOnInit() {
    this.regExService.getRegExList().subscribe((data: any[]) => {
      this.data = data;
    })
  }

}
