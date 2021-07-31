import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup } from 'react-bootstrap';
import { Input, Label } from 'reactstrap';

class StudentEdit extends Component {

  emptyStudent = {
    name: '',
    surname: '',
    mobilePhone: ''
  };

  constructor(props) {
    super(props);
    this.state = {
      item: this.emptyStudent
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  async componentDidMount() {
    if (this.props.match.params.id !== 'new') {
      const student = await (await fetch(`/api/student/${this.props.match.params.id}`)).json();
      this.setState({item: student});
    }
  }

  handleChange(event) {
    const target = event.target;
    const value = target.value;
    const name = target.name;
    let item = {...this.state.item};
    item[name] = value;
    this.setState({item});
  }

  async handleSubmit(event) {
    event.preventDefault();
    const {item} = this.state;

    await fetch('/api/student', {
      method: (item.id) ? 'PUT' : 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(item),
    });
    this.props.history.push('/student/list/add');
  }

  render() {
    const {item} = this.state;
    const title = <h2>{item.id ? 'Edit Student' : 'Add Student'}</h2>;

    return <div>
   
      <Container>
        {title}
        <Form onSubmit={this.handleSubmit}>
          <FormGroup>
            <Label for="firstname">Firstname</Label>
            <Input type="text" name="firstname" id="firstname" value={item.name || ''}
                   onChange={this.handleChange} autoComplete="firstname"/>
          </FormGroup>
          <FormGroup>
            <Label for="lastname">Lastname</Label>
            <Input type="text" name="lastname" id="lastname" value={item.surname || ''}
                   onChange={this.handleChange} autoComplete="lastname"/>
          </FormGroup>          
          <FormGroup>
            <Label for="age">Mobile Phone</Label>
            <Input type="text" name="age" id="age" value={item.mobilePhone || ''}
                   onChange={this.handleChange} autoComplete="age"/>
          </FormGroup>
          <FormGroup>
            <Button color="primary" type="submit">Save</Button>{' '}
            <Button color="secondary" tag={Link} to="/customers">Cancel</Button>
          </FormGroup>
        </Form>
      </Container>
    </div>
  }
}

export default StudentEdit;
