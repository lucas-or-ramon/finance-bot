package br.com.devcanoa.financebot;

import java.util.List;

public record AnnualResume(double balance, double totalRevenue, double totalExpenditure, List<MonthlyResume> monthlyResumeList) {
    @Override
    public String toString() {
        return "*_[2022]_*\n"
                + "*_Total de Entradas:_* *R$ " + totalRevenue + "*\n"
                + "*_Total de Saídas:_* *R$ " + totalExpenditure + "*\n"
                + "*_Saldo do Ano:_* *R$ " + balance + "*\n\n"
                + monthlyResumeList.toString();
    }
}
