import React, {useEffect, useState} from 'react';
import './Servico.css';

function Servico() {
  return (

    <div className='container'>
      <h1>Cadastro de Serviços</h1>
      <form>
        <div className='col-6'>
          <div>
            <label className='form-label'>Nome do cliente</label>
            <input name='nomeCliente' type='text' className='form-control'/>
          </div>
          <div>
            <label className='form-label'>Data de inicio</label>
            <input name='dataInicio' type='date' className='form-control'/>
          </div>
          <div>
            <label className='form-label'>Data de término</label>
            <input name='dataTermino' type='date' className='form-control'/>
          </div>
          <div>
            <label className='form-label'>Descrição do serviço</label>
            <input name='descricaoServico' type='text' className='form-control'/>
          </div>
          <div>
            <label className='form-label'>Valor pago</label>
            <input name='valorPago' type='number' className='form-control'/>
          </div>
          <div>
            <label className='form-label'>Data de pagamento</label>
            <input name='dataPagamento' type='date' className='form-control'/>
          </div>

        </div>

      </form>
    </div>

  );
}

export default Servico;
