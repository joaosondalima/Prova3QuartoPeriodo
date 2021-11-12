import { Component } from "react";
import React from "react";
import "../styles/index.css";
import api from "../api";
import { Link } from "react-router-dom";

class Index extends Component {
    state = {
        contatos: [],
    };

    async componentDidMount() {
        const responseContato = await api.get("/contatos");
        this.setState({ contatos: responseContato.data });
    }

    render() {
        const { contatos } = this.state;
        return (
            <div className="caixa-index">
                {console.log(contatos)}
                {contatos.map((contato) => (
                    <div key={contato.id} className="caixa-index-get">
                        <p>
                            <span>ID: </span>
                            {contato.id}
                        </p>
                        <p>
                            <span>Nome: </span>
                            {contato.nome}
                        </p>
                        <p>
                            <span>Email: </span>
                            {contato.email}
                        </p>
                        <p>
                            <span>Telefone: </span>
                            {contato.telefone}
                        </p>
                    </div>
                ))}
            </div>
        );
    }
}
export default Index;