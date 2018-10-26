
public class Conta {

	private String tipoConta;
	private boolean status;
	private double saldo;
	private int numeroConta;

	public Conta() {// Construct
		this.setSaldo(0.0);
		this.setStatus(false);

	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void abreConta(String tipoConta, int numeroConta) {
		if (tipoConta.equals("CC")) {
			this.setTipoConta(tipoConta);
			this.setStatus(true);
			this.setSaldo(50.00);
			this.setNumeroConta(numeroConta);
			System.out.println("Sua conta corrente foi aberta com sucesso! \n");
		} else if (tipoConta.equals("CP")) {
			this.setTipoConta(tipoConta);
			this.setStatus(true);
			this.setSaldo(150.00);
			this.setNumeroConta(numeroConta);
			System.out.println("Sua conta poupança foi aberta com sucesso! \n");
		}

		else {
			System.out.println("Insira um tipo de conta compativel ('CC' ou 'CP') \n");
		}
	}// Fim do abreConta()

	public void fechaConta() {
		if (this.getSaldo() == 0.0) {
			this.setStatus(false);
			System.out.println("A sua conta Nº"+getNumeroConta()+" foi fechada. \n");
		} else {
			System.out.println("Você precisa zerar seu saldo antes de fechar a conta! \n");
		}
	}// Fim do fechaConta()

	public void realizaDeposito(double valor) {
		if (this.isStatus() == true) {
			this.setSaldo(getSaldo() + valor);
		} else {
			System.out.println("A conta " + getNumeroConta() + " está fechada! \n");
		}
	}// Fim do realizaDeposito()

	public void realizaSaque(double valor) {
		if (this.isStatus() == true) {

			if (this.getSaldo() > valor || this.getSaldo() == valor) {
				this.setSaldo(getSaldo() - valor);
				System.out.println("Saque realizado com sucesso! \n");
			} else {
				System.out.println("Você não tem todo este saldo disponivel! \n");
			}

		} else {
			System.out.println("A conta Nº"+getNumeroConta()+" está fechada! \n");
		}

	}// Fim do realizaSaque()

	public void mensalidade() {
		if (this.getTipoConta().equals("CC")) {
			this.setSaldo(getSaldo() - 12.00);
		} else {
			this.setSaldo(getSaldo() - 20.00);
		}
	}//Fim do mensalidade()

	public void mostraConta() {
		if (this.isStatus() == true) {
			System.out.println("A conta Nº" + getNumeroConta() + ":");
			if (this.getTipoConta().equals("CC")) {// valida cc ou cp
				System.out.println("É uma conta corrente");
			} else {
				System.out.println("É uma conta poupança");
			} // Fim do valida
			System.out.println("Tem um saldo de R$" + getSaldo()+ "\n");
		}else {
			System.out.println("Essa conta não esta aberta!");
		}

	

	}

}
