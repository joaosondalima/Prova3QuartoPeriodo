import React, {useState} from 'react';
import '../styles/Home.css';
import api from "../api";
import {Link} from "react-router-dom";

function Create(){

    const [contatoNome, setNome] = useState("");
    const [contatoEmail, setEmail] = useState("");
    const [contatoTelefone, setTelefone] = useState("");

    const handleSubmit = (e) =>{
        e.preventDefault();
        const postContatos = {
            nome: contatoNome,
            email: contatoEmail,
            telefone: contatoTelefone
        }
        api.post('/contatos', postContatos).then((resp) => {
            console.log(resp);
        });
    }
    return(
        <form className="criar" onSubmit={handleSubmit}>
            <ul>
                <li>
                    <input onChange={value => setNome(value.target.value)} value={contatoNome} className="criar" type="text" placeholder="Nome"></input>                
                </li>
                <li>
                    <input onChange={value => setEmail(value.target.value)} value={contatoEmail} className="criar" type="text" placeholder="Email"></input>                
                </li>
                <li>
                    <input onChange={value => setTelefone(value.target.value)} value={contatoTelefone} className="criar" type="text" placeholder="Telefone"></input>                
                </li>
                <li>
                    <button id="botao-enviar" type="submit" className="criar">ENVIAR</button>
                </li>
            </ul>
        </form>
    );
}
export default Create;