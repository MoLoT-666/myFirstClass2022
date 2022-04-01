import axios from 'axios';
import ReactDOM from 'react-dom';
import React, {Component} from 'react';
import {Button} from 'primereact/button';
import {InputText} from 'primereact/inputtext';
/*table*/
import {DataTable} from 'primereact/datatable';
import {Column} from 'primereact/column';


/*aka 'root' component*/
class App extends Component {

    constructor(props) {
        super(props);
    }

    state = {
        inputOneValue: '',
        inputTwoValue: '',
        inputThreeValue: ''
    }

    onInputOneChange = (event) => {
        this.setState({inputOneValue: event.target.value});
    }

    onInputTwoChange = (event) => {
        this.setState({inputTwoValue: event.target.value});
    }

    onInputThreeChange = (event) => {
        this.setState({inputThreeValue: event.target.value});
    }

    onFormSubmit = (event) => {
        event.preventDefault();
        console.log('Form submiting')

        let formData = {
            inputOneValue: this.state.inputOneValue,
            inputTwoValue: this.state.inputTwoValue,
            inputThreeValue: this.state.inputThreeValue
        };

        console.log(formData);

        /*real job*/
        axios.post(
            'http://localhost:8080/processItemForm',
            formData
        )

        console.log('Form submited successfully!');
    }

    render() {
        return (
            <div>
                <div>
                    <form onSubmit={this.onFormSubmit}>
                        <TheInput label='Name'
                                  callback={this.onInputOneChange}/>
                        <TheInput label='Description'
                                  callback={this.onInputTwoChange}/>
                        <TheInput label='Price'
                                  callback={this.onInputThreeChange}/>
                        <Button label="Save"
                                style={{marginTop: "10px"}}/>
                    </form>
                </div>
                <hr/>
                <div>
                    <DataTableBasicDemo/>
                </div>
            </div>
        );
    }
}

class TheInput extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <div className="card">
                    <h5>{this.props.label}</h5>
                    <InputText onChange={this.props.callback}/>
                </div>
            </div>
        )
    }
}

class DataTableBasicDemo extends Component {

    constructor(props) {
        super(props);
        this.state = {
            products: []
        };
    }

    componentDidMount() {
        axios.get(
            'http://localhost:8080/allItems'
        ).then(response => this.setState({products: response.data}));
    }

    refresh = () => {
        axios.get(
            'http://localhost:8080/allItems'
        ).then(response => this.setState({products: response.data}));
    }

    render() {
        return (
            <div>
                <div>
                    <Button label="Reload"
                            style={{marginTop: "10px"}}
                            onClick={this.refresh}/>
                </div>
                <div className="card">
                    <DataTable value={this.state.products} responsiveLayout="scroll">
                        <Column field="id" header="Id" style={{width: "100px"}}></Column>
                        <Column field="name" header="Name"></Column>
                        <Column field="description" header="Description"></Column>
                        <Column field="price" header="Price"></Column>
                    </DataTable>
                </div>
            </div>
        );
    }
}

ReactDOM.render(
    <React.StrictMode>
        <App/>
    </React.StrictMode>,
    document.getElementById('root')
);

