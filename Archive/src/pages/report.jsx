import React, { Component } from 'react'
class Report extends Component {
    state = {}
    render() {
        return (
            <div >
                <div class="card my-3 shadow-lg p-3 mb-5 bg-white rounded">
                    <div class="card-header" id="bordercard">
                        <h1>Reports</h1>
                    </div>
                    <div class="card-body">
                    <table class="table table-striped table-hover">
                            <thead class="table-dark ">
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Name Emp</th>
                                    <th scope="col">Department</th>
                                    <th scope="col">Position</th>
                                    <th scope="col"></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th scope="row">1</th>
                                    <td>Shift A</td>
                                    <td>Morning</td>
                                    <td>6:00</td>
                                    <td>14:00</td>
                                    <td>
                                        <button class="btn btn-group" type="button" onClick={()=>this.showModal(1)}><i class="fas fa-edit"></i></button>
                                        <button class="btn btn-group" type="button"><i class="fas fa-times-circle"></i></button>
                                    </td>

                                </tr>
                                <tr>
                                    <th scope="row">2</th>
                                    <td>Shift B</td>
                                    <td>Evening</td>
                                    <td>14:00</td>
                                    <td>22:00</td>
                                    <td>
                                        <button class="btn btn-group" type="button" ><i class="fas fa-edit" onClick={()=>this.showModal(0)}></i></button>
                                        <button class="btn btn-group" type="button"><i class="fas fa-times-circle"></i></button>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">3</th>
                                    <td>Shift C</td>
                                    <td>Increased</td>
                                    <td>22:00</td>
                                    <td>6:00</td>
                                    <td>
                                        <button class="btn btn-group" type="button"><i class="fas fa-edit" onClick={()=>this.showModal(1)}></i></button>
                                        <button class="btn btn-group" type="button"><i class="fas fa-times-circle"></i></button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        );
    }
}

export default Report;