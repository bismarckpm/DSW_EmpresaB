import { Component, OnInit } from '@angular/core';

declare var $;

@Component({
  selector: 'app-analista',
  templateUrl: './analista.component.html',
  styleUrls: ['./analista.component.css']
})
export class AnalistaComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  action() {
    $('body').toggleClass('sidebar-toggled');
    $('.sidebar').toggleClass('toggled');
  }
}
