import { HttpErrorResponse } from '@angular/common/http';
import { ErrorHandler, Injectable } from '@angular/core';

@Injectable()
export class GlobalErrorHandler implements ErrorHandler {
  
  handleError(error) {
        console.log("handler",error)
        
        if(error instanceof HttpErrorResponse) {
        console.log("HttpErr",error)
        }
  }
  
}