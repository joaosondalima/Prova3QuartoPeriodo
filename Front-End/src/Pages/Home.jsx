import React from "react"
import '../styles/Home.css'
import {Link} from "react-router-dom"

function Home(){
    return(
        <section className="botoes">
            <ul>
                <li>
                    <Link to="/criar">
                        <button id="botao-criar" type="button" className="buton-home">CRIAR</button>
                    </Link>
                </li>
                <li>
                    <Link to="/update">
                        <button id="botao-update" type="button" className="buton-home">ATUALIZAR</button>
                    </Link>
                </li>
                <li>
                    <Link to="/show">
                        <button id="botao-show" type="button" className="buton-home">SHOW</button>
                    </Link>
                </li>
                <li>
                    <Link to="/index">
                        <button id="botao-index" type="button" className="buton-home">INDEX</button>
                    </Link>
                </li>
                <li>
                    <Link to="/delete">
                        <button id="botao-delete" type="button" className="buton-home">EXCLUIR</button>
                    </Link>
                </li>
            </ul>
        </section>

    );
}
export default Home;