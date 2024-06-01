import React, {useEffect, useState} from 'react';
import './Servico.css';
import axios from 'axios';

function Servico() {

    const [servico, setServico] = useState({valorServico:'', nomeCliente:'', dataInicio:'', dataTermino:'', descricaoServico:'', valorPago:'', dataPagamento:''});
    const [servicos, setServicos] = useState([]);
    const [atualizar, setAtualizar] = useState();


    function handleChange(event){

        setServico({...servico,[event.target.name]:event.target.value});

    }

    useEffect(()=> {
      buscarTodos();
    },[atualizar])

    function buscarTodos() {
      axios.get("http://localhost:8080/api/servico/").then(result=>{
        setServicos(result.data);
      });
    }

    function buscarPagamentoPendente() {
      axios.get("http://localhost:8080/api/servico/pagamentoPendente").then(result=>{
        setServicos(result.data);
      });
    }

    function buscarCancelados() {
      axios.get("http://localhost:8080/api/servico/cancelados").then(result=>{
        setServicos(result.data);
      });
    }

    function limpar(){
      setServico({valorServico:'', nomeCliente:'', dataInicio:'', dataTermino:'', descricaoServico:'', valorPago:'', dataPagamento:''});
    }

    function handleSubmit(event){

        event.preventDefault();
        if(servico.id===undefined){
          console.log("Inserir");
        axios.post("http://localhost:8080/api/servico/", servico).then(result=>{
            setAtualizar(result);
        })
        }else{
          axios.put("http://localhost:8080/api/servico/", servico).then(result=>{
            setAtualizar(result);
        }) 
        }
        limpar();
    }

    function excluir(id) {
      axios.delete("http://localhost:8080/api/servico/"+id).then(result=>{
        setAtualizar(result);
      });
    }

    function cancelar(id) {
      axios.post("http://localhost:8080/api/servico/"+id).then(result=>{
        setAtualizar(result);
      });
    }

  return (

    <div className='container'>
      <h1>Cadastro de Serviços</h1>
      <form onSubmit={handleSubmit}>
        <div className='col-6'>
          <div>
            <label className='form-label'>Nome do cliente</label>
            <input  onChange={handleChange} value={servico.nomeCliente || ''} name='nomeCliente' type='text' className='form-control'/>
          </div>
          <div>
            <label className='form-label'>Data de inicio</label>
            <input onChange={handleChange} value={servico.dataInicio || ''} name='dataInicio' type='date' className='form-control'/>
          </div>
          <div>
            <label className='form-label'>Data de término</label>
            <input onChange={handleChange} value={servico.dataTermino || ''} name='dataTermino' type='date' className='form-control'/>
          </div>
          <div>
            <label className='form-label'>Descrição do serviço</label>
            <input onChange={handleChange} value={servico.descricaoServico || ''} name='descricaoServico' type='text' className='form-control'/>
          </div>
          <div>
            <label className='form-label'>Valor do serviço</label>
            <input onChange={handleChange} value={servico.valorServico || ''} name='valorServico' type='text' className='form-control'/>
          </div>
          <div>
            <label className='form-label'>Valor pago</label>
            <input onChange={handleChange} value={servico.valorPago || ''} name='valorPago' type='number' className='form-control'/>
          </div>
          <div>
            <label className='form-label'>Data de pagamento</label>
            <input onChange={handleChange} value={servico.dataPagamento || ''} name='dataPagamento' type='date' className='form-control'/>
          </div>
    <br/>
          <input type="submit" className='btn btn-success' value="Cadastrar"/>

        </div>

      </form>
      <hr/><hr/>

  <button onClick={buscarTodos} type="button" class="btn btn-dark">Listar todos</button> &nbsp;
  <button onClick={buscarPagamentoPendente} type="button" class="btn btn-dark">Serviços com pagamento pendente</button> &nbsp;
  <button onClick={buscarCancelados} type="button" class="btn btn-dark">Serviços cancelados</button>

      <table className="table">
  <thead>
    <tr>
      <th scope="col">Nome</th>
      <th scope="col">Descrição</th>
      <th scope="col">Valor</th>
      <th scope="col">Status</th>
      <th scope="col">Opções</th>
    </tr>
  </thead>
  <tbody>
    {
      servicos.map(serv=>

        <tr key={serv.id}>
        <td>{serv.nomeCliente}</td>
        <td>{serv.descricaoServico}</td>
        <td>{serv.valorServico}</td>
        <td>{serv.status}</td>
        <td>
          {serv.status!=='cancelado' &&
          <button onClick={()=>setServico(serv)} className='btn btn-primary'>Alterar</button>
          } &nbsp;
          <button onClick={()=>excluir(serv.id)} className='btn btn-danger'>Excluir</button> &nbsp;
          {serv.status!=='cancelado' &&
          <button onClick={()=>cancelar(serv.id)} className='btn btn-warning'>Cancelar</button>
          }
        </td>
      </tr>

      )
    }
  </tbody>
</table>

    </div>

  );
}

export default Servico;
