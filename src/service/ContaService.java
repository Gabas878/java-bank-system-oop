package service;

import model.Conta;
import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ContaService {
    private List<Conta> contas = new ArrayList<>();
    private int proximoNumeroConta;

    public void criarConta(Usuario usuario) {
        contas.add(new Conta(proximoNumeroConta, usuario));
        proximoNumeroConta += 1;
    }

    public Conta buscarContaPorUsuario(Usuario usuario) {
        for(Conta conta: this.contas) {
            if(conta.getCliente().equals(usuario)) {
              return conta;
            }
        }
        return null;
    }


    public void depositar(Usuario usuario, double valor) {
        Conta conta = buscarContaPorUsuario(usuario);
        if(conta != null) {
            conta.depositar(valor);
        }
    }

    public void sacar(Usuario usuario, double valor) {
        Conta conta = buscarContaPorUsuario(usuario);
        if (conta != null) {
            conta.sacar(valor);
        }
    }

    public void transferir(Usuario contaOrigem, Usuario contaDestino, double valor) {
        Conta origem = buscarContaPorUsuario(contaOrigem);
        Conta destino = buscarContaPorUsuario(contaDestino);
        if(origem != null && destino != null) {
            origem.transferir(valor, destino);
        }

    }
}
