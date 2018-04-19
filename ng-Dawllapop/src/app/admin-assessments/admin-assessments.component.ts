import { Component, OnInit } from '@angular/core';
import { DashboardService } from '../service/dashboard.service';
import { element } from 'protractor';

@Component({
  selector: 'app-admin-assessments',
  templateUrl: './admin-assessments.component.html',
  styleUrls: ['./admin-assessments.component.css']
})
export class AdminAssessmentsComponent implements OnInit {

  private assessments: any[];

  constructor(private dashboardService: DashboardService) { }

  ngOnInit() {    
    this.loadAssessments();
  }

  loadAssessments(){
    this.assessments = [];
    this.dashboardService.getAllAssessments().subscribe(data => {
      data.forEach(
        element => this.assessments.push(element)
      );
    });
  }

  deleteAssessment(id: number){
    this.dashboardService.deleteAssessment(id).subscribe(
      response => this.loadAssessments()
    );
  }
}
