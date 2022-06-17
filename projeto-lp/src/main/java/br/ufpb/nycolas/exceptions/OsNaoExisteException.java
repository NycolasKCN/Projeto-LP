package br.ufpb.nycolas.exceptions;

public class OsNaoExisteException extends Exception {
    public OsNaoExisteException(String msg) {
        super(msg);
    }

    public OsNaoExisteException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
