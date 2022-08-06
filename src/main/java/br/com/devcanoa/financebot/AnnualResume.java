package br.com.devcanoa.financebot;

import java.util.Comparator;
import java.util.List;

public record sAnnualResume(double balance, double totalRevenue, double totalExpenditure, List<MonthlyResume> monthlyResumeList) {

    @Override
    public String toString() {
        sortMonthlyResumeListByDate();

        return "\n\t" + bold(italic(monthlyResumeList.get(0).getMonthSlashYear()))
                + " Até "
                + bold(italic(monthlyResumeList.get(monthlyResumeList.size() - 1).getMonthSlashYear())) + "\n"
                + bold(italic("Total de Entradas: ")) + bold("R$ " + totalRevenue) + "\n"
                + bold(italic("Total de Saídas: ")) + bold("R$ " + totalExpenditure) + "\n"
                + bold(italic("Saldo: ")) + bold("R$ " + balance) + "\n\n"
                + monthlyResumeList;
    }

    private String bold(String text) {
        return "*" + text + "*";
    }

    private String italic(String text) {
        return "_" + text + "_";
    }

    public void sortMonthlyResumeListByDate() {
        monthlyResumeList.sort(Comparator.comparing(MonthlyResume::date).reversed());
    }
}
