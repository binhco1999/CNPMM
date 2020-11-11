import React, { Component } from 'react'
import './header.css'
import {Link} from 'react-router-dom'
class Sidebar extends Component {
    state = {  }
    render() { 
        return ( 

            <div class="bg-light border-right " id="sidebar-wrapper" >
                <div class="sidebar-heading collapse" id="collapseExample"><h5>System TimeKeeping</h5> </div>
                <div class="list-group list-group-flush collapse"id="collapseExample">
                <Link to="/home" class="list-group-item list-group-item-action"><i class="fas fa-home"></i> Dashboard</Link>
                <Link to="/reschedule" class="list-group-item list-group-item-action "><i class="far fa-calendar-alt"></i> Reschedule</Link>
                <Link to="/timecheck" class="list-group-item list-group-item-action "><i class="fas fa-history"></i> Time Check</Link>               
                <Link to="/report" class="list-group-item list-group-item-action "><i class="fas fa-clipboard-check"></i> Report</Link>
                <Link to="/shift" class="list-group-item list-group-item-action "><i class="fas fa-calendar-alt"></i> Shift</Link>                         
                <Link to="/employee" class="list-group-item list-group-item-action "><i class="fas fa-users"></i> Employees</Link>
                <Link to="/department" class="list-group-item list-group-item-action "><i class="fas fa-landmark"></i> Department</Link>
                <Link to="/position" class="list-group-item list-group-item-action "><i class="fas fa-user-circle"></i> Position</Link>
                <Link to="/profile" class="list-group-item list-group-item-action "><i class="fas fa-address-card"></i> My Profile</Link>
                <Link to="/holiday" class="list-group-item list-group-item-action "><i class="fas fa-umbrella-beach"></i> Holiday</Link>   
                </div>
          </div>
             
         );
    }
}
 
export default Sidebar;