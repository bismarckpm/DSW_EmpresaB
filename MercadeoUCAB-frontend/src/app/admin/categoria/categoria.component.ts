import { Component, OnInit, Input, Inject } from '@angular/core';
import { CategoriasService } from 'src/app/servicios/categorias.service';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { AddCategoriaComponent } from './add-categoria/add-categoria.component';
import { EditCategoriaComponent } from './edit-categoria/edit-categoria.component';
import { Categoria, Categoria2 } from 'src/app/modelos/categoria';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Location } from '@angular/common';



@Component({
  selector: 'app-categoria',
  templateUrl: './categoria.component.html',
  styleUrls: ['./categoria.component.css']
})
export class CategoriaComponent implements OnInit {

  categorias: Categoria[];


  @Input() categoriaData: any = {};
  constructor(
    private service: CategoriasService,
    public actRoute: ActivatedRoute,
    public dialog: MatDialog,
    private router: Router,
    private formBuilder: FormBuilder,
    private location: Location
  ) { }
  categoriaForm: FormGroup;
  ngOnInit() {
    this.service.getCategorias()
    .subscribe(data => {this.categorias = data;
    } );

  }
  openModal(){
    this.dialog.open(AddCategoriaComponent);
  }


  openEModal( id: number): void{
    this.dialog.open(EditCategoriaComponent,
      {
        data: {id: id}
      }
    );
  }

  deleteCategoria( categoria: Categoria): void{
    console.log('segundo', categoria);
    const deleteCa: Categoria2 = {
      id: categoria._id,
      nombre: categoria._nombre,
      descripcion: categoria._descripcion,
      estatus: 'Inactivo'
    };
    this.service.updateCategoria(deleteCa).subscribe();
      }
}