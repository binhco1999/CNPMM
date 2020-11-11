import React, { Component } from 'react';
import './profile.css'
class Profile extends Component {
    state = {  }
    render() { 
        return ( <div >
        <div class="card my-3 shadow-lg p-3 mb-5 bg-white rounded">
            <div class="card-header" id="bordercard">
                <div class="row justify-content-between">
                    <div class="col-3">
                        <h1>Profile</h1>
                    </div>
                    <div class="d-flex flex-wrap justify-content-between align-items-center mr-4">     
                        <button class="btn btn-style-1 btn-primary ml-auto" type="button" data-toast=""
                            data-toast-position="topRight" data-toast-type="success"
                            data-toast-icon="fe-icon-check-circle" data-toast-title="Success!"
                            data-toast-message="Your profile updated successfuly.">Update
                        </button>
                        <button class="btn btn-style-1 btn-danger ml-2" type="button" data-toast=""
                            data-toast-position="topRight" data-toast-type="success"
                            data-toast-icon="fe-icon-check-circle"
                            data-toast-message="Your profile updated cancel.">Cancel
                        </button>
                    </div>
                </div>
            </div>

            <div class="card-body">
                <div class="row">
                    <div class="col-lg-4 pb-5">
                        <div class="border border-light">
                        <div class="author-card pb-3">
                             {/* Account Sidebar*/}
                            <div class="author-card-cover">
                                {/* <img src="https://demo.createx.studio/createx-html/img/widgets/author/cover.jpg" alt="Hinhanh"/> */}                                       
                                <a class="btn btn-style-1 btn-white btn-sm" href="#" data-toggle="tooltip" title=""
                                    data-original-title="You currently have 290 Reward points to spend">
                                    <i class="fa fa-award text-md"></i>&nbsp;290 points
                                </a>
                            </div>

                            <div class="author-card-profile">
                                <div class="author-card-avatar">
                                    <img className ="photo ml-2" src="https://scontent.fsgn2-4.fna.fbcdn.net/v/t1.0-9/120073963_3005327479694357_7457786720289630508_o.jpg?_nc_cat=109&ccb=2&_nc_sid=09cbfe&_nc_ohc=xtYLvre_V6UAX_Qfxpx&_nc_oc=AQlSh5IftXW68QYq-9jLreB8VYyMTDtXSivOJyeTq-yS9-0dESa1kCrFPJZdrorUmqA&_nc_ht=scontent.fsgn2-4.fna&oh=cc6f6a164a6802a721baa26c6678d2c7&oe=5FC771C7" alt="ChrisTran"/>                           
                                </div>
                                
                                <div class="author-card-details">
                                    <h5 class="author-card-name text-lg mt-3">ChrisTran</h5>
                                    <span class="author-card-position">Joined February 06, 2017</span>
                                </div>
                            </div>
                        </div>
                        <div class="wizard">
                            <nav class="list-group list-group-flush">
                                <a class="list-group-item active" href=" ">
                                    <i class="fe-icon-user text-muted"></i>Profile Settings
                                    <span class="badge badge-secondary fa-pull-right">8</span>
                                </a>
                            </nav>
                        </div>
                        </div>
                           
                    </div>
                    
                    {/* Profile Settings */}
                    <div class="col-lg-8 pb-5">
                        <form class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="account-fn">First Name</label>
                                    <input class="form-control" type="text" id="account-fn" value="Chris" required=""/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="account-ln">Last Name</label>
                                    <input class="form-control" type="text" id="account-ln" value="Tran" required=""/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="account-email">E-mail</label>
                                    <input class="form-control" type="email" id="account-email" value="ChrisTran@example.com" disabled=""/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="account-phone">Phone Number</label>
                                    <input class="form-control" type="text" id="account-phone" value="+7 (805) 348 95 72" required=""/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="account-pass">Date of Birth</label>
                                    <div class="form-group row">
                                        <div class="col-4">
                                            <select class="custom-select">
                                                <option selected>Day</option>
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="1">4</option>
                                            </select>
                                        </div>

                                        <div class="col-4">
                                            <select class="custom-select">
                                                <option selected>Month</option>
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="1">4</option>
                                            </select>
                                        </div>

                                        <div class="col-4">
                                            <select class="custom-select">
                                                <option selected>Year</option>
                                                <option value="1">1997</option>
                                                <option value="2">1998</option>
                                                <option value="3">1999</option>
                                                <option value="1">2000</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="account-phone">Address</label>
                                    <input class="form-control" type="text" id="account-phone" value="New York" required=""/>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="account-phone">New password</label>
                                    <input class="form-control" type="text" id="account-phone" required=""/>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="account-phone">Confirm password</label>
                                    <input class="form-control" type="text" id="account-phone" required=""/>
                                </div>
                            </div>

                            {/* upload */}
                            <div class="col-md-7">
                                <form>
                                    <div class="form-group">
                                        <label for="exampleFormControlFile1"><tt><big>Let's choose avatar you want to change</big></tt></label>
                                        <input type="file" class="form-control-file" id="exampleFormControlFile1"/>
                                    </div>
                                </form>
                            </div>                                   
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>                   
    );
    }
}
 
export default Profile;