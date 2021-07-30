import './App.css';
import School from './Components/School';
import MyAdminDashboard from './Components/Admin/Admin Dashboard/MyAdminDashboard';
import MyProfDashboard from './Components/Prof/Prof Dashboard/MyProfDashboard';
import MyStudentDashboard from './Components/Student/Student Dashboard/MyStudentDashboard';
import TestLogin from './Components/TestLogin';
import MyRegister from './Components/Register/MyRegister';
function App() {
  return (
    <div className="App">
     {/* <School/> */}
    <TestLogin/>
   
    </div>
  );
}

export default App;
