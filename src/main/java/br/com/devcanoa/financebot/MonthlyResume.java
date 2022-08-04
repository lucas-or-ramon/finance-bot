package br.com.devcanoa.financebot;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

public record MonthlyResume(LocalDate date, double balance, double totalRevenue, double totalExpenditure) {
    @Override
    public String toString() {
        return "*_[" + date.getMonth().getDisplayName(TextStyle.FULL, new Locale("pt")) + "/" + date.getYear() + "]_*\n"
                + "*_Total de Entradas:_* *R$ " + totalRevenue + "*\n"
                + "*_Total de Saídas:_* *R$ " + totalExpenditure + "*\n"
                + "*_Saldo do Mês:_* *R$ " + balance + "*";
    }
}
