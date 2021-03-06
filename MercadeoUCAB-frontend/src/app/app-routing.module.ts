import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { MarcaComponent } from './admin/marca/marca.component';
import { CategoriaComponent } from './admin/categoria/categoria.component';
import { SubcategoriaComponent } from './admin/subcategoria/subcategoria.component';
import { UsuarioComponent } from './admin/usuario/usuario.component';
import { AdminComponent } from './admin/admin.component';
import { EstudiosClienteComponent } from './cliente/estudios-cliente/estudios-cliente.component';
import { SolicitudEstudioComponent } from './cliente/solicitud-estudio/solicitud-estudio.component';
import { ClienteComponent } from './cliente/cliente.component';
import { EstudiosEncuestadoComponent } from './encuestado/estudios-encuestado/estudios-encuestado.component';
import { AnalistaComponent } from './analista/analista.component';
import { EstudiosAnalistaComponent } from './analista/estudios-analista/estudios-analista.component';
import { CrearEstudioComponent } from './analista/crear-estudio/crear-estudio.component';
import { TipoComponent } from './admin/tipo/tipo.component';
import { PresentacionComponent } from './admin/presentacion/presentacion.component';
import { RegistroEncuestadoComponent } from './encuestado/registro-encuestado/registro-encuestado.component';

import { ProductoComponent } from './cliente/producto/producto.component';
import { RecuperarContrasenaComponent } from './recuperar-contrasena/recuperar-contrasena.component';
import { CambioContrasenaComponent } from './cambio-contrasena/cambio-contrasena.component';
import { PreguntaComponent } from './admin/pregunta/pregunta.component';
import { RespuestasEncuestaComponent } from './encuestado/respuestas-encuesta/respuestas-encuesta.component';
import { EstudiosComponent } from './admin/estudios/estudios.component';
import { PreguntasEstudioComponent } from './admin/estudios/preguntas-estudio/preguntas-estudio.component';
import { AnalistaPoblacionComponent } from './analista/analista-poblacion/analista-poblacion.component';
import { PreguntasSugeridasComponent } from './admin/preguntas-sugeridas/preguntas-sugeridas.component';
import { EncuestadoComponent } from './encuestado/encuestado.component';
import { SolicitudesComponent } from './admin/solicitudes/solicitudes.component';
import { EstudiosSugeridosComponent } from './admin/estudios-sugeridos/estudios-sugeridos.component';
import { SolicitudesPendientesComponent } from './cliente/solicitudes-pendientes/solicitudes-pendientes.component';
import { ResultadosComponent } from './analista/resultados/resultados.component';
import { MuestraEstudioComponent } from './analista/muestra-estudio/muestra-estudio.component';
import { AddEstudioComponent } from './admin/estudios/add-estudio/add-estudio.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: 'recuperarContrasena', component: RecuperarContrasenaComponent},
  { path: 'cambioContrasena', component:  CambioContrasenaComponent},
  { path: '', redirectTo: 'login', pathMatch: 'full' },

  { path: 'admin', component: AdminComponent,
    children: [
      { path: 'categorias', component: CategoriaComponent},
      { path: 'marcas', component: MarcaComponent},
      { path: 'tipos', component: TipoComponent},
      { path: 'presentaciones', component: PresentacionComponent},
      { path: 'usuarios', component: UsuarioComponent},
      { path: 'subcategorias', component: SubcategoriaComponent},
      { path: 'preguntas', component: PreguntaComponent},
      { path: 'preguntas/:id', component: PreguntaComponent},
      { path: 'preguntassugeridas/:id', component: PreguntasSugeridasComponent},
      { path: 'solicitudes', component: SolicitudesComponent},
      { path: 'solicitudes/crearEstudio', component: AddEstudioComponent},
      { path: 'estudios', component: EstudiosComponent},
      { path: 'estudiossugeridos', component: EstudiosSugeridosComponent},
      { path: 'asignacionpreguntas/:id', component: PreguntasEstudioComponent},
      { path: '', pathMatch: 'prefix', redirectTo: 'solicitudes'},
    ]
  },

  { path: 'cliente', component: ClienteComponent,
    children: [
      { path: 'estudios', component: EstudiosClienteComponent },
      { path: 'solicitar_estudio', component: SolicitudEstudioComponent },
      { path: 'producto', component: ProductoComponent },
      { path: 'solicitudes', component: SolicitudesPendientesComponent },
      { path: '', pathMatch: 'prefix', redirectTo: 'estudios'},
    ]
  },

  { path: 'encuestado', component: EncuestadoComponent,
    children: [
      { path: 'estudios', component: EstudiosEncuestadoComponent },
      { path: 'registro-encuestado', component: RegistroEncuestadoComponent },
      { path: 'respuestas-encuesta/:id', component: RespuestasEncuestaComponent },
      { path: '', pathMatch: 'prefix', redirectTo: 'estudios'},
    ]
  },

  { path: 'analista', component: AnalistaComponent,
    children: [
      { path: 'solicitudes', component: EstudiosAnalistaComponent },
      { path: 'crearEncuesta', component: CrearEstudioComponent },
      { path: 'muestra', component: MuestraEstudioComponent },
      { path: 'poblacion', component: AnalistaPoblacionComponent },
      { path: 'resultados/:id', component: ResultadosComponent},
      { path: '', pathMatch: 'prefix', redirectTo: 'solicitudes'},
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
