import React, { Component } from 'react'
// import './department.css'
import { Modal, Form, Col, Button, Row } from 'react-bootstrap';
import departmentService from '../services/departmentService'
class Department extends Component {
    state = {
        departments: [],
        department: {},

        modalShow: false,
        modalTitle: '',
        strSearch:''
    }
    componentDidMount() {
        this.loadData();
    }
    loadData = () => {
        departmentService.list().then(res => {
            this.setState({ departments: res.data})
        })
    }
    //Su kien tat
    closeModal = () => {
        this.setState({ modalShow: false });
    }
    //Su kien mo
    openModal = (id) => {
        if (id == 0) {
            //add
            this.setState({ modalTitle: 'New Department' });
            this.setState({ major: {} });
            this.setState({ modalShow: true });

        }
        else {
            //update
            this.setState({ modalTitle: 'Edit Department' });
            departmentService.get(id).then(res => {
                this.setState({ department: res.data })
                this.setState({ modalShow: true });
            })

        }

    }
    inputOnChange = (event) => {
        const { name, value } = event.target;
        const newDept = { ...this.state.department, [name]: value }
        this.setState({ department: newDept })
    }
    save = () => {
        if (this.state.department.dept_Id > 0) {
            departmentService.update(this.state.department.dept_Id, this.state.department).then(res => {
                if (res.status === 200) {
                this.setState({ modalShow: false });
                this.loadData();
                console.log(this.state.departments)
                } else {

                }
            })
        }
        else {
            departmentService.add(this.state.department).then(res => {
                 if (res.data.errorCode === 0) {
                    this.setState({ modalShow: false })
                    this.loadData();
                 }
                 else {

                 }
            })
        }
    }
    handleSearch=(search)=>{
        let sourceArr=departmentService.list();
        let newArr=[];
        if(search.length<=0){
            newArr=sourceArr
        }else{
            search.toLowerCase()
            for(let item of sourceArr){
                if(item.indexOf(search)>-1){
                    newArr.push(item)
                }
            }    
        }
        this.setState({
            sourceArr:newArr,
            strSearch:search
        })
    }
    render() {
        return (
            
                <div className="card my-3 shadow-lg p-3 mb-5 bg-white rounded">
                    <div className="card-header" id="bordercard">
                        <div className="row justify-content-between">
                            <div className="col-3">
                                <h1>Department</h1>
                            </div>
                            <div className="col-3 text-right p-2">
                                <button className="btn btn-success" onClick={() => this.openModal(0)}><i className="fas fa-plus"></i><b> Add </b></button>
                            </div>
                        </div>
                    </div>
                    <div className="card-body">
                        <div className="card my-3">
                            <div className="card-header">
                                <h5><b>Data Department</b></h5>
                            </div>
                            <div className="card-body">
                                <div className="row ml-2 mr-2">
                                    <div className="col-6 mt-2">
                                        <div className="form-check form-check-inline mr-4">
                                            <input className="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1" />
                                            <label className="form-check-label" for="inlineRadio1"><tt><big>Department ID</big></tt></label>
                                        </div>
                                        <div className="form-check form-check-inline">
                                            <input className="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2" />
                                            <label className="form-check-label" for="inlineRadio2"><tt><big>Department Name</big></tt></label>
                                        </div>

                                        <div className="input-group mt-4">
                                            <input type="text" className="form-control fix-rounded-right" required 
                                            value={this.props.strSearch}
                                            onChange={(event)=>this.props.handleSearch(event.target.value)}/>
                                            <div className="input-group-prepend">
                                                <span className="input-group-text"><tt><big>Search</big></tt></span>
                                            </div>
                                        </div>
                                    </div>

                                    <table className="table table-striped table-hover mt-4">
                                        <thead className="table-dark ">
                                            <tr>
                                                <th scope="col">#</th>

                                                <th scope="col">Department Name</th>
                                                <th scope="col">Amount</th>
                                                <th scope="col">Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            {this.state.departments.map((department, idx) => {
                                                return (
                                                    <tr key={department.dept_Id}>
                                                        <th scope="row">{idx + 1}</th>

                                                        <td>{department.departmentName} </td>
                                                        <td>{department.amount}</td>

                                                        <td>
                                                            <button className="btn btn-group"><i className="fas fa-user-edit" onClick={() => this.openModal(department.dept_Id)}></i></button>
                                                            <button className="btn btn-group" type="button" data-toggle="modal"
                                                                data-target="#exampleModalCenter"><i className="fas fa-trash"></i></button>
                                                        </td>
                                                    </tr>

                                                )
                                            })}
                                        </tbody>
                                    </table>

                                    <nav aria-label="..." className="offset-5">
                                        <ul className="pagination pagination-sm">
                                            <li className="page-item active" aria-current="page">
                                                <span className="page-link">1
                                        <span className="sr-only">(current)</span>
                                                </span>
                                            </li>
                                            <li className="page-item"><a className="page-link" href="#">2</a></li>
                                            <li className="page-item"><a className="page-link" href="#">3</a></li>
                                            <li className="page-item"><a className="page-link" href="#">4</a></li>
                                        </ul>
                                    </nav>
                                    <Modal
                                        show={this.state.modalShow}
                                        onHide={this.closeModal}
                                        backdrop="static"
                                        keyboard={false}
                                    >
                                        <Modal.Header closeButton>
                                            <Modal.Title>{this.state.modalTitle}</Modal.Title>
                                        </Modal.Header>
                                        <Modal.Body>
                                            <Form>
                                                <Form.Group as={Row}>


                                                    <Form.Label column sm={3} className="mb-2">Name</Form.Label>
                                                    <Col sm={9}>
                                                        <Form.Control

                                                            name="departmentName"
                                                            onChange={this.inputOnChange}
                                                            value={this.state.department.departmentName || ""}
                                                            type="text" placeholder=" " />
                                                    </Col>
                                                    <Form.Label column sm={3} className="mb-2">Amount</Form.Label>
                                                    <Col sm={9}>
                                                        <Form.Control

                                                            name="amount"
                                                            onChange={this.inputOnChange}
                                                            value={this.state.department.amount || ""}
                                                            type="text" placeholder=" " />
                                                    </Col>


                                                </Form.Group>
                                            </Form>
                                        </Modal.Body>
                                        <Modal.Footer>
                                            <Button variant="secondary" onClick={this.closeModal}>Close</Button>
                                            <Button variant="primary" onClick={this.save}>Save</Button>
                                        </Modal.Footer>
                                    </Modal>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            
        );
    }
}

export default Department;