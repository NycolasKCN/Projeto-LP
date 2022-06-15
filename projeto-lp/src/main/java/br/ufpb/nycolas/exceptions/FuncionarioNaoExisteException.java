package br.ufpb.nycolas.exceptions;

public class FuncionarioNaoExisteException extends Exception {
    public FuncionarioNaoExisteException(String msg) {
        super(msg);
    }

    public FuncionarioNaoExisteException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
