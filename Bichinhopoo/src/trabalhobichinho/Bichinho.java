package trabalhobichinho;
import java.util.Scanner;

public class Bichinho {

    static class Bicho {
        String nome;
        String classe;
        String familia;
        int idade;
        boolean estado;  // true vivo / false morto
        int caloria;
        int forca;

        // Construtor do bichinho
        public Bicho(String nome, String classe, String familia) {
            this.nome = nome;
            this.classe = classe;
            this.familia = familia;
            this.idade = 0;
            this.estado = true;
            this.caloria = 10;
            this.forca = 10;
        }

        // Método para nascer
        public void nascer() {
            System.out.println("O animal se chama " + nome + " é da classe " + classe + " da família " + familia +
                               ". O animal possui força " + forca + ", caloria de " + caloria + " e " + idade + " idade.");
        }

        // Ações do bichinho
        public void comer() {
            if (estado && caloria < 100) {
                caloria += 10;
                forca -= 2;
                if (forca < 0) forca = 0;
                System.out.println("O animal comeu e agora sua força é " + forca + " e suas calorias valem " + caloria + ".");
            } else {
                System.out.println("O animal não pode comer porque está morto ou cheio.");
            }
        }

        public void correr() {
            if (estado && caloria > 0) {
                forca -= 5;
                caloria -= 5;
                if (forca < 0) forca = 0;
                if (caloria < 0) caloria = 0;
                System.out.println("O animal está correndo!! Agora sua força é de " + forca + " e suas calorias valem " + caloria + ".");
            } else {
                System.out.println("O animal não pode correr porque está morto ou exausto.");
            }
        }

        public void dormir() {
            if (estado) {
                forca += 10;
                caloria -= 2;
                if (caloria < 0) caloria = 0;
                System.out.println("O animal está dormindo agora! Sua força aumentou para " + forca + " e suas calorias diminuíram para " + caloria + ".");
            } else {
                System.out.println("O animal não pode dormir porque está morto.");
            }
        }

        public void morrer() {
            estado = false;
            forca = 0;
            System.out.println("O animal morreu!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Entrada dados bichinho
        System.out.println("Crie seu novo Bichinho :):):)");
        System.out.print("Insira o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Insira a classe: ");
        String classe = scanner.nextLine();
        System.out.print("Insira a família: ");
        String familia = scanner.nextLine();

        // Criação do bichinho
        Bicho bicho = new Bicho(nome, classe, familia);

        //status
        bicho.nascer();

        // Loop principal do jogo
        while (bicho.estado) {
            System.out.println("\nO que o " + bicho.nome + " vai fazer agora?");
            System.out.println("1- Comer");
            System.out.println("2- Correr");
            System.out.println("3- Dormir");
            System.out.println("4- Morrer");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    bicho.comer();
                    break;
                case 2:
                    bicho.correr();
                    break;
                case 3:
                    bicho.dormir();
                    break;
                case 4:
                    bicho.morrer();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        // Fim do jogo
        System.out.println("GAME OVER!");
        scanner.close();
    }
}
    
