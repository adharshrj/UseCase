import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'react-bootstrap';
import { Link } from 'react-router-dom';
class StudentList extends Component{
   
    constructor(props) {
        super(props);
        this.state = {students: [], isLoading: true};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        this.setState({isLoading: true});
    
        fetch('api/student')
          .then(response => response.json())
          .then(data => this.setState({students: data, isLoading: false}));
    }

    async remove(id) {
        await fetch(`/api/student/${id}`, {
          method: 'DELETE',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          }
        }).then(() => {
          let updatedStudents = [...this.state.students].filter(i => i.id !== id);
          this.setState({students: updatedStudents});
        });
      }
    
      render() {
        const {students, isLoading} = this.state;
    
        if (isLoading) {
          return <p>Loading...</p>;
        }

      const studentList = students.map(student => {
        return <tr key={student.id}>
          <td style={{whiteSpace: 'nowrap'}}>{student.name}</td>
          <td>{student.surname}</td>
          <td>{student.mobilePhone}</td>
          <td>
            <ButtonGroup>
              <Button size="sm" color="primary" tag={Link} to={"/student/" + student.id}>Edit</Button>
              <Button size="sm" color="danger" onClick={() => this.remove(student.id)}>Delete</Button>
            </ButtonGroup>
          </td>
        </tr>
      });
      return (
        <div>
          <Container fluid>
            <div className="float-right">
              <Button color="success" tag={Link} to="/student/list/add">Add Student</Button>
            </div>
            <h3>Student List</h3>
            <Table className="mt-4">
              <thead>
                <tr>
                  <th width="20%">Firstname</th>
                  <th width="20%">Lastname</th>
                  <th width="10%">Mobile</th>
                  <th width="10%">Actions</th>
                </tr>
              </thead>
              <tbody>
              {studentList}
              </tbody>
            </Table>
          </Container>
        </div>
      );
    }
}
export default StudentList;
  
