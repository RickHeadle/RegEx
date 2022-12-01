import {Component, OnInit} from '@angular/core';
import {RegExService} from "../regex.service";
import {Router} from "@angular/router";
import {RegEx} from "../regex";

@Component({
  selector: 'app-regex-list',
  templateUrl: './regex-list.component.html',
  styleUrls: ['./regex-list.component.css']
})
export class RegexListComponent implements OnInit {

  regExArray: RegEx[] | undefined;

  constructor(private regExService: RegExService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getRegExArray();
  }

  regExDetails(id: number) {
    this.router.navigate(['regex-details', id]);
  }

  updateRegEx(id: number) {
    this.router.navigate(['update-regex', id]);
  }

  deleteRegEx(id: number) {
    this.regExService.deleteRegEx(id).subscribe(data => {
      console.log(data);
      this.getRegExArray();
    })
  }

  private getRegExArray() {
    this.regExService.getRegExList().subscribe(data => {
      this.regExArray = data;
    });
  }

}
