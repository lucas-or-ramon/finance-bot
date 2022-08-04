package br.com.devcanoa.financebot;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

public record MonthlyResume(LocalDate date, double balance, double totalRevenue, double totalExpenditure) {
    @Override
    public String toString() {
        return "\n\t*_[" + date.getMonth().getDisplayName(TextStyle.FULL, new Locale("pt")) + "/" + date.getYear() + "]_*\n"
                + "\t*_Total de Entradas:_* *R$ " + totalRevenue + "*\n"
                + "\t*_Total de Saídas:_* *R$ " + totalExpenditure + "*\n"
                + "\t*_Saldo do Mês:_* *R$ " + balance + "*\n";
    }
}
