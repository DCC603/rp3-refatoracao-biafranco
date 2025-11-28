public class OperacaoFormatter {

    public static String formatar(Operacao op) {
        return String.format("%s:\t%.2f",
                op.getTipo().getDescricao(),
                op.getValor());
    }
}
