package bancoBanco;

import java.util.Scanner;

import excecoes.*;

public class Programa {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int escolha, escolha1;
		double valor;
		String numero;
		Banco banco = new Banco();
		Conta conta;
		try {
			do {
				System.out.println(
						"informe 1 para criar uma conta corrente\n2 para criar uma polpanca \n3 para conta especial \n4 para conta imposto \n5 se voce ja eh cadastrado\n6 para mostrar todas as contas\n0 para sair");
				escolha = in.nextInt();
				in.nextLine();
				switch (escolha) {
				case 1:
					System.out.println("informe o numero da sua conta (modelo: xxxx-xx): ");
					numero = in.nextLine();
					conta = new Conta(numero);
					banco.cadastrar(conta);
					escolha1 = 1;
					while (escolha1 != 0) {
						System.out.println(
								"informe 1 para creditar na sua conta\n2 para debitar\n3 para ver sua conta\n0 para sair");
						escolha1 = in.nextInt();
						in.nextLine();
						switch (escolha1) {
						case 1:
							System.out.println("informe o valor que deseja creditar");
							valor = in.nextDouble();
							banco.creditar(numero, valor);
							break;
						case 2:
							System.out.println("informe o valor que deseja debitar");
							valor = in.nextDouble();
							banco.debitar(numero, valor);
							break;
						case 3:
							System.out.printf("numero da conta: %s\nvalor na conta: %.2f\n",banco.getConta(numero), banco.getSaldo(numero));
							break;
						case 0:
							System.out.print("foi um prazer\n");
							break;
						}

					}
					break;
				case 2:
					System.out.println("informe o numero da sua conta poupanca (modelo: xxxx-xx) : ");
					numero = in.nextLine();
					conta = new Poupanca(numero);
					banco.cadastrar(conta);
					escolha1 = 1;
					while (escolha1 != 0) {
						System.out.println(
								"informe 1 para creditar na sua conta\n2 para debitar\n3 para render juros\n4 para ver sua conta\n0 para sair");
						escolha1 = in.nextInt();
						in.nextLine();
						switch (escolha1) {
						case 1:
							System.out.println("informe o valor que deseja creditar");
							valor = in.nextDouble();
							banco.creditar(numero, valor);
							break;
						case 2:
							System.out.println("informe o valor que deseja debitar");
							valor = in.nextDouble();
							banco.debitar(numero, valor);
							break;
						case 3:
							banco.renderJuros(numero);
							break;
						case 4:
							System.out.printf("numero da conta: %s\nvalor na conta: %.2f\n",banco.getConta(numero), banco.getSaldo(numero));
							break;
						case 0:
							System.out.print("foi um prazer\n");
							break;
						}

					}
					break;
				case 3:
					System.out.println("informe o numero da sua conta especial (modelo: xxxx-xx) : ");
					numero = in.nextLine();
					conta = new ContaEspecial(numero);
					banco.cadastrar(conta);
					escolha1 = 1;
					while (escolha1 != 0) {
						System.out.println(
								"informe 1 para creditar na sua conta\n2 para debitar\n3 para render bonus\n4 para ver sua conta\n0 para sair");
						escolha1 = in.nextInt();
						in.nextLine();
						switch (escolha1) {
						case 1:
							System.out.println("informe o valor que deseja creditar");
							valor = in.nextDouble();
							banco.creditar(numero, valor);
							break;
						case 2:
							System.out.println("informe o valor que deseja debitar");
							valor = in.nextDouble();
							banco.debitar(numero, valor);
							break;
						case 3:
							banco.renderBonus(numero);
							break;
						case 4:
							System.out.printf("numero da conta: %s\nvalor na conta: %.2f\n",banco.getConta(numero), banco.getSaldo(numero));
							break;
						case 0:
							System.out.print("foi um prazer\n");
							break;
						}

					}
					break;
				case 4:
					System.out.println("informe o numero da sua conta imposto (modelo: xxxx-xx) : ");
					numero = in.nextLine();
					conta = new ContaImposto(numero);
					banco.cadastrar(conta);
					escolha1 = 1;
					while (escolha1 != 0) {
						System.out.println(
								"informe 1 para creditar na sua conta\n2 para debitar \n3 para ver sua conta\n0 para sair");
						escolha1 = in.nextInt();
						in.nextLine();
						switch (escolha1) {
						case 1:
							System.out.println("informe o valor que deseja creditar");
							valor = in.nextDouble();
							banco.creditar(numero, valor);
							break;
						case 2:
							System.out.println("informe o valor que deseja debitar");
							valor = in.nextDouble();
							banco.debitar(numero, valor);
							break;
						case 3:
							System.out.printf("numero da conta: %s\nvalor na conta: %.2f\n",banco.getConta(numero), banco.getSaldo(numero));
							break;
						case 0:
							System.out.print("foi um prazer\n");
							break;
						}

					}

					break;
				case 5:
					System.out.print("informe o numero da sua conta\n");
					numero = in.nextLine();
					String destino;
					banco.creditar(numero, 0);
					System.out.print("informe o que voce deseja fazer: \n");
					escolha1 = 1;
					double transferencia = 0.0;
					while (escolha1 != 0) {
						System.out.println(
								"1 para creditar na sua conta\n2 para debitar \n3 para ver sua conta\n4 para transferir\n0 para sair");
						escolha1 = in.nextInt();
						
						in.nextLine();
						switch (escolha1) {
						case 1:
							System.out.println("informe o valor que deseja creditar");
							valor = in.nextDouble();
							banco.creditar(numero, valor);
							break;
						case 2:
							System.out.println("informe o valor que deseja debitar");
							valor = in.nextDouble();
							banco.debitar(numero, valor);
							break;
						case 3:
							System.out.printf("numero da conta: %s\nvalor na conta: %.2f\n",banco.getConta(numero), banco.getSaldo(numero));
							break;
						case 4:
							int escolha2;
							System.out.print("informe o valor da transferencia:\n");
							transferencia = in.nextDouble();
							System.out.print("informe o numero da conta destino:\n");
							in.nextLine();
							destino = in.nextLine();
							banco.transferir(numero, destino, transferencia);
							break;
							
						case 0:
							System.out.print("foi um prazer\n");
							break;
						}

					}

					break;
				case 6:
					banco.mostrar();

					break;
				
				case 0:
					System.out.print("obrigado!\n");
					break;

				default:
					System.out.println("voce digitou uma opcao invalida");
					break;

				}
			} while (escolha != 0);
		} catch (ContaInesistenteException e) {
			System.out.print(e.getMessage()+"\n");
			
		}
		 catch (ContaJaCadastradaException e) {
			System.out.print(e.getMessage());
			System.out.print(" numero: ");
			System.out.print(e.getConta()+"\n");
			
		}
		 catch (ContaTipoDiferenteException e) {
			System.out.print(e.getMessage()+"\n");
		}
		catch (SaldoInsuficienteException e) {
			System.out.print(e.getMessage());
			System.out.print("numero: ");
			System.out.print(e.getNumero()+"\n");
			System.out.print("saldo: ");
			System.out.printf("%.2f",e.getSaldo());
		}
		catch (NumeroContaInvalidoException e) {
			System.out.print(e.getMessage());
		}

		in.close();
	}

}
