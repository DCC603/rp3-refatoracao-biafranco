public class DadosBancarios {

    private int numAgencia;
    private int numConta;
    private String gerente;

    public DadosBancarios(int numAgencia, int numConta, String gerente) {
        this.numAgencia = numAgencia;
        this.numConta = numConta;
        this.gerente = gerente;
    }

    public int getNumAgencia() {
        return numAgencia;
    }

    public int getNumConta() {
        return numConta;
    }

    public String getGerente() {
        return gerente;
    }

    @Override
    public String toString() {
        return String.format("Ag.: %d%nConta: %d%nGerente: %s",
                numAgencia, numConta, gerente);
    }
}
