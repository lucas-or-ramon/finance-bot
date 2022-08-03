package br.com.devcanoa.financebot;

import java.time.LocalDate;
import java.util.List;

public record MonthlyResume(LocalDate date, double balance, double totalRevenue, double totalExpenditure, List<CategoryResume> categoryResumeList) {
    @Override
    public String toString() {
        return "Resumo Mensal de " + date.getMonth().name() + "\n"
                + "Total de Entradas: " + totalRevenue + "\n"
                + "Total de Saídas: " + totalExpenditure + "\n"
                + "Saldo do Mês: " + balance;

    }
}
