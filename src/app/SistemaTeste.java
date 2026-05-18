package app;

import model.Usuario;
import service.SistemaLogin;
import service.ContaService;

public class SistemaTeste {

    public static void main(String[] args) {

        SistemaLogin login = new SistemaLogin();
        ContaService contaService = new ContaService();

        // 🔹 Cadastro de usuários
        login.cadastrarUsuario("Gabriel", "gabriel@gmail.com", "12345678900", "123");
        login.cadastrarUsuario("Clara", "clara@gmail.com", "98765432100", "123");

        // 🔹 Login
        Usuario gabriel = login.login("gabriel@gmail.com", "123");
        Usuario clara = login.login("clara@gmail.com", "123");

        // 🔹 Criar contas
        contaService.criarConta(gabriel);
        contaService.criarConta(clara);

        // 🔹 Depositar
        contaService.depositar(gabriel, 1000);
        contaService.depositar(clara, 500);

        // 🔹 Sacar
        contaService.sacar(gabriel, 200);

        // 🔹 Transferir
        contaService.transferir(gabriel, clara, 300);

        // 🔹 Resultado final
        System.out.println("=== RESULTADO FINAL ===");
        System.out.println(contaService.buscarContaPorUsuario(gabriel));
        System.out.println(contaService.buscarContaPorUsuario(clara));
    }
}