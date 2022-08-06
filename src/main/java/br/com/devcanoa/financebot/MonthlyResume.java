package br.com.devcanoa.financebot;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public record MonthlyResume(LocalDate date, double balance, double totalRevenue, double totalExpenditure) {
    @Override
    public String toString() {
        return "\n\t" + bold(italic(getMonthSlashYear())) + "\n"
                + "\t" + bold(italic("Total de Entradas: ")) + bold("R$ " + totalRevenue) + "\n"
                + "\t" + bold(italic("Total de Saídas: ")) + bold("R$ " + totalExpenditure) + "\n"
                + "\t" + bold(italic("Saldo do Mês: ")) + bold("R$ " + balance) + "\n";
    }

    public String getMonthSlashYear() {
        return "[" + date.getMonth().getDisplayName(TextStyle.FULL, new Locale("pt")) + "/" + date.getYear() + "]";
    }

    private String bold(String text) {
        return "*" + text + "*";
    }

    private String italic(String text) {
        return "_" + text + "_";
    }

}
