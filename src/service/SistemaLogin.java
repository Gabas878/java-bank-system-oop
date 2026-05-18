package service;

import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class SistemaLogin {

    List<Usuario> usuarios = new ArrayList<>();



    public void cadastrarUsuario(String nome, String email, String cpf, String senha) {
        Usuario usuarioEncontrado = buscarPorEmail(email);
        Usuario usuarioEncontradoCpf = buscarPorCpf(cpf);

        if(usuarioEncontrado != null || usuarioEncontradoCpf != null) {
            System.out.println("Usuário já Cadastrado");
        }else {
            this.usuarios.add(new Usuario(nome, email, cpf, senha));
            System.out.println("Usuário Cadastrado com Sucesso");
        }

    }

    private Usuario buscarPorEmail(String email) {
        for(Usuario usuario: this.usuarios) {
            if (usuario.getEmail().equalsIgnoreCase(email)) {
                return usuario;
            }
        }
        return null;
    }

    private Usuario buscarPorCpf(String cpf) {
        for(Usuario usuario: this.usuarios) {
            if (usuario.getCpf().equalsIgnoreCase(cpf)) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario login(String email, String senha) {
        Usuario usuarioEncontrado = buscarPorEmail(email);

        if(usuarioEncontrado == null) {
            System.out.println("Usuário não encontrado");
            return null;
        }

        if (usuarioEncontrado.getSenha().equals(senha)) {
            System.out.println("Login realizado com Sucesso");
            return usuarioEncontrado;
        }else {
            System.out.println("Senha Incorreta");
            return null;
        }
    }



}
