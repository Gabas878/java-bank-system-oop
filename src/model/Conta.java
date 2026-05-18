package model;

public class Conta {

    private int numConta;
    private double saldo = 0;
    private Usuario cliente;

    public int getNumeroConta() {
        return this.numConta;
    }
    public Usuario getCliente() {
        return cliente;
    }

    public Conta(int numConta, Usuario cliente){
        this.numConta = numConta;
        this.cliente = cliente;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public void sacar(double valor) {
        if(valor > 0 && saldo >= valor) {
                saldo -= valor;
        }
    }

    public void transferir(double valor, Conta contaDestino) {
        if(contaDestino != null && valor > 0 && saldo >= valor && contaDestino != this) {
                sacar(valor);
                contaDestino.depositar(valor);
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public String toString() {
        return "Cliente: " + cliente.getNome() + " | " + "Conta: " + numConta;
    }

}
