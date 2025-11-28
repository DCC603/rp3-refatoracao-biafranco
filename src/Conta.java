import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Conta {

    private Cliente cliente;
    private DadosBancarios dadosBancarios;

    // TODO(#2) REFATORAR: Esse nome não é o ideal para representar o saldo da conta
    // -> renomeado para saldo
    private double saldo;

    private List<Operacao> operacoes;

    public Conta(Cliente cliente,
                 DadosBancarios dadosBancarios,
                 double saldoInicial) {

        this.cliente = cliente;
        this.dadosBancarios = dadosBancarios;
        this.saldo = saldoInicial;
        this.operacoes = new ArrayList<>();
    }

    public Conta() {
        this(null, null, 0.0);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public DadosBancarios getDadosBancarios() {
        return dadosBancarios;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Operacao> getOperacoes() {
        return Collections.unmodifiableList(operacoes);
    }

    // TODO(#3) REFATORAR: Muita responsabilidade para o mesmo método
    // -> separar em métodos mais específicos
    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de depósito deve ser positivo");
        }
        Operacao op = new Operacao(TipoOperacao.DEPOSITO, valor);
        this.operacoes.add(op);
        this.saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque deve ser positivo");
        }
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        Operacao op = new Operacao(TipoOperacao.SAQUE, valor);
        this.operacoes.add(op);
        this.saldo -= valor;
    }


        // caso queira manter a assinatura antiga (para compatibilidade):
        public void realizarOperacao(char tipo, double valor) {
            if (tipo == 'd') {
                depositar(valor);
            } else if (tipo == 's') {
                sacar(valor);
            } else {
                throw new IllegalArgumentException("Tipo de operação inválido: " + tipo);
            }
        }

    @Override
    public String toString() {
        // TODO(#4) REFATORAR: Esses dados não estão relacionados a conta
        // -> agora Conta apenas delega para outras classes, sem montar extrato
        String dadosCliente = (cliente != null) ? cliente.toString() : "Cliente não definido";
        String dadosConta = (dadosBancarios != null)
                ? String.format("%s%nSaldo: %.2f", dadosBancarios.toString(), saldo)
                : String.format("Dados bancários não definidos%nSaldo: %.2f", saldo);

        return "-----CLIENTE-----\n" +
                dadosCliente +
                "\n\n" +
                "-----CONTA-----\n" +
                dadosConta +
                "\n";
    }
}
