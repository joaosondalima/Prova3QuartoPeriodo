import { useState } from "react"
import api from '../../services/api'
import { Form, Label, Input, Button } from './DeleteStyle'

    export default function Delete() {
        const [id, setId] = useState(0)

        const deletion = {
        id: id
        }
}

    async function handleSubmit(e) {
        e.preventDefault();
        await cadastrar(deletion);
    }

    async function cadastrar(deletion) {
        console.log(deletion);
        const response = await api.delete(
            '/contato/'+id,
            deletion
        )
        console.log(response.status);
        if (response.status === 200) {
            alert("Deletado com sucesso!")
        } else {
            alert("Não encontrado")
    }

    return(
        <Form
        onSubmit={(e)=> handleSubmit(e)}
        >
            <label>
                Informe ID que deseja deletar:
                <Input
                type="numero"
                name="id"
                onChange={value => setId(value.target.value)}
                value={id}
                />
            </label>
        </Form>
    )    
}