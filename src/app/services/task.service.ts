import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import {
  ITask,
  ITaskTypeOption,
  ITypePercentage,
} from '../interface/task.interface';

@Injectable({
  providedIn: 'root',
})
export class TaskService {
  constructor(private httpclient: HttpClient) {}

  getTaskList(): Observable<Array<ITask>> {
    return this.httpclient
      .get('http://localhost:8080/api/v1/task/getAllTask')
      .pipe(map((d: Array<ITask>) => d));
  }
  postTaskList(task: ITask): Observable<ITask> {
    return this.httpclient
      .post('http://localhost:8080/api/v1/task/addTask', task)
      .pipe(map((d: ITask) => d));
  }

  updateTask(task: ITask, id: string): Observable<ITask> {
    return this.httpclient
      .put(`http://localhost:8080/api/v1/task/updateTask/${id}`, task)
      .pipe(map((d: ITask) => d));
  }
  deleteTask(id: string) {
    return this.httpclient.delete(`http://localhost:8080/api/v1/task/deleteById/${id}`);
  }

  getTaskById(id: string): Observable<ITask> {
    return this.httpclient
      .get(`http://localhost:8080/api/v1/task/getById/${id}`)
      .pipe(map((d: ITask) => d));
  }

  getTypePercentage(): Observable<Array<ITypePercentage>> {
    return this.httpclient
      .get(`http://localhost:8080/api/v1/task/getTask/vData/percentcounttype`)
      .pipe(map((d: Array<ITypePercentage>) => d));
  }

  getTypeOptions(): Array<ITaskTypeOption> {
    return [{ type: 'done' }, { type: 'todo' }, { type: 'pending' }];
  }
}