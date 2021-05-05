package RMI_Calculo;


public class RMI_CalculoQuestao implements RMI_CalculoInterface {

	public double CalculateReajustSalary(String name, String role, double salary) {
        if ("Operator".equals(role)) {
            salary *= 1.2;
        } else if ("Developer".equals(role)) {
            salary *= 1.18;
        }
        return salary;
    }
}
