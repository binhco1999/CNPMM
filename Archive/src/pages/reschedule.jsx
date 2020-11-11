import React, { Component } from 'react'
import { Modal, Form, Header, Footer, Button, Title, Row, Col, Card , Label, InputGroup} from 'react-bootstrap'
import { Last } from 'react-bootstrap/esm/PageItem'
class Reschedule extends Component {
    state = {
        modalShow:false
    }
    closeModal=()=>{
        this.setState({modalShow:false})
    }
    showModal=()=>{    
        this.setState({modalShow:true})
    }
    render() {
        return (
            <div >
                <div class="card my-3 shadow-lg p-3 mb-5 bg-white rounded">
                    <div class="card-header" id="bordercard">
                        <h1>Reschedule</h1>
                    </div>
                    <div class="card-body">
                        <form class="my-3">
                            <div class="row">
                                <div class="col-6">
                                    <div class="row mb-3">
                                        <div class="col-auto">
                                            <select class="custom-select">
                                                <option selected>Choose Department...</option>
                                                <option>HR</option>
                                                <option>Produce</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="row input-group">
                                        <div class="col-6">
                                            <input class="form-control" type="text" placeholder="Searching..."></input>
                                        </div>
                                        <div class="col-3 ">
                                            <button class="btn btn-success">Search</button>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </form>
                        <table class="table table-striped table-hover">
                            <thead class="table-dark ">
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope>ID Code</th>
                                    <th scope="col">Name Emp</th>
                                    <th scope="col">DOB</th>
                                    <th scope="col">Department</th>
                                    <th scope="col">Position</th>
                                    <th scope="col"></th>

                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th scope="row">1</th>
                                    <td>17110146</td>
                                    <td>Mark</td>
                                    <td>19/03/1999</td>
                                    <td>HR</td>
                                    <td>Team Leader</td>
                                    <td>
                                        <button class="btn btn-group" type="button" onClick={()=>this.showModal()} ><i class="fas fa-calendar-week"></i></button>

                                    </td>

                                </tr>
                                <tr>
                                    <th scope="row">2</th>
                                    <td>17110146</td>
                                    <td>Mark</td>
                                    <td>19/03/1999</td>
                                    <td>HR</td>
                                    <td>Team Leader</td>
                                    <td>
                                        <button class="btn btn-group" type="button" onClick={()=>this.showModal()}><i class="fas fa-calendar-week"></i></button>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">3</th>
                                    <td>17110146</td>
                                    <td>Mark</td>
                                    <td>19/03/1999</td>
                                    <td>HR</td>
                                    <td>Team Leader</td>
                                    <td>
                                        <button class="btn btn-group" type="button" onClick={()=>this.showModal()}><i class="fas fa-calendar-week"></i></button>

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
                    size="lg"
                >
                    <Modal.Header closeButton>
                        <Modal.Title>Schedule Emp</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <Form>
                       <Row>
                        <Col xs={4}>
                            <h5>Department</h5>
                        </Col>
                        <Col xs={6}>
                            <h5>Position</h5>
                        </Col>
                       </Row>
                       <Row>
                        <Col xs={4}>
                            <p>HR</p>
                        </Col>
                        <Col xs={6}>
                            <p>Team Leader</p>
                        </Col>
                       </Row>
                       <Card className="mt-4">
                           <Card.Header>
                               
                               <h5>Schedule :20/9/2020</h5>
                                
                           </Card.Header>
                           <Card.Body>
                       <Row>
                        <Col xs={3}>
                            
                        </Col>
                        <Col xs={3}>
                            <h5>Shift</h5>
                        </Col>
                        <Col xs={3}>
                            <h5>Time In</h5>
                        </Col>
                        <Col xs={3}>
                            <h5>Time Out</h5>
                        </Col>
                        </Row>
                        <Row className="my-3">
                        <Col xs={3}>
                            <h5>Monday</h5>
                        </Col>
                        <Col xs={3}>
                            <p>Shift A</p>
                        </Col>
                        <Col xs={3}>
                            <p>6:00</p>
                        </Col>
                        <Col xs={3}>
                            <p>14:00</p>
                        </Col>
                        </Row>
                        <Row className="my-3">
                        <Col xs={3}>
                            <h5>Tuesday</h5>
                        </Col>
                        <Col xs={3}>
                            <p>Shift A</p>
                        </Col>
                        <Col xs={3}>
                            <p>6:00</p>
                        </Col>
                        <Col xs={3}>
                            <p>14:00</p>
                        </Col>
                        </Row>
                        <Row className="my-3">
                        <Col xs={3}>
                            <h5>Westerday</h5>
                        </Col>
                        <Col xs={3}>
                            <p>Shift B</p>
                        </Col>
                        <Col xs={3}>
                            <p>14:00</p>
                        </Col>
                        <Col xs={3}>
                            <p>22:00</p>
                        </Col>
                        </Row>
                        <Row className="my-3">
                        <Col xs={3}>
                            <h5>Thursday</h5>
                        </Col>
                        <Col xs={3}>
                            <p>Shift C</p>
                        </Col>
                        <Col xs={3}>
                            <p>22:00</p>
                        </Col>
                        <Col xs={3}>
                            <p>6:00</p>
                        </Col>
                        </Row>
                        <Row className="my-3">
                        <Col xs={3}>
                            <h5>Friday</h5>
                        </Col>
                        <Col xs={3}>
                            <p>Off</p>
                        </Col>
                        <Col xs={3}>
                            <p>...</p>
                        </Col>
                        <Col xs={3}>
                            <p>...</p>
                        </Col>
                        </Row>
                        <Row className="my-3">
                        <Col xs={3}>
                            <h5>Saturday</h5>
                        </Col>
                        <Col xs={3}>
                            <p>Shift</p>
                        </Col>
                        <Col xs={3}>
                            <p>Time In</p>
                        </Col>
                        <Col xs={3}>
                            <p>Time Out</p>
                        </Col>
                        </Row>
                        </Card.Body>
                        </Card>
                       </Form>
                    </Modal.Body>
                    <Modal.Footer>
                        <Button variant="secondary" onClick={()=>this.closeModal()}>
                            Close
               </Button>
                        <Button variant="primary">Understood</Button>
                    </Modal.Footer>
                </Modal>
            </div>
        );
    }
}

export default Reschedule;