import React, { Component } from 'react';
import employeeService from '../services/employeeService';
class Employee extends Component {
    state = { 
        employees:[],
        employee:{}
    }
    componentDidMount(){
        employeeService.list().then(res=>{
            console.log(res);
            this.setState({employees:res.data})
        })
    }
    render() { 
        return ( 
            <div>
            <div >
              <div className="card my-3 shadow-lg p-3 mb-5 bg-white rounded">
                <div class="card-header" id="bordercard">
                  <div class="row justify-content-between">
                    <div class="col-3">
                      <h1>Employee</h1>
                    </div>
                    <div className="col-auto">
                      <button
                        type="button"
                        className="btn btn-primary"
                        data-toggle="modal"
                        data-target="#addEmployee"
                      >
                        <i className="fas fa-plus"></i> Add
                      </button>
                    </div>
                  </div>
                </div>
                <div className="card-body">
                  <div className="table-responsive">
                  <table class="table table-striped table-hover mt-4">
                      <thead class="table-dark"> 
                        <tr>
                          <th>Employee_ID</th>
                          <th>First Name</th>
                          <th>Last Name</th>
                          <th>DOB</th>
                          <th>Gender</th>
                          <th>Address</th>
                          <th>Phone Number</th>
                          <th>Start Date</th>
                          <th>Action</th>
                        </tr>
                      </thead>
                      <tbody>
                      {this.state.employees.map((employee,idx)=>{
                            return(
                        <tr key={employee.emp_Id}>
                          <td>{employee.user_Id}</td>
                          <td>{employee.lastName}</td>
                          <td>{employee.firstName}</td>
                          <td>{employee.doB}</td>
                          <td>{employee.department.departmentName}</td>
                          <td>{employee.address}</td>
                          <td>{employee.phoneNumber}</td>
                          <td>15/09/2009</td>   
                          <td>
                          <button class="btn btn-group">
                              <i
                                className="fas fa-edit text-primary"
                                data-toggle="modal"
                                data-target="#editEmployee"
                              ></i>
                            </button>
                            <button class="btn btn-group">
                              <i
                                className="fas fa-trash-alt text-danger"
                                data-toggle="modal"
                                data-target="#deleteEmployee"
                              ></i>
                            </button>
                          </td>
                        </tr>
                        )
                    })}
                      </tbody>
                    </table>
                    <div class="row justify-content-center">
                      <div
                        class="btn-toolbar"
                        role="toolbar"
                        aria-label="Toolbar with button groups"
                      >
                        <div
                          class="btn-group mr-2"
                          role="group"
                          aria-label="First group"
                        >
                          <button type="button" class="btn btn-secondary">
                            1
                          </button>
                          <button type="button" class="btn btn-secondary">
                            2
                          </button>
                          <button type="button" class="btn btn-secondary">
                            3
                          </button>
                          <button type="button" class="btn btn-secondary">
                            4
                          </button>
                        </div>
                      </div>
                    </div>
  
                  </div>
                </div>
              </div>
            </div>
  
  
            <div class="modal fade" id="addEmployee" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Add Employee</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                </div>
                <div class="modal-body">
                <form>
                  <div className="form-row">
                  <div class="form-group col-md-12">
                      <label for="inputEmployeeID">Employee_ID</label>
                      <input type="text" class="form-control" id="inputEmployeeID" placeholder="Employee_ID" />
                    </div>
                  </div>
                  <div class="form-row">
                    <div class="form-group col-md-6">
                      <label for="inputFirstName">First Name</label>
                      <input type="text" class="form-control" id="inputFirstName" placeholder="First Name" />
                    </div>
                    <div class="form-group col-md-6">
                      <label for="inputLastName">Last Name</label>
                      <input type="text" class="form-control" id="inputLastName" placeholder="Last Name" />
                    </div>
                  </div>
                  <div class="form-row">
                    <div class="form-group col-md-6">
                      <label for="inputEmployeeID">DOB</label>
                      <input type="text" class="form-control" id="inputEmployeeID" placeholder="DOB" />
                    </div>
                    <div class="form-group col-md-6">
                      <label for="inputFirstName">Gender</label>
                      <div>
                        <div class="form-check form-check-inline">
                          <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1" />
                          <label class="form-check-label" for="inlineRadio1">Male</label>
                        </div>
                        <div class="form-check form-check-inline">
                          <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2" />
                          <label class="form-check-label" for="inlineRadio2">Female</label>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="inputAddress">Address</label>
                    <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St" />
                  </div>
                  <div class="form-group">
                    <label for="inputPhoneNumber">Phone Number</label>
                    <input type="text" class="form-control" id="inputPhoneNumber" placeholder="Phone Number" />
                  </div>
                </form>
  
                </div>
                <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save</button>
                </div>
            </div>
            </div>
        </div>
  
  
          <div class="modal fade" id="editEmployee" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
              <div class="modal-dialog">
              <div class="modal-content">
                  <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLabel">Edit Employee</h5>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                  </button>
                  </div>
                  <div class="modal-body">
                  <form>
                    <div className="form-row">
                    <div class="form-group col-md-12">
                        <label for="inputEmployeeID">Employee_ID</label>
                        <input type="text" class="form-control" id="inputEmployeeID" placeholder="Employee_ID" />
                      </div>
                    </div>
                    <div class="form-row">
                      <div class="form-group col-md-6">
                        <label for="inputFirstName">First Name</label>
                        <input type="text" class="form-control" id="inputFirstName" placeholder="First Name" />
                      </div>
                      <div class="form-group col-md-6">
                        <label for="inputLastName">Last Name</label>
                        <input type="text" class="form-control" id="inputLastName" placeholder="Last Name" />
                      </div>
                    </div>
                    <div class="form-row">
                      <div class="form-group col-md-6">
                        <label for="inputEmployeeID">DOB</label>
                        <input type="text" class="form-control" id="inputEmployeeID" placeholder="DOB" />
                      </div>
                      <div class="form-group col-md-6">
                        <label for="inputFirstName">Gender</label>
                        <div>
                          <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1" />
                            <label class="form-check-label" for="inlineRadio1">Male</label>
                          </div>
                          <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2" />
                            <label class="form-check-label" for="inlineRadio2">Female</label>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="inputAddress">Address</label>
                      <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St" />
                    </div>
                    <div class="form-group">
                      <label for="inputPhoneNumber">Phone Number</label>
                      <input type="text" class="form-control" id="inputPhoneNumber" placeholder="Phone Number" />
                    </div>
                  </form>
                  </div>
                  <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                  <button type="button" class="btn btn-primary">Save</button>
                  </div>
              </div>
            </div>
        </div>
  
  
        <div class="modal fade" id="deleteEmployee" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="form-group row">
                          <label for="txtMajor" class="col-sm-4 col-form-label">Are you sure?</label>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Delete</button>
                </div>
            </div>
            </div>
        </div>
        </div>
         );
    }
}
 
export default Employee;