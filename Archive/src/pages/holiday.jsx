import React, { Component } from 'react'
import './holiday.css'
class Holiday extends Component {
    state = {  }
    render() { 
        return ( 
            <div class="container">
            <div class="card my-3 shadow-lg p-3 mb-5 bg-white rounded">
                <div class="card-header" id="bordercard">
                    <h1>Reschedule</h1>
                </div>
                <div class="card-body">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-6">
                                <div class="row">
                                    <div class="col">
                                        <input class="form-control" type="text" placeholder="Text here..."></input>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="calendar shadow bg-white p-3">
                        <div class="d-flex align-items-center"><i class="fa fa-calendar fa-3x mr-3"></i>
                            <h2 class="month font-weight-bold mb-0 text-uppercase">December 2019</h2>
                        </div>
                        <p class="font-italic text-muted mb-5">No events for this day.</p>
                        <ol class="day-names list-unstyled">
                            <li class="font-weight-bold text-uppercase">Sun</li>
                            <li class="font-weight-bold text-uppercase">Mon</li>
                            <li class="font-weight-bold text-uppercase">Tue</li>
                            <li class="font-weight-bold text-uppercase">Wed</li>
                            <li class="font-weight-bold text-uppercase">Thu</li>
                            <li class="font-weight-bold text-uppercase">Fri</li>
                            <li class="font-weight-bold text-uppercase">Sat</li>
                        </ol>

                        <ol class="days list-unstyled">
                            <li>
                                <div class="date">1</div>
                                <div class="event bg-success">Event with Long Name</div>
                            </li>
                            <li>
                                <div class="date">2</div>
                            </li>
                            <li>
                                <div class="date">3</div>
                            </li>
                            <li>
                                <div class="date">4</div>
                            </li>
                            <li>
                                <div class="date">5</div>
                            </li>
                            <li>
                                <div class="date">6</div>
                            </li>
                            <li>
                                <div class="date">7</div>
                            </li>
                            <li>
                                <div class="date">8</div>
                            </li>
                            <li>
                                <div class="date">9</div>
                            </li>
                            <li>
                                <div class="date">10</div>
                            </li>
                            <li>
                                <div class="date">11</div>
                            </li>
                            <li>
                                <div class="date">12</div>
                            </li>
                            <li>
                                <div class="date">13</div>
                                <div class="event all-day begin span-2 bg-warning">Event Name</div>
                            </li>
                            <li>
                                <div class="date">14</div>
                            </li>
                            <li>
                                <div class="date">15</div>
                                <div class="event all-day end bg-success">Event Name</div>
                            </li>
                            <li>
                                <div class="date">16</div>
                            </li>
                            <li>
                                <div class="date">17</div>
                            </li>
                            <li>
                                <div class="date">18</div>
                            </li>
                            <li>
                                <div class="date">19</div>
                            </li>
                            <li>
                                <div class="date">20</div>
                            </li>
                            <li>
                                <div class="date">21</div>
                                <div class="event bg-primary">Event Name</div>
                                <div class="event bg-success">Event Name</div>
                            </li>
                            <li>
                                <div class="date">22</div>
                                <div class="event bg-info">Event with Longer Name</div>
                            </li>
                            <li>
                                <div class="date">23</div>
                            </li>
                            <li>
                                <div class="date">24</div>
                            </li>
                            <li>
                                <div class="date">25</div>
                            </li>
                            <li>
                                <div class="date">26</div>
                            </li>
                            <li>
                                <div class="date">27</div>
                            </li>
                            <li>
                                <div class="date">28</div>
                            </li>
                            <li>
                                <div class="date">29</div>
                            </li>
                            <li>
                                <div class="date">30</div>
                            </li>
                            <li>
                                <div class="date">31</div>
                            </li>
                            <li class="outside">
                                <div class="date">1</div>
                            </li>
                            <li class="outside">
                                <div class="date">2</div>
                            </li>
                            <li class="outside">
                                <div class="date">3</div>
                            </li>
                            <li class="outside">
                                <div class="date">4</div>
                            </li>
                        </ol>
                    </div>
                </div>
            </div>
            </div>
         );
    }
}
 
export default Holiday;