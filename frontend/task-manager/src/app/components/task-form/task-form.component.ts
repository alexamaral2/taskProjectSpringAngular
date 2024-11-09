import { Component, Output, EventEmitter } from '@angular/core';
import { TaskService } from '../../services/task.service';
import { Task } from '../../models/task.model';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-task-form',
  templateUrl: './task-form.component.html',
  standalone: true,
  imports: [FormsModule]
})
export class TaskFormComponent {
  task: Task = { title: '', completed: false }; 

  @Output() taskCreated = new EventEmitter<void>();

  constructor(private taskService: TaskService) {}

  createTask() {
    this.taskService.createTask(this.task).subscribe(() => {
      this.task = { title: '', completed: false }; 
      this.taskCreated.emit();
    });
  }
}
