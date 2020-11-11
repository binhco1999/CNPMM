import React, { Component } from 'react'
import './timecheck.css'
class Timecheck
 extends Component {
    state = {  }
    render() { 
        return ( 
            <div >
                <div class="card my-3 shadow-lg p-3 mb-5 bg-white rounded">
                    <div class="card-header" id="bordercard">
                        <div class="row justify-content-between">
                            <div class="col-3">
                                <h1>Time Check</h1>
                            </div>
                            <div class="col-3 text-right p-2">
                                <button class="btn btn-success">Import <i class="fas fa-file-import"></i> </button>
                            </div>
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col-6">
                                <div class="form mt-5">
                                    
                                    <div class="row">
                                        <div class="col-4">
                                            <div class="dropdown">
                                                <button class="btn btn-outline-dark dropdown-toggle" type="button"
                                                    id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
                                                    aria-expanded="false">
                                                    Shift
                                                </button>
                                                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                                    <a class="dropdown-item" href="#">A</a>
                                                    <a class="dropdown-item" href="#">B</a>
                                                    <a class="dropdown-item" href="#">C</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-4 ">
                                        <h3>Shift A</h3>
                                    </div>
                                    <div class="col-4">
                                        <h3>20/9/2020</h3>
                                    </div>

                                    </div>
                                    <div class="row mt-3">
                                        <div class="col-4">
                                            <select class="custom-select mr-sm-2" id="inlineFormCustomSelect">
                                                <option selected>Day</option>
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                            </select>
                                        </div>
                                        <div class="col-4">
                                            <select class="custom-select mr-sm-2" id="inlineFormCustomSelect">
                                                <option selected>Month</option>
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                            </select>
                                        </div>
                                        <div class="col-4">
                                            <select class="custom-select mr-sm-2" id="inlineFormCustomSelect">
                                                <option selected>Year</option>
                                                <option value="1">1999</option>
                                                <option value="2">1998</option>
                                                <option value="3">1997</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="row mt-3">
                                        <div class="col">
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend">
                                                    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"
                                                        aria-haspopup="true" aria-expanded="false">
                                                        Choose
                                    </button>
                                                    <div class="dropdown-menu">
                                                        <a class="dropdown-item" href="#">Employees</a>
                                                        <a class="dropdown-item" href="#">Shift</a>
                                                        <a class="dropdown-item" href="#">Department</a>

                                                    </div>
                                                </div>
                                                <input class="custom-select" id="inputGroupSelect03" placeholder="Searching..."
                                                    aria-label="Example select with button addon" />
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        <div class="col-6">
                            <div class="row justify-content-end">
                                <button class="btn btn-primary">Report</button>
                            </div>
                            <div class="row justify-content-end mt-3 ">
                                <button class="btn btn-warning ">Refesh</button>
                                
                            </div>
                        </div>

                        </div>
                        <div class="row justify-content-center mb-3">
                            <div class="col-2 text-center">
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1"
                                        value="option1" checked />
                                    <label class="form-check-label" for="exampleRadios1" >
                                        Confirm
                    </label>
                                </div>
                            </div>
                            <div class="col-2 text-center">
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1"
                                        value="option1" checked />
                                    <label class="form-check-label" for="exampleRadios1" >
                                        Unconfirm
                    </label>
                                </div>
                            </div>
                            <div class="col-2 text-center">
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1"
                                        value="option1" checked />
                                    <label class="form-check-label" for="exampleRadios1" >
                                        Absent
                    </label>
                                </div>
                            </div>
                            <div class="col-2 text-center">
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1"
                                        value="option1" checked />
                                    <label class="form-check-label" for="exampleRadios1">
                                        All
                    </label>
                                </div>
                            </div>

                        </div>

                        <div class="card my-5">
                            <div class="card-header">
                                <h5>Data Report</h5>
                            </div>
                            <div class="card-body">
                                <table class="table table-striped table-hover">
                                    <thead class="table-dark ">
                                        <tr>
                                            <th scope="col">#</th>
                                            <th scope="col">ID</th>
                                            <th scope="col">Name</th>
                                            <th scope="col">DOB</th>
                                            <th scope="col">Department</th>
                                            <th scope="col">Position</th>
                                            
                                            <th scope="col">Time Check</th>
                                            <th scope="col">Status</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">1</th>
                                            <td>1</td>
                                            <td>Mark</td>
                                            <td>19/3/1999</td>
                                            <td>Produce</td>
                                            <td>Emp</td>
                                            <td>14:00</td>
                                            <td>

                                                <button class="btn btn-group"><i class="fas fa-check-circle" ></i></button>
                                                <button class="btn btn-group" type="button" data-toggle="modal"
                                                    data-target="#exampleModalCenter"><i class="fas fa-user-edit" data-toggle="modal"
                                                        data-tartget="#exampleModalCenter"></i></button>
                                            </td>

                                        </tr>
                                        <tr>
                                            <th scope="row">2</th>
                                            <td>1</td>
                                            <td>Mark</td>
                                            <td>19/3/1999</td>
                                            <td>Produce</td>
                                            <td>Emp</td>
                                            <td>14:00</td>
                                            <td>
                                                <button class="btn btn-group"><i class="fas fa-ellipsis-h"></i></button>
                                                <button class="btn btn-group" type="button" data-toggle="modal"
                                                    data-target="#exampleModalCenter"><i class="fas fa-user-edit"></i></button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th scope="row">3</th>
                                            <td>1</td>
                                            <td>Mark</td>
                                            <td>19/3/1999</td>
                                            <td>Produce</td>
                                            <td>Emp</td>
                                            <td>...</td>
                                            <td>
                                                <button class="btn btn-group"><i class="fas fa-times-circle" ></i></button>
                                                <button class="btn btn-group" type="button" data-toggle="modal"
                                                    data-target="#exampleModalCenter"><i class="fas fa-user-edit" data-toggle="modal"
                                                        data-tartget="#exampleModalCenter"></i></button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th scope="row">4</th>
                                            <td>1</td>
                                            <td>Mark</td>
                                            <td>19/3/1999</td>
                                            <td>Produce</td>
                                            <td>Emp</td>
                                            
                                            <td>14:00</td>
                                            <td>
                                                <button class="btn btn-group"><i class="fas fa-ellipsis-h"></i></button>
                                                <button class="btn btn-group" type="button" data-toggle="modal"
                                                    data-target="#exampleModalCenter"><i class="fas fa-user-edit"></i></button>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                                <div class="row justify-content-center">
                                    <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                                        <div class="btn-group mr-2" role="group" aria-label="First group">
                                            <button type="button" class="btn btn-secondary">1</button>
                                            <button type="button" class="btn btn-secondary">2</button>
                                            <button type="button" class="btn btn-secondary">3</button>
                                            <button type="button" class="btn btn-secondary">4</button>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog"
                        aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <div>
                                        <h5>20/9/2020</h5>
                                        <h5>Shift A</h5>
                                        <h3 class="modal-title" id="exampleModalCenterTitle">Information Mark</h3>

                                    </div>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <div class="row">
                                        <div class="col-12">
                                            <span><h5>Department:</h5> <label>Produce</label> </span>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col">
                                            <span><h5>Position:</h5> <label>Emp</label> </span>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-3">
                                            <span><h5>Time In:</h5><input class="input-group" type="text" placeholder="6:00"></input> </span>
                                        </div>
                                        <div class="col-3">
                                            <span><h5>Time Out:</h5> <input class="input-group" type="text" placeholder="14:00" /></span>
                                        </div>
                                    </div>
                                    <div class="row mt-3">
                                        <div class="col">
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="option1" checked />
                                                <label class="form-check-label" for="gridRadios1">
                                                    Confirm
                                    </label>
                                            </div>
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="option2" />
                                                <label class="form-check-label" for="gridRadios2">
                                                    Absent
                                    </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button type="button" class="btn btn-primary">Save changes</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
         );
    }
}
 
export default Timecheck
;