package br.com.devcanoa.financebot;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

public record MonthlyResume(LocalDate date, double balance, double totalRevenue, double totalExpenditure, List<CategoryResume> categoryResumeList) {
    @Override
    public String toString() {
        return "Resumo Mensal de _" + date.getMonth().getDisplayName(TextStyle.FULL, new Locale("pt")) + "/" + date.getYear() + "_\n"
                + "*Total de Entradas*: R$ " + totalRevenue + "\n"
                + "*Total de Saídas*: R$ " + totalExpenditure + "\n"
                + "*Saldo do Mês*: R$ " + balance;
    }
}
