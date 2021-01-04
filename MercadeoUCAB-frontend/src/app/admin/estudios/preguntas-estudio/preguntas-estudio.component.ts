import { Component, OnInit, Input, Inject } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Location } from '@angular/common';
import { Pregunta, Pregunta2 } from 'src/app/modelos/pregunta';
import { PreguntasService } from 'src/app/servicios/preguntas.service';
import { DialogComponent } from '../dialog/dialog.component';
import { PreguntasEstudioService } from 'src/app/servicios/preguntasestudios.service';
import { PreguntaEstudio, PreguntaEstudio2 } from 'src/app/modelos/pregunta_estudio';

@Component({
  selector: 'app-preguntas-estudio',
  templateUrl: './preguntas-estudio.component.html',
  styleUrls: ['./preguntas-estudio.component.css']
})
export class PreguntasEstudioComponent implements OnInit {

  preguntasEstudios: PreguntaEstudio[];
  preguntas: Pregunta[];
  id: number;

  constructor(
    private service: PreguntasEstudioService,
    public actRoute: ActivatedRoute,
    public dialog: MatDialog,
    private router: Router,
    private formBuilder: FormBuilder,
    private location: Location
  ) { }

  ngOnInit(): void {
      this.id= +this.actRoute.snapshot.paramMap.get("id");
      this.service.getPreguntasEstudio(this.id)
      .subscribe(data => {this.preguntas = data;
      } );
  }

  openModal(id: number):void{
    this.dialog.open(DialogComponent,
      {
        data: {id: id}
      }
      );
  }

}
