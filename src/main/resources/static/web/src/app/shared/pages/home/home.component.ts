import { Component, OnInit, ViewChild } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Profesor } from '../../models/profesor';
import { ProfesorService } from '../../services/profesor.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';



@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  @ViewChild('createProfesor') contentCreate: any;
  @ViewChild('updateProfesor') contentUpdate: any;

  profesores:Profesor[] | undefined;
  profesor : Profesor = {
    cedula: 0,
    nombre: '',
    apellido: '',
    facultad: '',
    email: '',
  };

  constructor(
    private modalService: NgbModal,
    private profesorService:ProfesorService,
    private router:Router,
    private toastr: ToastrService,
  ) { }

  ngOnInit(): void {
    this.getAll();
  }

  openModalCreate(){
    this.modalService.open(this.contentCreate);
  }

  openModalUpdate(cedula:number){
    this.profesorService.findByCedula(cedula).subscribe(data=>{
      this.profesor = data;
    });
    this.modalService.open(this.contentUpdate);
  }


  save():void {
    this.profesorService.save(this.profesor).subscribe({
      next: (_) => {
        this.modalService.dismissAll(this.contentCreate);
        this.getAll();
        this.clean();
        this.toastr.success('Se ha creado el profesor.', 'OK', {timeOut: 3000});
      },
      error: (e) => this.toastr.error("", 'Fail', {timeOut: 3000}),
      complete:() => console.info('complete')
    });
  }

  update():void {
    this.profesorService.update(this.profesor.cedula, this.profesor).subscribe({
      next: (v) => {
        this.modalService.dismissAll(this.contentUpdate);
        this.getAll();
        this.clean();
        this.toastr.success('Se actualizó el profesor con éxito....', 'OK', {timeOut: 3000});
      },
      error: (e) => this.toastr.error("", 'Fail', {timeOut: 3000}),
      complete:() => console.info('complete')
    });
  }

  delete(cedula:number) : void {
    this.profesorService.delete(cedula).subscribe({
      next: (v) => {
        this.getAll();
        this.clean();
        this.toastr.success('Se eliminó el profesor con éxito....', 'OK', {timeOut: 3000});
      },
      error: (e) => this.toastr.error("", 'Fail', {timeOut: 3000})
    });
  }

  getAll():void{
    this.profesorService.findAll().subscribe(data=>{
      this.profesores=data;
    });
  }

  clean(){
    this.profesor.cedula=0;
    this.profesor.nombre='';
    this.profesor.apellido='';
    this.profesor.email='';
    this.profesor.facultad='';
  }

}
