import React, { Component } from 'react'
import {Modal,Footer,Header,Button,Title, Form, Row, Col} from 'react-bootstrap'
class Shift extends Component {
    state = {
        modalShow:false,
        modalTitle:"",
    }
    showModal=(id)=>{
        if(id==0)
        {
            this.setState({modalShow:true})
            this.setState({modalTitle:"New Shift"})
        }
        else{
            this.setState({modalShow:true})
            this.setState({modalTitle:"Edit Shift"})
        }
    }
    closeModal=()=>{
        this.setState({modalShow:false})
    }
    render() {
        return (
            <div >
                <div class="card my-3 shadow-lg p-3 mb-5 bg-white rounded">
                    <div class="card-header" id="bordercard">
                        <h1>Shift</h1>
                    </div>
                    <div class="card-body">
                        <div class="row my-3">
                            <div class="col text-right">
                                <button class="btn btn-success" onClick={()=>this.showModal(0)}>+ Add</button>
                            </div>
                        </div>
                        <table class="table table-striped table-hover">
                            <thead class="table-dark ">
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Name Shift</th>
                                    <th scope="col">Description</th>
                                    <th scope="col">Time In</th>
                                    <th scope="col">Time Out</th>
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
                        <Form.Group>
                            <Row>
                                <Col sm={3}>
                                    <Form.Label>Shift Name</Form.Label>
                                </Col>
                                <Col sm={3}>
                                    <Form.Control type="text"></Form.Control>
                                </Col>
                            </Row>
                            <Row className="mt-3">
                                <Col sm={3}>
                                    <Form.Label>Description</Form.Label>
                                </Col>
                                <Col sm={3}>
                                    <Form.Control type="text"></Form.Control>
                                </Col>
                            </Row>
                            
                        </Form.Group>
                    </Modal.Body>
                    <Modal.Footer>
                        <Button variant="secondary" onClick={()=>this.closeModal()}>
                            Close
                    </Button>
                        <Button variant="primary">Save</Button>
                    </Modal.Footer>
                </Modal>
            </div>

        );
    }
}

export default Shift;