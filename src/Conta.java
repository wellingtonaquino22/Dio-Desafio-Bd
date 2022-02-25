public abstract class Conta implements IConta{
	
	private static final int AGENCIA_PADRAO = 0;
	private static final int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	private Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL;
		this.cliente = cliente;
	
	}


	@Override
	public void sacar(double valor) {
		saldo-=valor;
	}

	@Override
	public void depositar(double valor) {
		// TODO Auto-generated method stub
		saldo+= valor;
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		// TODO Auto-generated method stub
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	
	
	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
	
	protected void ImprimirInfosComuns() {
		System.out.println(String.format("Titular %s", this.cliente.getNome()));
		System.out.println(String.format("Cpf %s", this.cliente.getcpf()));
		System.out.println(String.format("Agencia %d", this.agencia));
		System.out.println(String.format("Numero %d", this.numero));
		System.out.println(String.format("Saldo %.2f", this.saldo));
	}
	

}
