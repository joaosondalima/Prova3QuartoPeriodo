import {BrowserRouter as Router, Switch, Route} from "react-router-dom";
import './App.css';
import Home from './Pages/Home';
import Edit from './Pages/Edit';
import Delete from './Pages/Delete';
import Create from './Pages/Create';
import Index from './Pages/Index';
import Show from './Pages/Show';

function App() {
  return (
    <Router>
      <Switch>
      <Route path="/home" exact component={Home} />
        <Route path="/index" component={Index} />
        <Route path="/show" component={Show} />
        <Route path="/create" component={Create} />
        <Route path="/update" component={Edit} />
        <Route path="/delete" component={Delete} />
      </Switch>
    </Router>
  );
}

export default App;
