import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
        Scanner entrada = new Scanner(System.in);
        Cliente primeiroCliente = new Cliente();
        Menu menu = new Menu();

        menu.entradaDeDados();
        System.out.println("Por favor, digite seu nome: ");
        String nome = entrada.next();
        primeiroCliente.setNome(nome);
        System.out.println("Por favor, digite sua idade: ");
        int idade = entrada.nextInt();
        primeiroCliente.setIdade(idade);
        if(idade < 18){
            System.out.println("Cliente menor de idade precisa de um responsável");
            System.out.println("Por favor, digite o nome do responsável: ");
            String nomeResponsavel = entrada.next();
            primeiroCliente.setNomeResponsavel(nomeResponsavel);
            System.out.println("Seja bem vindo(a) à nossa Agência, " + primeiroCliente.getNome() +
                    " e " + primeiroCliente.getNomeResponsavel() + ".");
        } else
            System.out.println("Seja bem vindo(a) à nossa Agência, " + primeiroCliente.getNome());
//Até aqui tudo Ok
        menu.selecionaTipoConta();
        int tipoConta = entrada.nextInt();
        if (tipoConta == 1){
 //até aqui tudo ok
            Conta contaCorrente = new ContaCorrente(primeiroCliente);
            menu.showMenu();
            int selecao = entrada.nextInt();
            switch (selecao){
                case 1:
                    System.out.println("Qual valor gostaria de depositar?");
                    double valorDeposito = entrada.nextDouble();
                    contaCorrente.depositar(valorDeposito);
                    System.out.println("R$ "+valorDeposito + " Depositado(s)");
                    
                case 2:
                    System.out.println("Quanto gostaria de sacar? (Digite 0 caso não queira sacar!)");
                    double valorSaque = entrada.nextDouble();
                    contaCorrente.sacar(valorSaque);

                case 3:
                    System.out.println("Seu saldo é de: " + contaCorrente.getSaldo());
            }
        } else {
            Conta contaPoupanca = new ContaPoupanca(primeiroCliente);
            menu.showMenu();
            int selecao = entrada.nextInt();
            switch (selecao){
                case 1:
                    System.out.println("Qual valor gostaria de depositar?");
                    double valorDeposito = entrada.nextDouble();
                    contaPoupanca.depositar(valorDeposito);
                case 2:
                    System.out.println("Quanto gostaria de sacar?");
                    double valorSaque = entrada.nextDouble();
                    contaPoupanca.sacar(valorSaque);
                case 3:
                    System.out.println("Seu saldo é de: " + contaPoupanca.getSaldo());
            }
        }
    }	
		//IConta cc = new ContaCorrente(); //Polimorfismo
		/*Cliente wellington = new Cliente();
		wellington.setNome("Wellington");
		Conta cc = new ContaCorrente(wellington);
		wellington.setcpf("125872968-24");
		ContaPoupanca cp = new ContaPoupanca(wellington);
		

		
		cc.depositar(100);
		cc.transferir(100, cp);
		cc.imprimirExtrato();
		cp.imprimirExtrato();
		*/
	}
