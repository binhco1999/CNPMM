import React from 'react';
import './App.css';
import {Route, Switch} from 'react-router-dom';
import DefaultLayout from './blocks/defaultLayout';
import Position from './pages/position';
import Department from './pages/department';
import Employee from './pages/employee';
import Home from './pages/home';
import Shift from './pages/shift';
import Holiday from './pages/holiday';
import Reschedule from './pages/reschedule';
import Timecheck from './pages/timecheck';
import Report from './pages/report';
function App() {
  return (
    <Switch>
      <Route path='/' component={DefaultLayout}/>
      <Route path='/home' component={Home}/>
      <Route path='/employee' component={Employee}/>
      <Route path='/department' component={Department}/>
      <Route path='/position' component={Position}/>
      <Route path='/shift' component={Shift}/>
      <Route path='/holiday' component={Holiday}/>
      <Route path='/reschedule' component={Reschedule}/>
      <Route path='/timecheck' component={Timecheck}/>
      <Route path='/report' component={Report}/>
    </Switch>
  );
}

export default App;
