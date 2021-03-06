import { Component, Inject, OnInit, ViewChild } from '@angular/core';
import { EstudiosService } from '../../servicios/estudios.service';
import { Estudio } from '../../modelos/estudio';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { RegistroEncuestado } from 'src/app/modelos/registro-encuestado';
import { UsuariosService } from 'src/app/servicios/usuarios.service';
import { identifierModuleUrl } from '@angular/compiler';
import { MatSort } from '@angular/material/sort';

@Component({
  selector: 'app-estudios-encuestado',
  templateUrl: './estudios-encuestado.component.html',
  styleUrls: ['./estudios-encuestado.component.css']
})
export class EstudiosEncuestadoComponent implements OnInit {

  constructor(
    private estudiosService: EstudiosService,
    private usuariosService: UsuariosService,
    private dialog: MatDialog,
    // tslint:disable-next-line: variable-name
    private _router: Router,

   ) { }

  id: number;
  otro: number;
  estudios: Estudio[];
  infoEncuestado: RegistroEncuestado;
  displayedColumns: string[] = ['nombre', 'fechaInicio', 'fechaFin', 'estatus', 'acciones'];
  dataSource: MatTableDataSource<Estudio>;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  ngOnInit(): void {
    // tslint:disable-next-line: prefer-const
    let id = JSON.parse(localStorage.getItem('usuarioID'));
    this.estudiosService.getEstudiosEncuestado(id)
      .subscribe(data => {
        this.dataSource = new MatTableDataSource<Estudio>(data);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
        console.log(this.estudios);
    });
      // console.log(this.infoEncuestado);
      // this.estudiosService.getEstudios()
      // .subscribe(data => {this.estudios = data;
      // } );
      // console.log(this.estudios);
    this.id = JSON.parse(localStorage.getItem('usuarioID')),
      console.log(this.id);
  }

  // tslint:disable-next-line: typedef
  logId(){
    this.id = JSON.parse(localStorage.getItem('usuarioID'));
    return this.id;
  }

  //  this.estudiosService.getEstudiosEncuestado(this.id).subscribe(estudios => console.log(estudios));

  // tslint:disable-next-line: typedef
  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }

}
