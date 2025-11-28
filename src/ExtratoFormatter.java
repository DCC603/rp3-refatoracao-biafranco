public class ExtratoFormatter {

    public static String gerarExtrato(Conta conta) {
        StringBuilder dadosExtrato = new StringBuilder();

        for (Operacao op : conta.getOperacoes()) {
            dadosExtrato.append(op.toString()).append(System.lineSeparator());
        }

        return "-----EXTRATO-----\n" +
                dadosExtrato +
                String.format("%nSaldo atual: %.2f%n", conta.getSaldo());
    }
}
